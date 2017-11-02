package com.centit.app.cmipmodule.gwlz.entity;

import java.util.ArrayList;
import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class ActiveBizResponse extends RetParseResponse
{
    private List<HistoryDataResponse> steplist = new ArrayList<HistoryDataResponse>();
    
    /**
     * 获取 steplist
     * 
     * @return 返回 steplist
     * @author rqj
     */
    public List<HistoryDataResponse> getSteplist()
    {
        return steplist;
    }
    
    /**
     * 设置 steplist
     * 
     * @param steplist 对steplist进行赋值
     * @author rqj
     */
    public void setSteplist(List<HistoryDataResponse> steplist)
    {
        this.steplist = steplist;
    }
    
}
