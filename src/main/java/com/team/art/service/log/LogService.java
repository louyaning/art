package com.team.art.service.log;

import java.util.List;

import com.team.art.entity.log.Log;

public interface LogService {
    int insert(Log record);

    List<Log> listAllLog(Log log);

    int deleteByPrimaryKey(Long id);
}
