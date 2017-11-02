package com.centit.app.cmipmodule.news.parseResponse;

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
public class NewsSiteChannelBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            channelName;
    
    private String            channelCode;
    
    /**
     * 获取 channelName
     * 
     * @return 返回 channelName
     * @author rqj
     */
    public String getChannelName()
    {
        if (channelName == null)
        {
            return name;
        }
        return channelName;
    }
    
    /**
     * 设置 channelName
     * 
     * @param channelName 对channelName进行赋值
     * @author rqj
     */
    public void setChannelName(String channelName)
    {
        this.channelName = channelName;
    }
    
    /**
     * 获取 channelCode
     * 
     * @return 返回 channelCode
     * @author rqj
     */
    public String getChannelCode()
    {
        if (channelCode == null)
        {
            return id;
        }
        return channelCode;
    }
    
    /**
     * 设置 channelCode
     * 
     * @param channelCode 对channelCode进行赋值
     * @author rqj
     */
    public void setChannelCode(String channelCode)
    {
        this.channelCode = channelCode;
    }
    
    // 云图
    private String id;
    
    private String name;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
}
