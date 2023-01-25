package com.esc.estogether.api;

import com.esc.estogether.model.parameter.AttendanceSearch;
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

    @GetMapping("/groups")
    public ResponseEntity<?> findGroupAttendanceList(AttendanceSearch attendanceSearch) {
        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(attendanceSearch));
    }
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<?> findGroupAttendanceListByGroupId(@PathVariable int groupId,
                                                      AttendanceSearch attendanceSearch) {
        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(attendanceSearch));
    }
//    @GetMapping("/findAll")
//    public ResponseEntity<?> findAllMemberAttendanceList(AttendanceSearch attendanceSearch) {
//        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(attendanceSearch));
//    }
//    @GetMapping("/checked")
//    public ResponseEntity<?> findMemberAttendanceList(AttendanceSearch attendanceSearch) {
//        return ResponseEntity.ok(attendanceService.findMemberAttendanceList(attendanceSearch));
//    }

    @GetMapping("/checked/print")
    public ResponseEntity<?> attendancePrint() {
        return ResponseEntity.ok(attendanceService.attendancePrint(null, null, true));
    }

    @PostMapping("")
    public ResponseEntity<?> attendanceCheck(@RequestBody List<Member> memberList) {
        return ResponseEntity.ok(attendanceService.attendanceCheck(memberList));
    }

    @PostMapping("/members/{memberId}")
    public ResponseEntity<?> attendanceCheckByMemberId(@PathVariable int memberId,
                                                       @RequestBody AttendanceSearch attendanceSearch) {
        attendanceSearch.setMemberId(memberId);
        return ResponseEntity.ok(attendanceService.attendanceCheckByMemberId(attendanceSearch));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAttendance(@RequestBody List<Member> memberList) {
        return ResponseEntity.ok(attendanceService.deleteAttendance(memberList));
    }
}
