/*
 * File name:  YunTuNavlistBizResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-23
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.news.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-23]
 */
public class YunTuNavlistBizResponse extends RetParseResponse
{
    private List<YunTuNavlistDataResponse> bizData;
    
    public List<YunTuNavlistDataResponse> getBizData()
    {
        return bizData;
    }
    
    public void setBizData(List<YunTuNavlistDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
