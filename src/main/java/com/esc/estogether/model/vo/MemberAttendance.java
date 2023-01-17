package com.esc.estogether.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberAttendance extends Member {

    private String groupName;
    private boolean attendance;
}
