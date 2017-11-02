package com.centit.app.cmipmodule.gwlz.entity;

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
public class GWLZBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            docid;
    
    private String            title;
    
    private String            readstatus;
    
    private String            createusername;
    
    private String            createdatetime;
    
    private String            nodeinstid;
    
    private boolean           isRead           = true;
    
    /**
     * 获取 docid
     * 
     * @return 返回 docid
     * @author rqj
     */
    public String getDocid()
    {
        return docid;
    }
    
    /**
     * 设置 docid
     * 
     * @param docid 对docid进行赋值
     * @author rqj
     */
    public void setDocid(String docid)
    {
        this.docid = docid;
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
     * 获取 nodeinstid
     * 
     * @return 返回 nodeinstid
     * @author rqj
     */
    public String getNodeinstid()
    {
        return nodeinstid;
    }
    
    /**
     * 设置 nodeinstid
     * 
     * @param nodeinstid 对nodeinstid进行赋值
     * @author rqj
     */
    public void setNodeinstid(String nodeinstid)
    {
        this.nodeinstid = nodeinstid;
    }
    
    /**
     * 获取 isRead
     * 
     * @return 返回 isRead
     * @author rqj
     */
    public boolean isRead()
    {
        return isRead;
    }
    
    /**
     * 设置 isRead
     * 
     * @param isRead 对isRead进行赋值
     * @author rqj
     */
    public void setRead(boolean isRead)
    {
        this.isRead = isRead;
    }
    
}
