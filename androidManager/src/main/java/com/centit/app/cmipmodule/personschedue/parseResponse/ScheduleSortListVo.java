package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.util.ArrayList;

public class ScheduleSortListVo {
	private ArrayList<ScheduleSortVo> dataList;
	public ScheduleSortListVo() {
		super();
	}
	public ScheduleSortListVo(ArrayList<ScheduleSortVo> dataList) {
		super();
		this.dataList = dataList;
	}
	public ArrayList<ScheduleSortVo> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<ScheduleSortVo> dataList) {
		this.dataList = dataList;
	}
	
}
