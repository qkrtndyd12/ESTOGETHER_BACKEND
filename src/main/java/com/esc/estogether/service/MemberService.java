package com.esc.estogether.service;

import com.esc.estogether.mapper.MemberMapper;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberAttendance;
import com.esc.estogether.model.vo.MemberByGroup;
import com.esc.estogether.model.parameter.MemberSearch;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    public List<MemberByGroup> findMemberByGroupIdOrderByGroup(MemberSearch memberSearch) {
        return memberMapper.findMemberByGroupIdOrderByGroup(memberSearch);
    }

    @Transactional
    public int attendanceCheck(List<Member> memberList) {
        int returnVal = 0;
        try {
            List<Member> attendanceMemberList = new ArrayList<>();
            for (Member member : memberList) {
                MemberAttendance memberAttendance = memberMapper.findAttendance(member);
                log.info("name : {}, attendance : {}", memberAttendance.getName(), memberAttendance.isAttendance());
                if (memberAttendance.isAttendance()) {
                    continue;
                }
                attendanceMemberList.add(member);
            }
            return memberMapper.attendanceCheck(attendanceMemberList);
        } catch(Exception e) {
            e.printStackTrace();
            return returnVal;
        }
    }

    @Transactional
    public int deleteAttendance(List<Member> memberList) {
        try {
            return memberMapper.deleteAttendance(memberList);
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}