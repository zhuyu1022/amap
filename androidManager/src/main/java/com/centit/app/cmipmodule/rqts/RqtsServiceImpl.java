/*
 * File name:  RqtsServiceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-28
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqts;

import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-28]
 */
public class RqtsServiceImpl
{
    // 预警推送
    public static NetTask getWarningPushInfo(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("warning",
                "WarningPushAdapter",
                "getWarningPushInfo",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 日清推送
    public static NetTask getWarningPushInfo1(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("warning",
                "WarningPushAdapter",
                "getWarningPushInfo1",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
