package com.team.art.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.NoticeInfo;
import com.team.art.mapper.NoticeInfoMapper;

/**
 * Created by YaNing on 2018/11/12.
 */
@Service
public class NoticeInfoService {
	@Autowired
	private NoticeInfoMapper noticeInfoMapper;
	
	public int updateByPrimaryKeySelective(NoticeInfo notice){
		return noticeInfoMapper.updateByPrimaryKeySelective(notice);
	}
	public NoticeInfo selectByid(NoticeInfo notice){
		return noticeInfoMapper.selectByid(notice);
	}
}
