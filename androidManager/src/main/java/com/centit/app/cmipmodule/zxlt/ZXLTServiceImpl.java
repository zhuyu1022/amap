/*
 * File name:  ZXLTServiceImpl.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年11月1日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.zxlt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年11月1日]
 */
public class ZXLTServiceImpl
{
    
    /**
     * 
     * 获取聊天列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type type:1私聊，type:2群聊
     * @param chat 聊天会话id+时间戳
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetChatListRequest(NetTask task, Handler handler, int requestType, String type,
        String chat)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("type", type);
            bodyVaule.put("chat", chat);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "getChatList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取聊天信息
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param cid 聊天实例id
     * @param mtime 聊天室人员更新时间
     * @param maxId 最大唯一标识
     * @param pageSize 分页大小
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetChatDataListRequest(NetTask task, Handler handler, int requestType, String cid,
        String mtime, String maxId, String pageSize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("cid", cid);
            bodyVaule.put("mtime", mtime);
            bodyVaule.put("maxId", maxId);
            bodyVaule.put("pageSize", pageSize);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "getChatData", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取聊天人员列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetUserListRequest(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "getUserList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 创建讨论组
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param uid 聊天人ids
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetChatRequest(NetTask task, Handler handler, int requestType, String uid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("uid", uid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "getChat", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 推出讨论组
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param cid
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendExitChatRequest(NetTask task, Handler handler, int requestType, String cid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("cid", cid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "exitChat", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 发送消息
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param cid 聊天会话id
     * @param msgtype 消息类型
     * @param content 内容
     * @param rid 书籍/新闻/视频/图片id
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendMsgRequest(NetTask task, Handler handler, int requestType, String cid, String msgtype,
        String content, String rid, String filepaths)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("cid", cid);
            bodyVaule.put("msgtype", msgtype);
            bodyVaule.put("content", content);
            bodyVaule.put("rid", rid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "sendMsg", "upload", bodyVaule);
        
        List<FileInfo> infos = new ArrayList<FileInfo>();
        
        // MIP_FileUtils.deleteDir(new File(Constant_Mgr.ZXLT_TEMP_ZIP));
        //
        // File file = new File(Constant_Mgr.ZXLT_TEMP_ZIP);
        // if (file != null && !file.exists())
        // {
        // file.mkdirs();
        // }
        //
        // String zipFilePath = Constant_Mgr.ZXLT_TEMP_ZIP + UUID.randomUUID().toString() + ".zip";
        //
        // if (filepaths != null && filepaths.size() > 0)
        // {
        // try
        // {
        // MIP_FileUtils.ZipFiles(filepaths, zipFilePath);
        // }
        // catch (Exception e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        // }
        if (filepaths != null && !filepaths.equals(""))
        {
            File file1 = new File(filepaths);
            if (file1 != null && file1.exists())
            {
                FileInfo info = new FileInfo();
                info.filepath = file1.getAbsolutePath();
                info.filename = file1.getName().replace(" ", "");
                infos.add(info);
            }
        }
        
        return NetRequestController.sendUploadFileServlet(null, handler, requestType, requestObj, infos);
        
        // return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 分享
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param msgtype
     * @param uid
     * @param rid
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendShareMessageRequest(NetTask task, Handler handler, int requestType, String msgtype,
        String uid, String rid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("msgtype", msgtype);
            bodyVaule.put("uid", uid);
            bodyVaule.put("rid", rid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "shareMessage", "upload", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 更新阅读状态
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param roomId
     * @return
     * @LastModifiedDate：2016年11月1日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendReadMessageStatusRequest(NetTask task, Handler handler, int requestType, String roomId)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("roomId", roomId);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "readMessageStatus", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 修改群聊天名称
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param cid
     * @param name
     * @return
     * @LastModifiedDate：2017年3月28日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendModifyChatRoomName(NetTask task, Handler handler, int requestType, String cid, String name)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("cid", cid);
            bodyVaule.put("name", name);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("chat", "ChatAdapter", "modifyChatRoomName", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
