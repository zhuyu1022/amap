/*
 * File name:  InternalMailReceiverInfo.java
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

public class InternalMailReceiverInfo implements Serializable
{
    
    /**
     * InternalMailReceiverInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    // "receiverid": "99999999",
    // "receivername": "系统管理员"
    
    private String            receiverid;
    
    private String            receivername;
    
    public String getReceiverid()
    {
        return receiverid;
    }
    
    public void setReceiverid(String receiverid)
    {
        this.receiverid = receiverid;
    }
    
    public String getReceivername()
    {
        return receivername;
    }
    
    public void setReceivername(String receivername)
    {
        this.receivername = receivername;
    }
}
