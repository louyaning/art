package com.team.art.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.art.entity.course.Course;
import com.team.art.mapper.course.CourseMapper;
import com.team.art.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> listAllCourses(Course course) {
        List<Course> Courses = courseMapper.listAllCourses(course);
        return Courses;
    }

    @Override
    public int insertSelective(Course record) {
        record.setPid(0);
        record.setpName("根目录");
        int result = courseMapper.insertSelective(record);
        return result;
    }

    @Override
    public int insertSelectives(Course record) {
        int result = courseMapper.insertSelective(record);
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(Course course) {
        int result = courseMapper.updateByPrimaryKeySelective(course);
        return result;
    }

    @Override
    public Course selectById(Integer id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        return course;
    }

    @Override
    public int updateByDelete(Integer id) {
        int result = courseMapper.updateByDelete(id);
        return result;
    }

    @Override
    public List<Course> listCoursesByPid(Integer pid, int teacherId) {
        List<Course> courses = courseMapper.listCoursesByPid(pid, teacherId);
        return courses;
    }

    @Override
    public List<Course> listCoursesByPids(Integer pid, Integer teacherId) {
        List<Course> courses = courseMapper.listCoursesByPids(pid, teacherId);
        return courses;
    }

    @Override
    public List<Course> listCoursesByAdmin(Integer pid) {
        List<Course> courses = courseMapper.listCoursesByAdmin(pid);
        return courses;
    }

    @Override
    public List<Course> selectCourse() {
        List<Course> courses = courseMapper.selectCourse();
        return courses;
    }

    @Override
    public List<Course> selectCourseAges(Integer pid) {
        List<Course> courses = courseMapper.selectCourseAges(pid);
        return courses;
    }

}
