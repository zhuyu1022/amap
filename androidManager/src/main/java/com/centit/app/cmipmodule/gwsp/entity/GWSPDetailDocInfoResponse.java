package com.centit.app.cmipmodule.gwsp.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWSPDetailDocInfoResponse extends RetParseResponse
{
    private GWSPDetailBizDataResponse docinfo;
    
    /**
     * 获取 docinfo
     * 
     * @return 返回 docinfo
     * @author rqj
     */
    public GWSPDetailBizDataResponse getDocinfo()
    {
        return docinfo;
    }
    
    /**
     * 设置 docinfo
     * 
     * @param docinfo 对docinfo进行赋值
     * @author rqj
     */
    public void setDocinfo(GWSPDetailBizDataResponse docinfo)
    {
        this.docinfo = docinfo;
    }
}
