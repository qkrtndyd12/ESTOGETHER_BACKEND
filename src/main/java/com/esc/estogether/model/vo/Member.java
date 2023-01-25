package com.esc.estogether.model.vo;

import com.esc.estogether.model.type.SexEnum;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Member {
    private int id;
    private String name;
    private SexEnum sex;
    private LocalDateTime dayOfBirth;
    private String phoneNumber;
    private String address;
    private String parents;
    private String baptism;
    private String job;
    private String grade;
    private MemberStatus memberStatus;
    private Position position;

    private Boolean attendance;

}
