package com.team.art.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.user.User;
import com.team.art.mapper.user.UserMapper;
import com.team.art.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByNameAndPassword(String username, String password) {
        return userMapper.selectByNameAndPassword(username, password);
    }
}
