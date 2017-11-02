/*
 * File name:  InternalMailListInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-24
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.internalMail.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-2-24]
 */
public class InternalMailListInfo implements Serializable
{
    // "msgid":"邮件id"
    // "msgtitle":"邮件标题",
    // "createuserid":"邮件发起人id",
    // "createusername":"邮件发起人姓名",
    // "createtime":"发起时间",
    // "readflag":"是否已读 0已读 1未读 包括本身和回复记录的阅读状态"
    
    /**
     * InternalMailListInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            msgid;
    
    private String            msgtitle;
    
    private String            createuserid;
    
    private String            createusername;
    
    private String            createtime;
    
    private String            readflag;
    
    private boolean           isCheck;
    
    private Boolean           isDeleting       = false;
    
    public boolean isCheck()
    {
        return isCheck;
    }
    
    public void setCheck(boolean isCheck)
    {
        this.isCheck = isCheck;
    }
    
    public String getMsgid()
    {
        return msgid;
    }
    
    public void setMsgid(String msgid)
    {
        this.msgid = msgid;
    }
    
    public String getMsgtitle()
    {
        return msgtitle;
    }
    
    public void setMsgtitle(String msgtitle)
    {
        this.msgtitle = msgtitle;
    }
    
    public String getCreateuserid()
    {
        return createuserid;
    }
    
    public void setCreateuserid(String createuserid)
    {
        this.createuserid = createuserid;
    }
    
    public String getCreateusername()
    {
        return createusername;
    }
    
    public void setCreateusername(String createusername)
    {
        this.createusername = createusername;
    }
    
    public String getCreatetime()
    {
        return createtime;
    }
    
    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }
    
    public String getReadflag()
    {
        return readflag;
    }
    
    public void setReadflag(String readflag)
    {
        this.readflag = readflag;
    }
    
    public Boolean getIsDeleting()
    {
        return isDeleting;
    }
    
    public void setIsDeleting(Boolean isDeleting)
    {
        this.isDeleting = isDeleting;
    }
    
}
