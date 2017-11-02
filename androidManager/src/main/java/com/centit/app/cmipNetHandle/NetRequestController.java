package com.centit.app.cmipNetHandle;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.wrapRequest.CustomDownloadBaseWrapRequest;
import com.centit.app.cmipNetHandle.wrapRequest.CustomStrBaseWrapRequest;
import com.centit.app.cmipNetHandle.wrapRequest.CustomStrBaseWrapRequestNew;
import com.centit.app.cmipNetHandle.wrapRequest.CustomUploadBaseWrapRequest;
import com.centit.app.cmipNetHandle.wrapRequest.DownloadFileFromServerWrapRequest;
import com.centit.app.cmipNetHandle.wrapRequest.FileDownloadWithURLBaseWrapRequest;
import com.centit.app.cmipNetHandle.wrapRequest.LoginBaseWrapRequest;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.netUtils.engine.httpEngine.HttpNetFactoryCreator;

public class NetRequestController
{
    private static JSONObject getWrapHeader()
    {
        JSONObject jsonObj = new JSONObject();
        
        try
        {
            jsonObj.put("messageId", "");// 请求Id
            jsonObj.put("appCode", Constant_Mgr.ANDROID_APPID); // 应用编号
            jsonObj.put("appVersion", GlobalState.getInstance().getAppVersion()); // 应用版本号
            jsonObj.put("deviceId", GlobalState.getInstance().getDeviceId()); // 设备标示
            jsonObj.put("deviceType", GlobalState.getInstance().getDeviceType()); // 设备类型",1.
                                                                                  // ipad;
                                                                                  // 2.apad(android
                                                                                  // pad);3.iphone;4.android;5.ereb
            jsonObj.put("resolutionRatio", GlobalState.getInstance().getmScreen_With() + "X"
                + GlobalState.getInstance().getmScreen_Height()); // 分辨率
            jsonObj.put("isEncrypt", Constant_Mgr.isEncrypt);// 是否加密
            jsonObj.put("osVersion", GlobalState.getInstance().getOsVersion());// 系统版本
            jsonObj.put("userDept", GlobalState.getInstance().getDepName());// 所属部门
            jsonObj.put("userId", GlobalState.getInstance().getOpenId());// 用户Id
            jsonObj.put("sessionId", "");// 回话标示 GlobalState.getInstance().getSessingId()
            jsonObj.put("requestDateTime", System.currentTimeMillis());// 请求时间
            jsonObj.put("requestDescription", "");// 请求描述
            jsonObj.put("param1", "");// 预留字段1
            jsonObj.put("param2", "");// 预留字段2
            String param3 = "";
            int num = GlobalState.getInstance().getJHModuleNumber();
            switch (num)
            {
                case 0:
                    param3 = "simple";
                    break;
                case 1:
                    param3 = "metro";
                    break;
                case 2:
                    param3 = "metro2";
                    break;
                default:
                    break;
            }
            jsonObj.put("param3", param3);// 预留字段3
            jsonObj.put("param4", GlobalState.getInstance().getmUserNumber());// 预留字段4
            jsonObj.put("param5", GlobalState.getInstance().getmUserRole());// 预留字段5
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return jsonObj;
        
    }
    
    /**
     * 封装发起头时的JSONOBJ
     * 
     * @param bizCode
     * @param bizType
     * @param methodName
     * @return
     */
    public static JSONObject getPredefineObj(String bizCode, String bizType, String methodName, String rType,
        JSONObject bizeData)
    {
        JSONObject requestObj = new JSONObject();
        
        try
        {
            requestObj.put("bizCode", bizCode);
            requestObj.put("bizType", bizType);
            requestObj.put("methodName", methodName);
            requestObj.put("requestType", rType);
            if (bizeData != null)
            {
                requestObj.put("bizData", bizeData);
            }
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return requestObj;
    }
    
    /**
     * 以base str 发送时的处理函数 这个请求的URL为代码中默认的URL，其他所有的请求的URL均未服务器返回的URL
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param object
     * @return
     */
    public static NetTask sendGetSerInfoServlet(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMIP_BAES_URL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        //wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        wrapRequest.wrapRequest(handler, null, requestType, task, object);
        return task;
    }
    
    /**
     * 登录时封装的请求，下载的流的内容为zip流，里面的内容为.json、.alist文件
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param object
     * @param fileInfo
     * @return
     */
    public static NetTask sendLoginServlet(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        LoginBaseWrapRequest wrapRequest = new LoginBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }
    
    /**
     * 返回为String
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param object
     * @return
     */
    public static NetTask sendStrBaseServlet(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, null, requestType, task, object);
        
        return task;
    }

    public static NetTask sendStrBaseServletNew(NetTask task, Handler handler, int requestType, JSONObject requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequestNew wrapRequest =
                new CustomStrBaseWrapRequestNew(Constant_Mgr.getMipRequstURL(), requestType);


        wrapRequest.wrapRequestNew(handler, null, requestType, task, requestObj);

        return task;
    }


    
    /**
     * 下载文件时的处理，下载的流的内容为zip流
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param object
     * @param fileInfo
     * @return
     */
    public static NetTask sendStrDownloadServlet(NetTask task, Handler handler, int requestType, Object requestObj,
        FileInfo fileInfo)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomDownloadBaseWrapRequest wrapRequest =
            new CustomDownloadBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType, fileInfo);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }
    
    /**
     * 获取最新版本
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param object
     * @param fileInfo
     * @return
     */
    public static NetTask sendDownloadFileWithUrlServlet(NetTask task, Handler handler, int requestType, String url,
        FileInfo fileInfo)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        FileDownloadWithURLBaseWrapRequest wrapRequest =
            new FileDownloadWithURLBaseWrapRequest(requestType, url, fileInfo);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, null);
        
        return task;
    }
    
    // 通过前置机中转下载文件
    public static NetTask sendDownloadFileFromServlet(NetTask task, Handler handler, int requestType,
        Object requestObj, FileInfo fileInfo)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        DownloadFileFromServerWrapRequest wrapRequest =
            new DownloadFileFromServerWrapRequest(requestType, Constant_Mgr.getDownloadFileRequstURL(), fileInfo);
        
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYMAPPARM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }
    
    /**
     * 
     * 提交文件
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param requestObj
     * @param fileInfoList
     * @return
     * @LastModifiedDate：2015-2-15
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendUploadFileServlet(NetTask task, Handler handler, int requestType, Object requestObj,
        List<FileInfo> fileInfoList)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomUploadBaseWrapRequest wrapRequest =
            new CustomUploadBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        object.put(Constant_Net.FILES, fileInfoList);
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        return task;
    }
    
    /**
     * 获取验证码 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param requestObj
     * @return
     * @LastModifiedDate：2017-4-20
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendPhone(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }
    
    /**
     * 用户注册 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param requestObj
     * @return
     * @LastModifiedDate：2017-4-20
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask startZhuCe(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
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
     * @param requestObj
     * @return
     * @LastModifiedDate：2017-5-5
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getClockList(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }

    
    /**
     * 修改密码 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param requestObj
     * @return
     * @LastModifiedDate：2017-4-20
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask modifyPwd(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }
    
    /**
     * 提交用户信息 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param requestObj
     * @return
     * @LastModifiedDate：2017-4-20
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask userInfoSubmit(NetTask task, Handler handler, int requestType, Object requestObj)
    {
        if (task == null)
        {
            task = new HttpNetFactoryCreator(requestType).create();
        }
        CustomStrBaseWrapRequest wrapRequest =
            new CustomStrBaseWrapRequest(Constant_Mgr.getMipRequstURL(), requestType);
        HashMap<String, Object> object = new HashMap<String, Object>();
        object.put(Constant_Net.BODYPARAM, requestObj);
        
        wrapRequest.wrapRequest(handler, getWrapHeader(), requestType, task, object);
        
        return task;
    }
}
