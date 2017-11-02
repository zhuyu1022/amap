package com.centit.app.cmipmodule.gwsp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.utils.MIP_FileUtils;

public class GWSPServiceImpl
{
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
    public static NetTask sendGetGWSPList(NetTask task, Handler handler, int requestType, String keyword,
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
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getLocalOfficialList",
                "general",
                bodyVaule);
        
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
    public static NetTask sendGetGWSPDetail(NetTask task, Handler handler, int requestType, String hid)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("hid", hid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getLocalOfficialDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取公文实体
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
    public static NetTask sendGetGWSPFileContent(NetTask task, Handler handler, int requestType, String hid,
        String dih, String assetid, FileInfo fileInfo)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("hid", hid);
            bodyVaule.put("did", dih);
            bodyVaule.put("assetid", assetid);
            
            // "did":"公文唯一id"
            // "hid":"工作项的唯一消息id"
            // "assetid":"附件唯一id"
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "getLocalDoc", "download", bodyVaule);
        
        return NetRequestController.sendStrDownloadServlet(task, handler, requestType, requestObj, fileInfo);
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
    public static NetTask sendGetGWSPDocHistory(NetTask task, Handler handler, int requestType, String hid, String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("hid", hid);
            if ("GWK".equals(type))
            {
                type = "";
            }
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
                "getLocalOfficialApprovalList",
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
    public static NetTask sendGWSPFileContent(NetTask task, Handler handler, int requestType, String hid,
        String filePath, String fileType, String opinion)
    {
        
        JSONObject body = new JSONObject();
        try
        {
            body.put("hid", hid);
            body.put("fileType", fileType);
            body.put("opinion", opinion);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "sendLocalOfficialProcess",
                "upload",
                body);
        List<FileInfo> infos = new ArrayList<FileInfo>();
        if (fileType.equals("1"))
        {
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
            
            File file1 = new File(zipFilePath);
            if (file1 != null && file1.exists())
            {
                FileInfo info = new FileInfo();
                info.filepath = file1.getAbsolutePath();
                info.filename = file1.getName();
                infos.add(info);
            }
        }
        else
        {
            
            File file1 = new File(filePath);
            if (file1 != null && file1.exists())
            {
                FileInfo info = new FileInfo();
                info.filepath = file1.getAbsolutePath();
                info.filename = file1.getName();
                infos.add(info);
            }
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
    public static NetTask sendGWSPGetNextStep(NetTask task, Handler handler, int requestType, String hid)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("hid", hid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "sendLocalOfficialProcess",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param type
     * @return
     * @LastModifiedDate：2016-6-14
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetLocalOfficialCount(NetTask task, Handler handler, int requestType, String type)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getLocalOfficialCount",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取附件
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param docid
     * @return
     * @LastModifiedDate：2016-7-13
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetGWSPAttachList(NetTask task, Handler handler, int requestType, String docid)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("hid", docid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getLocalOfficialAttachments",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取公文实体
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
    public static NetTask sendGetFileWithId(NetTask task, Handler handler, int requestType, FileInfo fileInfo,
        String hid, String assetid)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("hid", hid);
            bodyVaule.put("assetid", assetid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "getLocalDoc", "download", bodyVaule);
        
        return NetRequestController.sendStrDownloadServlet(task, handler, requestType, requestObj, fileInfo);
    }
    
    /**
     * 设置/取消收藏
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @return
     * @LastModifiedDate：2017年2月17日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask setCollect(NetTask task, Handler handler, int requestType, String hid, String status)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            // "hid":"工作项的唯一消息id",
            // "status":"1收藏  0取消收藏"
            
            bodyVaule.put("hid", hid);
            bodyVaule.put("status", status);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("official", "OfficialAdapter", "setCol", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
