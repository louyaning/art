package com.team.art.mapper.course;

import java.util.List;

import com.team.art.entity.course.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> listAllCourses(Course course);

    int updateByDelete(Integer id);
    
    List<Course> listCoursesByPid(Integer pid);
}