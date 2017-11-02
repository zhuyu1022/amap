/*
 * File name:  InforMarketListInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.informarket.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-22]
 */
public class InforMarketListInfo implements Serializable
{
    
    /**
     * InforMarketListInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    /** 文件id **/
    private String            id;
    
    /** 文件标题 **/
    private String            title;
    
    /** 上传人姓名 **/
    private String            uploader;
    
    /** 上传时间 **/
    private String            uploadtime;
    
    /** 附件名称 **/
    private String            assetname;
    
    /** 附件地址 **/
    private String            acceurl;
    
    /** 已读未读标识" **/
    private String            isread;
    
    /**
     * 获取 isread
     * 
     * @return 返回 isread
     * @author wl
     */
    public String getIsread()
    {
        return isread;
    }
    
    /**
     * 设置 isread
     * 
     * @param isread 对isread进行赋值
     * @author wl
     */
    public void setIsread(String isread)
    {
        this.isread = isread;
    }
    
    public String getUploader()
    {
        return uploader;
    }
    
    public void setUploader(String uploader)
    {
        this.uploader = uploader;
    }
    
    public String getUploadtime()
    {
        return uploadtime;
    }
    
    public void setUploadtime(String uploadtime)
    {
        this.uploadtime = uploadtime;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getAssetName()
    {
        return assetname;
    }
    
    public void setAssetName(String assetName)
    {
        this.assetname = assetName;
    }
    
    public String getAcceurl()
    {
        return acceurl;
    }
    
    public void setAcceurl(String acceurl)
    {
        this.acceurl = acceurl;
    }
}
