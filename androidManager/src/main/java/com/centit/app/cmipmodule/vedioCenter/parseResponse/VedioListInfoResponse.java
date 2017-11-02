/*
 * File name:  VedioListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月11日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.vedioCenter.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年10月11日]
 */
public class VedioListInfoResponse implements Serializable
{
    
    /**
     * VedioListInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"视频id",
    // "title":"标题",
    // "desc":"简介",
    // "author":"作者",
    // "size":"视频大小",
    // "type":"视频类型",
    // "createTime":"创建时间",
    // "thumbimg":"缩略图",
    // "detailimg":"详细图片",
    // "downloadPath":"下载地址"
    // "unread":"未读标识"，
    // "order":"排序号"
    private String            detail_asset_id;
    
    /** 视频id **/
    private String            id;
    
    /** 标题 **/
    private String            title;
    
    /** 简介 **/
    private String            desc;
    
    /** 作者 **/
    private String            author;
    
    /** 视频大小 **/
    private String            videoSize;
    
    /** 视频类型 **/
    private String            type;
    
    /** 创建时间 **/
    private String            createTime;
    
    /** 缩略图 **/
    private String            thumbimg;
    
    /** 详细图片 **/
    private String            detailimg;
    
    /** 下载地址 **/
    private String            download_path;
    
    /** 未读标识 **/
    private String            unread;
    
    /** 排序号 **/
    private String            order;
    
    /**
     * 获取 detail_asset_id
     * 
     * @return 返回 detail_asset_id
     * @author wl
     */
    public String getDetail_asset_id()
    {
        return detail_asset_id;
    }
    
    /**
     * 设置 detail_asset_id
     * 
     * @param detail_asset_id 对detail_asset_id进行赋值
     * @author wl
     */
    public void setDetail_asset_id(String detail_asset_id)
    {
        this.detail_asset_id = detail_asset_id;
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
     * 获取 desc
     * 
     * @return 返回 desc
     * @author wl
     */
    public String getDesc()
    {
        return desc;
    }
    
    /**
     * 设置 desc
     * 
     * @param desc 对desc进行赋值
     * @author wl
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
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
     * 获取 size
     * 
     * @return 返回 size
     * @author wl
     */
    public String getSize()
    {
        return videoSize;
    }
    
    /**
     * 设置 size
     * 
     * @param size 对size进行赋值
     * @author wl
     */
    public void setSize(String size)
    {
        this.videoSize = size;
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
    
    /**
     * 获取 createTime
     * 
     * @return 返回 createTime
     * @author wl
     */
    public String getCreateTime()
    {
        return createTime;
    }
    
    /**
     * 设置 createTime
     * 
     * @param createTime 对createTime进行赋值
     * @author wl
     */
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
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
     * 获取 detailimg
     * 
     * @return 返回 detailimg
     * @author wl
     */
    public String getDetailimg()
    {
        return detailimg;
    }
    
    /**
     * 设置 detailimg
     * 
     * @param detailimg 对detailimg进行赋值
     * @author wl
     */
    public void setDetailimg(String detailimg)
    {
        this.detailimg = detailimg;
    }
    
    /**
     * 获取 downloadPath
     * 
     * @return 返回 downloadPath
     * @author wl
     */
    public String getDownloadPath()
    {
        return download_path;
    }
    
    /**
     * 设置 downloadPath
     * 
     * @param downloadPath 对downloadPath进行赋值
     * @author wl
     */
    public void setDownloadPath(String downloadPath)
    {
        this.download_path = downloadPath;
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
    
    /**
     * 获取 order
     * 
     * @return 返回 order
     * @author wl
     */
    public String getOrder()
    {
        return order;
    }
    
    /**
     * 设置 order
     * 
     * @param order 对order进行赋值
     * @author wl
     */
    public void setOrder(String order)
    {
        this.order = order;
    }
    
}
