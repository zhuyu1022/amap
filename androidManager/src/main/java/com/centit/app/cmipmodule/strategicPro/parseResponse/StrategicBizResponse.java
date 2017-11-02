/*
 * File name:  ResultBizResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.strategicPro.parseResponse;

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
public class StrategicBizResponse implements Serializable
{
    
    /**
     * ResultBizResponse.java
     */
    private static final long    serialVersionUID = 1L;
    
    /**
     * 是否可发起决议/汇报 0 不可以 1 可以
     */
    private String               isoper;
    
    private List<StrategicProResponse> results          = new ArrayList<StrategicProResponse>();
    
    /**
     * 获取 isoper
     * 
     * @return 返回 isoper
     * @author wl
     */
    public String getIsoper()
    {
        return isoper;
    }
    
    /**
     * 设置 isoper
     * 
     * @param isoper 对isoper进行赋值
     * @author wl
     */
    public void setIsoper(String isoper)
    {
        this.isoper = isoper;
    }
    
    /**
     * 获取 results
     * 
     * @return 返回 results
     * @author wl
     */
    public List<StrategicProResponse> getResults()
    {
        return results;
    }
    
    /**
     * 设置 results
     * 
     * @param results 对results进行赋值
     * @author wl
     */
    public void setResults(List<StrategicProResponse> results)
    {
        this.results = results;
    }
    
}
