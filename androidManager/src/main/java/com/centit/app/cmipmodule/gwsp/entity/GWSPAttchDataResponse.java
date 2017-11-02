/*
 * File name:  GWSPAttchDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-7-13
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.gwsp.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-7-13]
 */
public class GWSPAttchDataResponse implements Serializable
{
    
    /**
     * GWSPAttchDataResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "assetid":""
    // "name":""
    // "fileSize":""
    
    private String            assetid;
    
    private String            name;
    
    private String            fileSize;
    
    public String getAssetid()
    {
        return assetid;
    }
    
    public void setAssetid(String assetid)
    {
        this.assetid = assetid;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getFileSize()
    {
        return fileSize;
    }
    
    public void setFileSize(String fileSize)
    {
        this.fileSize = fileSize;
    }
    
}
