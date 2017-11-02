package com.centit.app.cmipmodule.tzgg.parseResponse;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class DemoBizResponse extends RetParseResponse
{
    private DemoDataResponse bizData;
    
    public DemoDataResponse getBizData()
    {
        return bizData;
    }
    
    public void setBizData(DemoDataResponse bizData)
    {
        this.bizData = bizData;
    }
}
