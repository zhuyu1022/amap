package com.centit.app.cmipmodule.gongwenku.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWKDetailResponse extends RetParseResponse
{
    private GWKDetailDocInfoResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public GWKDetailDocInfoResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(GWKDetailDocInfoResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
