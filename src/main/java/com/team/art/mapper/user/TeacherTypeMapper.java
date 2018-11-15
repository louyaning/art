package com.team.art.mapper.user;

import org.springframework.stereotype.Repository;

import com.team.art.entity.user.TeacherType;

@Repository
public interface TeacherTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherType record);

    int insertSelective(TeacherType record);

    TeacherType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherType record);

    int updateByPrimaryKey(TeacherType record);
}