package com.centit.app.cmipmodule.gongwenku.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class GWKDetailDocInfoResponse extends RetParseResponse
{
    private GWKDetailBizDataResponse info;
    
    /**
     * 获取 info
     * 
     * @return 返回 info
     * @author rqj
     */
    public GWKDetailBizDataResponse getInfo()
    {
        return info;
    }
    
    /**
     * 设置 info
     * 
     * @param info 对info进行赋值
     * @author rqj
     */
    public void setInfo(GWKDetailBizDataResponse info)
    {
        this.info = info;
    }
    
}
