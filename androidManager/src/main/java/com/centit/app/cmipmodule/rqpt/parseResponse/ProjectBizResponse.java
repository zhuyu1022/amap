/*
 * File name:  YunTuBizResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqpt.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-22]
 */
public class ProjectBizResponse extends RetParseResponse
{
    private List<ProjectDataResponse> bizData;
    
    public List<ProjectDataResponse> getBizData()
    {
        return bizData;
    }
    
    public void setBizData(List<ProjectDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
