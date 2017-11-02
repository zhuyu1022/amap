/*
 * File name:  ScheduleJoinerDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月28日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月28日]
 */
public class ScheduleJoinerDataResponse implements Serializable
{
    
    /**
     * ScheduleJoinerDataResponse.java
     */
    private static final long            serialVersionUID = 1L;
    
    private String                       oid;
    
    private String                       oname;
    
    private List<ScheduleJoinerResponse> joiners          = new ArrayList<ScheduleJoinerResponse>();
    
    /**
     * 获取 joiners
     * 
     * @return 返回 joiners
     * @author wl
     */
    public List<ScheduleJoinerResponse> getJoiners()
    {
        return joiners;
    }
    
    /**
     * 设置 joiners
     * 
     * @param joiners 对joiners进行赋值
     * @author wl
     */
    public void setJoiners(List<ScheduleJoinerResponse> joiners)
    {
        this.joiners = joiners;
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
    
}
