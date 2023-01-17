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

    public MemberSearch(Integer memberId) {
        this.memberId = memberId;
    }
}
