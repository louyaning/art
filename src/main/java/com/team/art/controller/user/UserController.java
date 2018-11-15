package com.team.art.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.art.controller.DemoController;
import com.team.art.entity.user.User;
import com.team.art.service.user.UserService;

/**
 * Created by YaNing on 2018/11/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private UserService         userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        User user = userService.selectByNameAndPassword(request.getParameter("username"),
            request.getParameter("password"));
        if (null != user) {
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
            return "teacher_list";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/toadd")
    public String toAdd() {
        System.out.println("caoiniwc");
        return "teacher_add";
    }

    @RequestMapping("/update")
    public String updateUser(User user) {
        int result = userService.updateByUser(user);
        if (result == 1) {
            return "teacher_list";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/delete")
    public String deleteUser(Long id) {
        int result = userService.deleteByPrimaryKey(id);
        if (result == 1) {
            return "teacher_list";
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
