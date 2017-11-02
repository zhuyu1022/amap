package com.centit.app.cmipmodule.hygl;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class HYGLSeviceImpl
{
    /**
     * 
     * 获取会议列表
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
    public static NetTask sendGetHYList(NetTask task, Handler handler, int requestType, String startTime, String endTime)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("starttime", startTime);
            bodyVaule.put("endtime", endTime);
            requestObj =
                NetRequestController.getPredefineObj("meeting",
                    "MeetingAdapter",
                    "getMeetingList",
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
     * 获取会议详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param hyId
     * @return
     * @LastModifiedDate：2017年2月16日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetMeetingDetail(NetTask task, Handler handler, int requestType, String hyId)
    {
        JSONObject requestObj = null;
        try
        {
            
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", hyId);
            requestObj =
                NetRequestController.getPredefineObj("meeting",
                    "MeetingAdapter",
                    "getMeetingDetail",
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
     * 会议签到
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param id 会议id
     * @param lng 经度
     * @param lat 纬度
     * @param location 地址
     * @return
     * @LastModifiedDate：2017年2月16日
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendSignMeeting(NetTask task, Handler handler, int requestType, String id, String lng,
        String lat, String location)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("id", id);
            bodyVaule.put("lng", lng);
            bodyVaule.put("lat", lat);
            bodyVaule.put("location", location);
            
            requestObj =
                NetRequestController.getPredefineObj("meeting", "MeetingAdapter", "signMeeting", "general", bodyVaule);
            
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
