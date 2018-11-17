package com.team.art.controller.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.art.entity.log.Log;
import com.team.art.service.log.LogService;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/logs")
    public String SearchPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Model model, Log log) {
        //使用分页插件
        PageHelper.startPage(pn, 5);
        List<Log> logs = logService.listAllLog(log);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交个页面就好了
        //可传入连续显示的页数
        PageInfo page = new PageInfo(logs, 8);
        model.addAttribute("pageInfo", page);

        return "log/log_list";//由于视图解析器，会跳转到/WEB-INF/views/目录下

    }

    @RequestMapping("/delete")
    public String deleteLog(Long id) {
        int result = logService.deleteByPrimaryKey(id);
        if (result == 1) {
            return "redirect:logs";
        } else {
            return "注册失败";
        }
    }

}
