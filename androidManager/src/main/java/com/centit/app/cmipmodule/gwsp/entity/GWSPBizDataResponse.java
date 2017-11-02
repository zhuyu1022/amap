package com.centit.app.cmipmodule.gwsp.entity;

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
public class GWSPBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            hid;
    
    private String            title;
    
    private String            createusername;
    
    private String            handletime;
    
    private boolean           isLocalRead;
    
    private String            iscol;
    
    /** 是否紧急 1是 0否", **/
    private String            isurgent;
    
    /** 是否阅读 0-未读 **/
    private String            isread;
    
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
    
    public String getIsurgent()
    {
        return isurgent;
    }
    
    public void setIsurgent(String isurgent)
    {
        this.isurgent = isurgent;
    }
    
    /**
     * 获取 hid
     * 
     * @return 返回 hid
     * @author rqj
     */
    public String getHid()
    {
        return hid;
    }
    
    /**
     * 设置 hid
     * 
     * @param hid 对hid进行赋值
     * @author rqj
     */
    public void setHid(String hid)
    {
        this.hid = hid;
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
     * 获取 isLocalRead
     * 
     * @return 返回 isLocalRead
     * @author rqj
     */
    public boolean isLocalRead()
    {
        return isLocalRead;
    }
    
    /**
     * 设置 isLocalRead
     * 
     * @param isLocalRead 对isLocalRead进行赋值
     * @author rqj
     */
    public void setLocalRead(boolean isLocalRead)
    {
        this.isLocalRead = isLocalRead;
    }
    
    /**
     * 获取 createusername
     * 
     * @return 返回 createusername
     * @author rqj
     */
    public String getCreateusername()
    {
        return createusername;
    }
    
    /**
     * 设置 createusername
     * 
     * @param createusername 对createusername进行赋值
     * @author rqj
     */
    public void setCreateusername(String createusername)
    {
        this.createusername = createusername;
    }
    
    /**
     * 获取 handletime
     * 
     * @return 返回 handletime
     * @author rqj
     */
    public String getHandletime()
    {
        return handletime;
    }
    
    /**
     * 设置 handletime
     * 
     * @param handletime 对handletime进行赋值
     * @author rqj
     */
    public void setHandletime(String handletime)
    {
        this.handletime = handletime;
    }
    
    /**
     * 获取 iscol
     * 
     * @return 返回 iscol
     * @author rqj
     */
    public String getIscol()
    {
        return iscol;
    }
    
    /**
     * 设置 iscol
     * 
     * @param iscol 对iscol进行赋值
     * @author rqj
     */
    public void setIscol(String iscol)
    {
        this.iscol = iscol;
    }
    
}
