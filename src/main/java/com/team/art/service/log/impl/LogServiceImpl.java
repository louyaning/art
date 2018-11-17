package com.team.art.service.log.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.log.Log;
import com.team.art.mapper.log.LogMapper;
import com.team.art.service.log.LogService;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int insert(Log record) {
        int result = logMapper.insert(record);
        return result;
    }

    @Override
    public List<Log> listAllLog(Log log) {
        List<Log> listAllLog = logMapper.listAllLog(log);
        return listAllLog;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int result = logMapper.deleteByPrimaryKey(id);
        return result;
    }

}
