package com.centit.app.cmipmodule.news.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class NewsSiteResponse extends RetParseResponse
{
    private List<NewsSiteBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<NewsSiteBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<NewsSiteBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
