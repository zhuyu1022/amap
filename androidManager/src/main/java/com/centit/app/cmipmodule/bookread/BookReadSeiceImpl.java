/*
 * File name:  BookReadSeiceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月30日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.bookread;

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
 * @Version [版本号, 2016年9月30日]
 */
public class BookReadSeiceImpl
{
    /**
     * 
     * 获取书籍列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type
     * @param handletype
     * @param maxId
     * @param pagesize
     * @return
     * @LastModifiedDate：2016年9月30日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetBookListRequest(NetTask task, Handler handler, int requestType, String maxId,
        String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("book", "BookAdapter", "getBookList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取书籍详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @return
     * @LastModifiedDate：2016年9月30日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetBookDetailRequest(NetTask task, Handler handler, int requestType, String id)
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
            NetRequestController.getPredefineObj("book", "BookAdapter", "getBookDetail", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 添加到购物车
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param bookid
     * @return
     * @LastModifiedDate：2016年9月30日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendAddToCartRequest(NetTask task, Handler handler, int requestType, String bookid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("bookid", bookid);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("book", "BookAdapter", "addToCart", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 从购物车中删除
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param ids
     * @return
     * @LastModifiedDate：2016年9月30日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendDeleteFromCartRequest(NetTask task, Handler handler, int requestType, String ids)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("ids", ids);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("book", "BookAdapter", "deleteFromCart", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * getCartList
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param maxId
     * @param pageSize
     * @return
     * @LastModifiedDate：2016年9月30日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetCartListRequest(NetTask task, Handler handler, int requestType, String maxId,
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
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("book", "BookAdapter", "getCartList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
