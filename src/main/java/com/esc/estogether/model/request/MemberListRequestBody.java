package com.esc.estogether.model.request;

import com.esc.estogether.model.vo.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberListRequestBody {
    private List<Member> memberList;
}
