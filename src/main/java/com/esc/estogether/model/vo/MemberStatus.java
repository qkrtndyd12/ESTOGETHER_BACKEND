package com.esc.estogether.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberStatus {
    private boolean army;
    private boolean otherArea;
    private boolean longAbsence;
}
