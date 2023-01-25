package com.esc.estogether.model.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceSearch {
    private Integer memberId;
    private Integer groupId;
    private Boolean attendance;
    private Boolean operation;
}
