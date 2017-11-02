/*
 * File name:  HERBServiceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月28日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.herb;

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
 * @Version [版本号, 2016年10月28日]
 */
public class HERBServiceImpl
{
    /**
     * 
     * 获取海尔人报列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param maxId
     * @param pageSize
     * @return
     * @LastModifiedDate：2016年10月28日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getHaierNspList(NetTask task, Handler handler, int requestType, String maxId, String pageSize)
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
            NetRequestController.getPredefineObj("newspaper",
                "HaierNspAdapter",
                "getHaierNspList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取海尔人报详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @return
     * @LastModifiedDate：2016年10月28日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getHaierNspDetail(NetTask task, Handler handler, int requestType, String id)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("newspaper",
                "HaierNspAdapter",
                "getHaierNspDetail",
                "general",
                bodyVaule);
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
