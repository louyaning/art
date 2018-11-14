package com.team.art.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
            return "test";
        } else {
            return "index";
        }
    }

}
