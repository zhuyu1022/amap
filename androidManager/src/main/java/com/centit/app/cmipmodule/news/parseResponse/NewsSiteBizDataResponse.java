package com.centit.app.cmipmodule.news.parseResponse;

import java.io.Serializable;
import java.util.List;

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
public class NewsSiteBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long                    serialVersionUID = 1L;
    
    private String                               siteCode;
    
    private String                               siteName;
    
    /** 网站图标 **/
    private String                               iconUrl;
    
    private List<NewsSiteChannelBizDataResponse> channels;
    
    private int                                  siteType         = -1;
    
    public String getIconUrl()
    {
        return iconUrl;
    }
    
    public void setIconUrl(String iconUrl)
    {
        this.iconUrl = iconUrl;
    }
    
    /**
     * 获取 siteCode
     * 
     * @return 返回 siteCode
     * @author rqj
     */
    public String getSiteCode()
    {
        return siteCode;
    }
    
    /**
     * 设置 siteCode
     * 
     * @param siteCode 对siteCode进行赋值
     * @author rqj
     */
    public void setSiteCode(String siteCode)
    {
        this.siteCode = siteCode;
    }
    
    /**
     * 获取 siteName
     * 
     * @return 返回 siteName
     * @author rqj
     */
    public String getSiteName()
    {
        return siteName;
    }
    
    /**
     * 设置 siteName
     * 
     * @param siteName 对siteName进行赋值
     * @author rqj
     */
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    
    /**
     * 获取 channels
     * 
     * @return 返回 channels
     * @author rqj
     */
    public List<NewsSiteChannelBizDataResponse> getChannels()
    {
        return channels;
    }
    
    /**
     * 设置 channels
     * 
     * @param channels 对channels进行赋值
     * @author rqj
     */
    public void setChannels(List<NewsSiteChannelBizDataResponse> channels)
    {
        this.channels = channels;
    }
    
    /**
     * 获取 type
     * 
     * @return 返回 type
     * @author rqj
     */
    public int getType()
    {
        return siteType;
    }
    
    /**
     * 设置 type
     * 
     * @param type 对type进行赋值
     * @author rqj
     */
    public void setType(int type)
    {
        this.siteType = type;
    }
    
}
