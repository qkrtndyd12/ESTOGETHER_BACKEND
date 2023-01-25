package com.esc.estogether.mapper;

import com.esc.estogether.model.parameter.AttendanceSearch;
import com.esc.estogether.model.vo.Group;
import com.esc.estogether.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendanceMapper {

    List<Group> findAttendance(AttendanceSearch attendanceSearch);
    int attendanceCheckByMemberId(AttendanceSearch attendanceSearch);
    int deleteAttendanceByMemberId(AttendanceSearch attendanceSearch);
    int attendanceCheck(List<Member> memberList);
    int deleteAttendance(List<Member> memberList);
}