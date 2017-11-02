/*
 * File name:  VedioCenterSeviceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月10日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.vedioCenter;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年10月10日]
 */
public class VedioCenterSeviceImpl
{
    /**
     * 
     * 3.6.1.获取视频系列
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param maxId
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年10月10日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetVideoSeriseListRequest(NetTask task, Handler handler, int requestType, String maxId,
        String pagesize)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("video", "VideoAdapter", "getVideoSeriseList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 搜索
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param name
     * @param maxId
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年10月10日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendSearchVideoSeriseByParam(NetTask task, Handler handler, int requestType, String name,
        String maxId, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("name", name);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("video",
                "VideoAdapter",
                "searchVideoSeriseByParam",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取视频列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param seriesid
     * @param maxId
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年10月10日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetVideoListRequest(NetTask task, Handler handler, int requestType, String seriesid,
        String maxId, String pagesize)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("seriesid", seriesid);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("video", "VideoAdapter", "getVideoList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
}
