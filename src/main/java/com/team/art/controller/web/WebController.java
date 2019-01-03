package com.team.art.controller.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.art.entity.NoticeInfo;
import com.team.art.entity.ScriptPage;
import com.team.art.entity.course.Course;
import com.team.art.entity.courseware.CourseWare;
import com.team.art.entity.user.User;
import com.team.art.service.NoticeInfoService;
import com.team.art.service.course.CourseService;
import com.team.art.service.courseware.CourseWareService;
import com.team.art.service.user.UserService;

@Controller
public class WebController {

    @Autowired
    private CourseService     courceService;
    @Autowired
    private CourseWareService courseWareService;
    @Autowired
    private UserService       userService;
    @Autowired
    private NoticeInfoService noticeInfoService;

    @RequestMapping("/web/index")
    public String index(CourseWare courseWare, HttpServletRequest request) {

        //TODO 这里的操作应该是。查出来一级菜单，在查出来二级菜单。 
        Integer teacherId = Integer.valueOf(request.getParameter("teacherId"));

        User user = userService.selectByPrimaryKey(Long.valueOf(teacherId));
        NoticeInfo notice = new NoticeInfo();
        notice.setId(1);
        NoticeInfo noticeInfo = noticeInfoService.selectByid(notice);
        if ("老师".equals(user.getType())) {
            //根据pid查出来所有一级id
            List<Course> courses = courceService.listCoursesByPid(0, teacherId.intValue());
           
            try {
                if (courses.size() > 0) {
                    //循环取出所有的二级菜单
                    for (Course course : courses) {
                        course
                            .setCourses(courceService.listCoursesByPids(course.getId(), teacherId));
                    }
                    /* //取出第一个默认
                    courseWare.setCourseId(
                        courceService.listCoursesByPids(courses.get(0).getId()).get(0).getId());*/

                    List<CourseWare> listCoursesWareByBranch = courseWareService
                        .listCoursesWareByBranch(courseWare);
                   
                    request.setAttribute("notice", noticeInfo.getContent());	
                    request.setAttribute("listCoursesWareByBranch", listCoursesWareByBranch);
                }

                request.setAttribute("courses", courses);
            } catch (Exception e) {
                //e.printStackTrace();

            }
        } else {
            //根据pid查出来所有一级id
            List<Course> courses = courceService.listCoursesByAdmin(0);
            try {
                if (courses.size() > 0) {
                    //循环取出所有的二级菜单
                    for (Course course : courses) {
                        course.setCourses(courceService.listCoursesByAdmin(course.getId()));
                    }
                    //坑爹操作一
                    courseWare.setCourseId(
                        courceService.listCoursesByAdmin(courses.get(0).getId()).get(0).getId());

                    List<CourseWare> listCoursesWareByBranch = courseWareService
                        .listCoursesWareByBranch(courseWare);
                    request.setAttribute("notice", noticeInfo.getContent());
                    request.setAttribute("listCoursesWareByBranch", listCoursesWareByBranch);
                }

                request.setAttribute("courses", courses);
            } catch (Exception e) {
                //e.printStackTrace();

            }
        }
        return "index";

    }

    @RequestMapping("/web/login")
    public String login() {

        return "login";

    }

    @RequestMapping("/loadCourseWare")
    @ResponseBody
    public ScriptPage loadCourseWare(CourseWare courseWare, HttpServletRequest request) {

        List<CourseWare> listCoursesWareByBranch = courseWareService
            .listCoursesWareByBranch(courseWare);
        int cout = courseWareService.countCoursesWareByBranch(courseWare);
        ScriptPage scriptPage = new ScriptPage();
        scriptPage.setRows(listCoursesWareByBranch);
        courseWare.calculatePageCount(cout);
        scriptPage.setTotal(cout);
        scriptPage.setTotalNumber(courseWare.getPageCount());
        return scriptPage;

    }

    @RequestMapping("/downCourseWare")
    public ResponseEntity<byte[]> export(HttpServletRequest request) throws IOException {
        String fileName = request.getParameter("fileName");
        HttpHeaders headers = new HttpHeaders();
        CourseWare courseWare = courseWareService.selectByWareName(fileName);
        String wareUrl = courseWare.getWareUrl();
        String url = wareUrl.replaceAll("\\\\", "/");
        File file = new File(url + "/" + fileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers,
            HttpStatus.CREATED);
    }
    
    
    
    /**
     * 修改公共
     */
  
    @RequestMapping("saveNotcie")
    @ResponseBody
    public String saveNotice(NoticeInfo notice){
    	
    	notice.setId(1);
    	int count = noticeInfoService.updateByPrimaryKeySelective(notice);
    	if(count > 0){
    		return "{\"msg\":\"SUCCESS\"}";
    	}else{
    		return "{\"msg\":\"ERROR\"}";
    	}
    	
    }
    /**
     * 获取公共
     */
//    @ResponseBody
//    @RequestMapping("getNotcie")
//    public String getNotice(){
//    	return NoticeInfo.getNOTICE();
//    }
}
