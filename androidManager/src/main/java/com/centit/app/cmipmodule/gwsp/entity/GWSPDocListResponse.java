package com.centit.app.cmipmodule.gwsp.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWSPDocListResponse extends RetParseResponse
{
    private List<GWSPBizDataResponse> doclist;
    
    /**
     * 获取 doclist
     * 
     * @return 返回 doclist
     * @author rqj
     */
    public List<GWSPBizDataResponse> getDoclist()
    {
        return doclist;
    }
    
    /**
     * 设置 doclist
     * 
     * @param doclist 对doclist进行赋值
     * @author rqj
     */
    public void setDoclist(List<GWSPBizDataResponse> doclist)
    {
        this.doclist = doclist;
    }
    
}
