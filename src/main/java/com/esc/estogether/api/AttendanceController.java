package com.esc.estogether.api;

import com.esc.estogether.dto.ResponseDTO;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.service.AttendanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllMemberAttendanceList() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(attendanceService.findMemberAttendanceList(null, null, null));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/checked")
    public ResponseEntity<?> findMemberAttendanceList() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(attendanceService.findMemberAttendanceList(null, null, true));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/checked/print")
    public ResponseEntity<?> attendancePrint() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(attendanceService.attendancePrint(null, null, true));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> findMemberAttendanceList(@PathVariable int groupId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(attendanceService.findMemberAttendanceList(null, groupId, null));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> attendanceCheck(@RequestBody List<Member> memberList) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(attendanceService.attendanceCheck(memberList));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAttendance(@RequestBody List<Member> memberList) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(attendanceService.deleteAttendance(memberList));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
