package com.centit.app.cmipmodule.ldschedule.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class LDScheduleListResponse extends RetParseResponse
{
    private List<LDScheduleBizDataResponse> schedulelist;
    
    /**
     * 获取 schedulelist
     * 
     * @return 返回 schedulelist
     * @author rqj
     */
    public List<LDScheduleBizDataResponse> getSchedulelist()
    {
        return schedulelist;
    }
    
    /**
     * 设置 schedulelist
     * 
     * @param schedulelist 对schedulelist进行赋值
     * @author rqj
     */
    public void setSchedulelist(List<LDScheduleBizDataResponse> schedulelist)
    {
        this.schedulelist = schedulelist;
    }
    
}
