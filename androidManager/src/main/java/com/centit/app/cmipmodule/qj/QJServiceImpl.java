/*
 * File name:  QJsEVIceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月26日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.qj;

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
 * @Version [版本号, 2016年10月26日]
 */
public class QJServiceImpl
{
    public static NetTask sendGetReqReportListRequest(NetTask task, Handler handler, int requestType, String type,
        String auditstatus, String maxId, String pagesize, String keywords)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("auditstatus", auditstatus);
            bodyVaule.put("keywords", keywords);
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
            NetRequestController.getPredefineObj("reqreport", "ReqReportAdapter", "getReqReport", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 审核
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param auditcontent
     * @return
     * @LastModifiedDate：2016年10月26日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendAuditReqReport(NetTask task, Handler handler, int requestType, String auditcontent,
        String id)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("auditcontent", auditcontent);
            bodyVaule.put("id", id);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("reqreport",
                "ReqReportAdapter",
                "auditReqReport",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 发起请示报告
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type
     * @param reason
     * @param starttime
     * @param endtime
     * @return
     * @LastModifiedDate：2016年10月27日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendReqReport(NetTask task, Handler handler, int requestType, String type, String reason,
        String starttime, String endtime)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("type", type);
            bodyVaule.put("reason", reason);
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("reqreport", "ReqReportAdapter", "sendReqReport", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
