package com.esc.estogether.model.type;

import com.esc.estogether.util.EnumTypeHandler;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.MappedTypes;

@Getter
@ToString
public enum SubTypeEnum implements CodeEnum {

    CHAIRMAN("00", "회장")
    , GENERAL_AFFAIRS("01", "총무")
    , CLERK("02", "서기")
    , SUB_CLERK("03", "부서기")
    , BOOKKEEPER("04", "회계")
    , SUB_BOOKKEEPER("05", "부회계")
    , CELL_READER("10", "셀 리더")
    , PRAISE_TEAM_READER("10", "찬양팀 리더")
    , PASTOR("99", "목사")
    , DIRECTOR("98", "부장 집사");

    private final String code;
    private final String description;

    SubTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappedTypes(SubTypeEnum.class)
    public static class TypeHandler extends EnumTypeHandler<SubTypeEnum> {
        public TypeHandler() {
            super(SubTypeEnum.class);
        }
    }

    @Override
    public String getCode() {
        return code;
    }


    @JsonValue
    public String getDescription() {
        return description;
    }
}
