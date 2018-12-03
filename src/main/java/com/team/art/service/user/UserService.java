package com.team.art.service.user;

import java.util.List;

import com.team.art.entity.user.User;

/**
 * Created by YaNing on 2018/11/12.
 */

public interface UserService {
    User selectByNameAndPassword(String username, String password);

    /**
     * 
     * 新增老师
     * @param record
     * @return
     */
    int insertUser(User record);

    /**
     * 
     * 修改老师
     * @param record
     * @return
     */

    int updateByUser(User record);

    /**
     * 
     * 删除老师
     * @param id
     * @return
     */

    int deleteByPrimaryKey(Long id);

    /**
     * 
     * 查看详情
     * @param id
     * @return
     */
    User selectByPrimaryKey(Long id);

    List<User> getAll(User user);

    /**
    * 
    * 逻辑删除
    * @return
    */
    int updateByDelete(Long id);
	
	/**
    * 
    * 查询老师
    * @return
    */
	List<User> selectTeacher();
}
