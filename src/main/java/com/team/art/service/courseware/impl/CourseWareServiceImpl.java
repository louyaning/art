package com.team.art.service.courseware.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.courseware.CourseWare;
import com.team.art.mapper.courseware.CourseWareMapper;
import com.team.art.service.courseware.CourseWareService;

@Service
public class CourseWareServiceImpl implements CourseWareService {

    @Autowired
    private CourseWareMapper courseWareMapper;

    @Override
    public List<CourseWare> listAllCourses(CourseWare course) {
        List<CourseWare> courseWare = courseWareMapper.listAllCourseWares(course);
        return courseWare;
    }

    @Override
    public int insertSelective(CourseWare record) {
        int result = courseWareMapper.insertSelective(record);
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(CourseWare course) {
        int result = courseWareMapper.updateByPrimaryKeySelective(course);
        return result;
    }

    @Override
    public CourseWare selectById(Integer id) {
        CourseWare courseWare = courseWareMapper.selectByPrimaryKey(id);
        return courseWare;
    }

    @Override
    public int updateByDelete(Integer id) {
        int result = courseWareMapper.updateByDelete(id);
        return result;
    }
}
