package com.team.art.service.user;

import com.team.art.entity.user.User;

/**
 * Created by YaNing on 2018/11/12.
 */

public interface UserService {
    User selectByNameAndPassword(String username, String password);
}
