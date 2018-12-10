package com.team.art.entity;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class ScriptPage {
	//封装的数据
	private List rows;
	//页码
	private Integer total;
	
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
