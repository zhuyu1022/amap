/*
 * File name:  InternalMailListDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-2-24
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.internalMail.parseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-2-24]
 */
public class InternalMailListDataResponse implements Serializable
{
    /**
     * InternalMailListDataResponse.java
     */
    private static final long          serialVersionUID = 1L;
    
    private List<InternalMailListInfo> innermsglist;
    
    public List<InternalMailListInfo> getInnermsglist()
    {
        return innermsglist;
    }
    
    public void setInnermsglist(List<InternalMailListInfo> innermsglist)
    {
        this.innermsglist = innermsglist;
    }
    
}
