package com.team.art.service.courseware;

import java.util.List;

import com.team.art.entity.courseware.CourseWare;

public interface CourseWareService {
    List<CourseWare> listAllCourses(CourseWare courseWare);

    int insertSelective(CourseWare courseWare);

    int updateByPrimaryKeySelective(CourseWare courseWare);

    CourseWare selectById(Integer id);

    int updateByDelete(Integer id);
}
