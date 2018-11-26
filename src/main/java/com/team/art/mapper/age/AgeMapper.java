package com.team.art.mapper.age;

import com.team.art.entity.age.Age;

public interface AgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Age record);

    int insertSelective(Age record);

    Age selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Age record);

    int updateByPrimaryKey(Age record);
}