package com.team.art.entity.courseware;

import java.util.Date;

public class CourseWare {
    private Integer id;

    private Integer courseId;

    private String  wareName;

    private String  realName;

    private String  wareUrl;

    private String  imgUrl;

    private Date    createDatetime;

    private Date    modifyDatetime;

    private Integer isDelete;

    private String  desc;

    private Integer branch;

    private String  branchName;

    private String  suffix;

    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName == null ? null : wareName.trim();
    }

    public String getWareUrl() {
        return wareUrl;
    }

    public void setWareUrl(String wareUrl) {
        this.wareUrl = wareUrl == null ? null : wareUrl.trim();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getBranch() {
        return branch;
    }

    public void setBranch(Integer branch) {
        this.branch = branch;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "CourseWare [id=" + id + ", courseId=" + courseId + ", wareName=" + wareName
               + ", wareUrl=" + wareUrl + ", createDatetime=" + createDatetime + ", modifyDatetime="
               + modifyDatetime + ", isDelete=" + isDelete + ", desc=" + desc + ", branch=" + branch
               + ", suffix=" + suffix + ", weight=" + weight + "]";
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}