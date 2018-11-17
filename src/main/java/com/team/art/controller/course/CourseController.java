package com.team.art.controller.course;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.art.entity.course.Course;
import com.team.art.service.course.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public String SearchPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Model model, Course course) {
        //使用分页插件
        PageHelper.startPage(pn, 5);
        List<Course> courses = courseService.listAllCourses(course);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就好了
        //可传入连续显示的页数
        PageInfo page = new PageInfo(courses, 8);
        model.addAttribute("pageInfo", page);

        return "course/course_list";//由于视图解析器，会跳转到/WEB-INF/views/目录下

    }

    @RequestMapping("/toadd")
    public String toAdd() {
        return "course/course_add";
    }

    @RequestMapping("/add")
    public String insertUser(Course course) {
        Date createDatetime = new Date();
        course.setCreateDatetime(createDatetime);
        course.setIsDelete(1);
        int result = courseService.insertSelective(course);
        if (result == 1) {
            return "redirect:courses";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Integer id) {
        Course course = courseService.selectById(id);
        return new ModelAndView("course/course_update").addObject("course", course);
    }

    @RequestMapping("/update")
    public String updateUser(Course course) {
        Date modifyDatetime = new Date();
        course.setModifyDatetime(modifyDatetime);
        int result = courseService.updateByPrimaryKeySelective(course);
        if (result == 1) {
            return "redirect:courses";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/delete")
    public String deleteUser(Integer id) {
        int result = courseService.updateByDelete(id);
        if (result == 1) {
            return "redirect:courses";
        } else {
            return "删除失败";
        }
    }
}
