/*
 * File name:  RoomMeetingComparator.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-4-25
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.roommanager;

import java.util.Comparator;

import com.centit.app.cmipmodule.roommanager.parseResponse.MeetingListInfo;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-4-25]
 */
public class RoomMeetingComparator implements Comparator<MeetingListInfo>
{
    
    /**
     * 重载方法
     * 
     * @param arg0
     * @param arg1
     * @return
     * @author wl
     */
    @Override
    public int compare(MeetingListInfo arg0, MeetingListInfo arg1)
    {
        // TODO Auto-generated method stub
        long seq1 = 0L;
        long seq2 = 0L;
        try
        {
            seq1 = Long.parseLong(arg0.getStarttime());
            seq2 = Long.parseLong(arg1.getStarttime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return (int)(seq1 - seq2);
    }
    
}
