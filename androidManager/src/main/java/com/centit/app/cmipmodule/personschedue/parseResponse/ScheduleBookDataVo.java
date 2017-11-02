/*
 * File name:  ScheduleBookDataVo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月22日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.io.Serializable;

/**
 * 预约日程列表
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月22日]
 */
public class ScheduleBookDataVo implements Serializable
{
    
    /**
     * ScheduleBookDataVo.java
     */
    private static final long serialVersionUID = 1L;
    
    /** 预约日程id **/
    private String            id;
    
    /** 标题 **/
    private String            title;
    
    /** 参与人员姓名，多个人员姓名采用半角逗号分隔 **/
    private String            joinernames;
    
    /** 地点 **/
    private String            address;
    
    /** 开始时间 **/
    private String            starttime;
    
    /** 结束时间 **/
    private String            endtime;
    
    /** 内容 **/
    private String            content;
    
    /** 预约状态 **/
    private String            status;
    
    /** 预约人 **/
    private String            oid;
    
    /** 预约人姓名 **/
    private String            oname;
    
    /** 发起人 **/
    private String            sid;
    
    /** 发起人姓名 **/
    private String            sname;
    
    /** 0时间无冲突 1 时间有冲突 **/
    private String            conflict;
    
    private Boolean           isDeleting       = false;
    
    /**
     * 获取 oname
     * 
     * @return 返回 oname
     * @author wl
     */
    public String getOname()
    {
        return oname;
    }
    
    /**
     * 设置 oname
     * 
     * @param oname 对oname进行赋值
     * @author wl
     */
    public void setOname(String oname)
    {
        this.oname = oname;
    }
    
    /**
     * 获取 sid
     * 
     * @return 返回 sid
     * @author wl
     */
    public String getSid()
    {
        return sid;
    }
    
    /**
     * 设置 sid
     * 
     * @param sid 对sid进行赋值
     * @author wl
     */
    public void setSid(String sid)
    {
        this.sid = sid;
    }
    
    /**
     * 获取 sname
     * 
     * @return 返回 sname
     * @author wl
     */
    public String getSname()
    {
        return sname;
    }
    
    /**
     * 设置 sname
     * 
     * @param sname 对sname进行赋值
     * @author wl
     */
    public void setSname(String sname)
    {
        this.sname = sname;
    }
    
    /**
     * 获取 conflict
     * 
     * @return 返回 conflict
     * @author wl
     */
    public String getConflict()
    {
        return conflict;
    }
    
    /**
     * 设置 conflict
     * 
     * @param conflict 对conflict进行赋值
     * @author wl
     */
    public void setConflict(String conflict)
    {
        this.conflict = conflict;
    }
    
    /**
     * 获取 isDeleting
     * 
     * @return 返回 isDeleting
     * @author wl
     */
    public Boolean getIsDeleting()
    {
        return isDeleting;
    }
    
    /**
     * 设置 isDeleting
     * 
     * @param isDeleting 对isDeleting进行赋值
     * @author wl
     */
    public void setIsDeleting(Boolean isDeleting)
    {
        this.isDeleting = isDeleting;
    }
    
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
     * 获取 title
     * 
     * @return 返回 title
     * @author wl
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 设置 title
     * 
     * @param title 对title进行赋值
     * @author wl
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * 获取 joinernames
     * 
     * @return 返回 joinernames
     * @author wl
     */
    public String getJoinernames()
    {
        return joinernames;
    }
    
    /**
     * 设置 joinernames
     * 
     * @param joinernames 对joinernames进行赋值
     * @author wl
     */
    public void setJoinernames(String joinernames)
    {
        this.joinernames = joinernames;
    }
    
    /**
     * 获取 address
     * 
     * @return 返回 address
     * @author wl
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * 设置 address
     * 
     * @param address 对address进行赋值
     * @author wl
     */
    public void setAddress(String address)
    {
        this.address = address;
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
     * 获取 oid
     * 
     * @return 返回 oid
     * @author wl
     */
    public String getOid()
    {
        return oid;
    }
    
    /**
     * 设置 oid
     * 
     * @param oid 对oid进行赋值
     * @author wl
     */
    public void setOid(String oid)
    {
        this.oid = oid;
    }
    
}
