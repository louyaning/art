package com.team.art.service.course;

import java.util.List;

import com.team.art.entity.course.Course;

public interface CourseService {
    List<Course> listAllCourses(Course course);

    int insertSelective(Course course);

    int updateByPrimaryKeySelective(Course course);

    Course selectById(Integer id);

    int updateByDelete(Integer id);
}
