package com.team.art.service.course;

import java.util.List;

import com.team.art.entity.course.Course;

public interface CourseService {
    List<Course> listAllCourses(Course course);

    List<Course> listCoursesByPid(Integer pid, int teacherId);

    List<Course> listCoursesByPids(Integer pid, Integer teacherId);

    List<Course> listCoursesByAdmin(Integer pid);

    int insertSelective(Course course);

    int insertSelectives(Course course);

    int updateByPrimaryKeySelective(Course course);

    Course selectById(Integer id);

    int updateByDelete(Integer id);

    List<Course> selectCourse();

    List<Course> selectCourseAges(Integer pid);
}
