package com.team.art.service.age;

import java.util.List;

import com.team.art.entity.age.Age;

public interface AgeService {
    List<Age> selectAges();

    Age selectByid(Integer id);

    int insertSelective(Age record);
}
