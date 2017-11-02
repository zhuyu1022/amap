package com.centit.app.cmipmodule.notepad;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class NotePadSeviceImpl
{
    // 获取记事
    public static NetTask sendGetCloudRequest(NetTask task, Handler handler, int requestType, String keywords,
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("cloudevent",
                "CloudEventAdapter",
                "getCloudEvents",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 添加记事
    public static NetTask sendAddCloudRequest(NetTask task, Handler handler, int requestType, String content,
        long createTime)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("content", content);
            bodyVaule.put("createTime", "" + createTime);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("cloudevent",
                "CloudEventAdapter",
                "addCloudEvent",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 删除记事
    public static NetTask sendDelCloudRequest(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("cloudevent",
                "CloudEventAdapter",
                "delCloudEvent",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
