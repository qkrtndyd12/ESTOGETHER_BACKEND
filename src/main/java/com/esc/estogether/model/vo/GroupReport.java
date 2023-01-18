package com.esc.estogether.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GroupReport {
    private int groupMemberId;
    private int year;
    private int week;
    private String weeklyMemo;
    private String sermonMemo;
    private String praiseMemo;
    private boolean favorite;


}
