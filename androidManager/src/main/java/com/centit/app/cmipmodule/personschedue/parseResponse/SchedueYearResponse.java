/*
 * File name:  SchedueYearResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月28日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月28日]
 */
public class SchedueYearResponse implements Serializable
{
    /**
     * SchedueYearResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            startdate;
    
    /**
     * 获取 starttime
     * 
     * @return 返回 starttime
     * @author wl
     */
    public String getStarttime()
    {
        return startdate;
    }
    
    /**
     * 设置 starttime
     * 
     * @param starttime 对starttime进行赋值
     * @author wl
     */
    public void setStarttime(String starttime)
    {
        this.startdate = starttime;
    }
    
}
