package com.esc.estogether.model.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSearch {
    private Integer memberId;
    private Integer groupId;

    private Boolean army;
    private Boolean otherArea;
    private Boolean longAbsence;


    public MemberSearch(Integer memberId) {
        this.memberId = memberId;
    }

    public MemberSearch(Integer memberId, Integer groupId) {
        this.memberId = memberId;
        this.groupId = groupId;
    }
}
