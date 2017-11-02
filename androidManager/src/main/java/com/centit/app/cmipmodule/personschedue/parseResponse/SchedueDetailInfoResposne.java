/*
 * File name:  SchedueDetailInfoResposne.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月27日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月27日]
 */
public class SchedueDetailInfoResposne implements Serializable
{
    
    /**
     * SchedueDetailInfoResposne.java
     */
    private static final long serialVersionUID = 1L;
    
    /** 日程id **/
    private String            id;
    
    /** 标题 **/
    private String            title;
    
    /** 参与人员ids，多个人员id采用半角逗号分隔 **/
    private String            joiners;
    
    /** 参与人员姓名，多个人员姓名采用半角逗号分隔 **/
    private String            joinernames;
    
    /** 日程类型名称 **/
    private String            tname;
    
    /** 地点 **/
    private String            address;
    
    /** 开始时间 **/
    private String            starttime;
    
    /** 结束时间 **/
    private String            endtime;
    
    /** 日程内容 **/
    private String            content;
    
    /** 关联的决议id **/
    private String            rid;
    
    /** 关联的决议名称 **/
    private String            rname;
    
    /** 所属人id **/
    private String            oid;
    
    /** 所属人姓名 **/
    private String            oname;
    
    /** 需要传回后台的 **/
    private String            uuid;
    
    /** 创建人 **/
    private String            createuserid;
    
    private String            qrcodePath;
    
    /**
     * 获取 createuserid
     * 
     * @return 返回 createuserid
     * @author wl
     */
    public String getCreateuserid()
    {
        return createuserid;
    }
    
    /**
     * 设置 createuserid
     * 
     * @param createuserid 对createuserid进行赋值
     * @author wl
     */
    public void setCreateuserid(String createuserid)
    {
        this.createuserid = createuserid;
    }
    
    /**
     * 获取 qrcodePath
     * 
     * @return 返回 qrcodePath
     * @author wl
     */
    public String getQrcodePath()
    {
        return qrcodePath;
    }
    
    /**
     * 设置 qrcodePath
     * 
     * @param qrcodePath 对qrcodePath进行赋值
     * @author wl
     */
    public void setQrcodePath(String qrcodePath)
    {
        this.qrcodePath = qrcodePath;
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
     * 获取 joiners
     * 
     * @return 返回 joiners
     * @author wl
     */
    public String getJoiners()
    {
        return joiners;
    }
    
    /**
     * 设置 joiners
     * 
     * @param joiners 对joiners进行赋值
     * @author wl
     */
    public void setJoiners(String joiners)
    {
        this.joiners = joiners;
    }
    
    /**
     * 获取 joinernames
     * 
     * @return 返回 joinernames
     * @author wl
     */
    public String getJoinernames()
    {
        return joinernames;
    }
    
    /**
     * 设置 joinernames
     * 
     * @param joinernames 对joinernames进行赋值
     * @author wl
     */
    public void setJoinernames(String joinernames)
    {
        this.joinernames = joinernames;
    }
    
    /**
     * 获取 tname
     * 
     * @return 返回 tname
     * @author wl
     */
    public String getTname()
    {
        return tname;
    }
    
    /**
     * 设置 tname
     * 
     * @param tname 对tname进行赋值
     * @author wl
     */
    public void setTname(String tname)
    {
        this.tname = tname;
    }
    
    /**
     * 获取 address
     * 
     * @return 返回 address
     * @author wl
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * 设置 address
     * 
     * @param address 对address进行赋值
     * @author wl
     */
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    /**
     * 获取 starttime
     * 
     * @return 返回 starttime
     * @author wl
     */
    public String getStarttime()
    {
        return starttime;
    }
    
    /**
     * 设置 starttime
     * 
     * @param starttime 对starttime进行赋值
     * @author wl
     */
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }
    
    /**
     * 获取 endtime
     * 
     * @return 返回 endtime
     * @author wl
     */
    public String getEndtime()
    {
        return endtime;
    }
    
    /**
     * 设置 endtime
     * 
     * @param endtime 对endtime进行赋值
     * @author wl
     */
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    
    /**
     * 获取 content
     * 
     * @return 返回 content
     * @author wl
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author wl
     */
    public void setContent(String content)
    {
        this.content = content;
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
     * 获取 rname
     * 
     * @return 返回 rname
     * @author wl
     */
    public String getRname()
    {
        return rname;
    }
    
    /**
     * 设置 rname
     * 
     * @param rname 对rname进行赋值
     * @author wl
     */
    public void setRname(String rname)
    {
        this.rname = rname;
    }
    
    /**
     * 获取 oid
     * 
     * @return 返回 oid
     * @author wl
     */
    public String getOid()
    {
        return oid;
    }
    
    /**
     * 设置 oid
     * 
     * @param oid 对oid进行赋值
     * @author wl
     */
    public void setOid(String oid)
    {
        this.oid = oid;
    }
    
    /**
     * 获取 oname
     * 
     * @return 返回 oname
     * @author wl
     */
    public String getOname()
    {
        return oname;
    }
    
    /**
     * 设置 oname
     * 
     * @param oname 对oname进行赋值
     * @author wl
     */
    public void setOname(String oname)
    {
        this.oname = oname;
    }
    
    /**
     * 获取 uuid
     * 
     * @return 返回 uuid
     * @author wl
     */
    public String getUuid()
    {
        return uuid;
    }
    
    /**
     * 设置 uuid
     * 
     * @param uuid 对uuid进行赋值
     * @author wl
     */
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
}
