package com.centit.app.cmipmodule.ldschedule.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * @Description<功能详细描述>
 * 
 * @author  rqj 
 * @Version  [版本号, 2015-9-15]
 */
/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-15]
 */
public class LDScheduleBizDataResponseNew implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /** 日程id **/
    private String            scheduleid;
    
    /** 日程id **/
    private String            scheduletitle;
    
    /** 创建时间 **/
    private String            createdate;
    
    /** 发布人姓名 **/
    private String            publisher;
    
    /** 发布地址 **/
    private String            publishurl;
    
    // "isread": "0",
    
    private String            isread;
    
    public String getScheduleid()
    {
        return scheduleid;
    }
    
    public void setScheduleid(String scheduleid)
    {
        this.scheduleid = scheduleid;
    }
    
    public String getScheduletitle()
    {
        return scheduletitle;
    }
    
    public void setScheduletitle(String scheduletitle)
    {
        this.scheduletitle = scheduletitle;
    }
    
    public String getCreatedate()
    {
        return createdate;
    }
    
    public void setCreatedate(String createdate)
    {
        this.createdate = createdate;
    }
    
    public String getPublisher()
    {
        return publisher;
    }
    
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    public String getPublishurl()
    {
        return publishurl;
    }
    
    public void setPublishurl(String publishurl)
    {
        this.publishurl = publishurl;
    }
    
    /**
     * 获取 isread
     * 
     * @return 返回 isread
     * @author wl
     */
    public String getIsread()
    {
        return isread;
    }
    
    /**
     * 设置 isread
     * 
     * @param isread 对isread进行赋值
     * @author wl
     */
    public void setIsread(String isread)
    {
        this.isread = isread;
    }
    
}
