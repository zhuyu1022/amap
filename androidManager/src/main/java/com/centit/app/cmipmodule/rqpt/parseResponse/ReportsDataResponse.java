/*
 * File name:  YunTuDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqpt.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-22]
 */
public class ReportsDataResponse implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    // "id":"报告id",
    // "title":"报告标题",
    // "reporter":"报告人姓名",
    // "time":"报告时间",
    // "info":"报告内容",
    // "assetName":"附件名称",
    // "acceurl":"附件地址",
    // "status":"报告状态",
    // "department":"部门名称",
    // "reply":"反馈",
    // "decs":"介绍"
    
    // "reporter": "生态圈优化",
    // "id": 100000000351,
    // "acceurl": "/Asset/resource/upload/2016-11-14/20161114140559.pdf",
    // "time": "20161114140600",
    // "title": "W46周六日清会决议",
    // "status": "1",
    // "isread": "1",
    // "deptment": "生态圈优化",
    // "assetname": "W46周六日清会决议.pdf",
    // "info": "W46周六日清会决议"
    
    private String            id;
    
    private String            title;
    
    private String            reporter;
    
    private String            time;
    
    private String            info;
    
    private String            assetName;
    
    private String            acceurl;
    
    private String            status;
    
    private String            deptment;
    
    private String            reply;
    
    private String            decs;
    
    private String            isread;
    
    public String getDeptment()
    {
        return deptment;
    }
    
    public void setDeptment(String deptment)
    {
        this.deptment = deptment;
    }
    
    public String getIsread()
    {
        return isread;
    }
    
    public void setIsread(String isread)
    {
        this.isread = isread;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getReporter()
    {
        return reporter;
    }
    
    public void setReporter(String reporter)
    {
        this.reporter = reporter;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public String getInfo()
    {
        return info;
    }
    
    public void setInfo(String info)
    {
        this.info = info;
    }
    
    public String getAssetName()
    {
        return assetName;
    }
    
    public void setAssetName(String assetName)
    {
        this.assetName = assetName;
    }
    
    public String getAcceurl()
    {
        return acceurl;
    }
    
    public void setAcceurl(String acceurl)
    {
        this.acceurl = acceurl;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getDepartment()
    {
        return deptment;
    }
    
    public void setDepartment(String department)
    {
        this.deptment = department;
    }
    
    public String getReply()
    {
        return reply;
    }
    
    public void setReply(String reply)
    {
        this.reply = reply;
    }
    
    public String getDecs()
    {
        return decs;
    }
    
    public void setDecs(String decs)
    {
        this.decs = decs;
    }
    
}
