/*
 * File name:  BookDetailResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月9日
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
 * @Version [版本号, 2016年10月9日]
 */
public class BookDetailResponse implements Serializable
{
    /**
     * BookDetailResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"书籍id",
    // "title":"标题",
    // "author":"作者",
    // "time":"创建时间",
    // "publisher":"发布人",
    // "list_price":"列表价格",
    // "sale_price":"销售价格",
    // "bookcatalog":"书籍目录",
    // "bookinfo":"内容简介",
    // "thumbimg":"缩略图",
    // "cart":"购物车标识"
    /** 书籍id **/
    private String            id;
    
    /** 标题 **/
    private String            title;
    
    /** 作者 **/
    private String            author;
    
    /** 创建时间 **/
    private String            time;
    
    /** 发布人 **/
    private String            publisher;
    
    /** 列表价格 **/
    private String            list_price;
    
    /** 销售价格 **/
    private String            sale_price;
    
    /** 书籍目录 **/
    private String            bookcatalog;
    
    /** 内容简介 **/
    private String            bookinfo;
    
    /** 缩略图 **/
    private String            thumbimg;
    
    /** 购物车标识 **/
    private String            cart;
    
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
     * 获取 time
     * 
     * @return 返回 time
     * @author wl
     */
    public String getTime()
    {
        return time;
    }
    
    /**
     * 设置 time
     * 
     * @param time 对time进行赋值
     * @author wl
     */
    public void setTime(String time)
    {
        this.time = time;
    }
    
    /**
     * 获取 publisher
     * 
     * @return 返回 publisher
     * @author wl
     */
    public String getPublisher()
    {
        return publisher;
    }
    
    /**
     * 设置 publisher
     * 
     * @param publisher 对publisher进行赋值
     * @author wl
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    /**
     * 获取 list_price
     * 
     * @return 返回 list_price
     * @author wl
     */
    public String getList_price()
    {
        return list_price;
    }
    
    /**
     * 设置 list_price
     * 
     * @param list_price 对list_price进行赋值
     * @author wl
     */
    public void setList_price(String list_price)
    {
        this.list_price = list_price;
    }
    
    /**
     * 获取 sale_price
     * 
     * @return 返回 sale_price
     * @author wl
     */
    public String getSale_price()
    {
        return sale_price;
    }
    
    /**
     * 设置 sale_price
     * 
     * @param sale_price 对sale_price进行赋值
     * @author wl
     */
    public void setSale_price(String sale_price)
    {
        this.sale_price = sale_price;
    }
    
    /**
     * 获取 bookcatalog
     * 
     * @return 返回 bookcatalog
     * @author wl
     */
    public String getBookcatalog()
    {
        return bookcatalog;
    }
    
    /**
     * 设置 bookcatalog
     * 
     * @param bookcatalog 对bookcatalog进行赋值
     * @author wl
     */
    public void setBookcatalog(String bookcatalog)
    {
        this.bookcatalog = bookcatalog;
    }
    
    /**
     * 获取 bookinfo
     * 
     * @return 返回 bookinfo
     * @author wl
     */
    public String getBookinfo()
    {
        return bookinfo;
    }
    
    /**
     * 设置 bookinfo
     * 
     * @param bookinfo 对bookinfo进行赋值
     * @author wl
     */
    public void setBookinfo(String bookinfo)
    {
        this.bookinfo = bookinfo;
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
     * 获取 cart
     * 
     * @return 返回 cart
     * @author wl
     */
    public String getCart()
    {
        return cart;
    }
    
    /**
     * 设置 cart
     * 
     * @param cart 对cart进行赋值
     * @author wl
     */
    public void setCart(String cart)
    {
        this.cart = cart;
    }
    
}
