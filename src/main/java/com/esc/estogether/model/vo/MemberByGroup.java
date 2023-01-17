package com.esc.estogether.model.vo;

import com.esc.estogether.model.type.SubTypeEnum;
import com.esc.estogether.model.type.TypeEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberByGroup extends Member {
    private TypeEnum type;
    private SubTypeEnum subType;
    private String groupName;
    private String readerName;

}
