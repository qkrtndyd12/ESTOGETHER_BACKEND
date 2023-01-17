package com.esc.estogether.model.type;

import com.esc.estogether.util.EnumTypeHandler;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.MappedTypes;

@Getter
@ToString
public enum TypeEnum implements CodeEnum {

    EXECUTIVES("0", "임원")
    , READER("1", "리더")
    , PRAISE_TEAM("2", "찬양팀")
    , MASTER("99", "교역자 및 부장집사");

    private final String code;
    private final String description;

    TypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappedTypes(TypeEnum.class)
    public static class TypeHandler extends EnumTypeHandler<TypeEnum> {
        public TypeHandler() {
            super(TypeEnum.class);
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
