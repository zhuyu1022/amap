/*
 * File name:  VedioSeriseResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月10日
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
 * @Version [版本号, 2016年10月10日]
 */
public class VedioSeriseResponse implements Serializable
{
    
    /**
     * VedioSeriseResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "id":"视频系列id",
    // "name":"视频名称",
    // "img":"视频系列缩略图",
    // "type":"视频系列类型",
    // "count":"视频数量",
    // "order":"排序号"
    /** 视频系列id **/
    private String            id;
    
    /** 视频名称 **/
    private String            name;
    
    /** 视频系列缩略图 **/
    private String            img;
    
    /** 视频系列类型 **/
    private String            type;
    
    /** 视频数量 **/
    private String            count;
    
    /** 排序号 **/
    private String            order;
    
    /** 0-未读，1-已读 **/
    private String            unread;
    
    /** 0-未收藏，1-已收藏 **/
    private String            unstore;
    
    /** 0-未观看，1-观看历史 **/
    private String            unhistory;
    
    /**
     * 获取 unstore
     * 
     * @return 返回 unstore
     * @author wl
     */
    public String getUnstore()
    {
        return unstore;
    }
    
    /**
     * 设置 unstore
     * 
     * @param unstore 对unstore进行赋值
     * @author wl
     */
    public void setUnstore(String unstore)
    {
        this.unstore = unstore;
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
     * 获取 name
     * 
     * @return 返回 name
     * @author wl
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 设置 name
     * 
     * @param name 对name进行赋值
     * @author wl
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 获取 img
     * 
     * @return 返回 img
     * @author wl
     */
    public String getImg()
    {
        return img;
    }
    
    /**
     * 设置 img
     * 
     * @param img 对img进行赋值
     * @author wl
     */
    public void setImg(String img)
    {
        this.img = img;
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
     * 获取 count
     * 
     * @return 返回 count
     * @author wl
     */
    public String getCount()
    {
        return count;
    }
    
    /**
     * 设置 count
     * 
     * @param count 对count进行赋值
     * @author wl
     */
    public void setCount(String count)
    {
        this.count = count;
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
     * 获取 unhistory
     * 
     * @return 返回 unhistory
     * @author wl
     */
    public String getUnhistory()
    {
        return unhistory;
    }
    
    /**
     * 设置 unhistory
     * 
     * @param unhistory 对unhistory进行赋值
     * @author wl
     */
    public void setUnhistory(String unhistory)
    {
        this.unhistory = unhistory;
    }
    
}
