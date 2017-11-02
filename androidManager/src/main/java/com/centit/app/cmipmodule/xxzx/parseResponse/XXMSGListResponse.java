/*
 * File name:  BookListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月30日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.xxzx.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月30日]
 */
public class XXMSGListResponse implements Serializable
{
    /**
     * XXCountResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            msgId;                // 消息编号
                                                     
    private String            msgTitle;             // 消息标题
                                                     
    private String            msgContent;           // 消息内容
                                                     
    private String            receiveTime;          // 接收时间
                                                     
    private String            readStatus;           // 未读标示
                                                     
    private String            insid;                // 功能实例Id
                                                     
    private String            url;
    
    private String            fileTitle;            // 文件名字
                                                     
    /**
     * 获取 fileTitle
     * 
     * @return 返回 fileTitle
     * @author wl
     */
    public String getFileTitle()
    {
        return fileTitle;
    }
    
    /**
     * 设置 fileTitle
     * 
     * @param fileTitle 对fileTitle进行赋值
     * @author wl
     */
    public void setFileTitle(String fileTitle)
    {
        this.fileTitle = fileTitle;
    }
    
    /**
     * 获取 msgId
     * 
     * @return 返回 msgId
     * @author rqj
     */
    public String getMsgId()
    {
        return msgId;
    }
    
    /**
     * 设置 msgId
     * 
     * @param msgId 对msgId进行赋值
     * @author rqj
     */
    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }
    
    /**
     * 获取 msgTitle
     * 
     * @return 返回 msgTitle
     * @author rqj
     */
    public String getMsgTitle()
    {
        return msgTitle;
    }
    
    /**
     * 设置 msgTitle
     * 
     * @param msgTitle 对msgTitle进行赋值
     * @author rqj
     */
    public void setMsgTitle(String msgTitle)
    {
        this.msgTitle = msgTitle;
    }
    
    /**
     * 获取 msgContent
     * 
     * @return 返回 msgContent
     * @author rqj
     */
    public String getMsgContent()
    {
        return msgContent;
    }
    
    /**
     * 设置 msgContent
     * 
     * @param msgContent 对msgContent进行赋值
     * @author rqj
     */
    public void setMsgContent(String msgContent)
    {
        this.msgContent = msgContent;
    }
    
    /**
     * 获取 receiveTime
     * 
     * @return 返回 receiveTime
     * @author rqj
     */
    public String getReceiveTime()
    {
        return receiveTime;
    }
    
    /**
     * 设置 receiveTime
     * 
     * @param receiveTime 对receiveTime进行赋值
     * @author rqj
     */
    public void setReceiveTime(String receiveTime)
    {
        this.receiveTime = receiveTime;
    }
    
    /**
     * 获取 readStatus
     * 
     * @return 返回 readStatus
     * @author rqj
     */
    public String getReadStatus()
    {
        return readStatus;
    }
    
    /**
     * 设置 readStatus
     * 
     * @param readStatus 对readStatus进行赋值
     * @author rqj
     */
    public void setReadStatus(String readStatus)
    {
        this.readStatus = readStatus;
    }
    
    /**
     * 获取 insid
     * 
     * @return 返回 insid
     * @author rqj
     */
    public String getInsid()
    {
        return insid;
    }
    
    /**
     * 设置 insid
     * 
     * @param insid 对insid进行赋值
     * @author rqj
     */
    public void setInsid(String insid)
    {
        this.insid = insid;
    }
    
    /**
     * 获取 url
     * 
     * @return 返回 url
     * @author rqj
     */
    public String getUrl()
    {
        return url;
    }
    
    /**
     * 设置 url
     * 
     * @param url 对url进行赋值
     * @author rqj
     */
    public void setUrl(String url)
    {
        this.url = url;
    }
    
}
