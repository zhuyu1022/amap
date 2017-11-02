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
public class GWKDetailBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            createusername;
    
    private String            createdatetime;
    
    private String            modifydatetime;
    
    private String            collectstatus;
    
    private String            docurl;
    
    private String            filePw;
    
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
     * 获取 modifydatetime
     * 
     * @return 返回 modifydatetime
     * @author rqj
     */
    public String getModifydatetime()
    {
        return modifydatetime;
    }
    
    /**
     * 设置 modifydatetime
     * 
     * @param modifydatetime 对modifydatetime进行赋值
     * @author rqj
     */
    public void setModifydatetime(String modifydatetime)
    {
        this.modifydatetime = modifydatetime;
    }
    
    /**
     * 获取 collectstatus
     * 
     * @return 返回 collectstatus
     * @author rqj
     */
    public String getCollectstatus()
    {
        return collectstatus;
    }
    
    /**
     * 设置 collectstatus
     * 
     * @param collectstatus 对collectstatus进行赋值
     * @author rqj
     */
    public void setCollectstatus(String collectstatus)
    {
        this.collectstatus = collectstatus;
    }
    
    /**
     * 获取 docurl
     * 
     * @return 返回 docurl
     * @author rqj
     */
    public String getDocurl()
    {
        return docurl;
    }
    
    /**
     * 设置 docurl
     * 
     * @param docurl 对docurl进行赋值
     * @author rqj
     */
    public void setDocurl(String docurl)
    {
        this.docurl = docurl;
    }
    
    /**
     * 获取 filePw
     * 
     * @return 返回 filePw
     * @author rqj
     */
    public String getFilePw()
    {
        return filePw;
    }
    
    /**
     * 设置 filePw
     * 
     * @param filePw 对filePw进行赋值
     * @author rqj
     */
    public void setFilePw(String filePw)
    {
        this.filePw = filePw;
    }
    
}
