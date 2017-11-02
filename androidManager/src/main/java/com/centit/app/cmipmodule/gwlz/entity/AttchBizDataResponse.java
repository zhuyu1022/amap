package com.centit.app.cmipmodule.gwlz.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class AttchBizDataResponse extends RetParseResponse
{
    
    private AttchBizResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public AttchBizResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(AttchBizResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
