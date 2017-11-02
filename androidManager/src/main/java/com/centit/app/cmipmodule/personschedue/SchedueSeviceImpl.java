package com.centit.app.cmipmodule.personschedue;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class SchedueSeviceImpl
{
    /**
     * 
     * 新增/编辑日程
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @param title
     * @param address
     * @param starttime
     * @param endtime
     * @param content
     * @return
     * @LastModifiedDate：2017年2月16日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendAddSchedue(NetTask task, Handler handler, int requestType, String id, String title,
        String address, String starttime, String endtime, String content)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", id);
            bodyVaule.put("title", title);
            bodyVaule.put("location", address);
            bodyVaule.put("type", "");
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
            bodyVaule.put("content", content);
            requestObj =
                NetRequestController.getPredefineObj("personschedule",
                    "PersonScheduleAdapter",
                    "modifyPersonalSchedule",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 刪除日程
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param schedueId
     * @return
     * @LastModifiedDate：2015-5-26
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendDelSchedue(NetTask task, Handler handler, int requestType, String schedueId)
    {
        JSONObject requestObj = null;
        
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", schedueId);
            requestObj =
                NetRequestController.getPredefineObj("personschedule",
                    "PersonScheduleAdapter",
                    "deletePersonalSchedule",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取日程详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param schedueId
     * @return
     * @LastModifiedDate：2016-2-23
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetSchedueDetail(NetTask task, Handler handler, int requestType, String schedueId)
    {
        JSONObject requestObj = null;
        try
        {
            
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", schedueId);
            requestObj =
                NetRequestController.getPredefineObj("schedule",
                    "ScheduleAdapter",
                    "getSheduleDetail",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取日程列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param startTime
     * @param endTime
     * @return
     * @LastModifiedDate：2017年2月16日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetSchedueList(NetTask task, Handler handler, int requestType, String startTime,
        String endTime)
    {
        
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("starttime", startTime);
            bodyVaule.put("endtime", endTime);
            requestObj =
                NetRequestController.getPredefineObj("personschedule",
                    "PersonScheduleAdapter",
                    "getPersonalScheduleList",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取年日程安排列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param year
     * @param memberId
     * @return
     * @LastModifiedDate：2016年11月22日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetScheduleListByYear(NetTask task, Handler handler, int requestType, String year,
        String memberId)
    {
        
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("year", year);
            bodyVaule.put("memberId", memberId);
            requestObj =
                NetRequestController.getPredefineObj("schedule",
                    "ScheduleAdapter",
                    "getScheduleListByYear",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 新增预约日程
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @param title
     * @param joiners
     * @param joinernames
     * @param address
     * @param starttime
     * @param endtime
     * @param content
     * @param oid
     * @return
     * @LastModifiedDate：2016年11月22日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendAddBookSchedule(NetTask task, Handler handler, int requestType, String id, String title,
        String joiners, String joinernames, String address, String starttime, String endtime, String content, String oid)
    {
        JSONObject requestObj = null;
        try
        {
            
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", id);
            bodyVaule.put("title", title);
            bodyVaule.put("joiners", joiners);
            bodyVaule.put("joinernames", joinernames);
            bodyVaule.put("address", address);
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
            bodyVaule.put("content", content);
            bodyVaule.put("oid", oid);
            requestObj =
                NetRequestController.getPredefineObj("schedule",
                    "ScheduleAdapter",
                    "addBookSchedule",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 确认预约日程
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id
     * @param status
     * @return
     * @LastModifiedDate：2016年11月22日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendComfirmBookSchedule(NetTask task, Handler handler, int requestType, String id,
        String status)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", id);
            bodyVaule.put("status", status);
            requestObj =
                NetRequestController.getPredefineObj("schedule",
                    "ScheduleAdapter",
                    "comfirmBookSchedule",
                    "general",
                    bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
}
