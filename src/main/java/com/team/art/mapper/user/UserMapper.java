package com.team.art.mapper.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.team.art.entity.user.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByNameAndPassword(@Param("username") String username,
                                 @Param("password") String password);
}