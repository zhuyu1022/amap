/*
 * File name:  SchedueDetailDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-23
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
 * @Version [版本号, 2016-2-23]
 */
public class SchedueDetailDataResponse implements Serializable
{
    /**
     * SchedueDetailDataResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private ScheduleDataVo    schedulel;
    
    public ScheduleDataVo getSchedulel()
    {
        return schedulel;
    }
    
    public void setSchedulel(ScheduleDataVo schedulel)
    {
        this.schedulel = schedulel;
    }
    
}
