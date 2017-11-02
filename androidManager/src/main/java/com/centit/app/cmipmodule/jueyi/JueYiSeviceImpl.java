/*
 * File name:  JueYiSeviceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月21日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.jueyi;

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
 * @Version [版本号, 2016年9月21日]
 */
public class JueYiSeviceImpl
{
    // 获取决议/汇报列表
    /**
     * 
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type 类型：0 决议 1 汇报",
     * @param handletype 处理类型：0 待处理 1 我发起的
     * @param maxId
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetResultListRequest(NetTask task, Handler handler, int requestType, String type,
        String handletype, String maxId, String pagesize)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("handletype", handletype);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("result", "ResultAdapter", "getResultList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id 决议/汇报id
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetResultDetailRequest(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("result", "ResultAdapter", "getResultDetail", "general", bodyVaule);
        
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
     * @param id 决议/汇报id
     * @param handlestatus 处理状态
     * @param handlecontent 处理内容
     * @param handletime 处理时间
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendSubmitResultOpinionRequest(NetTask task, Handler handler, int requestType, String id,
        String handlestatus, String handlecontent, String handletime)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("handlestatus", handlestatus);
            bodyVaule.put("handlecontent", handlecontent);
            bodyVaule.put("handletime", handletime);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("result", "ResultAdapter", "submitResultOpinion", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取所属日程
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param keywords
     * @param currenttime
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetDailyWorkOfResult(NetTask task, Handler handler, int requestType, String keywords,
        String currenttime, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("keywords", keywords);
            bodyVaule.put("currenttime", currenttime);
            bodyVaule.put("pagesize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("result",
                "ResultAdapter",
                "getDailyWorkOfResult",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 编辑
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id 决议/汇报id
     * @param type 类型：0 决议 1 汇报
     * @param title 决议/汇报标题
     * @param info 决议/汇报内容
     * @param dailyworkid 决议/汇报所属日程
     * @param handlerids 指定人IDs，多个ID之间用半角逗号分隔
     * @param handlers 指定人姓名，多个人之间用半角逗号分隔
     * @param copierids 抄送人IDs，多个ID之间用半角逗号分隔
     * @param copiers 抄送人姓名，多个人之间用半角逗号分隔
     * @param finishtime 完成时间
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendEditResultResult(NetTask task, Handler handler, int requestType, String id, String type,
        String title, String info, String dailyworkid, String handlerids, String handlers, String copierids,
        String copiers, String finishtime)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("type", type);
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
            NetRequestController.getPredefineObj("result", "ResultAdapter", "editResult", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取人员列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type 类型：0 上级 1 下级
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetUserListResult(NetTask task, Handler handler, int requestType, String type)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("result", "ResultAdapter", "getUserList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 删除
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @return
     * @LastModifiedDate：2016年9月21日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendDeleteResult(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("result", "ResultAdapter", "deleteResult", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
