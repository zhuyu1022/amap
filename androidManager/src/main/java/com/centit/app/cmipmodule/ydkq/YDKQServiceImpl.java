/*
 * File name:  YDKQServiceImpl.java
 * Copyright:  Copyright (c) 2006-2017 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zxm
 * Last modified date:  2017-5-4
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.ydkq;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.utils.MIP_FileUtils;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zxm
 * @Version [版本号, 2017-5-4]
 */
public class YDKQServiceImpl
{
    
    /**
     * 
     * 上下班打卡
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param singnType
     * @param signLocation
     * @param signLng
     * @param signLat
     * @return
     * @LastModifiedDate：2017-5-4
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask saveClock(NetTask task, Handler handler, int requestType, String signType,
        String signLocation, double signLng, double signLat)
    {
        
        JSONObject body = new JSONObject();
        try
        {
            body.put("type", signType);
            body.put("location", signLocation);
            body.put("lng", signLng);
            body.put("lat", signLat);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance", "AttendanceAdapter", "saveClock", "upload", body);
        
        String zipFilePath = Constant_Mgr.GETMIP_ROOT_DIR() + GlobalState.getInstance().getmUserId() + ".zip";
        String zipSourcePath = Constant_Mgr.GETMIP_ROOT_DIR() + GlobalState.getInstance().getmUserId();
        
        try
        {
            MIP_FileUtils.ZipFolder(zipSourcePath, zipFilePath);
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
     * 
     * 保存补卡记录
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param date
     * @param timeFlag
     * @param reason
     * @param auditorType
     * @param auditor
     * @return
     * @LastModifiedDate：2017-5-22
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask saveBKApply(NetTask task, Handler handler, int requestType, String date, String timeFlag,
        String reason, String auditorType, String auditor)
    {
        
        JSONObject body = new JSONObject();
        try
        {
            body.put("date", date);
            body.put("timeFlag", timeFlag);
            body.put("reason", reason);
            body.put("auditorType", auditorType);
            body.put("auditor", auditor);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance", "AttendanceAdapter", "saveApply", "upload", body);
        
        String zipFilePath = Constant_Mgr.GETMIP_ROOT_DIR() + GlobalState.getInstance().getmUserId() + ".zip";
        String zipSourcePath = Constant_Mgr.GETMIP_ROOT_DIR() + GlobalState.getInstance().getmUserId();
        
        try
        {
            MIP_FileUtils.ZipFolder(zipSourcePath, zipFilePath);
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
     * 
     * 获取后台系统时间
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @return
     * @LastModifiedDate：2017-6-27
     * @author zhu_yu
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getSystemTime(NetTask task, Handler handler, int requestType)
    {
        JSONObject bodyVaule = new JSONObject();
        
        JSONObject requestObj =
            NetRequestController.getPredefineObj("commoper", "CommOperAdapter", "getSystemTime", "general", bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取当天考勤记录 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param todayDate
     * @return
     * @LastModifiedDate：2017-5-8
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getClockList(NetTask task, Handler handler, int requestType, String todayDate)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("date", todayDate);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance",
                "AttendanceAdapter",
                "getClockList",
                "general",
                bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取当月考勤汇总 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param todayDate
     * @return
     * @LastModifiedDate：2017-5-8
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask geAttendanceList(NetTask task, Handler handler, int requestType, String curMonthDate)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("date", curMonthDate);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance",
                "AttendanceAdapter",
                "getAttendanceList",
                "general",
                bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取考勤日历明细表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param curMonthDate
     * @return
     * @LastModifiedDate：2017-5-9
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getAttendanceDetailList(NetTask task, Handler handler, int requestType, String curMonthDate)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("date", curMonthDate);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance",
                "AttendanceAdapter",
                "getAttendanceDetailList",
                "general",
                bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取审核列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param curMonthDate
     * @return
     * @LastModifiedDate：2017-6-5
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getAuditList(NetTask task, Handler handler, int requestType, String status, String keywords,
        String pageSize, String currenttime)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("status", status);
            bodyVaule.put("keywords", keywords);
            bodyVaule.put("pageSize", pageSize);
            bodyVaule.put("currenttime", currenttime);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance",
                "AttendanceAdapter",
                "getAuditList",
                "general",
                bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取审核列表详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @param type
     * @return
     * @LastModifiedDate：2017-6-6
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask getAuditDetail(NetTask task, Handler handler, int requestType, String id, String type)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("type", type);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance",
                "AttendanceAdapter",
                "getAuditDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
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
     * @param id
     * @param type
     * @return
     * @LastModifiedDate：2017-6-6
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask auditApply(NetTask task, Handler handler, int requestType, String id, String type,
        String status, String opinion)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("id", id);
            bodyVaule.put("type", type);
            bodyVaule.put("status", id);
            bodyVaule.put("opinion", type);
            
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("attendance", "AttendanceAdapter", "auditApply", "general", bodyVaule);
        
        return NetRequestController.getClockList(task, handler, requestType, requestObj);
    }
    
}
