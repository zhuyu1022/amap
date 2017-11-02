/*
 * File name:  SchedueDetailInfoResposne.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月27日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.hygl.parseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月27日]
 */
public class HYDetailInfoResposne implements Serializable
{
    
    /**
     * SchedueDetailInfoResposne.java
     */
    private static final long  serialVersionUID = 1L;
    
    /** 会议id **/
    private String             id;
    
    /** 会议名称 **/
    private String             name;
    
    /** 会议状态 **/
    private String             status;
    
    /** 会议开始时间 **/
    private String             starttime;
    
    /** 会议结束时间 **/
    private String             endtime;
    
    /** 发起人id **/
    private String             suserid;
    
    /** 发起人姓名 **/
    private String             susername;
    
    /** 参与人id 用，分隔 **/
    private String             joinuserids;
    
    /** 参与人姓名 用，分隔 **/
    private String             joinusernames;
    
    /** 内容 **/
    private String             content;
    
    /** 地点 **/
    private String             location;
    
    /** 二维码url **/
    private String             qrcode;
    
    /** 文件路径 **/
    private List<HYAttachInfo> files;
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author wl
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author wl
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 name
     * 
     * @return 返回 name
     * @author wl
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 设置 name
     * 
     * @param name 对name进行赋值
     * @author wl
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 获取 status
     * 
     * @return 返回 status
     * @author wl
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * 设置 status
     * 
     * @param status 对status进行赋值
     * @author wl
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * 获取 starttime
     * 
     * @return 返回 starttime
     * @author wl
     */
    public String getStarttime()
    {
        return starttime;
    }
    
    /**
     * 设置 starttime
     * 
     * @param starttime 对starttime进行赋值
     * @author wl
     */
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }
    
    /**
     * 获取 endtime
     * 
     * @return 返回 endtime
     * @author wl
     */
    public String getEndtime()
    {
        return endtime;
    }
    
    /**
     * 设置 endtime
     * 
     * @param endtime 对endtime进行赋值
     * @author wl
     */
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    
    /**
     * 获取 createuserid
     * 
     * @return 返回 createuserid
     * @author wl
     */
    public String getCreateuserid()
    {
        return suserid;
    }
    
    /**
     * 设置 createuserid
     * 
     * @param createuserid 对createuserid进行赋值
     * @author wl
     */
    public void setCreateuserid(String createuserid)
    {
        this.suserid = createuserid;
    }
    
    /**
     * 获取 createusername
     * 
     * @return 返回 createusername
     * @author wl
     */
    public String getCreateusername()
    {
        return susername;
    }
    
    /**
     * 设置 createusername
     * 
     * @param createusername 对createusername进行赋值
     * @author wl
     */
    public void setCreateusername(String createusername)
    {
        this.susername = createusername;
    }
    
    /**
     * 获取 joinuserids
     * 
     * @return 返回 joinuserids
     * @author wl
     */
    public String getJoinuserids()
    {
        return joinuserids;
    }
    
    /**
     * 设置 joinuserids
     * 
     * @param joinuserids 对joinuserids进行赋值
     * @author wl
     */
    public void setJoinuserids(String joinuserids)
    {
        this.joinuserids = joinuserids;
    }
    
    /**
     * 获取 joinusernames
     * 
     * @return 返回 joinusernames
     * @author wl
     */
    public String getJoinusernames()
    {
        return joinusernames;
    }
    
    /**
     * 设置 joinusernames
     * 
     * @param joinusernames 对joinusernames进行赋值
     * @author wl
     */
    public void setJoinusernames(String joinusernames)
    {
        this.joinusernames = joinusernames;
    }
    
    /**
     * 获取 content
     * 
     * @return 返回 content
     * @author wl
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author wl
     */
    public void setContent(String content)
    {
        this.content = content;
    }
    
    /**
     * 获取 location
     * 
     * @return 返回 location
     * @author wl
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * 设置 location
     * 
     * @param location 对location进行赋值
     * @author wl
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    /**
     * 获取 qrcode
     * 
     * @return 返回 qrcode
     * @author wl
     */
    public String getQrcode()
    {
        return qrcode;
    }
    
    /**
     * 设置 qrcode
     * 
     * @param qrcode 对qrcode进行赋值
     * @author wl
     */
    public void setQrcode(String qrcode)
    {
        this.qrcode = qrcode;
    }
    
    /**
     * 获取 suserid
     * 
     * @return 返回 suserid
     * @author wl
     */
    public String getSuserid()
    {
        return suserid;
    }
    
    /**
     * 设置 suserid
     * 
     * @param suserid 对suserid进行赋值
     * @author wl
     */
    public void setSuserid(String suserid)
    {
        this.suserid = suserid;
    }
    
    /**
     * 获取 susername
     * 
     * @return 返回 susername
     * @author wl
     */
    public String getSusername()
    {
        return susername;
    }
    
    /**
     * 设置 susername
     * 
     * @param susername 对susername进行赋值
     * @author wl
     */
    public void setSusername(String susername)
    {
        this.susername = susername;
    }
    
    /**
     * 获取 files
     * 
     * @return 返回 files
     * @author wl
     */
    public List<HYAttachInfo> getFiles()
    {
        return files;
    }
    
    /**
     * 设置 files
     * 
     * @param files 对files进行赋值
     * @author wl
     */
    public void setFiles(List<HYAttachInfo> files)
    {
        this.files = files;
    }
    
}
