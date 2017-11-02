/*
 * File name:  BookReadSeiceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月30日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.xxzx;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

/**
 * 消息中心接口文件
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月30日]
 */
public class XXZXServiceImpl
{
    /**
     * 
     * 获取消息列表
     * 
     * @Description<功能详细描述>
     * 
     */
    public static NetTask getMsgCenterList(NetTask task, Handler handler, int requestType)
    {
        
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("message", "MsgAdapter", "getMsgCenterList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取消息未读数
     * 
     * @Description<功能详细描述>
     * 
     */
    public static NetTask getMsgNoReadCount(NetTask task, Handler handler, int requestType)
    {
        
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("message", "MsgAdapter", "getMsgNoReadCount", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 设置消息状态
     * 
     * @Description<功能详细描述>
     */
    public static NetTask updateMsgReadStatus(NetTask task, Handler handler, int requestType, String insid,
        String sortCode)
    {
        JSONObject obj = new JSONObject();
        try
        {
            obj.put("insid", insid);
            obj.put("sortCode", sortCode);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("message", "MsgAdapter", "updateMsgReadStatus", "general", obj);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取分类中所有消息
     * 
     * @Description<功能详细描述>
     * 
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getMsgList(NetTask task, Handler handler, int requestType, String sortCode, String maxId,
        String pageSize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("sortCode", sortCode);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pageSize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("message", "MsgAdapter", "getMsgList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 删除聊天项
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param insid
     * @return
     * @LastModifiedDate：2016年12月26日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask deleteItem(NetTask task, Handler handler, int requestType, String insid)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("insid", insid);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("message", "MsgAdapter", "deleteMsg", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
