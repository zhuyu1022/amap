/*
 * File name:  BookListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月30日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.bookread.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月30日]
 */
public class BookListInfoResponse implements Serializable
{
    
    /**
     * BookListInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"书籍id",
    // "title":"标题",
    // "author":"作者",
    // "thumbimg":"缩略图",
    // "unread":"未读标识"
    /** 书籍id **/
    private String            id;
    
    /** 标题 **/
    private String            title;
    
    /** 作者 **/
    private String            author;
    
    /** 缩略图 **/
    private String            thumbimg;
    
    /** 未读标识 **/
    private String            unread;
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author wl
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author wl
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 title
     * 
     * @return 返回 title
     * @author wl
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 设置 title
     * 
     * @param title 对title进行赋值
     * @author wl
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * 获取 author
     * 
     * @return 返回 author
     * @author wl
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * 设置 author
     * 
     * @param author 对author进行赋值
     * @author wl
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    /**
     * 获取 thumbimg
     * 
     * @return 返回 thumbimg
     * @author wl
     */
    public String getThumbimg()
    {
        return thumbimg;
    }
    
    /**
     * 设置 thumbimg
     * 
     * @param thumbimg 对thumbimg进行赋值
     * @author wl
     */
    public void setThumbimg(String thumbimg)
    {
        this.thumbimg = thumbimg;
    }
    
    /**
     * 获取 unread
     * 
     * @return 返回 unread
     * @author wl
     */
    public String getUnread()
    {
        return unread;
    }
    
    /**
     * 设置 unread
     * 
     * @param unread 对unread进行赋值
     * @author wl
     */
    public void setUnread(String unread)
    {
        this.unread = unread;
    }
    
}
