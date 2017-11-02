package com.centit.app.cmipmodule.gwsp.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWSPDetailResponse extends RetParseResponse
{
    private GWSPDetailDocInfoResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public GWSPDetailDocInfoResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(GWSPDetailDocInfoResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
