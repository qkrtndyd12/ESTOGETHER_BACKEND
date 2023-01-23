package com.esc.estogether.api;

import com.esc.estogether.model.vo.Member;
import com.esc.estogether.service.AttendanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(null, null, null));
    }
    @GetMapping("/checked")
    public ResponseEntity<?> findMemberAttendanceList() {
        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(null, null, true));
    }

    @GetMapping("/checked/print")
    public ResponseEntity<?> attendancePrint() {
        return ResponseEntity.ok(attendanceService.attendancePrint(null, null, true));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> findMemberAttendanceList(@PathVariable int groupId) {
        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(null, groupId, null));
    }
    @PostMapping("")
    public ResponseEntity<?> attendanceCheck(@RequestBody List<Member> memberList) {
        return ResponseEntity.ok(attendanceService.attendanceCheck(memberList));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAttendance(@RequestBody List<Member> memberList) {
        return ResponseEntity.ok(attendanceService.deleteAttendance(memberList));
    }
}
