package com.centit.app.cmipThirtpart.cmipmodulemgr;

import java.io.Serializable;
import java.util.List;

public class ModuleTeamEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String funCode;

	private String funName;
	
	private int sort ;

	private List<ModuleEntity> mModuleEntitys;

	/**
	 * @return the funCode
	 */
	public String getFunCode() {
		return funCode;
	}

	/**
	 * @param funCode the funCode to set
	 */
	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}

	/**
	 * @return the funName
	 */
	public String getFunName() {
		return funName;
	}

	/**
	 * @param funName the funName to set
	 */
	public void setFunName(String funName) {
		this.funName = funName;
	}

	/**
	 * @return the mModuleEntitys
	 */
	public List<ModuleEntity> getmModuleEntitys() {
		return mModuleEntitys;
	}

	/**
	 * @param mModuleEntitys the mModuleEntitys to set
	 */
	public void setmModuleEntitys(List<ModuleEntity> mModuleEntitys) {
		this.mModuleEntitys = mModuleEntitys;
	}

	/**
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
}
