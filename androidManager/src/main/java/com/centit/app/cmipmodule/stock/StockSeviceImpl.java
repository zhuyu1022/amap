package com.centit.app.cmipmodule.stock;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class StockSeviceImpl
{
    public static NetTask getStockList(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("stock", "StockAdapter", "getStockList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask attentionthestock(NetTask task, Handler handler, int requestType, String name, String code)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("name", name);
            bodyVaule.put("code", code);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("stock", "StockAdapter", "attentionthestock", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask unattentionthestock(NetTask task, Handler handler, int requestType, String code)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("code", code);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("stock", "StockAdapter", "unattentionthestock", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
