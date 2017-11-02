package com.centit.app.cmipmodule.gongwenku.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWKResponse extends RetParseResponse
{
    private List<GWKBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author wl
     */
    public List<GWKBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author wl
     */
    public void setBizData(List<GWKBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
    // /**
    // * 获取 bizData
    // *
    // * @return 返回 bizData
    // * @author rqj
    // */
    // public GWKDocListResponse getBizData()
    // {
    // return bizData;
    // }
    //
    // /**
    // * 设置 bizData
    // *
    // * @param bizData 对bizData进行赋值
    // * @author rqj
    // */
    // public void setBizData(GWKDocListResponse bizData)
    // {
    // this.bizData = bizData;
    // }
    
}
