package com.esc.estogether.mapper;


import com.esc.estogether.token.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface LoginMapper {
    Optional<User> findByUserId(String id);
    int saveUser(User user);
    int refreshToken(User user);
    int updateUser(User user);


}
