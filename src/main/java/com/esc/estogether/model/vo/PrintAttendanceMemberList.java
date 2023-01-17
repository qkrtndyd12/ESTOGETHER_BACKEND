package com.esc.estogether.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class PrintAttendanceMemberList {

    private int totalCnt;
    private int maleCnt;
    private int femaleCnt;

    private List<String> memberList;
}
