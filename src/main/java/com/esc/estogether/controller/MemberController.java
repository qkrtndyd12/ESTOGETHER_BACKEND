package com.esc.estogether.controller;

import com.esc.estogether.dto.ResponseDTO;
import com.esc.estogether.model.parameter.MemberSearch;
import com.esc.estogether.service.MemberService;
import com.esc.estogether.model.vo.Member;
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
@RequestMapping(value = "/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(memberService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<?> findMemberByMemberId(@PathVariable Integer memberId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        MemberSearch memberSearch = new MemberSearch();
        memberSearch.setMemberId(memberId);
        responseDTO.setRes(memberService.findMemberByGroupIdOrderByGroup(memberSearch));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/groups")
    public ResponseEntity<?> findMemberOrderByGroup() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        MemberSearch memberSearch = new MemberSearch();
        responseDTO.setRes(memberService.findMemberByGroupIdOrderByGroup(memberSearch));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<?> findMemberByGroupIdOrderByGroup(@PathVariable Integer groupId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        MemberSearch memberSearch = new MemberSearch();
        memberSearch.setGroupId(groupId);
        responseDTO.setRes(memberService.findMemberByGroupIdOrderByGroup(memberSearch));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
