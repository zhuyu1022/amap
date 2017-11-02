/*
 * File name:  InforMarketSeviceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-21
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.informarket;

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
 * @Version [版本号, 2016-3-21]
 */
public class InforMarketSeviceImpl
{
    /**
     * 
     * 获取分类
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type
     * @param keyword
     * @param currentdatetime
     * @param pagesize
     * @return
     * @LastModifiedDate：2016-3-21
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendInforSuperMarketSortRequest(NetTask task, Handler handler, int requestType,
        String funcCode)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("funcode", funcCode);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("informarket",
                "InforMarketAdapter",
                "getInforMarketList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /***
     * 获取文件列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type
     * @param keyword
     * @param currentdatetime
     * @param pagesize
     * @return
     * @LastModifiedDate：2016-3-21
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendInforSuperMarketListRequest(NetTask task, Handler handler, int requestType, String maxId,
        String keyword, String pid, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("keywords", keyword);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pagesize", pagesize);
            bodyVaule.put("pid", pid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("informarket",
                "InforMarketAdapter",
                "getInforMarketFiles",
                "general",
                bodyVaule);
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
