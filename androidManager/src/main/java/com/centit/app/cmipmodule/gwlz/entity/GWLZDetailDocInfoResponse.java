package com.centit.app.cmipmodule.gwlz.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWLZDetailDocInfoResponse extends RetParseResponse
{
    private GWLZDetailBizDataResponse docinfo;
    
    /**
     * 获取 docinfo
     * 
     * @return 返回 docinfo
     * @author rqj
     */
    public GWLZDetailBizDataResponse getDocinfo()
    {
        return docinfo;
    }
    
    /**
     * 设置 docinfo
     * 
     * @param docinfo 对docinfo进行赋值
     * @author rqj
     */
    public void setDocinfo(GWLZDetailBizDataResponse docinfo)
    {
        this.docinfo = docinfo;
    }
}
