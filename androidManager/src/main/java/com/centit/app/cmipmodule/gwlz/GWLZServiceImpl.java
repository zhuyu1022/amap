package com.centit.app.cmipmodule.gwlz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.utils.MIP_FileUtils;

public class GWLZServiceImpl
{
    /**
     * 获取归档公文的
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     */
    // public static NetTask sendGetGWLZType(NetTask task, Handler handler, int requestType, String funCode)
    // {
    // JSONObject requestObj = null;
    //
    // JSONObject bodyVaule = new JSONObject();
    // try
    // {
    // bodyVaule.put("funcode", funCode);
    //
    // }
    // catch (JSONException e)
    // {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // requestObj = NetRequestController.getPredefineObj("home", "HomeAdapter", "getModuleType", "general", bodyVaule);
    // return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    // }
    
    /**
     * 获取归档公文列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     * @LastModifiedDate：2016年2月25日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetGWLZList(NetTask task, Handler handler, int requestType, String keyword,
        String currentdatetime, String pagesize, String type, String handletype)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("keyword", keyword);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pagesize);
            bodyVaule.put("type", type);
            bodyVaule.put("handletype", handletype);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "getOfficialList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取归档公文库详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     * @LastModifiedDate：2016年2月25日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetGWLZDetail(NetTask task, Handler handler, int requestType, String messageitemguid,
        String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", messageitemguid);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getOfficialDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取公文历史记录
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param messageitemguid
     * @param type
     * @return
     * @LastModifiedDate：2016年3月1日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetDocHistory(NetTask task, Handler handler, int requestType, String messageitemguid,
        String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", messageitemguid);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getOfficialApprovalList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取当前处理人员
    public static NetTask getOfficialActiveNodeList(NetTask task, Handler handler, int requestType,
        String messageitemguid, String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", messageitemguid);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getOfficialActiveNodeList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取公文附件列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param docid
     * @param type
     * @return
     * @LastModifiedDate：2016年3月1日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetAttachList(NetTask task, Handler handler, int requestType, String docid, String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", docid);
            bodyVaule.put("type", type);
            
            bodyVaule.put("currentdatetime", "");
            bodyVaule.put("pagesize", "20");
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getOfficialAttachments",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * <一句话功能简述> 发送文件
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param docId
     * @param doctitle
     * @param nextpersonid
     * @param nextstepid
     * @param type
     * @param mDocFileId
     * @return
     * @LastModifiedDate：2015-7-13
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendFileContent(NetTask task, Handler handler, int requestType, String messageitemguid,
        String nodeinstid, JSONArray nextsteplist, String opinion, String type, String docfileid)
    {
        
        JSONObject body = new JSONObject();
        try
        {
            body.put("messageitemguid", messageitemguid);
            body.put("nodeinstid", nodeinstid);
            body.put("nextsteplist", nextsteplist);
            body.put("opinion", opinion);
            body.put("type", type);
            body.put("docFileid", docfileid);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "sendOfficialProcess", "upload", body);
        
        File zipFoldeFile = new File(Constant_Mgr.MIP_PNG_TEMP_ZIP);
        if (zipFoldeFile != null)
        {
            if (zipFoldeFile.exists())
            {
                if (zipFoldeFile.isFile())
                {
                    zipFoldeFile.delete();
                }
                else
                {
                    MIP_FileUtils.deleteDir(zipFoldeFile);
                }
            }
            zipFoldeFile.mkdirs();
        }
        
        String zipFilePath = Constant_Mgr.MIP_PNG_TEMP_ZIP + UUID.randomUUID().toString() + ".zip";
        
        try
        {
            MIP_FileUtils.ZipFolder(Constant_Mgr.MIP_PNG_TEMP, zipFilePath);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        List<FileInfo> infos = new ArrayList<FileInfo>();
        
        File file1 = new File(zipFilePath);
        if (file1 != null && file1.exists())
        {
            FileInfo info = new FileInfo();
            info.filepath = file1.getAbsolutePath();
            info.filename = file1.getName();
            infos.add(info);
        }
        
        return NetRequestController.sendUploadFileServlet(null, handler, requestType, requestObj, infos);
    }
    
    /**
     * <一句话功能简述> 获取下一步步骤
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param messageitemguid
     * @param type
     * @param nodeinstid
     * @return
     * @LastModifiedDate：2016年3月2日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetNextStep(NetTask task, Handler handler, int requestType, String messageitemguid,
        String type, String nodeinstid)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", messageitemguid);
            bodyVaule.put("type", type);
            bodyVaule.put("nodeinstid", nodeinstid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getNextOfficialProcessing",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * <一句话功能简述> 签批时锁定公文
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param docid
     * @param type
     * @param lockstatus 锁定状态T锁定F解锁
     * @return
     * @LastModifiedDate：2016年3月4日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendLockDocRequest(NetTask task, Handler handler, int requestType, String docid, String type,
        String lockstatus)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("messageitemguid", docid);
            bodyVaule.put("type", type);
            
            bodyVaule.put("lockstatus", lockstatus);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "lockOfficial ", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // // 获取未读数
    // public static NetTask getOfficialUncount(NetTask task, Handler handler, int requestType, String type)
    // {
    // JSONObject requestObj = null;
    //
    // JSONObject bodyVaule = new JSONObject();
    // try
    // {
    // bodyVaule.put("type", type);
    // }
    // catch (JSONException e)
    // {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //
    // requestObj =
    // NetRequestController.getPredefineObj("official",
    // "OfficialAdapter",
    // "getOfficialCount",
    // "general",
    // bodyVaule);
    //
    // return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    // }
}
