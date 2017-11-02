/*
 * File name:  ZXLTCreateChartResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月3日
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
 * @Version [版本号, 2016年11月3日]
 */
public class ZXLTCreateChartResponse implements Serializable
{
    
    /**
     * ZXLTCreateChartResponse.java
     */
    private static final long           serialVersionUID = 1L;
    
    private String                      mtime;
    
    private String                      cid;
    
    private String                      cname;
    
    private List<ZXLTChartUserListInfo> user_list        = new ArrayList<ZXLTChartUserListInfo>();
    
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
