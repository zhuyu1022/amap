/*
 * File name:  InternalMailAttachInfo.java
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
public class InternalMailAttachInfo implements Serializable
{
    
    /**
     * InternalMailAttachInfo.java
     */
    private static final long serialVersionUID = 1L;
    
    // "attachid":"附件id",
    // "attachtitle":"附件名称",
    // "attachurl":"附件地址"
    private String            attachid;
    
    private String            attachtitle;
    
    private String            attachurl;
    
    private String            attachPath;
    
    public String getAttachid()
    {
        return attachid;
    }
    
    public void setAttachid(String attachid)
    {
        this.attachid = attachid;
    }
    
    public String getAttachtitle()
    {
        return attachtitle;
    }
    
    public void setAttachtitle(String attachtitle)
    {
        this.attachtitle = attachtitle;
    }
    
    public String getAttachurl()
    {
        return attachurl;
    }
    
    public void setAttachurl(String attachurl)
    {
        this.attachurl = attachurl;
    }
    
    public String getAttachPath()
    {
        return attachPath;
    }
    
    public void setAttachPath(String attachPath)
    {
        this.attachPath = attachPath;
    }
    
}
