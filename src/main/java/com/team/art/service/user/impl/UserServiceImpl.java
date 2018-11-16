package com.team.art.service.user.impl;

import java.util.List;

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

    @Override
    public int insertUser(User user) {
        int result = userMapper.insertUser(user);
        return result;
    }

    @Override
    public int updateByUser(User user) {
        int result = userMapper.updateByUser(user);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int result = userMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userMapper.listAllUsers();
    }

    @Override
    public int updateByDelete(Long id) {
        int result = userMapper.updateByDelete(id);
        return result;
    }
}
