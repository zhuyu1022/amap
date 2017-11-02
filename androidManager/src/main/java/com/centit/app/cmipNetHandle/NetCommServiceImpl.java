package com.centit.app.cmipNetHandle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class NetCommServiceImpl
{
    
    /**
     * 
     * 获取服务器信息
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     * @LastModifiedDate：<date>
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetSevInfo(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper", "SysInitAdapter", "getConnInfo", "general", bodyVaule);
        
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
        
    }
    
    public static NetTask updateModuleReadStatus(NetTask task, Handler handler, int requestType, String funcode,
        String insid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("funcCode", funcode);
            bodyVaule.put("unionId", insid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper",
                "CommOperAdapter",
                "updateModuleReadStatus",
                "general",
                bodyVaule);
        
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
        
    }
    
    /**
     * 上传日志
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param logType
     * @return
     */
    public static NetTask sendUploadLogInfo(NetTask task, Handler handler, int requestType, String logType)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("logType", logType);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper", "UploadLogAdapter", "uploadLogInfo", "upload", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 发起心跳请求
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     */
    public static NetTask sendHeartRequest(NetTask task, Handler handler, int requestType)
    {
        
        JSONObject bodyVaule = new JSONObject();
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper", "HeartBeatAdapter", "heartBeat", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 发送推送参数
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     * @LastModifiedDate：2015-2-28
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendBaiduInfo(NetTask task, Handler handler, int requestType, String pushType,
        String pushParam1, String pushParam2, String pushParam3, String pushParam4)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            
            bodyVaule.put("pushType", pushType);
            bodyVaule.put("pushParam1", pushParam1);
            bodyVaule.put("pushParam2", pushParam2);
            bodyVaule.put("pushParam3", pushParam3);
            bodyVaule.put("pushParam4", pushParam4);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper",
                "PushInfoRegisterAdapter",
                "registerPushInfo",
                "general",
                bodyVaule);
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 上傳设备信息
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param logType
     * @return
     */
    public static NetTask sendDeviceInfo(NetTask task, Handler handler, int requestType, String cellularProviderName,
        String totalMemory, String freeDiskSpace, String netConnectName, String wifiConnectName,
        String localWiFiIPAddress, String cellularNetworkType, String scrreenPixels, String isRoot, String macAddress,
        String deviceBrand)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("cellularProviderName", cellularProviderName);
            bodyVaule.put("totalMemory", totalMemory);
            bodyVaule.put("freeDiskSpace", freeDiskSpace);
            bodyVaule.put("netConnectName", netConnectName);
            bodyVaule.put("wifiConnectName", wifiConnectName);
            bodyVaule.put("localWiFiIPAddress", localWiFiIPAddress);
            bodyVaule.put("cellularNetworkType", cellularNetworkType);
            bodyVaule.put("scrreenPixels", scrreenPixels);
            bodyVaule.put("isRoot", isRoot);
            bodyVaule.put("macAddress", macAddress);
            bodyVaule.put("deviceBrand", deviceBrand);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper",
                "DevInfoGatherAdapter",
                "gatherDevInfo",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取数量接口
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     * @LastModifiedDate：<date>
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetCount(NetTask task, Handler handler, int requestType, String funcCode)
    {
        
        // JSONObject bodyVaule = new JSONObject();
        // try
        // {
        // bodyVaule.put("funcCode", funcCode);
        // }
        // catch (JSONException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // JSONObject requestObj =
        // NetRequestController.getPredefineObj("home", "HomeAdapter", "getModuleNoReadCount", "general", bodyVaule);
        //
        // return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("type", funcCode);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        requestObj =
            NetRequestController.getPredefineObj("official",
                "OfficialAdapter",
                "getLocalOfficialCount",
                "general",
                bodyVaule);
        // getOfficialCount
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取指定默认功能下二级菜单列表
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param funcCode
     * @param type
     * @return
     */
    public static NetTask sendGetModules(NetTask task, Handler handler, int requestType, String funcCode, String type)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("funcCode", funcCode);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("home", "HomeAdapter", "getNextModuleList", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取指定默认功能下二级菜单列表
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param funcCode
     * @param type
     * @return
     */
    public static NetTask sendGetModulesType(NetTask task, Handler handler, int requestType, String funcCode)
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
            NetRequestController.getPredefineObj("home", "HomeAdapter", "getModuleType", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取天气
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param cityName
     * @return
     */
    public static NetTask sendGetWeather(NetTask task, Handler handler, int requestType, String cityName)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("cityName", cityName);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("home", "HomeAdapter", "getWeather", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 修改密码
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param newPassword
     * @param oldPassword
     * @return
     */
    public static NetTask sendChangePwd(NetTask task, Handler handler, int requestType, String newPassword,
        String oldPassword)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("newPassword", newPassword);
            bodyVaule.put("oldPassword", oldPassword);
            bodyVaule.put("loginname", GlobalState.getInstance().getLoginName());
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "modifyPwd", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 设置绑定
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param password
     * @param flag
     * @return
     */
    public static NetTask sendBindDev(NetTask task, Handler handler, int requestType, String password, String flag)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("password", password);
            bodyVaule.put("flag", flag);
            bodyVaule.put("loginname", GlobalState.getInstance().getLoginName());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "bindDevice", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 设置是否設置消息推送
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param flag
     * @return
     */
    public static NetTask sendPushSet(NetTask task, Handler handler, int requestType, String flag)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("flag", flag);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "setPush", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取最新版本信息
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     */
    public static NetTask sendGetNewVersion(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("appType", "zhyy");
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper",
                "CommOperAdapter",
                "getNewestVersion",
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
     * @param funcCode
     * @param unionId
     * @return
     * @LastModifiedDate：2016年10月10日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendUpdateReadStatus(NetTask task, Handler handler, int requestType, String funcCode,
        String unionId)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("funcCode", funcCode);
            bodyVaule.put("unionId", unionId);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper",
                "CommOperAdapter",
                "updateModuleReadStatus",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取类型
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param selectType
     * @return
     * @LastModifiedDate：2016年10月27日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetSelectType(NetTask task, Handler handler, int requestType, String selectType)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("selectType", selectType);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper", "CommOperAdapter", "getSelectType", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取广告页
    public static NetTask sendGetStartPage(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("appType", Constant_Mgr.AppType);
            if (GlobalState.getInstance().getDeviceType().equals("A"))
            {
                bodyVaule.put("appId", "phone");
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper", "CommOperAdapter", "getStartPage", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 获取未读数
    public static NetTask getModuleNoReadCount(NetTask task, Handler handler, int requestType, String funcCode)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("funcCode", funcCode);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("home", "HomeAdapter", "getModuleNoReadCount", "general", bodyVaule);
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 更新模块点击统计
    public static NetTask updateClickModuleCount(NetTask task, Handler handler, int requestType, String modual)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("modual", modual);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("init", "InitAdapter", "updateModaulClickCnt", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 上传步数及获取步数排名
    public static NetTask sendStepRequest(NetTask task, Handler handler, int requestType, String step)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("sportNums", step);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("usersport",
                "UserSportAdapter",
                "getSportRanking",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask sendPushInfo(NetTask task, Handler handler, int requestType, String appid, String clientid,
        String channelid)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("appid", appid);
            bodyVaule.put("clientid", clientid);
            bodyVaule.put("channelid", channelid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("login", "LoginAdapter", "sendPushInfo", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    // 设置提醒时间
    public static NetTask setScheduleRemindtime(NetTask task, Handler handler, int requestType, String time)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("settime", time);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "setRemindtime", "general", bodyVaule);
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
        
    }
    
    /**
     * 
     * 获取日程提醒时间
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     * @LastModifiedDate：2017年2月27日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getScheduleRemindtime(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "getRemindtime", "general", bodyVaule);
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
        
    }
    
    // 设置手势密码关闭或取消
    public static NetTask saveGestureStatus(NetTask task, Handler handler, int requestType, String lockStatus)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("status", lockStatus);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("init", "InitAdapter", "lockDevice", "general", bodyVaule);
        
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 反馈意见
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param lockStatus
     * @return
     * @LastModifiedDate：2017年2月24日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask saveFeedback(NetTask task, Handler handler, int requestType, String lockStatus)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("content", lockStatus);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("feedback", "FeedbackAdapter", "createFeedback", "general", bodyVaule);
        
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 保存个性签名
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param lockStatus
     * @return
     * @LastModifiedDate：2017-7-10
     * @author zhu_yu
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask saveSignature(NetTask task, Handler handler, int requestType, String content)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("content", content);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "saveSignature", "general", bodyVaule);
        
        return NetRequestController.sendGetSerInfoServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 上传用户头像
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param filePath
     * @return
     * @LastModifiedDate：2017-7-10
     * @author zhu_yu
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask uploadPhoto(NetTask task, Handler handler, int requestType, String filePath)
    {
        JSONObject bodyVaule = new JSONObject();
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("pcenter", "PCenterAdapter", "uploadPhoto", "general", bodyVaule);
        List<FileInfo> infos = new ArrayList<FileInfo>();
        File file1 = new File(filePath);
        if (file1 != null && file1.exists())
        {
            FileInfo info = new FileInfo();
            info.filepath = file1.getAbsolutePath();
            info.filename = file1.getName();
            infos.add(info);
        }
        return NetRequestController.sendUploadFileServlet(null, handler, requestType, requestObj, infos);
    }
}
