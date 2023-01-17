package com.esc.estogether.mapper;

import com.esc.estogether.model.parameter.AttendanceSearch;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberAttendance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendanceMapper {

    List<MemberAttendance> findAttendance(AttendanceSearch attendanceSearch);
    int attendanceCheck(List<Member> memberList);
    int deleteAttendance(List<Member> memberList);
}