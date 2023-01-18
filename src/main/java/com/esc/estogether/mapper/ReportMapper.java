package com.esc.estogether.mapper;

import com.esc.estogether.model.parameter.AttendanceSearch;
import com.esc.estogether.model.parameter.ReportSearch;
import com.esc.estogether.model.vo.GroupReport;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberAttendance;
import com.esc.estogether.model.vo.ReportByMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportMapper {

    List<ReportByMember> findReport(ReportSearch reportSearch);
    int createReport(GroupReport groupReport);
    int deleteReport(int id);
}