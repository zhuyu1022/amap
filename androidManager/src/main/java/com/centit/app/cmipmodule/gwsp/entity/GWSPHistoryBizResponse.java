package com.centit.app.cmipmodule.gwsp.entity;

import java.util.ArrayList;
import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWSPHistoryBizResponse extends RetParseResponse
{
    private List<GWSPHistoryDataResponse> doclist = new ArrayList<GWSPHistoryDataResponse>();
    
    /**
     * 获取 doclist
     * 
     * @return 返回 doclist
     * @author rqj
     */
    public List<GWSPHistoryDataResponse> getDoclist()
    {
        return doclist;
    }
    
    /**
     * 设置 doclist
     * 
     * @param doclist 对doclist进行赋值
     * @author rqj
     */
    public void setDoclist(List<GWSPHistoryDataResponse> doclist)
    {
        this.doclist = doclist;
    }
    
}
