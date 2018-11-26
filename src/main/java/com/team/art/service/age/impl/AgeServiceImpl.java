package com.team.art.service.age.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.age.Age;
import com.team.art.mapper.age.AgeMapper;
import com.team.art.service.age.AgeService;

@Service
public class AgeServiceImpl implements AgeService {

    @Autowired
    private AgeMapper ageMapper;

    @Override
    public List<Age> selectAges() {
        return ageMapper.selectAges();
    }

}
