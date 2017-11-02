package com.centit.app.cmipmodule.gwlz.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWLZTypeResponse extends RetParseResponse
{
    private List<GWLZTypeBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<GWLZTypeBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<GWLZTypeBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
