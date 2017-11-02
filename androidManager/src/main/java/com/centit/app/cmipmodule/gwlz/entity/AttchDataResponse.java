package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;

public class AttchDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            attachid;
    
    private String            attachtitle;
    
    private String            attachsize;
    
    private String            attachurl;
    
    /**
     * 获取 attachid
     * 
     * @return 返回 attachid
     * @author rqj
     */
    public String getAttachid()
    {
        return attachid;
    }
    
    /**
     * 设置 attachid
     * 
     * @param attachid 对attachid进行赋值
     * @author rqj
     */
    public void setAttachid(String attachid)
    {
        this.attachid = attachid;
    }
    
    /**
     * 获取 attachtitle
     * 
     * @return 返回 attachtitle
     * @author rqj
     */
    public String getAttachtitle()
    {
        return attachtitle;
    }
    
    /**
     * 设置 attachtitle
     * 
     * @param attachtitle 对attachtitle进行赋值
     * @author rqj
     */
    public void setAttachtitle(String attachtitle)
    {
        this.attachtitle = attachtitle;
    }
    
    /**
     * 获取 attachsize
     * 
     * @return 返回 attachsize
     * @author rqj
     */
    public String getAttachsize()
    {
        return attachsize;
    }
    
    /**
     * 设置 attachsize
     * 
     * @param attachsize 对attachsize进行赋值
     * @author rqj
     */
    public void setAttachsize(String attachsize)
    {
        this.attachsize = attachsize;
    }
    
    /**
     * 获取 attachurl
     * 
     * @return 返回 attachurl
     * @author rqj
     */
    public String getAttachurl()
    {
        return attachurl;
    }
    
    /**
     * 设置 attachurl
     * 
     * @param attachurl 对attachurl进行赋值
     * @author rqj
     */
    public void setAttachurl(String attachurl)
    {
        this.attachurl = attachurl;
    }
    
}
