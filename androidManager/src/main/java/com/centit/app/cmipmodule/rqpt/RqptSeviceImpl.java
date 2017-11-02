package com.centit.app.cmipmodule.rqpt;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class RqptSeviceImpl
{
    // 获取战略项目列表
    public static NetTask getProjectList(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("project", "ProjectAdapter", "getProjectList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取项目报告列表
    public static NetTask getProjectReports(NetTask task, Handler handler, int requestType, String pid, String maxId,
        String pageSize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("pid", pid);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pageSize);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("project", "ProjectAdapter", "getProjectReports", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 设置项目报告为已读状态
    public static NetTask setReportStatus(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("project", "ProjectAdapter", "setReportStatus", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 回复项目报告
    public static NetTask replyProjectReports(NetTask task, Handler handler, int requestType, String id, String info)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("info", info);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("project",
                "ProjectAdapter",
                "replyProjectReports",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
