/*
 * File name:  DailyWorkResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月22日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.jueyi.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月22日]
 */
public class DailyWorkResponse implements Serializable
{
    
    /**
     * DailyWorkResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "dailyworkid":"决议/汇报所属日程ID",
    // "dailyworktitle":"决议/汇报所属日程标题"
    private String            dailyworkid;
    
    private String            dailyworktitle;
    
    private String            starttime;
    
    /**
     * 获取 dailyworkid
     * 
     * @return 返回 dailyworkid
     * @author wl
     */
    public String getDailyworkid()
    {
        return dailyworkid;
    }
    
    /**
     * 设置 dailyworkid
     * 
     * @param dailyworkid 对dailyworkid进行赋值
     * @author wl
     */
    public void setDailyworkid(String dailyworkid)
    {
        this.dailyworkid = dailyworkid;
    }
    
    /**
     * 获取 dailyworktitle
     * 
     * @return 返回 dailyworktitle
     * @author wl
     */
    public String getDailyworktitle()
    {
        return dailyworktitle;
    }
    
    /**
     * 设置 dailyworktitle
     * 
     * @param dailyworktitle 对dailyworktitle进行赋值
     * @author wl
     */
    public void setDailyworktitle(String dailyworktitle)
    {
        this.dailyworktitle = dailyworktitle;
    }
    
    /**
     * 获取 dailyworktime
     * 
     * @return 返回 dailyworktime
     * @author wl
     */
    public String getDailyworktime()
    {
        return starttime;
    }
    
    /**
     * 设置 dailyworktime
     * 
     * @param dailyworktime 对dailyworktime进行赋值
     * @author wl
     */
    public void setDailyworktime(String dailyworktime)
    {
        this.starttime = dailyworktime;
    }
    
}
