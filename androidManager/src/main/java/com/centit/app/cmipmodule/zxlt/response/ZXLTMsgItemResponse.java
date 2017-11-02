/*
 * File name:  ZXLTMsgItemResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月8日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt.response;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月8日]
 */
public class ZXLTMsgItemResponse implements Serializable
{
    // private String id;
    // private String sender_id;
    // private String time;
    // private String locationimg;
    // private String msg_type;
    // private String content;
    // private String icon;
    // private String name;
    // private String rid;
    // private String image;
    
    // "srctype": "aPhone",
    // "sendid": "10000014",
    // "id": "100000000000",
    // "content": "马坚向你推荐了图书：77",
    // "icon": "/Asset/resource/upload/photo/photo_mj@3x.jpg",
    // "time": "20161009091700",
    // "rid": "100000000008",
    // "name": "马坚",
    // "asset_url": "/resource/news/2016-02-20/icon01.png",
    // "image": "/Asset/resource/upload/2016-07-07/20160707160506.jpg",
    // "msgtype": "B",
    // "asset_id": "100000000008"
    private String srctype;
    
    private String asset_url;
    
    private String asset_id;
    
    private String id;
    
    private String sendid;
    
    private String time;
    
    private String locationimg;
    
    private String msgtype;
    
    private Object content;
    
    private String icon;
    
    private String name;
    
    private String rid;
    
    private String image;
    
    /**
     * 获取 srctype
     * 
     * @return 返回 srctype
     * @author wl
     */
    public String getSrctype()
    {
        return srctype;
    }
    
    /**
     * 设置 srctype
     * 
     * @param srctype 对srctype进行赋值
     * @author wl
     */
    public void setSrctype(String srctype)
    {
        this.srctype = srctype;
    }
    
    /**
     * 获取 asset_url
     * 
     * @return 返回 asset_url
     * @author wl
     */
    public String getAsset_url()
    {
        return asset_url;
    }
    
    /**
     * 设置 asset_url
     * 
     * @param asset_url 对asset_url进行赋值
     * @author wl
     */
    public void setAsset_url(String asset_url)
    {
        this.asset_url = asset_url;
    }
    
    /**
     * 获取 asset_id
     * 
     * @return 返回 asset_id
     * @author wl
     */
    public String getAsset_id()
    {
        return asset_id;
    }
    
    /**
     * 设置 asset_id
     * 
     * @param asset_id 对asset_id进行赋值
     * @author wl
     */
    public void setAsset_id(String asset_id)
    {
        this.asset_id = asset_id;
    }
    
    /**
     * 获取 sendid
     * 
     * @return 返回 sendid
     * @author wl
     */
    public String getSendid()
    {
        return sendid;
    }
    
    /**
     * 设置 sendid
     * 
     * @param sendid 对sendid进行赋值
     * @author wl
     */
    public void setSendid(String sendid)
    {
        this.sendid = sendid;
    }
    
    /**
     * 获取 msgtype
     * 
     * @return 返回 msgtype
     * @author wl
     */
    public String getMsgtype()
    {
        return msgtype;
    }
    
    /**
     * 设置 msgtype
     * 
     * @param msgtype 对msgtype进行赋值
     * @author wl
     */
    public void setMsgtype(String msgtype)
    {
        this.msgtype = msgtype;
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
     * 获取 locationimg
     * 
     * @return 返回 locationimg
     * @author wl
     */
    public String getLocationimg()
    {
        return locationimg;
    }
    
    /**
     * 设置 locationimg
     * 
     * @param locationimg 对locationimg进行赋值
     * @author wl
     */
    public void setLocationimg(String locationimg)
    {
        this.locationimg = locationimg;
    }
    
    /**
     * 获取 content
     * 
     * @return 返回 content
     * @author rqj
     */
    public Object getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author rqj
     */
    public void setContent(Object content)
    {
        this.content = content;
    }
    
    /**
     * 获取 icon
     * 
     * @return 返回 icon
     * @author wl
     */
    public String getIcon()
    {
        return icon;
    }
    
    /**
     * 设置 icon
     * 
     * @param icon 对icon进行赋值
     * @author wl
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
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
     * 获取 rid
     * 
     * @return 返回 rid
     * @author wl
     */
    public String getRid()
    {
        return rid;
    }
    
    /**
     * 设置 rid
     * 
     * @param rid 对rid进行赋值
     * @author wl
     */
    public void setRid(String rid)
    {
        this.rid = rid;
    }
    
    /**
     * 获取 image
     * 
     * @return 返回 image
     * @author wl
     */
    public String getImage()
    {
        return image;
    }
    
    /**
     * 设置 image
     * 
     * @param image 对image进行赋值
     * @author wl
     */
    public void setImage(String image)
    {
        this.image = image;
    }
    
}
