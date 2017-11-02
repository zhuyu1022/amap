package com.centit.app.cmipmodule.news.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class NewsResponse extends RetParseResponse
{
    private List<NewsBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<NewsBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<NewsBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
