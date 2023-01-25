package com.esc.estogether.api;

import com.esc.estogether.model.parameter.MemberSearch;
import com.esc.estogether.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public ResponseEntity<?> findAll(MemberSearch memberSearch) {
        return ResponseEntity.ok().body(memberService.findAll(memberSearch));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<?> findMemberByMemberId(@PathVariable Integer memberId,
                                                  MemberSearch memberSearch) {
        memberSearch.setMemberId(memberId);
        return ResponseEntity.ok().body(memberService.findById(memberSearch));
    }

//    @GetMapping("/groups")
//    public ResponseEntity<?> findMemberOrderByGroup() {
//        return ResponseEntity.ok().body(memberService.findMemberByGroupIdOrderByGroup(new MemberSearch()));
//    }
//    @GetMapping("/groups/{groupId}")
//    public ResponseEntity<?> findMemberByGroupIdOrderByGroup(@PathVariable Integer groupId) {
//        return ResponseEntity.ok().body(memberService.findMemberByGroupIdOrderByGroup(new MemberSearch(null, groupId)));
//    }
}
