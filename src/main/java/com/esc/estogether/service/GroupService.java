package com.esc.estogether.service;

import com.esc.estogether.exception.ApiException;
import com.esc.estogether.exception.ExceptionEnum;
import com.esc.estogether.mapper.GroupMapper;
import com.esc.estogether.mapper.MemberMapper;
import com.esc.estogether.model.parameter.GroupSearch;
import com.esc.estogether.model.parameter.MemberSearch;
import com.esc.estogether.model.vo.Group;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberByGroup;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class GroupService {

    private final GroupMapper groupMapper;

    public List<Group> findAll(GroupSearch groupSearch) {
        return Optional.of(groupMapper.findGroup(groupSearch)).orElseThrow(() -> new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR));
    }

    public Group findGroupById(GroupSearch groupSearch) {
        return Optional.of(groupMapper.findGroup(groupSearch).get(0)).orElseThrow(() -> new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR));
    }
    public List<Group> findGroupByReaderId(GroupSearch groupSearch) {
        return groupMapper.findGroup(groupSearch);
    }
}