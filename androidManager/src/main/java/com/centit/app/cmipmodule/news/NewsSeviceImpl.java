package com.centit.app.cmipmodule.news;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class NewsSeviceImpl
{
    // 获取网站-频道列表
    public static NetTask sendGetSiteChannelListRequest(NetTask task, Handler handler, int requestType, String funcCode)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("funcCode", funcCode);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("information",
                "InfomationAdapter",
                "getSiteChannelList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取资讯列表
    public static NetTask sendGetInfomationListRequest(NetTask task, Handler handler, int requestType, String siteCode,
        String channelCode, String keywords, String maxId, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("siteCode", siteCode);
            bodyVaule.put("channelCode", channelCode);
            bodyVaule.put("keywords", keywords);
            // bodyVaule.put("currenttime", currenttime);
            bodyVaule.put("pageSize", pagesize);
            bodyVaule.put("maxId", maxId);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("information",
                "InfomationAdapter",
                "getInfomationList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取云图导航菜单
    public static NetTask getHaiercloudNavlist(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("information",
                "InfomationAdapter",
                "getHaiercloudNavlist",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取云图二级列表下的新闻列表
    public static NetTask getSecondNavNews(NetTask task, Handler handler, int requestType, String navid,
        String startNum, String pageSize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("navid", navid); // 二级菜单id
            bodyVaule.put("startNum", startNum);
            bodyVaule.put("pageSize", pageSize);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("information",
                "InfomationAdapter",
                "getSecondNavNews",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取云图新闻详情
    public static NetTask getCloudNewsInfo(NetTask task, Handler handler, int requestType, String id)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id); // 新闻id
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("information",
                "InfomationAdapter",
                "getCloudNewsInfo",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
}
