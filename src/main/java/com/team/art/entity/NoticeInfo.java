package com.team.art.entity;

public class NoticeInfo {
	private Integer id;
	private String content;
	private Integer isUse;
	private Integer isDel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "NoticeInfo [id=" + id + ", content=" + content + ", isUse=" + isUse + ", isDel=" + isDel + "]";
	}
	

	
}
