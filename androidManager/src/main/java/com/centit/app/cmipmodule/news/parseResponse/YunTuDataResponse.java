/*
 * File name:  YunTuDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.news.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-22]
 */
public class YunTuDataResponse implements Serializable
{
    
    /**
     * YunTuDataResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id": "资讯ID ",
    // "info": "资讯内容",
    // "source": "资讯源",
    // "time": "资讯内容",
    // "title": "资讯标题",
    // "url": "资讯地址"
    
    private String            id;
    
    private String            info;
    
    private String            source;
    
    private String            time;
    
    private String            title;
    
    private String            url;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getInfo()
    {
        return info;
    }
    
    public void setInfo(String info)
    {
        this.info = info;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    // "id": "云图新闻id ",
    // "title": "云图新闻标题",
    // "info": "云图信息",
    // "content": "云图内容",
    // "url": "云图新闻url ",
    // "time": "新闻创建时间",
    // "pic": "新闻图片地址",
    // "source": "新闻源"
    
    private String content;
    
    private String pic;
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getPic()
    {
        return pic;
    }
    
    public void setPic(String pic)
    {
        this.pic = pic;
    }
    
}
