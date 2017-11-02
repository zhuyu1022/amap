/*
 * File name:  ZXLTChartUpdateResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月2日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月2日]
 */
public class ZXLTChartUpdateResponse implements Serializable
{
    
    /**
     * ZXLTChartUpdateResponse.java
     */
    private static final long           serialVersionUID = 1L;
    
    private String                      unreadcount;
    
    private String                      time;
    
    private String                      cnt;
    
    private String                      role_code;
    
    private String                      cid;
    
    private String                      msg;
    
    private String                      cname;
    
    private String                      latest_time;
    
    /** 群聊还是单聊 **/
    private String                      type;
    
    /** 人员更新时间 **/
    private String                      mtime;
    
    private String                      cnt_old;
    
    private Boolean                     isDeleting       = false;
    
    private List<ZXLTChartUserListInfo> user_list        = new ArrayList<ZXLTChartUserListInfo>();
    
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
     * 获取 cnt_old
     * 
     * @return 返回 cnt_old
     * @author wl
     */
    public String getCnt_old()
    {
        return cnt_old;
    }
    
    /**
     * 设置 cnt_old
     * 
     * @param cnt_old 对cnt_old进行赋值
     * @author wl
     */
    public void setCnt_old(String cnt_old)
    {
        this.cnt_old = cnt_old;
    }
    
    /**
     * 获取 type
     * 
     * @return 返回 type
     * @author wl
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * 设置 type
     * 
     * @param type 对type进行赋值
     * @author wl
     */
    public void setType(String type)
    {
        this.type = type;
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
     * 获取 unreadcount
     * 
     * @return 返回 unreadcount
     * @author wl
     */
    public String getUnreadcount()
    {
        return unreadcount;
    }
    
    /**
     * 设置 unreadcount
     * 
     * @param unreadcount 对unreadcount进行赋值
     * @author wl
     */
    public void setUnreadcount(String unreadcount)
    {
        this.unreadcount = unreadcount;
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
    
    /**
     * 获取 cnt
     * 
     * @return 返回 cnt
     * @author wl
     */
    public String getCnt()
    {
        return cnt;
    }
    
    /**
     * 设置 cnt
     * 
     * @param cnt 对cnt进行赋值
     * @author wl
     */
    public void setCnt(String cnt)
    {
        this.cnt = cnt;
    }
    
    /**
     * 获取 role_code
     * 
     * @return 返回 role_code
     * @author wl
     */
    public String getRole_code()
    {
        return role_code;
    }
    
    /**
     * 设置 role_code
     * 
     * @param role_code 对role_code进行赋值
     * @author wl
     */
    public void setRole_code(String role_code)
    {
        this.role_code = role_code;
    }
    
    /**
     * 获取 cid
     * 
     * @return 返回 cid
     * @author wl
     */
    public String getCid()
    {
        return cid;
    }
    
    /**
     * 设置 cid
     * 
     * @param cid 对cid进行赋值
     * @author wl
     */
    public void setCid(String cid)
    {
        this.cid = cid;
    }
    
    /**
     * 获取 msg
     * 
     * @return 返回 msg
     * @author wl
     */
    public String getMsg()
    {
        return msg;
    }
    
    /**
     * 设置 msg
     * 
     * @param msg 对msg进行赋值
     * @author wl
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
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
     * 获取 latest_time
     * 
     * @return 返回 latest_time
     * @author wl
     */
    public String getLatest_time()
    {
        return latest_time;
    }
    
    /**
     * 设置 latest_time
     * 
     * @param latest_time 对latest_time进行赋值
     * @author wl
     */
    public void setLatest_time(String latest_time)
    {
        this.latest_time = latest_time;
    }
    
    /**
     * 获取 user_list
     * 
     * @return 返回 user_list
     * @author wl
     */
    public List<ZXLTChartUserListInfo> getUser_list()
    {
        return user_list;
    }
    
    /**
     * 设置 user_list
     * 
     * @param user_list 对user_list进行赋值
     * @author wl
     */
    public void setUser_list(List<ZXLTChartUserListInfo> user_list)
    {
        this.user_list = user_list;
    }
    
}
