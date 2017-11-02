package com.centit.app.cmipmodule.gongwenku.entity;

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
public class GWKBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    // title":"是否是发","createusername":"系统管理员","did":"10000000","createdatetime":"2017-02-16 17:09:17"
    
    private String            hid;
    
    private String            title;
    
    private String            readstatus;
    
    private String            createusername;
    
    private String            createdatetime;
    
    private String            type;
    
    /**
     * 获取 did
     * 
     * @return 返回 did
     * @author wl
     */
    public String getDid()
    {
        return hid;
    }
    
    /**
     * 设置 did
     * 
     * @param did 对did进行赋值
     * @author wl
     */
    public void setDid(String did)
    {
        this.hid = did;
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
     * 获取 readstatus
     * 
     * @return 返回 readstatus
     * @author rqj
     */
    public String getReadstatus()
    {
        return readstatus;
    }
    
    /**
     * 设置 readstatus
     * 
     * @param readstatus 对readstatus进行赋值
     * @author rqj
     */
    public void setReadstatus(String readstatus)
    {
        this.readstatus = readstatus;
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
     * 获取 createdatetime
     * 
     * @return 返回 createdatetime
     * @author rqj
     */
    public String getCreatedatetime()
    {
        return createdatetime;
    }
    
    /**
     * 设置 createdatetime
     * 
     * @param createdatetime 对createdatetime进行赋值
     * @author rqj
     */
    public void setCreatedatetime(String createdatetime)
    {
        this.createdatetime = createdatetime;
    }
    
    /**
     * 获取 type
     * 
     * @return 返回 type
     * @author wl
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * 设置 type
     * 
     * @param type 对type进行赋值
     * @author wl
     */
    public void setType(String type)
    {
        this.type = type;
    }
    
}
