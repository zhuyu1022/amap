/*
 * File name:  ScheduleResultResponse.java
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
public class ScheduleResultResponse implements Serializable
{
    // "rid":"决议id",
    // "rtitle":"决议标题"
    
    private String rid;
    
    private String rtitle;
    
    /**
     * 获取 rid
     * 
     * @return 返回 rid
     * @author wl
     */
    public String getRid()
    {
        return rid;
    }
    
    /**
     * 设置 rid
     * 
     * @param rid 对rid进行赋值
     * @author wl
     */
    public void setRid(String rid)
    {
        this.rid = rid;
    }
    
    /**
     * 获取 rtitle
     * 
     * @return 返回 rtitle
     * @author wl
     */
    public String getRtitle()
    {
        return rtitle;
    }
    
    /**
     * 设置 rtitle
     * 
     * @param rtitle 对rtitle进行赋值
     * @author wl
     */
    public void setRtitle(String rtitle)
    {
        this.rtitle = rtitle;
    }
    
    public String getPickerViewText()
    {
        // 这里还可以判断文字超长截断再提供显示
        if (rtitle.length() > 16)
        {
            rtitle = rtitle.substring(0, 16) + "...";
        }
        return rtitle;
    }
}
