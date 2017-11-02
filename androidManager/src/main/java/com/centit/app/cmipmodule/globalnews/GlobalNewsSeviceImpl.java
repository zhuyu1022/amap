package com.centit.app.cmipmodule.globalnews;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class GlobalNewsSeviceImpl
{
    public static NetTask getGlobalNewsList(NetTask task, Handler handler, int requestType, String maxId,
        String pageSize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pageSize);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("globalnews",
                "GlobalNewsAdapter",
                "getGlobalNewsList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask getGlobalNewsDetail(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("globalnews",
                "GlobalNewsAdapter",
                "getGlobalNewsDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
