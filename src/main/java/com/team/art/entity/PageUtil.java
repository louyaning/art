package com.team.art.entity;

import java.util.List;

/**
 * 
 * @ClassName: PageUtil  
 * @Description: 手写分页组件
 * @author YaNing
 * @date 2018年12月5日 下午5:56:16
 */
public class PageUtil {
	private Integer pageNo = 1;
	
	private Integer pageSize = 2;
	//开始行
	private Integer startRow;
	//封装的数据
	private List<Object> rows;
	//总页码
	private Integer totalNumebr;
	
	private Integer pageCount;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartRow() {
		System.out.println("写入数据："+startRow);
		return pageSize * ( pageNo - 1);
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	public Integer getTotalNumebr() {
		return totalNumebr;
	}
	public void setTotalNumebr(Integer totalNumebr) {
		this.totalNumebr = totalNumebr;
	}
	
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}
	
	public void calculatePageCount(Integer totalNumebr) {
		if (totalNumebr % pageSize == 0)
			pageCount = totalNumebr / pageSize;
		else
			pageCount = totalNumebr / pageSize + 1;
	}
	
	

}
