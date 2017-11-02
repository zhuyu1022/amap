package com.centit.app.cmipmodule.qmys;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class QmysSeviceImpl
{
    
    // "body": {
    // "bizCode": "statement",
    // "bizData": {},
    // "bizType": "HaierIncomeReportAdapter",
    // "methodName": "getProductCatList",
    // "requestType": "general"
    // },
    
    public static NetTask getProjectList(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("statement",
                "HaierIncomeReportAdapter",
                "getProductCatList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // "body": {
    // "bizCode": "statement",
    // "bizData": {
    // "area": "0", // 全球为0
    // "date": "201604",
    // "terrace": "690",
    // "type": "month_income"
    // },
    // "bizType": "HaierReportAdapter",
    // "methodName": "getStatement",
    // "requestType": "general"
    
    public static NetTask getStatement(NetTask task, Handler handler, int requestType, String area, String date,
        String terrace, String type)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("area", area);
            bodyVaule.put("date", date);
            bodyVaule.put("terrace", terrace);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("statement",
                "HaierReportAdapter",
                "getStatement",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
}
