package com.esc.estogether.model.type;

import com.esc.estogether.util.EnumTypeHandler;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.MappedTypes;

@Getter
@ToString
public enum SexEnum implements CodeEnum {
    MALE("1", "남")
    , FEMALE("2", "여");

    private final String code;
    private final String description;

    SexEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappedTypes(SexEnum.class)
    public static class TypeHandler extends EnumTypeHandler<SexEnum> {
        public TypeHandler() {
            super(SexEnum.class);
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
