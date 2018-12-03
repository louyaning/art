package com.team.art.controller.authority;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.art.entity.course.Course;
import com.team.art.entity.permission.Permission;
import com.team.art.service.authority.PermissonionService;
import com.team.art.service.course.CourseService;

/**
 * 
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private CourseService       courseService;

    @Autowired
    private PermissonionService permissionService;

    @RequestMapping("/toAuthority")
    public ModelAndView toAdd() {
        return new ModelAndView("authority/authority_dis");
    }

    @RequestMapping("/addAuthoritys")
    public String addAuthoritys(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String names = request.getParameter("ids");
        String courseId = request.getParameter("courseId");
        String teacherId = request.getParameter("teacherId");
        String teacherName = request.getParameter("teacherName");
        String courseName = request.getParameter("courseName");
        Date createDatetime = new Date();
        String roleName = "";
        for (String name : names.split(",")) {
            if (!"".equals(name)) {
                Course course = courseService.selectById(Integer.valueOf(name));
                roleName += course.getCourseName() + ",";
            }
        }
        Permission permission = new Permission();
        permission.setTeacherId(Integer.valueOf(teacherId));
        permission.setCourseBranchId(names);
        permission.setCoursewareName(roleName.substring(0, roleName.length() - 1));
        permission.setTeacherName(teacherName);
        permission.setCourseId(Integer.valueOf(courseId));
        permission.setCourseName(courseName);
        permission.setCreateDatetime(createDatetime);
        permission.setIsDelete(1);
        permissionService.insertSelective(permission);
        return "redirect:authoritys";
    }

    @RequestMapping("/authoritys")
    public String SearchPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Model model, Permission permission) {
        //使用分页插件
        PageHelper.startPage(pn, 5);
        List<Permission> permissions = permissionService.getAll(permission);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就好了
        //可传入连续显示的页数
        PageInfo page = new PageInfo(permissions, 8);
        model.addAttribute("pageInfo", page);

        return "authority/authority_list";//由于视图解析器，会跳转到/WEB-INF/views/目录下

    }

    @RequestMapping("/delete")
    public String deleteUser(Integer id) {
        int result = permissionService.deleteById(id);
        if (result == 1) {
            return "redirect:authoritys";
        } else {
            return "删除失败";
        }
    }

}
