package com.team.art.controller.course;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.art.entity.age.Age;
import com.team.art.entity.course.Course;
import com.team.art.entity.log.Log;
import com.team.art.entity.user.User;
import com.team.art.service.age.AgeService;
import com.team.art.service.course.CourseService;
import com.team.art.service.log.LogService;
import com.team.art.util.SessionUtil;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private AgeService    ageService;
    @Autowired
    private LogService    logService;

    @RequestMapping("/courses")
    public String SearchPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Model model, Course course) {
        //使用分页插件
        PageHelper.startPage(pn, 5);
        List<Course> courses = courseService.listAllCourses(course);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就好了
        //可传入连续显示的页数
        PageInfo page = new PageInfo(courses, 6);
        model.addAttribute("pageInfo", page);

        return "course/course_list";//由于视图解析器，会跳转到/WEB-INF/views/目录下

    }

    @RequestMapping("/toadd")
    public String toAdd() {
        return "course/course_add";
    }

    /**
     * 给课程分配下一级的年龄菜单，这是第一步，跳到分配页面
     * 
     * @return
     */
    @RequestMapping("/toDistribution")
    public ModelAndView toDistribution() {
        List<Age> ages = ageService.selectAges();
        return new ModelAndView("course/course_dis").addObject("ages", ages);
    }

    @RequestMapping("/add")
    public String insertUser(Course course) {
        Date createDatetime = new Date();
        course.setCreateDatetime(createDatetime);
        course.setIsDelete(1);
        int result = courseService.insertSelective(course);
        if (result == 1) {
            Log log = new Log();
            User attribute = (User) SessionUtil.getSession().getAttribute("user");
            log.setUserName(attribute.getUsername());
            log.setUserId(attribute.getId());
            log.setOpera(attribute.getUsername() + "新增课程" + course.getCourseName());
            logService.insert(log);
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
            Log log = new Log();
            User attribute = (User) SessionUtil.getSession().getAttribute("user");
            log.setUserName(attribute.getUsername());
            log.setUserId(attribute.getId());
            log.setOpera(attribute.getUsername() + "更新课程" + course.getCourseName());
            logService.insert(log);
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

    @RequestMapping(value = "/selectCourse", method = RequestMethod.POST)
    @ResponseBody
    public List<Course> selectCourse(HttpServletRequest request, HttpServletResponse response) {
        List<Course> courses = courseService.selectCourse();
        return courses;
    }

    @RequestMapping("/addKids")
    public String insertCourse(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String names = request.getParameter("ids");
        String courseId = request.getParameter("courseId");
        String weight = request.getParameter("weight");
        Date createDatetime = new Date();
        for (String name : names.split(",")) {
            if (!"".equals(name)) {
                Course course = new Course();
                course.setCourseName(name);
                course.setPid(Integer.valueOf(courseId));
                Course parent = courseService.selectById(Integer.valueOf(courseId));
                course.setWeight(Integer.valueOf(weight));
                course.setpName(parent.getCourseName());
                course.setCreateDatetime(createDatetime);
                course.setIsDelete(1);
                courseService.insertSelectives(course);
            }
        }
        return "redirect:courses";
    }
}
