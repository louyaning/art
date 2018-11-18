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
    public List<CourseWare> listAllCoursesWare(CourseWare courseWare) {
        List<CourseWare> courseWares = courseWareMapper.listAllCourseWares(courseWare);
        return courseWares;
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

    @Override
    public List<CourseWare> listCoursesWareByBranch(CourseWare courseWare) {
        List<CourseWare> listCoursesWareByBranch = courseWareMapper
            .listCoursesWareByBranch(courseWare);
        return listCoursesWareByBranch;
    }

}
