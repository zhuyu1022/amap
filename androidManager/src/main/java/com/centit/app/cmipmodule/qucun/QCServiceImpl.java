/*
 * File name:  QCServiceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月27日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.qucun;

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
 * @Version [版本号, 2016年10月27日]
 */
public class QCServiceImpl
{
    
    public static NetTask getStrateList(NetTask task, Handler handler, int requestType, String funcCode)
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
            NetRequestController.getPredefineObj("strate", "StrateAdapter", "getStrateList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask sendUpdateModaulClickCnt(NetTask task, Handler handler, int requestType, String modual)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("modual", modual);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("init", "InitAdapter", "updateModaulClickCnt", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
