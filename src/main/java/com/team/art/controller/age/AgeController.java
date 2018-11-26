package com.team.art.controller.age;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.art.entity.age.Age;
import com.team.art.service.age.AgeService;

@Controller
@RequestMapping("/age")
public class AgeController {
    @Autowired
    private AgeService ageService;

    @RequestMapping("/toadd")
    public String toAdd() {
        return "age/age_add";
    }

    @RequestMapping("/add")
    public String insertUser(Age age) {

        int result = ageService.insertSelective(age);
        if (result == 1) {
            return "redirect:toadd";
        } else {
            return "注册失败";
        }
    }
}
