package com.team.art.controller.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.art.controller.DemoController;
import com.team.art.entity.log.Log;
import com.team.art.entity.user.User;
import com.team.art.service.log.LogService;
import com.team.art.service.user.UserService;
import com.team.art.util.SessionUtil;

/**
 * Created by YaNing on 2018/11/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private UserService         userService;
    @Autowired
    private LogService          logService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        User user = userService.selectByNameAndPassword(request.getParameter("username"),
            request.getParameter("password"));

        if (null != user) {
            SessionUtil.getSession().setAttribute("user", user);
            Log log = new Log();
            Date loginTime = new Date();
            log.setUserName(user.getUsername());
            log.setLoginTime(loginTime);
            log.setUserId(user.getId());
            logService.insert(log);
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/add")
    public String insertUser(User user) {
        Date createDatetime = new Date();
        user.setCreateDatetime(createDatetime);
        user.setIsDelete(1);
        int result = userService.insertUser(user);
        if (result == 1) {
            return "redirect:users";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/toadd")
    public String toAdd() {
        return "teacher/teacher_add";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Long id) {
        User user = userService.selectByPrimaryKey(id);
        return new ModelAndView("teacher/teacher_update").addObject("user", user);
    }

    @RequestMapping("/users")
    public String SearchPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Model model, User user) {
        //使用分页插件
        PageHelper.startPage(pn, 5);
        List<User> users = userService.getAll(user);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就好了
        //可传入连续显示的页数
        PageInfo page = new PageInfo(users, 8);
        model.addAttribute("pageInfo", page);

        return "teacher/teacher_list";//由于视图解析器，会跳转到/WEB-INF/views/目录下

    }

    @RequestMapping("/update")
    public String updateUser(User user) {
        Date modifyDatetime = new Date();
        user.setModifyDatetime(modifyDatetime);
        int result = userService.updateByUser(user);
        if (result == 1) {
            return "redirect:users";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/delete")
    public String deleteUser(Long id) {
        int result = userService.updateByDelete(id);
        if (result == 1) {
            return "redirect:users";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/detail")
    public ModelAndView findById(Long id) {
        User user = userService.selectByPrimaryKey(id);
        return new ModelAndView("teacher_detail").addObject("user", user);
    }
}
