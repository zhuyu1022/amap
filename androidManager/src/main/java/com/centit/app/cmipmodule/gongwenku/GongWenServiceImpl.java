package com.centit.app.cmipmodule.gongwenku;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class GongWenServiceImpl
{
    /**
     * 获取归档公文的
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     */
    // public static NetTask sendGetGWKType(NetTask task, Handler handler, int requestType)
    // {
    // JSONObject requestObj = null;
    //
    // JSONObject bodyVaule = new JSONObject();
    // requestObj =
    // NetRequestController.getPredefineObj("archivingdoc",
    // "ArchivingDocAdapter",
    // "getDocType",
    // "general",
    // bodyVaule);
    //
    // return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    // }
    
    /**
     * 获取归档公文库列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     * @LastModifiedDate：2016年2月25日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetGWKList(NetTask task, Handler handler, int requestType, String keyword,
        String currentdatetime, String pagesize, String type)
    {
        JSONObject requestObj = null;
        
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
        
        requestObj =
            NetRequestController.getPredefineObj("archivingdoc",
                "ArchivingDocAdapter",
                "getDocList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取归档公文库详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     * @LastModifiedDate：2016年2月25日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetGWKDetail(NetTask task, Handler handler, int requestType, String messageitemguid,
        String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", messageitemguid);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("archivingdoc",
                "ArchivingDocAdapter",
                "getDocDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取公文库列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param keyword
     * @param currentdatetime
     * @param pagesize
     * @param type
     * @return
     * @LastModifiedDate：2017年2月20日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getofficialLibrary(NetTask task, Handler handler, int requestType, String keyword,
        String currentdatetime, String pagesize, String type)
    {
        JSONObject requestObj = null;
        
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
        
        requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "getOfficialList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
}
