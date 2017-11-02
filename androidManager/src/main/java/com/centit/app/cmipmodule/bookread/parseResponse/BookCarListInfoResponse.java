/*
 * File name:  BookCarListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月8日
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
 * @Version [版本号, 2016年10月8日]
 */
public class BookCarListInfoResponse implements Serializable
{
    // "id": "",
    // "title":"",
    // "author":"",
    // "thumbimg":"",
    // "bookstatus":""
    
    /**
     * BookCarListInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            id;
    
    private String            title;
    
    private String            author;
    
    private String            thumbimg;
    
    private String            bookstatus;
    
    private boolean           isDeleting;
    
    public BookCarListInfoResponse(String id, String title, String author, String thumbimg, String bookstatus,
        Boolean isDeleting)
    {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.thumbimg = thumbimg;
        this.bookstatus = bookstatus;
        this.isDeleting = isDeleting;
    }
    
    /**
     * 获取 isDeleting
     * 
     * @return 返回 isDeleting
     * @author wl
     */
    public boolean getIsDeleting()
    {
        return isDeleting;
    }
    
    /**
     * 设置 isDeleting
     * 
     * @param isDeleting 对isDeleting进行赋值
     * @author wl
     */
    public void setIsDeleting(boolean isDeleting)
    {
        this.isDeleting = isDeleting;
    }
    
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
     * 获取 bookstatus
     * 
     * @return 返回 bookstatus
     * @author wl
     */
    public String getBookstatus()
    {
        return bookstatus;
    }
    
    /**
     * 设置 bookstatus
     * 
     * @param bookstatus 对bookstatus进行赋值
     * @author wl
     */
    public void setBookstatus(String bookstatus)
    {
        this.bookstatus = bookstatus;
    }
    
}
