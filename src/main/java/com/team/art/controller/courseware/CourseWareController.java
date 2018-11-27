package com.team.art.controller.courseware;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.art.entity.course.Course;
import com.team.art.entity.courseware.CourseWare;
import com.team.art.service.course.CourseService;
import com.team.art.service.courseware.CourseWareService;

@Controller
@RequestMapping("/courseware")
public class CourseWareController {
    @Autowired
    private CourseWareService courseWareService;

    @Autowired
    private CourseService     courseService;

    @RequestMapping("/coursewares")
    public String SearchPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Model model, CourseWare courseware) {
        //使用分页插件
        PageHelper.startPage(pn, 5);
        List<CourseWare> courseWare = courseWareService.listAllCoursesWare(courseware);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就好了
        //可传入连续显示的页数
        PageInfo page = new PageInfo(courseWare, 8);
        model.addAttribute("pageInfo", page);

        return "courseware/courseware_list";//由于视图解析器，会跳转到/WEB-INF/views/目录下

    }

    @RequestMapping("/toadd")
    public ModelAndView toAdd() {
        return new ModelAndView("courseware/courseware_add");
    }

    @RequestMapping("/toloadAge/{pid}")
    @ResponseBody
    public List<Course> toloadAge(@PathVariable("pid") String pid) {
        List<Course> ages = courseService.selectCourseAges(Integer.valueOf(pid));
        return ages;
    }

    @RequestMapping("/add")
    public String insertUser(CourseWare courseware) {
        Date createDatetime = new Date();
        courseware.setCreateDatetime(createDatetime);
        courseware.setIsDelete(1);
        int result = courseWareService.insertSelective(courseware);
        if (result == 1) {
            return "redirect:coursewares";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/addWars")
    public String addWares(HttpServletRequest request,
                           @RequestParam(value = "file") MultipartFile file,
                           RedirectAttributes redirectAttributes) {
        String names = request.getParameter("ids");
        String courseId = request.getParameter("courseId");
        String weight = request.getParameter("weight");
        Date createDatetime = new Date();
        return "注册失败";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Integer id) {
        CourseWare course = courseWareService.selectById(id);
        return new ModelAndView("courseware/courseware_update").addObject("course", course);
    }

    @RequestMapping("/update")
    public String updateUser(CourseWare course) {
        Date modifyDatetime = new Date();
        course.setModifyDatetime(modifyDatetime);
        int result = courseWareService.updateByPrimaryKeySelective(course);
        if (result == 1) {
            return "redirect:coursewares";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/delete")
    public String deleteUser(Integer id) {
        int result = courseWareService.updateByDelete(id);
        if (result == 1) {
            return "redirect:coursewares";
        } else {
            return "删除失败";
        }
    }
}
