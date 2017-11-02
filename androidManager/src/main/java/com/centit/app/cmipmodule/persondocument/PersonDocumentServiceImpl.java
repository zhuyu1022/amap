package com.centit.app.cmipmodule.persondocument;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class PersonDocumentServiceImpl
{
    
    /**
     * 
     * 获取个人文档列表
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
     * @LastModifiedDate：2016-2-29
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetPersonalDocList(NetTask task, Handler handler, int requestType, String keyword,
        String currentdatetime, String pagesize, String parentnode, String foldertype)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("keyword", keyword);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pagesize);
            bodyVaule.put("parentnode", parentnode);
            bodyVaule.put("foldertype", foldertype);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("personaldoc",
                "PersonalDocAdapter",
                "getPersonalDocList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 个人文档新增
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param foldertype 文档业务类型
     * @param parentnode 上级节点id(空字符串为获取根节点)
     * @param foldername 文件夹名称
     * @return
     * @LastModifiedDate：2016-2-29
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendCreatePersonalDocFolder(NetTask task, Handler handler, int requestType,
        String foldertype, String parentnode, String foldername)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("foldertype", foldertype);
            bodyVaule.put("parentnode", parentnode);
            bodyVaule.put("foldername", foldername);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("personaldoc",
                "PersonalDocAdapter",
                "createPersonalDocFolder",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask sendSaveOrUpdatePersonalDocFolder(NetTask task, Handler handler, int requestType,
        String foldertype, String operationtype, String foldername, String id)
    {
        JSONObject requestObj = null;
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("foldertype", foldertype);
            bodyVaule.put("operationtype", operationtype);
            bodyVaule.put("id", id);
            bodyVaule.put("foldername", foldername);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("personaldoc",
                "PersonalDocAdapter",
                "saveOrUpdatePersonalDocFolder",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 上传文件
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param foldertype
     * @param title
     * @param doctype
     * @param parentnode
     * @return
     * @LastModifiedDate：2016-3-2
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendUploadPersonalDoc(NetTask task, Handler handler, int requestType, String foldertype,
        String title, String doctype, String parentnode, ArrayList<FileInfo> fileInfoList)
    {
        JSONObject requestObj = null;
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("foldertype", foldertype);
            bodyVaule.put("title", title);
            bodyVaule.put("doctype", doctype);
            bodyVaule.put("parentnode", parentnode);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("personaldoc",
                "PersonalDocAdapter",
                "uploadPersonalDoc",
                "upload",
                bodyVaule);
        
        return NetRequestController.sendUploadFileServlet(task, handler, requestType, requestObj, fileInfoList);
    }
    
}
