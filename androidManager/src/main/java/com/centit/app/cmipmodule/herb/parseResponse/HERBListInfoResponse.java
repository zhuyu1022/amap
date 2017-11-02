/*
 * File name:  HERBListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月28日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.herb.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年10月28日]
 */
public class HERBListInfoResponse implements Serializable
{
    
    /**
     * HERBListInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    /****/
    private String            id;
    
    /****/
    private String            time;
    
    /****/
    private String            acceurl;
    
    /****/
    private String            order;
    
    /****/
    private String            unread;
    
    /****/
    private String            nsid;
    
    /****/
    private String            accename;
    
    /****/
    private String            info;
    
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
     * 获取 acceurl
     * 
     * @return 返回 acceurl
     * @author wl
     */
    public String getAcceurl()
    {
        return acceurl;
    }
    
    /**
     * 设置 acceurl
     * 
     * @param acceurl 对acceurl进行赋值
     * @author wl
     */
    public void setAcceurl(String acceurl)
    {
        this.acceurl = acceurl;
    }
    
    /**
     * 获取 order
     * 
     * @return 返回 order
     * @author wl
     */
    public String getOrder()
    {
        return order;
    }
    
    /**
     * 设置 order
     * 
     * @param order 对order进行赋值
     * @author wl
     */
    public void setOrder(String order)
    {
        this.order = order;
    }
    
    /**
     * 获取 unread
     * 
     * @return 返回 unread
     * @author wl
     */
    public String getUnread()
    {
        return unread;
    }
    
    /**
     * 设置 unread
     * 
     * @param unread 对unread进行赋值
     * @author wl
     */
    public void setUnread(String unread)
    {
        this.unread = unread;
    }
    
    /**
     * 获取 nsid
     * 
     * @return 返回 nsid
     * @author wl
     */
    public String getNsid()
    {
        return nsid;
    }
    
    /**
     * 设置 nsid
     * 
     * @param nsid 对nsid进行赋值
     * @author wl
     */
    public void setNsid(String nsid)
    {
        this.nsid = nsid;
    }
    
    /**
     * 获取 accename
     * 
     * @return 返回 accename
     * @author wl
     */
    public String getAccename()
    {
        return accename;
    }
    
    /**
     * 设置 accename
     * 
     * @param accename 对accename进行赋值
     * @author wl
     */
    public void setAccename(String accename)
    {
        this.accename = accename;
    }
    
    /**
     * 获取 info
     * 
     * @return 返回 info
     * @author wl
     */
    public String getInfo()
    {
        return info;
    }
    
    /**
     * 设置 info
     * 
     * @param info 对info进行赋值
     * @author wl
     */
    public void setInfo(String info)
    {
        this.info = info;
    }
    
}
