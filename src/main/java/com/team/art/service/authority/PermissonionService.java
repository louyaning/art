package com.team.art.service.authority;

import java.util.List;

import com.team.art.entity.permission.Permission;

public interface PermissonionService {

    int insertSelective(Permission permission);

    List<Permission> getAll(Permission permission);

    int deleteById(Integer id);

}
