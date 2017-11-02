/*
 * File name:  ZXLTCreateChartBizDataResposne.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月3日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt.response;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月3日]
 */
public class ZXLTCreateChartBizDataResposne extends RetParseResponse
{
    private ZXLTCreateChartResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author wl
     */
    public ZXLTCreateChartResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author wl
     */
    public void setBizData(ZXLTCreateChartResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
