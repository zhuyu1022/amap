package com.centit.app.cmipmodule.infomation.parseResponse;

import java.io.Serializable;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class InfomationBizInfoDetailResponse extends RetParseResponse implements Serializable
{
    /**
     * InfomationBizInfoDetailResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            id;
    
    private String            title;
    
    private String            publishtime;
    
    private String            publisher;
    
    private String            publishdept;
    
    private String            fileurl;
    
    private String            content;
    
    private String            filename;
    
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
    
    /**
     * 获取 publishdept
     * 
     * @return 返回 publishdept
     * @author rqj
     */
    public String getPublishdept()
    {
        return publishdept;
    }
    
    /**
     * 设置 publishdept
     * 
     * @param publishdept 对publishdept进行赋值
     * @author rqj
     */
    public void setPublishdept(String publishdept)
    {
        this.publishdept = publishdept;
    }
    
    /**
     * 获取 fileurl
     * 
     * @return 返回 fileurl
     * @author rqj
     */
    public String getFileurl()
    {
        return fileurl;
    }
    
    /**
     * 设置 fileurl
     * 
     * @param fileurl 对fileurl进行赋值
     * @author rqj
     */
    public void setFileurl(String fileurl)
    {
        this.fileurl = fileurl;
    }
    
    /**
     * 获取 content
     * 
     * @return 返回 content
     * @author rqj
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author rqj
     */
    public void setContent(String content)
    {
        this.content = content;
    }
    
    /**
     * 获取 filename
     * 
     * @return 返回 filename
     * @author rqj
     */
    public String getFilename()
    {
        return filename;
    }
    
    /**
     * 设置 filename
     * 
     * @param filename 对filename进行赋值
     * @author rqj
     */
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    
}
