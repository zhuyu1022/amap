package com.centit.app.cmipmodule.gwlz.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWLZDocListResponse extends RetParseResponse
{
    private List<GWLZBizDataResponse> doclist;
    
    /**
     * 获取 doclist
     * 
     * @return 返回 doclist
     * @author rqj
     */
    public List<GWLZBizDataResponse> getDoclist()
    {
        return doclist;
    }
    
    /**
     * 设置 doclist
     * 
     * @param doclist 对doclist进行赋值
     * @author rqj
     */
    public void setDoclist(List<GWLZBizDataResponse> doclist)
    {
        this.doclist = doclist;
    }
    
}
