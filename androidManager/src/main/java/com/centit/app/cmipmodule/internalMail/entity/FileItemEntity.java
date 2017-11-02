package com.centit.app.cmipmodule.internalMail.entity;

import java.io.File;

/**
 * 文件列表项
 * @author wl
 *
 */
public class FileItemEntity {
	/** 文件 **/
    private File    file;
    
    /** 是否选中 **/
    private boolean isSelect;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}
}
