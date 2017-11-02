package com.centit.app.cmipmodule.infomation.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class InfomationSiteResponse extends RetParseResponse
{
    private List<InfomationSiteBizDataResponse> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<InfomationSiteBizDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<InfomationSiteBizDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
