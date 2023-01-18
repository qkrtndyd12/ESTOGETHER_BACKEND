package com.esc.estogether.model.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportSearch {
    private Integer memberId;
    private Integer groupId;
    private Integer year;
    private Integer week;

}
