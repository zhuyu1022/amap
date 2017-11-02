package com.centit.app.cmipmodule.ldschedule.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class LDScheduleResponse extends RetParseResponse
{
    private LDScheduleListResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public LDScheduleListResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(LDScheduleListResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
