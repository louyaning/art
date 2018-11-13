package com.team.art.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Created by YaNing on 2018/11/12.
 */
@Controller
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @RequestMapping("/test")
    public String testJsp(){
        logger.info("这是info日志1");
        return "test";
    }
    @ResponseBody
    @RequestMapping("/testJson")
    public String testJson(){
        logger.info("这是info日志2");
        return "hello,project is success";
    }
}
