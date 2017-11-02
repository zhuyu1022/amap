package com.centit.app.cmipmodule.globalnews.pardeResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GlobalNewsBizResponse extends RetParseResponse
{
    private List<GlobalNewsDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<GlobalNewsDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<GlobalNewsDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
