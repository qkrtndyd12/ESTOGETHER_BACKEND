package com.esc.estogether.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Group {
    private int id;
    private String name;
    private String readerName;

    private List<Member> memberList;
}
