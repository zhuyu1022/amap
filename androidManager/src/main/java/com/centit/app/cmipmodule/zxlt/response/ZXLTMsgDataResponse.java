/*
 * File name:  ZXLTMsgDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月8日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt.response;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月8日]
 */
public class ZXLTMsgDataResponse implements Serializable
{
    private ArrayList<ZXLTMsgItemResponse>   msg_list;
    
    private ArrayList<ZXLTChartUserListInfo> user_list;
    
    private String                           cname;
    
    private String                           mtime;
    
    private String                           time;
    
    /**
     * 获取 msg_list
     * 
     * @return 返回 msg_list
     * @author wl
     */
    public ArrayList<ZXLTMsgItemResponse> getMsg_list()
    {
        return msg_list;
    }
    
    /**
     * 设置 msg_list
     * 
     * @param msg_list 对msg_list进行赋值
     * @author wl
     */
    public void setMsg_list(ArrayList<ZXLTMsgItemResponse> msg_list)
    {
        this.msg_list = msg_list;
    }
    
    /**
     * 获取 user_list
     * 
     * @return 返回 user_list
     * @author wl
     */
    public ArrayList<ZXLTChartUserListInfo> getUser_list()
    {
        return user_list;
    }
    
    /**
     * 设置 user_list
     * 
     * @param user_list 对user_list进行赋值
     * @author wl
     */
    public void setUser_list(ArrayList<ZXLTChartUserListInfo> user_list)
    {
        this.user_list = user_list;
    }
    
    /**
     * 获取 cname
     * 
     * @return 返回 cname
     * @author wl
     */
    public String getCname()
    {
        return cname;
    }
    
    /**
     * 设置 cname
     * 
     * @param cname 对cname进行赋值
     * @author wl
     */
    public void setCname(String cname)
    {
        this.cname = cname;
    }
    
    /**
     * 获取 mtime
     * 
     * @return 返回 mtime
     * @author wl
     */
    public String getMtime()
    {
        return mtime;
    }
    
    /**
     * 设置 mtime
     * 
     * @param mtime 对mtime进行赋值
     * @author wl
     */
    public void setMtime(String mtime)
    {
        this.mtime = mtime;
    }
    
    /**
     * 获取 time
     * 
     * @return 返回 time
     * @author wl
     */
    public String getTime()
    {
        return time;
    }
    
    /**
     * 设置 time
     * 
     * @param time 对time进行赋值
     * @author wl
     */
    public void setTime(String time)
    {
        this.time = time;
    }
    
}
