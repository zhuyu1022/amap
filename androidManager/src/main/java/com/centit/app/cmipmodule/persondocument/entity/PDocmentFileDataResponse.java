/*
 * File name:  PDocmentFileDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.persondocument.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-2-29]
 */
public class PDocmentFileDataResponse implements Serializable
{
    
    /**
     * PDocmentFileDataResponse.java
     */
    private static final long       serialVersionUID = 1L;
    
    private PDocumentFolderInfo     folder;
    
    private List<PDocumentFileInfo> fileList         = new ArrayList<PDocumentFileInfo>();
    
    public PDocumentFolderInfo getFolder()
    {
        return folder;
    }
    
    public void setFolder(PDocumentFolderInfo folder)
    {
        this.folder = folder;
    }
    
    public List<PDocumentFileInfo> getFileList()
    {
        return fileList;
    }
    
    public void setFileList(List<PDocumentFileInfo> fileList)
    {
        this.fileList = fileList;
    }
    
}
