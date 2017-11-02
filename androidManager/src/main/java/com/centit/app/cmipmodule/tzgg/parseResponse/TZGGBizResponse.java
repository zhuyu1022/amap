package com.centit.app.cmipmodule.tzgg.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class TZGGBizResponse extends RetParseResponse
{
    private List<TZGGDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<TZGGDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<TZGGDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
