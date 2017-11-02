/*
 * File name:  InforMarketSortBizResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-21
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.informarket.entity;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-21]
 */
public class InforMarketSortBizResponse extends RetParseResponse
{
    private List<InforMarketSortInfo> bizData;
    
    public List<InforMarketSortInfo> getBizData()
    {
        return bizData;
    }
    
    public void setBizData(List<InforMarketSortInfo> bizData)
    {
        this.bizData = bizData;
    }
    
}
