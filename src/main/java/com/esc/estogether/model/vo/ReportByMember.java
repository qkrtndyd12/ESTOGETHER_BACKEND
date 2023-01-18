package com.esc.estogether.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReportByMember extends GroupReport {
    private String groupName;
    private String memberName;

}
