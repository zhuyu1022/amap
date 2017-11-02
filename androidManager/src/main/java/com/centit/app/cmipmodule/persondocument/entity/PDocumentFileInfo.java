/*
 * File name:  PDocumentFileInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-29
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
 * @Version [版本号, 2016-2-29]
 */
public class PDocumentFileInfo implements Serializable
{
    
    /**
     * PDocumentFileInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    /** 文档id **/
    private String            docid;
    
    /** 文档名称 **/
    private String            docname;
    
    /** 文档类型 **/
    private String            doctype;
    
    /** 文档大小 **/
    private String            docsize;
    
    /** 文档下载地址 **/
    private String            docurl;
    
    /** 是否是文件夹 **/
    private String            isfolder;
    
    /** 增删改操作权限 **/
    private String            crud;
    
    /** 更新时间 **/
    private String            modifytime;
    
    /** 是否选中 **/
    private boolean           isCheck;
    
    private Boolean           isDeleting       = false;
    
    public Boolean getIsDeleting()
    {
        return isDeleting;
    }
    
    public void setIsDeleting(Boolean isDeleting)
    {
        this.isDeleting = isDeleting;
    }
    
    public boolean isCheck()
    {
        return isCheck;
    }
    
    public void setCheck(boolean isCheck)
    {
        this.isCheck = isCheck;
    }
    
    public String getDocid()
    {
        return docid;
    }
    
    public void setDocid(String docid)
    {
        this.docid = docid;
    }
    
    public String getDocname()
    {
        return docname;
    }
    
    public void setDocname(String docname)
    {
        this.docname = docname;
    }
    
    public String getDoctype()
    {
        return doctype;
    }
    
    public void setDoctype(String doctype)
    {
        this.doctype = doctype;
    }
    
    public String getDocsize()
    {
        return docsize;
    }
    
    public void setDocsize(String docsize)
    {
        this.docsize = docsize;
    }
    
    public String getDocurl()
    {
        return docurl;
    }
    
    public void setDocurl(String docurl)
    {
        this.docurl = docurl;
    }
    
    public String getIsfolder()
    {
        return isfolder;
    }
    
    public void setIsfolder(String isfolder)
    {
        this.isfolder = isfolder;
    }
    
    public String getCrud()
    {
        return crud;
    }
    
    public void setCrud(String crud)
    {
        this.crud = crud;
    }
    
    public String getModifytime()
    {
        return modifytime;
    }
    
    public void setModifytime(String modifytime)
    {
        this.modifytime = modifytime;
    }
}
