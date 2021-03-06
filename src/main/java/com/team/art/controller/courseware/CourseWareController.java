package com.team.art.controller.courseware;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        List<CourseWare> courseWares = courseWareService.listAllCoursesWare(courseware);
        PageInfo page = new PageInfo(courseWares, 6);
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
                           RedirectAttributes redirectAttributes) throws IOException {
        String id = request.getParameter("id");
        String courseId = request.getParameter("courseId");
        String weight = request.getParameter("weight");
        String desc = request.getParameter("desc");
        Date createDatetime = new Date();
        CourseWare courseWar = new CourseWare();
        Course course = courseService.selectById(Integer.valueOf(courseId));
        if (!file.isEmpty()) {
            //以下的代码是将文件file重新命名并存入Tomcat的webapps目录下项目的下级目录fileDir
            String fileRealName = file.getOriginalFilename(); //获得原始文件名;
            int pointIndex = fileRealName.indexOf("."); //点号的位置     
            String fileSuffix = fileRealName.substring(pointIndex); //截取文件后缀
            UUID FileId = UUID.randomUUID(); //生成文件的前缀包含连字符
            String savedFileName = FileId.toString().replace("-", "").concat(fileSuffix); //文件存取名
            String savedDir = request.getSession().getServletContext().getRealPath("fileDir"); //获取服务器指定文件存取路径  
            File savedFile = new File(savedDir, savedFileName);
            //保存到数据库
            courseWar.setCreateDatetime(createDatetime);
            courseWar.setCourseId(Integer.valueOf(id));
            courseWar.setIsDelete(1);
            courseWar.setRealName(fileRealName);
            courseWar.setWeight(Integer.valueOf(weight));
            courseWar.setDesc(desc);
            courseWar.setBranch(Integer.valueOf(courseId));
            courseWar.setBranchName(course.getCourseName());
            courseWar.setWareName(savedFileName);
            courseWar.setWareUrl(savedDir);
            courseWar.setSuffix(fileSuffix);
            if (fileSuffix.equals(".ppt") || fileSuffix.equals(".pptx")) {
                courseWar.setImgUrl(Constant.PPT_IMG_PATH);
            } else if (fileSuffix.equals(".doc") || fileSuffix.equals(".docx")) {
                courseWar.setImgUrl(Constant.WORD_IMG_PATH);
            } else if (fileSuffix.equals(".xlsx") || fileSuffix.equals(".xls")) {
                courseWar.setImgUrl(Constant.EXCEL_IMG_PATH);
            } else {
                courseWar.setImgUrl(Constant.OTHER_IMG_PATH);
            }
            if (!savedFile.exists()) {
                new File(savedDir).mkdirs();
            }
            boolean isCreateSuccess = savedFile.createNewFile();
            courseWareService.insertSelective(courseWar);
            if (isCreateSuccess) {
                file.transferTo(savedFile); //转存文件
            }
        }
        return "redirect:coursewares";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Integer id) {
        CourseWare courseware = courseWareService.selectById(id);
        return new ModelAndView("courseware/courseware_update").addObject("courseware", courseware);
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
