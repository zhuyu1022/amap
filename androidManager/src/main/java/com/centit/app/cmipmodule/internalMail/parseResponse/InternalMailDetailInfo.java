/*
 * File name:  InternalMailDetailInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-25
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.internalMail.parseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-2-25]
 */
public class InternalMailDetailInfo implements Serializable
{
    
    /**
     * InternalMailDetailInfo.java
     */
    private static final long              serialVersionUID = 1L;
    
    /** 邮件id **/
    private String                         msgid;
    
    /** 邮件标题 **/
    private String                         msgtitle;
    
    /** 邮件内容(HTML) **/
    private String                         msgcontent;
    
    /** 邮件发起人id **/
    private String                         createuserid;
    
    /** 邮件发起人姓名 **/
    private String                         createusername;
    
    /** 发起时间 **/
    private String                         createtime;
    
    /** 回复数 **/
    private String                         replycount;
    
    /** 未读回复数 **/
    private String                         unreadcount;
    
    /** 是否已读 0已读 1未读 包括本身和回复记录的阅读状态 **/
    private String                         readflag;
    
    private List<InternalMailReceiverInfo> receivers;
    
    private List<InternalMailAttachInfo>   attachment;
    
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
    
    public String getMsgcontent()
    {
        return msgcontent;
    }
    
    public void setMsgcontent(String msgcontent)
    {
        this.msgcontent = msgcontent;
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
    
    public String getReplycount()
    {
        return replycount;
    }
    
    public void setReplycount(String replycount)
    {
        this.replycount = replycount;
    }
    
    public String getUnreadcount()
    {
        return unreadcount;
    }
    
    public void setUnreadcount(String unreadcount)
    {
        this.unreadcount = unreadcount;
    }
    
    public String getReadflag()
    {
        return readflag;
    }
    
    public void setReadflag(String readflag)
    {
        this.readflag = readflag;
    }
    
    public List<InternalMailReceiverInfo> getReceivers()
    {
        return receivers;
    }
    
    public void setReceivers(List<InternalMailReceiverInfo> receivers)
    {
        this.receivers = receivers;
    }
    
    public List<InternalMailAttachInfo> getAttachment()
    {
        return attachment;
    }
    
    public void setAttachment(List<InternalMailAttachInfo> attachment)
    {
        this.attachment = attachment;
    }
}
