package com.team.art.mapper;

import org.springframework.stereotype.Repository;

import com.team.art.entity.NoticeInfo;

/**
 * Created by YaNing on 2018/11/12.
 */
@Repository
public interface NoticeInfoMapper {
	int updateByPrimaryKeySelective(NoticeInfo notice);
	NoticeInfo selectByid(NoticeInfo notice);
}
