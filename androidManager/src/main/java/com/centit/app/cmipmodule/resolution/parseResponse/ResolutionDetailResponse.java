/*
 * File name:  ResultDetailResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.resolution.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月21日]
 */
public class ResolutionDetailResponse implements Serializable
{
    
    /**
     * ResultDetailResponse.java
     */
    private static final long                  serialVersionUID = 1L;
    
    // "id":"决议id",
    // "title":"决议标题",
    // "info":"决议内容",
    // "sender":"发起人姓名",
    // "sendtime":"发起时间",
    // "dailyworkid":"决议所属日程ID",
    // "dailyworktitle":"决议所属日程标题",
    // "handlerids":"指定人IDs，多个ID之间用半角逗号分隔",
    // "handlers":"指定人姓名，多个人之间用半角逗号分隔",
    // "copierids":"抄送人IDs，多个ID之间用半角逗号分隔",
    // "copiers":"抄送人姓名，多个人之间用半角逗号分隔",
    // "finishtime":"完成时间",
    // "acceurl":"附件地址",
    // "assetname":"附件名称",
    
    /** 决议/汇报id **/
    private String                             id;
    
    /** 决议/汇报标题 **/
    private String                             title;
    
    /** 决议/汇报内容 **/
    private String                             info;
    
    /** 发起人姓名 **/
    private String                             sender;
    
    /** 发起时间 **/
    private String                             sendtime;
    
    /** 决议/汇报所属日程ID **/
    private String                             dailyworkid;
    
    /** 决议/汇报所属日程标题 **/
    private String                             dailyworktitle;
    
    /** 指定人IDs，多个ID之间用半角逗号分隔 **/
    private String                             handlerids;
    
    /** 指定人姓名，多个人之间用半角逗号分隔 **/
    private String                             handlers;
    
    /** 抄送人IDs，多个ID之间用半角逗号分隔 **/
    private String                             copierids;
    
    /** 抄送人姓名，多个人之间用半角逗号分隔 **/
    private String                             copiers;
    
    /** 完成时间 **/
    private String                             finishtime;
    
    /** 附件地址 **/
    private String                             acceurl;
    
    /** 附件名称 **/
    private String                             assetname;
    
    /****/
    private List<ResolutionDetailItemResponse> results          = new ArrayList<ResolutionDetailItemResponse>();
    
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
     * 获取 info
     * 
     * @return 返回 info
     * @author wl
     */
    public String getInfo()
    {
        return info;
    }
    
    /**
     * 设置 info
     * 
     * @param info 对info进行赋值
     * @author wl
     */
    public void setInfo(String info)
    {
        this.info = info;
    }
    
    /**
     * 获取 sender
     * 
     * @return 返回 sender
     * @author wl
     */
    public String getSender()
    {
        return sender;
    }
    
    /**
     * 设置 sender
     * 
     * @param sender 对sender进行赋值
     * @author wl
     */
    public void setSender(String sender)
    {
        this.sender = sender;
    }
    
    /**
     * 获取 sendtime
     * 
     * @return 返回 sendtime
     * @author wl
     */
    public String getSendtime()
    {
        return sendtime;
    }
    
    /**
     * 设置 sendtime
     * 
     * @param sendtime 对sendtime进行赋值
     * @author wl
     */
    public void setSendtime(String sendtime)
    {
        this.sendtime = sendtime;
    }
    
    /**
     * 获取 dailyworkid
     * 
     * @return 返回 dailyworkid
     * @author wl
     */
    public String getDailyworkid()
    {
        return dailyworkid;
    }
    
    /**
     * 设置 dailyworkid
     * 
     * @param dailyworkid 对dailyworkid进行赋值
     * @author wl
     */
    public void setDailyworkid(String dailyworkid)
    {
        this.dailyworkid = dailyworkid;
    }
    
    /**
     * 获取 dailyworktitle
     * 
     * @return 返回 dailyworktitle
     * @author wl
     */
    public String getDailyworktitle()
    {
        return dailyworktitle;
    }
    
    /**
     * 设置 dailyworktitle
     * 
     * @param dailyworktitle 对dailyworktitle进行赋值
     * @author wl
     */
    public void setDailyworktitle(String dailyworktitle)
    {
        this.dailyworktitle = dailyworktitle;
    }
    
    /**
     * 获取 handlerids
     * 
     * @return 返回 handlerids
     * @author wl
     */
    public String getHandlerids()
    {
        return handlerids;
    }
    
    /**
     * 设置 handlerids
     * 
     * @param handlerids 对handlerids进行赋值
     * @author wl
     */
    public void setHandlerids(String handlerids)
    {
        this.handlerids = handlerids;
    }
    
    /**
     * 获取 handlers
     * 
     * @return 返回 handlers
     * @author wl
     */
    public String getHandlers()
    {
        return handlers;
    }
    
    /**
     * 设置 handlers
     * 
     * @param handlers 对handlers进行赋值
     * @author wl
     */
    public void setHandlers(String handlers)
    {
        this.handlers = handlers;
    }
    
    /**
     * 获取 copierids
     * 
     * @return 返回 copierids
     * @author wl
     */
    public String getCopierids()
    {
        return copierids;
    }
    
    /**
     * 设置 copierids
     * 
     * @param copierids 对copierids进行赋值
     * @author wl
     */
    public void setCopierids(String copierids)
    {
        this.copierids = copierids;
    }
    
    /**
     * 获取 copiers
     * 
     * @return 返回 copiers
     * @author wl
     */
    public String getCopiers()
    {
        return copiers;
    }
    
    /**
     * 设置 copiers
     * 
     * @param copiers 对copiers进行赋值
     * @author wl
     */
    public void setCopiers(String copiers)
    {
        this.copiers = copiers;
    }
    
    /**
     * 获取 finishtime
     * 
     * @return 返回 finishtime
     * @author wl
     */
    public String getFinishtime()
    {
        return finishtime;
    }
    
    /**
     * 设置 finishtime
     * 
     * @param finishtime 对finishtime进行赋值
     * @author wl
     */
    public void setFinishtime(String finishtime)
    {
        this.finishtime = finishtime;
    }
    
    /**
     * 获取 acceurl
     * 
     * @return 返回 acceurl
     * @author wl
     */
    public String getAcceurl()
    {
        return acceurl;
    }
    
    /**
     * 设置 acceurl
     * 
     * @param acceurl 对acceurl进行赋值
     * @author wl
     */
    public void setAcceurl(String acceurl)
    {
        this.acceurl = acceurl;
    }
    
    /**
     * 获取 assetname
     * 
     * @return 返回 assetname
     * @author wl
     */
    public String getAssetname()
    {
        return assetname;
    }
    
    /**
     * 设置 assetname
     * 
     * @param assetname 对assetname进行赋值
     * @author wl
     */
    public void setAssetname(String assetname)
    {
        this.assetname = assetname;
    }
    
    /**
     * 获取 results
     * 
     * @return 返回 results
     * @author wl
     */
    public List<ResolutionDetailItemResponse> getResults()
    {
        return results;
    }
    
    /**
     * 设置 results
     * 
     * @param results 对results进行赋值
     * @author wl
     */
    public void setResults(List<ResolutionDetailItemResponse> results)
    {
        this.results = results;
    }
    
}
