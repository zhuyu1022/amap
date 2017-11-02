package com.centit.app.cmipmodule.ldschedule.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class LDScheduleResponseNew extends RetParseResponse
{
    private List<LDScheduleBizDataResponseNew> bizData;
    
    public List<LDScheduleBizDataResponseNew> getBizData()
    {
        return bizData;
    }
    
    public void setBizData(List<LDScheduleBizDataResponseNew> bizData)
    {
        this.bizData = bizData;
    }
    
}
