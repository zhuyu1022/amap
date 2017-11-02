/*
 * File name:  PDocumentFileBizResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.persondocument.entity;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-2-29]
 */
public class PDocumentFileBizResponse extends RetParseResponse
{
    private PDocmentFileDataResponse bizData;
    
    public PDocmentFileDataResponse getBizData()
    {
        return bizData;
    }
    
    public void setBizData(PDocmentFileDataResponse bizData)
    {
        this.bizData = bizData;
    }
}
