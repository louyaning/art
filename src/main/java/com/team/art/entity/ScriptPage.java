package com.team.art.entity;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class ScriptPage {
	//封装的数据
	private List rows;
	//页码
	private Integer totalNumber;
	//总条数
	private Integer total;
	//当前页显示条数
	private Integer pageSize;
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public List getRows() {
		return rows;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotal() {
		return total;
	}
}
