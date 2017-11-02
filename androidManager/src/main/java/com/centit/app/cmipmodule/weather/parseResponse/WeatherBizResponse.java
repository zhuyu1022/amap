package com.centit.app.cmipmodule.weather.parseResponse;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class WeatherBizResponse extends RetParseResponse
{
    private WeatherDataResponse bizData;
    
    public WeatherDataResponse getBizData()
    {
        return bizData;
    }
    
    public void setBizData(WeatherDataResponse bizData)
    {
        this.bizData = bizData;
    }
}
