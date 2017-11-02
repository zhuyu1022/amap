/*
 * File name:  BoardRoomListInfo.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-4
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.roommanager.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-4]
 */
public class BoardRoomListInfo implements Serializable
{
    
    /**
     * BoardRoomListInfo.java
     */
    private static final long     serialVersionUID = 1L;
    
    // "id":"会议室id",
    // "name":"会议室名称"
    // "status": "会议室当前使用情况",
    // "lasttime": "会议室最近可预订时间",
    // "duration": "会议室最近可预订时长",
    private String                id;
    
    private String                name;
    
    private String                status;
    
    private String                lasttime;
    
    private String                duration;
    
    private boolean               isOpen           = false;
    
    private List<MeetingListInfo> meetingList      = new ArrayList<MeetingListInfo>();
    
    public List<MeetingListInfo> getMeetingList()
    {
        return meetingList;
    }
    
    public void setMeetingList(List<MeetingListInfo> meetingList)
    {
        this.meetingList = meetingList;
    }
    
    public boolean isOpen()
    {
        return isOpen;
    }
    
    public void setOpen(boolean isOpen)
    {
        this.isOpen = isOpen;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getLasttime()
    {
        return lasttime;
    }
    
    public void setLasttime(String lasttime)
    {
        this.lasttime = lasttime;
    }
    
    public String getDuration()
    {
        return duration;
    }
    
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    
}
