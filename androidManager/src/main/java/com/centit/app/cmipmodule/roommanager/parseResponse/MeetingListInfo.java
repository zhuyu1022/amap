/*
 * File name:  MeetingListInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-4
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.roommanager.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-4]
 */
public class MeetingListInfo implements Serializable
{
    
    /**
     * MeetingListInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    // "meetingid":"会议实例id",
    // "applicantid":"申请人id",（来决定是否具备取消预订功能）
    // "applicant":"申请人姓名",
    // "title":"会议主题",
    // "starttime":"会议开始时间",
    // "endtime":"会议结束时间"
    // "state":申请状态[1申请中2已安排3已使用4不同意5被抢占7取消]
    
    private String            meetingid;
    
    private String            applicantid;
    
    private String            applicant;
    
    private String            title;
    
    private String            starttime;
    
    private String            endtime;
    
    private String            state;
    
    // "id": "会议室id",
    // "name": "会议室名称",
    // "status": "会议室当前使用情况",
    private String            roomId;
    
    private String            roomName;
    
    public String getMeetingid()
    {
        return meetingid;
    }
    
    public void setMeetingid(String meetingid)
    {
        this.meetingid = meetingid;
    }
    
    public String getApplicantid()
    {
        return applicantid;
    }
    
    public void setApplicantid(String applicantid)
    {
        this.applicantid = applicantid;
    }
    
    public String getApplicant()
    {
        return applicant;
    }
    
    public void setApplicant(String applicant)
    {
        this.applicant = applicant;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getStarttime()
    {
        return starttime;
    }
    
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }
    
    public String getEndtime()
    {
        return endtime;
    }
    
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String getRoomId()
    {
        return roomId;
    }
    
    public void setRoomId(String roomId)
    {
        this.roomId = roomId;
    }
    
    public String getRoomName()
    {
        return roomName;
    }
    
    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }
    
}
