/*
 * File name:  SchdeuleTypeResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月28日
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
 * @Version [版本号, 2016年9月28日]
 */
public class ScheduleTypeResponse implements Serializable
{
    // "tid":"类型id",
    // "tname":"类型名称"
    
    private String tid;
    
    private String tname;
    
    /**
     * 获取 tid
     * 
     * @return 返回 tid
     * @author wl
     */
    public String getTid()
    {
        return tid;
    }
    
    /**
     * 设置 tid
     * 
     * @param tid 对tid进行赋值
     * @author wl
     */
    public void setTid(String tid)
    {
        this.tid = tid;
    }
    
    /**
     * 获取 tname
     * 
     * @return 返回 tname
     * @author wl
     */
    public String getTname()
    {
        return tname;
    }
    
    /**
     * 设置 tname
     * 
     * @param tname 对tname进行赋值
     * @author wl
     */
    public void setTname(String tname)
    {
        this.tname = tname;
    }
    
    public String getPickerViewText()
    {
        // 这里还可以判断文字超长截断再提供显示
        return tname;
    }
}
