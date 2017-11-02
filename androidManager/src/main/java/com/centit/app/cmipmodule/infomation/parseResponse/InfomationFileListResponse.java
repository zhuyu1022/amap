package com.centit.app.cmipmodule.infomation.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class InfomationFileListResponse extends RetParseResponse
{
    private List<InfomationBizDataResponse> infomationList;
    
    /**
     * 获取 infomationList
     * 
     * @return 返回 infomationList
     * @author rqj
     */
    public List<InfomationBizDataResponse> getInfomationList()
    {
        return infomationList;
    }
    
    /**
     * 设置 infomationList
     * 
     * @param infomationList 对infomationList进行赋值
     * @author rqj
     */
    public void setInfomationList(List<InfomationBizDataResponse> infomationList)
    {
        this.infomationList = infomationList;
    }
    
}
