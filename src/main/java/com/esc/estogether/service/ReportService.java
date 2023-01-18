package com.esc.estogether.service;

import com.esc.estogether.mapper.ReportMapper;
import com.esc.estogether.model.parameter.ReportSearch;
import com.esc.estogether.model.vo.GroupReport;
import com.esc.estogether.model.vo.ReportByMember;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ReportService {

    private final ReportMapper reportMapper;

    public List<ReportByMember> findReport(ReportSearch reportSearch) {
        return reportMapper.findReport(reportSearch);
    }

    public int createReport(GroupReport groupReport) {
        return reportMapper.createReport(groupReport);
    }
}