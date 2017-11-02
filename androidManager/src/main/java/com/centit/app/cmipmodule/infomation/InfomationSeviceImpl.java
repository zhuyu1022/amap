package com.centit.app.cmipmodule.infomation;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class InfomationSeviceImpl
{
    // 获取资讯类别
    // public static NetTask sendGetInfoTypeRequest(NetTask task, Handler handler, int requestType, String funcCode)
    // {
    // JSONObject bodyVaule = new JSONObject();
    // try
    // {
    // bodyVaule.put("funcCode", funcCode);
    // }
    // catch (JSONException e)
    // {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // JSONObject requestObj =
    // NetRequestController.getPredefineObj("infornews",
    // "InfoNewsAdapter",
    // "getInfomationType",
    // "general",
    // bodyVaule);
    //
    // return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    // }
    
    // 获取资讯列表
    public static NetTask sendGetInfomationListRequest(NetTask task, Handler handler, int requestType, String type,
        String keyword, String currentdatetime, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("keyword", keyword);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pagesize);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("infornews",
                "InfoNewsAdapter",
                "getInfomationList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取资讯列表
    public static NetTask sendGetInfomationDetailRequest(NetTask task, Handler handler, int requestType, String infoid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("informationid", infoid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("infornews",
                "InfoNewsAdapter",
                "getInformationDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
