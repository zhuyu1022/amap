package com.centit.app.cmipmodule.gwsp.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWSPTypeResponse extends RetParseResponse
{
    private List<GWSPTypeBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<GWSPTypeBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<GWSPTypeBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
