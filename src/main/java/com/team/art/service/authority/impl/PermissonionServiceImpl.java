package com.team.art.service.authority.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.permission.Permission;
import com.team.art.mapper.authority.PermissionMapper;
import com.team.art.service.authority.PermissonionService;

@Service
public class PermissonionServiceImpl implements PermissonionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int insertSelective(Permission permission) {
        return permissionMapper.insertSelective(permission);
    }

    @Override
    public List<Permission> getAll(Permission permission) {
        return permissionMapper.listAllPermissions(permission);
    }

    @Override
    public int deleteById(Integer id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

}
