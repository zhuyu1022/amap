/*
 * File name:  PDocumentFolderInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-3
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.persondocument.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-3]
 */
public class PDocumentFolderInfo implements Serializable
{
    
    /**
     * PDocumentFolderInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    // "folderId": "2183",
    // "folderName": "部门文档首页",
    // "crud": "3"
    
    private String            folderId;
    
    private String            folderName;
    
    private String            crud;
    
    public String getFolderId()
    {
        return folderId;
    }
    
    public void setFolderId(String folderId)
    {
        this.folderId = folderId;
    }
    
    public String getFolderName()
    {
        return folderName;
    }
    
    public void setFolderName(String folderName)
    {
        this.folderName = folderName;
    }
    
    public String getCrud()
    {
        return crud;
    }
    
    public void setCrud(String crud)
    {
        this.crud = crud;
    }
    
}
