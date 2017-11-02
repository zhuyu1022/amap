package com.centit.app.cmipmodule.gongwenku.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWKDocListResponse extends RetParseResponse
{
    private List<GWKBizDataResponse> doclist;
    
    /**
     * 获取 doclist
     * 
     * @return 返回 doclist
     * @author rqj
     */
    public List<GWKBizDataResponse> getDoclist()
    {
        return doclist;
    }
    
    /**
     * 设置 doclist
     * 
     * @param doclist 对doclist进行赋值
     * @author rqj
     */
    public void setDoclist(List<GWKBizDataResponse> doclist)
    {
        this.doclist = doclist;
    }
    
}
