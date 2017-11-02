package com.centit.app.cmipmodule.infomation.parseResponse;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class InfomationResponse extends RetParseResponse
{
    private InfomationFileListResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public InfomationFileListResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(InfomationFileListResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
