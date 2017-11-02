package com.centit.app.cmipmodule.infomation.parseResponse;

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
public class InfomationBizDataResponse implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String            id;
    
    private String            title;
    
    private String            publishtime;
    
    private String            publisher;
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author rqj
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author rqj
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 title
     * 
     * @return 返回 title
     * @author rqj
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 设置 title
     * 
     * @param title 对title进行赋值
     * @author rqj
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * 获取 publishtime
     * 
     * @return 返回 publishtime
     * @author rqj
     */
    public String getPublishtime()
    {
        return publishtime;
    }
    
    /**
     * 设置 publishtime
     * 
     * @param publishtime 对publishtime进行赋值
     * @author rqj
     */
    public void setPublishtime(String publishtime)
    {
        this.publishtime = publishtime;
    }
    
    /**
     * 获取 publisher
     * 
     * @return 返回 publisher
     * @author rqj
     */
    public String getPublisher()
    {
        return publisher;
    }
    
    /**
     * 设置 publisher
     * 
     * @param publisher 对publisher进行赋值
     * @author rqj
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
}
