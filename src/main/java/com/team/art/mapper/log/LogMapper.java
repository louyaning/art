package com.team.art.mapper.log;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.team.art.entity.log.Log;

@Repository
public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    List<Log> listAllLog(Log log);
}