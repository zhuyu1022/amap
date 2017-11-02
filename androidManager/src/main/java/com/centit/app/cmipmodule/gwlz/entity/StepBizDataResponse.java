package com.centit.app.cmipmodule.gwlz.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class StepBizDataResponse extends RetParseResponse
{
    
    private StepDataResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public StepDataResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(StepDataResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
