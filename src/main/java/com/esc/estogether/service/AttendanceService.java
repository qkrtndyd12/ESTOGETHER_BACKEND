package com.esc.estogether.service;

import com.esc.estogether.mapper.AttendanceMapper;
import com.esc.estogether.model.parameter.AttendanceSearch;
import com.esc.estogether.model.type.SexEnum;
import com.esc.estogether.model.vo.Group;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.PrintAttendanceMemberList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class AttendanceService {

    private final AttendanceMapper attendanceMapper;

    public List<Group> findMemberAttendanceList(AttendanceSearch attendanceSearch) {
        return attendanceMapper.findAttendance(attendanceSearch);
    }

    public String attendancePrint(Integer memberId, Integer groupId, Boolean attendance) {
        AttendanceSearch attendanceSearch = new AttendanceSearch();
        attendanceSearch.setMemberId(memberId);
        attendanceSearch.setGroupId(groupId);
        attendanceSearch.setAttendance(attendance);
//        List<Group> memberAttendanceList = attendanceMapper.findAttendance(attendanceSearch);
//        PrintAttendanceMemberList printAttendanceMemberList = new PrintAttendanceMemberList();
//        printAttendanceMemberList.setTotalCnt(memberAttendanceList.size());
//        printAttendanceMemberList.setMaleCnt((int) memberAttendanceList.stream().filter(member -> member.getSex().equals(SexEnum.MALE)).count());
//        printAttendanceMemberList.setFemaleCnt((int) memberAttendanceList.stream().filter(member -> member.getSex().equals(SexEnum.FEMALE)).count());
//        printAttendanceMemberList.setMemberList(memberAttendanceList.stream().map(member -> member.getName()).collect(Collectors.toList()));

//        log.info("print : {}", printAttendanceMemberList.toString());
        String returnVal = "";
//        returnVal += "총 : " + printAttendanceMemberList.getTotalCnt() + System.lineSeparator();
//        returnVal += "남 : " + printAttendanceMemberList.getMaleCnt() + System.lineSeparator();
//        returnVal += "여 : " + printAttendanceMemberList.getFemaleCnt() + System.lineSeparator() + System.lineSeparator();
//        returnVal += printAttendanceMemberList.getMemberList().toString();
        return returnVal;
    }

    @Transactional
    public int attendanceCheckByMemberId(AttendanceSearch attendanceSearch) {
        log.info("attendanceCheckByMemberId :: {}", attendanceSearch);
        if (attendanceSearch.getAttendance() != null && attendanceSearch.getAttendance()) {
            return attendanceMapper.attendanceCheckByMemberId(attendanceSearch);
        } else {
            return attendanceMapper.deleteAttendanceByMemberId(attendanceSearch);
        }
    }
    @Transactional
    public int attendanceCheck(List<Member> memberList) {
        int returnVal = 0;
        try {
            List<Member> attendanceMemberList = new ArrayList<>();
            for (Member member : memberList) {
//                List<Group> memberAttendanceList = attendanceMapper.findAttendance(new AttendanceSearch(member.getId()));
//                MemberAttendance memberAttendance = memberAttendanceList.get(0);
//                log.info("name : {}, attendance : {}", memberAttendance.getName(), memberAttendance.isAttendance());
//                if (memberAttendance.isAttendance()) {
//                    continue;
//                }
                attendanceMemberList.add(member);
            }
            if (attendanceMemberList.isEmpty()) {
                return returnVal;
            }
            return attendanceMapper.attendanceCheck(attendanceMemberList);
        } catch(Exception e) {
            e.printStackTrace();
            return returnVal;
        }
    }

    @Transactional
    public int deleteAttendance(List<Member> memberList) {
        try {
            return attendanceMapper.deleteAttendance(memberList);
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}