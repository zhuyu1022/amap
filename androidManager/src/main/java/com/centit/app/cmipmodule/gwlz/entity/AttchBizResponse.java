package com.centit.app.cmipmodule.gwlz.entity;

import java.util.ArrayList;
import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class AttchBizResponse extends RetParseResponse
{
    private List<AttchDataResponse> doclist = new ArrayList<AttchDataResponse>();
    
    /**
     * 获取 doclist
     * 
     * @return 返回 doclist
     * @author rqj
     */
    public List<AttchDataResponse> getDoclist()
    {
        return doclist;
    }
    
    /**
     * 设置 doclist
     * 
     * @param doclist 对doclist进行赋值
     * @author rqj
     */
    public void setDoclist(List<AttchDataResponse> doclist)
    {
        this.doclist = doclist;
    }
    
}
