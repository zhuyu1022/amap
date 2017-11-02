package com.centit.app.cmipmodule.roommanager;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class RoomManagerSeviceImpl
{
    /**
     * 
     * 获取会议室列表
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param keyword
     * @return
     * @LastModifiedDate：2016-3-4
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetBoardroomListRequest(NetTask task, Handler handler, int requestType, String keyword)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            
            bodyVaule.put("keyword", keyword);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("boardroom",
                "BoardRoomAdapter",
                "getBoardroomList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 获取会议室预定详情
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param boardroomid
     * @param starttime
     * @param endtime
     * @param currentdatetime
     * @param pagesize
     * @param keyword
     * @return
     * @LastModifiedDate：2016-3-4
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendBoardroomDetailRequest(NetTask task, Handler handler, int requestType,
        String boardroomid, String starttime, String endtime, String currentdatetime, String pagesize, String keyword)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            
            bodyVaule.put("boardroomid", boardroomid);
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pagesize);
            bodyVaule.put("keyword", keyword);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("boardroom",
                "BoardRoomAdapter",
                "getBoardroomDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 预定会议室
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param boardroomid
     * @param title
     * @param starttime
     * @param endtime
     * @param isremind
     * @return
     * @LastModifiedDate：2016-3-4
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendBookBoardroomRequest(NetTask task, Handler handler, int requestType, String boardroomid,
        String title, String starttime, String endtime, String isremind)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            
            bodyVaule.put("boardroomid", boardroomid);
            bodyVaule.put("title", title);
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
            bodyVaule.put("isremind", isremind);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("boardroom", "BoardRoomAdapter", "bookBoardroom", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 
     * 取消会议室预定
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param meetingid
     * @return
     * @LastModifiedDate：2016-3-4
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendCancelBookingRequest(NetTask task, Handler handler, int requestType, String meetingid)
    {
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            
            bodyVaule.put("meetingid", meetingid);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("boardroom",
                "BoardRoomAdapter",
                "cancelBookingBoardroom",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
}
