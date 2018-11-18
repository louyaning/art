package com.team.art.entity.course;

import java.util.Date;
import java.util.List;

public class Course {
    private Integer id;

    private String courseName;

    private String cover;

    private Integer weight;

    private Integer pid;

    private String pName;

    private Date createDatetime;

    private Date modifyDatetime;

    private Integer isDelete;
    
    //用于封装子目录的课程
    private List<Course> courses;
    
    public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
    
    public List<Course> getCourses() {
		return courses;
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", cover=" + cover + ", weight=" + weight + ", pid="
				+ pid + ", pName=" + pName + ", createDatetime=" + createDatetime + ", modifyDatetime=" + modifyDatetime
				+ ", isDelete=" + isDelete + ", courses=" + courses + "]";
	}
   
}