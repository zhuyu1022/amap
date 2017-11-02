package com.centit.app.cmipmodule.globalnews.pardeResponse;

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
public class GlobalNewsDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    // "globalid":"全球资讯id",
    // "info":"名称",
    // "id":"图标id",
    // "accename":"图标名称",
    // "acceurl":"存储地址",
    // "time":"创建时间"，
    // "unread":"未读标识"，
    // "order":"排序号"
    
    private String            globalid;
    
    private String            info;
    
    private String            id;
    
    private String            accename;
    
    private String            acceurl;
    
    private String            time;
    
    // 0代表已读,1未读
    private String            unread;
    
    private String            order;
    
    public String getGlobalid()
    {
        return globalid;
    }
    
    public void setGlobalid(String globalid)
    {
        this.globalid = globalid;
    }
    
    public String getInfo()
    {
        return info;
    }
    
    public void setInfo(String info)
    {
        this.info = info;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getAccename()
    {
        return accename;
    }
    
    public void setAccename(String accename)
    {
        this.accename = accename;
    }
    
    public String getAcceurl()
    {
        return acceurl;
    }
    
    public void setAcceurl(String acceurl)
    {
        this.acceurl = acceurl;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public String getUnread()
    {
        return unread;
    }
    
    public void setUnread(String unread)
    {
        this.unread = unread;
    }
    
    public String getOrder()
    {
        return order;
    }
    
    public void setOrder(String order)
    {
        this.order = order;
    }
    
}
