package com.team.art.mapper.courseware;

import java.util.List;

import com.team.art.entity.courseware.CourseWare;

public interface CourseWareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseWare record);

    int insertSelective(CourseWare record);

    CourseWare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseWare record);

    int updateByPrimaryKey(CourseWare record);

    List<CourseWare> listAllCourses(CourseWare courseWare);

    int updateByDelete(Integer id);
}