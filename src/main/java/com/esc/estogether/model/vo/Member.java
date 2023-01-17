package com.esc.estogether.model.vo;

import com.esc.estogether.model.type.SexEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member {
    private int id;
    private String name;
    private SexEnum sex;
}
