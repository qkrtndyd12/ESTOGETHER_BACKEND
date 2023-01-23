package com.esc.estogether.mapper;

import com.esc.estogether.model.parameter.GroupSearch;
import com.esc.estogether.model.parameter.MemberSearch;
import com.esc.estogether.model.vo.Group;
import com.esc.estogether.model.vo.Member;
import com.esc.estogether.model.vo.MemberByGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupMapper {

    List<Group> findGroup(GroupSearch groupSearch);

}