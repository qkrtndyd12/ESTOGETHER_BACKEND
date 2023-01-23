package com.esc.estogether.service;

import com.esc.estogether.exception.ApiException;
import com.esc.estogether.exception.ExceptionEnum;
import com.esc.estogether.mapper.MemberMapper;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberAttendance;
import com.esc.estogether.model.vo.MemberByGroup;
import com.esc.estogether.model.parameter.MemberSearch;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public List<Member> findAll(MemberSearch memberSearch) {
        return Optional.of(memberMapper.findAll(memberSearch)).orElseThrow(() -> new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR));
    }

    public Member findById(MemberSearch memberSearch) {
        return memberMapper.findById(memberSearch).orElseThrow(() -> new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR));
    }

    public List<MemberByGroup> findMemberByGroupIdOrderByGroup(MemberSearch memberSearch) {
        return memberMapper.findMemberByGroupIdOrderByGroup(memberSearch);
    }
}