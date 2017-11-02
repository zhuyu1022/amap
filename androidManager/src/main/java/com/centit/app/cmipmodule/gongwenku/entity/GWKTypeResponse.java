package com.centit.app.cmipmodule.gongwenku.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWKTypeResponse extends RetParseResponse
{
    private List<GWKTypeBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<GWKTypeBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<GWKTypeBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
