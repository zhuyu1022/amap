/*
 * File name:  ResolutionSeviceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年12月2日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.resolution;

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
 * @Version [版本号, 2016年12月2日]
 */
public class ResolutionSeviceImpl
{
    /**
     * 
     * 获取决议列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param handletype
     * @param maxId
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年12月2日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetResolutionLisRequest(NetTask task, Handler handler, int requestType,
        String handletype, String maxId, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("handleType", handletype);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("resolution",
                "ResolutionAdapter",
                "getResolutionList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取决议详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @return
     * @LastModifiedDate：2016年12月2日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetResolutionInfoRequest(NetTask task, Handler handler, int requestType, String id)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("resolution",
                "ResolutionAdapter",
                "getResolutionInfo",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 发起决议
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @param type
     * @param title
     * @param info
     * @param dailyworkid
     * @param handlerids
     * @param handlers
     * @param copierids
     * @param copiers
     * @param finishtime
     * @return
     * @LastModifiedDate：2016年12月2日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendAddResolution(NetTask task, Handler handler, int requestType, String id, String title,
        String info, String dailyworkid, String handlerids, String handlers, String copierids, String copiers,
        String finishtime)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("title", title);
            bodyVaule.put("info", info);
            bodyVaule.put("dailyworkid", dailyworkid);
            bodyVaule.put("handlerids", handlerids);
            bodyVaule.put("handlers", handlers);
            bodyVaule.put("copierids", copierids);
            bodyVaule.put("copiers", copiers);
            bodyVaule.put("finishtime", finishtime);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("resolution",
                "ResolutionAdapter",
                "addResolution",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 处理决议信息
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @param handlerids
     * @param handlers
     * @param handlecontent
     * @param handlestatus 决议处理情况0：发起 ，1：处理中，2：完成；",
     * @param handletime
     * @param fiskstatus "风险程度：0：正常，1：有风险，2：高风险；“
     * @return
     * @LastModifiedDate：2016年12月2日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendFeedbackResolution(NetTask task, Handler handler, int requestType, String id,
        String handlerids, String handlers, String handlecontent, String handlestatus, String handletime,
        String fiskstatus)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("handlerids", handlerids);
            bodyVaule.put("handlers", handlers);
            bodyVaule.put("handlecontent", handlecontent);
            bodyVaule.put("handlestatus", handlestatus);
            bodyVaule.put("handletime", handletime);
            bodyVaule.put("fiskstatus", fiskstatus);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("resolution",
                "ResolutionAdapter",
                "feedbackResolution",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 删除决议
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @return
     * @LastModifiedDate：2016年12月2日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendDelResolution(NetTask task, Handler handler, int requestType, String id)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("resolution",
                "ResolutionAdapter",
                "delResolution",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
