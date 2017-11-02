/*
 * File name:  YunTuDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqts.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-22]
 */
public class WaringDataResponse implements Serializable
{
    
    /**
     * YunTuDataResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "usernumber": "1000004",
    // "platform_name": "690大平台",
    // "color": "R",
    // "alarm_type": "超过90天库存占比最差",
    // "period_code": "20160912",
    // "displayorder": "5",
    // "dim_type": "产线",
    // "template_type": "1",
    // "measure_name": "库存",
    // "message_content": "冷柜;家用"
    
    private String            usernumber;
    
    private String            platform_name;
    
    private String            color;
    
    private String            alarm_type;
    
    private String            period_code;
    
    private String            displayorder;
    
    private String            dim_type;
    
    private String            template_type;
    
    private String            measure_name;
    
    private String            message_content;
    
    public String getUsernumber()
    {
        return usernumber;
    }
    
    public void setUsernumber(String usernumber)
    {
        this.usernumber = usernumber;
    }
    
    public String getPlatform_name()
    {
        return platform_name;
    }
    
    public void setPlatform_name(String platform_name)
    {
        this.platform_name = platform_name;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public String getAlarm_type()
    {
        return alarm_type;
    }
    
    public void setAlarm_type(String alarm_type)
    {
        this.alarm_type = alarm_type;
    }
    
    public String getPeriod_code()
    {
        return period_code;
    }
    
    public void setPeriod_code(String period_code)
    {
        this.period_code = period_code;
    }
    
    public String getDisplayorder()
    {
        return displayorder;
    }
    
    public void setDisplayorder(String displayorder)
    {
        this.displayorder = displayorder;
    }
    
    public String getDim_type()
    {
        return dim_type;
    }
    
    public void setDim_type(String dim_type)
    {
        this.dim_type = dim_type;
    }
    
    public String getTemplate_type()
    {
        return template_type;
    }
    
    public void setTemplate_type(String template_type)
    {
        this.template_type = template_type;
    }
    
    public String getMeasure_name()
    {
        return measure_name;
    }
    
    public void setMeasure_name(String measure_name)
    {
        this.measure_name = measure_name;
    }
    
    public String getMessage_content()
    {
        return message_content;
    }
    
    public void setMessage_content(String message_content)
    {
        this.message_content = message_content;
    }
    
}
