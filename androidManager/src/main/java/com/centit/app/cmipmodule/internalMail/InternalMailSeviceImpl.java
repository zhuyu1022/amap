package com.centit.app.cmipmodule.internalMail;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class InternalMailSeviceImpl
{
    /**
     * 
     * 获取内部邮件列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param keyword
     * @param currentdatetime
     * @param pageSize
     * @param type 1收件箱2发件箱
     * @param isRead 0：已读 1：未读 2：全部
     * @return
     * @LastModifiedDate：2016-2-23
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetInternalMailListRequest(NetTask task, Handler handler, int requestType,
        String keyword, String currentdatetime, String pageSize, String type, String isRead)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            
            bodyVaule.put("keyword", keyword);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pageSize);
            bodyVaule.put("type", type);
            bodyVaule.put("isread", isRead);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("internalmail",
                "InternalMailAdapter",
                "getMsgList",
                "general",
                bodyVaule);
        
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
     * @param msgid
     * @return
     * @LastModifiedDate：2016-2-23
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendUpdateMailReadStatusRequest(NetTask task, Handler handler, int requestType, String msgid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("msgid", msgid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("internalmail",
                "InternalMailAdapter",
                "updateMsgReadStatus",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取邮件详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param msgid
     * @return
     * @LastModifiedDate：2016-2-23
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetMailDetailRequest(NetTask task, Handler handler, int requestType, String msgid)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("msgid", msgid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("internalmail",
                "InternalMailAdapter",
                "getMsgDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 删除邮件
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param msgid
     * @return
     * @LastModifiedDate：2016-2-23
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendDeleteMailDetailRequest(NetTask task, Handler handler, int requestType, String msgid,
        String type)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("msgids", msgid);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("internalmail",
                "InternalMailAdapter",
                "deleteMsg",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 发送邮件
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param content
     * @param replaymsgid
     * @param title
     * @param receiverids
     * @param fileInfoList
     * @return
     * @LastModifiedDate：2016-2-23
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendNewMailRequest(NetTask task, Handler handler, int requestType, String content,
        String replaymsgid, String title, String receiverids, List<FileInfo> fileInfoList)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            // "attachlist"
            bodyVaule.put("content", content);
            bodyVaule.put("replaymsgid", replaymsgid);
            bodyVaule.put("title", title);
            bodyVaule.put("receiverids", receiverids);
            
            // JSONArray attchArr = new JSONArray();
            // for (int i = 0; i < fileInfoList.size(); i++)
            // {
            // JSONObject obj = new JSONObject();
            // String name = fileInfoList.get(i).getFilename();
            // obj.put("attachtitle", name);
            // if (name.contains("."))
            // {
            // obj.put("attachtype", name.substring(name.lastIndexOf(".")));
            // }
            // else
            // {
            // obj.put("attachtype", "");
            // }
            //
            // attchArr.put(obj);
            // }
            // bodyVaule.put("attachlist", attchArr);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("internalmail", "InternalMailAdapter", "sendMsg", "general", bodyVaule);
        
        return NetRequestController.sendUploadFileServlet(task, handler, requestType, requestObj, fileInfoList);
    }
}
