package com.esc.estogether.mapper;

import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberAttendance;
import com.esc.estogether.model.vo.MemberByGroup;
import com.esc.estogether.model.parameter.MemberSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MemberMapper {

    List<Member> findAll();
    List<MemberByGroup> findMemberByGroupIdOrderByGroup(MemberSearch memberSearch);
}