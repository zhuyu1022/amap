/*
 * File name:  BookListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月30日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.xxzx.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月30日]
 */
public class XXTypeListResponse implements Serializable
{
    /**
     * XXCountResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            sortCode;                // 分类编号 或 聊天编号+聊天类型（用+拼接）
                                                        
    private String            sortName;                // 分类名称
                                                        
    private String            sortIcon;                // 功能icon图标
                                                        
    private String            title;                   // 消息标题
                                                        
    private String            receiveTime;             // 最新接收时间
                                                        
    private String            count;                   // 未读数
                                                        
    private Boolean           isDeleting       = false;
    
    /**
     * 获取 sortCode
     * 
     * @return 返回 sortCode
     * @author rqj
     */
    public String getSortCode()
    {
        return sortCode;
    }
    
    /**
     * 设置 sortCode
     * 
     * @param sortCode 对sortCode进行赋值
     * @author rqj
     */
    public void setSortCode(String sortCode)
    {
        this.sortCode = sortCode;
    }
    
    /**
     * 获取 sortName
     * 
     * @return 返回 sortName
     * @author rqj
     */
    public String getSortName()
    {
        return sortName;
    }
    
    /**
     * 设置 sortName
     * 
     * @param sortName 对sortName进行赋值
     * @author rqj
     */
    public void setSortName(String sortName)
    {
        this.sortName = sortName;
    }
    
    /**
     * 获取 sortIcon
     * 
     * @return 返回 sortIcon
     * @author rqj
     */
    public String getSortIcon()
    {
        return sortIcon;
    }
    
    /**
     * 设置 sortIcon
     * 
     * @param sortIcon 对sortIcon进行赋值
     * @author rqj
     */
    public void setSortIcon(String sortIcon)
    {
        this.sortIcon = sortIcon;
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
     * 获取 receiveTime
     * 
     * @return 返回 receiveTime
     * @author rqj
     */
    public String getReceiveTime()
    {
        return receiveTime;
    }
    
    /**
     * 设置 receiveTime
     * 
     * @param receiveTime 对receiveTime进行赋值
     * @author rqj
     */
    public void setReceiveTime(String receiveTime)
    {
        this.receiveTime = receiveTime;
    }
    
    /**
     * 获取 count
     * 
     * @return 返回 count
     * @author rqj
     */
    public String getCount()
    {
        return count;
    }
    
    /**
     * 设置 count
     * 
     * @param count 对count进行赋值
     * @author rqj
     */
    public void setCount(String count)
    {
        this.count = count;
    }
    
    /**
     * 获取 isDeleting
     * 
     * @return 返回 isDeleting
     * @author rqj
     */
    public Boolean getIsDeleting()
    {
        return isDeleting;
    }
    
    /**
     * 设置 isDeleting
     * 
     * @param isDeleting 对isDeleting进行赋值
     * @author rqj
     */
    public void setIsDeleting(Boolean isDeleting)
    {
        this.isDeleting = isDeleting;
    }
    
    public boolean isChange(XXTypeListResponse entity)
    {
        if (!sortCode.equals(entity.getSortCode()))
        {
            return false;
        }
        
        if (!sortName.equals(entity.getSortName()))
        {
            return false;
        }
        
        if (!sortIcon.equals(entity.getSortIcon()))
        {
            return false;
        }
        
        if (!title.equals(entity.getTitle()))
        {
            return false;
        }
        
        if (!receiveTime.equals(entity.getReceiveTime()))
        {
            return false;
        }
        
        if (!count.equals(entity.getCount()))
        {
            return false;
        }
        
        if (isDeleting != entity.isDeleting)
        {
            return false;
        }
        return true;
    }
}
