package com.centit.app.cmipmodule.infomation.parseResponse;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class InfomationBizDetailResponse extends RetParseResponse
{
    private InfomationBizInfoDetailResponse information;
    
    /**
     * 获取 information
     * 
     * @return 返回 information
     * @author rqj
     */
    public InfomationBizInfoDetailResponse getInformation()
    {
        return information;
    }
    
    /**
     * 设置 information
     * 
     * @param information 对information进行赋值
     * @author rqj
     */
    public void setInformation(InfomationBizInfoDetailResponse information)
    {
        this.information = information;
    }
    
}
