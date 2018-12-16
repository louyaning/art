package com.team.art.mapper.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

    List<Course> listCoursesByPid(@Param("pid") Integer pid, @Param("teacherId") int teacherId);

    List<Course> listCoursesByPids(@Param("pid") Integer pid,
                                   @Param("teacherId") Integer teacherId);

    List<Course> listCoursesByAdmin(Integer pid);

    List<Course> selectCourse();

    List<Course> selectCourseAges(Integer pid);
}