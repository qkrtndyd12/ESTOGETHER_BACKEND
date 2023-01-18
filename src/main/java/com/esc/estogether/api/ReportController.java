package com.esc.estogether.api;

import com.esc.estogether.dto.ResponseDTO;
import com.esc.estogether.model.parameter.ReportSearch;
import com.esc.estogether.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("")
    public ResponseEntity<?> findAllMemberAttendanceList(@RequestParam(required=false) Integer memberId,
                                                         @RequestParam(required=false) Integer groupId,
                                                         @RequestParam(required=false) Integer year,
                                                         @RequestParam(required=false) Integer week) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(reportService.findReport(new ReportSearch(memberId, groupId, year, week)));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
