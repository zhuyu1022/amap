/*
 * File name:  InternalMailDetailDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-25
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.internalMail.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-2-25]
 */
public class InternalMailDetailDataResponse implements Serializable
{
    
    /**
     * InternalMailDetailDataResponse.java
     */
    private static final long      serialVersionUID = 1L;
    
    private InternalMailDetailInfo innermsg;
    
    public InternalMailDetailInfo getInnermsg()
    {
        return innermsg;
    }
    
    public void setInnermsg(InternalMailDetailInfo innermsg)
    {
        this.innermsg = innermsg;
    }
}
