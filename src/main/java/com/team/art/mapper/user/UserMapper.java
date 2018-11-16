package com.team.art.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.team.art.entity.user.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertUser(User record);

    User selectByPrimaryKey(Long id);

    int updateByUser(User user);

    int updateByPrimaryKey(User record);

    User selectByNameAndPassword(@Param("username") String username,
                                 @Param("password") String password);

    List<User> listAllUsers(User user);

    int updateByDelete(Long id);
}