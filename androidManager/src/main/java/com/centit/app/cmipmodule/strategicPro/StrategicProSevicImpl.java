/*
 * File name:  StrategicProSevicImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年12月8日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.strategicPro;

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
 * @Version [版本号, 2016年12月8日]
 */
public class StrategicProSevicImpl
{
    /**
     * 
     * 获取战略项目列表
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
    public static NetTask sendGetStrategicProListRequest(NetTask task, Handler handler, int requestType,
        String handletype, String maxId, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("handletype", handletype);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("strategicPro",
                "StrategicProAdapter",
                "getStrategicProList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取战略项目详情
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
    public static NetTask sendGetStrategicProInfoRequest(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("strategicPro",
                "StrategicProAdapter",
                "getStrategicProInfo",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 发起战略项目
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
     * @param handlerids
     * @param handlers
     * @param finishtime
     * @return
     * @LastModifiedDate：2016年12月2日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendAddStrategicPro(NetTask task, Handler handler, int requestType, String id, String title,
        String info, String handlerids, String handlers, String handlemode, String starttime, String finishtime)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            // "id":"战略项目id 新增为空",
            // "title":"项目标题",
            // "info":"项目概述",
            // "handlerid":"指定汇报人ID",
            // "handler":"指定汇报人姓名",
            // "handlemode":"汇报方式",
            // "starttime":"开始时间 yyyy-mm-dd",
            // "endtime":"结束时间 yyyy-mm-dd"
            
            bodyVaule.put("id", id);
            bodyVaule.put("title", title);
            bodyVaule.put("info", info);
            bodyVaule.put("handlerid", handlerids);
            bodyVaule.put("handler", handlers);
            bodyVaule.put("handlemode", handlemode);
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", finishtime);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("strategicPro",
                "StrategicProAdapter",
                "addStrategicPro",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 汇报战略项目
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
    public static NetTask sendDebriefStrategicPro(NetTask task, Handler handler, int requestType, String id,
        String handlecontent, String handlestatus, String handletime, String fiskstatus)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
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
            NetRequestController.getPredefineObj("strategicPro",
                "StrategicProAdapter",
                "debriefStrategicPro",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 删除战略项目
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
    public static NetTask sendDelStrategicPro(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("strategicPro",
                "StrategicProAdapter",
                "delStrategicPro",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
