/*
 * File name:  ZXLTChartListResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月2日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月2日]
 */
public class ZXLTChartListResponse implements Serializable
{
    
    /**
     * ZXLTChartListResponse.java
     */
    private static final long             serialVersionUID = 1L;
    
    private List<ZXLTChartUpdateResponse> update           = new ArrayList<ZXLTChartUpdateResponse>();
    
    private List<ZXLTChartRemoveResponse> remove           = new ArrayList<ZXLTChartRemoveResponse>();
    
    /**
     * 获取 update
     * 
     * @return 返回 update
     * @author wl
     */
    public List<ZXLTChartUpdateResponse> getUpdate()
    {
        return update;
    }
    
    /**
     * 设置 update
     * 
     * @param update 对update进行赋值
     * @author wl
     */
    public void setUpdate(List<ZXLTChartUpdateResponse> update)
    {
        this.update = update;
    }
    
    /**
     * 获取 remove
     * 
     * @return 返回 remove
     * @author wl
     */
    public List<ZXLTChartRemoveResponse> getRemove()
    {
        return remove;
    }
    
    /**
     * 设置 remove
     * 
     * @param remove 对remove进行赋值
     * @author wl
     */
    public void setRemove(List<ZXLTChartRemoveResponse> remove)
    {
        this.remove = remove;
    }
    
}
