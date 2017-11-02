package com.centit.app.cmipmodule.ldschedule;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class LDScheduleServiceImpl
{
    
    /**
     * 获取领导日程列表
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
    public static NetTask sendGetLDScheduleList(NetTask task, Handler handler, int requestType, String starttime,
        String endtime, String keyword, String currentdatetime, String pagesize)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
            
            bodyVaule.put("keyword", keyword);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("leaderschedule",
                "LeaderScheduleAdapter",
                "getLeaderScheduleList",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    public static NetTask sendGetLDScheduleList_CMIP(NetTask task, Handler handler, int requestType, String starttime,
        String endtime, String keyword, String currentdatetime, String pagesize)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("starttime", starttime);
            bodyVaule.put("endtime", endtime);
            
            bodyVaule.put("keyword", keyword);
            bodyVaule.put("currentdatetime", currentdatetime);
            bodyVaule.put("pagesize", pagesize);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("leaderschedule",
                "LeaderScheduleAdapter",
                "getLeaderSchedules",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取领导日程详情
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
    public static NetTask sendGetLDScheduleDetail(NetTask task, Handler handler, int requestType, String scheduleid)
    {
        JSONObject requestObj = null;
        
        JSONObject bodyVaule = new JSONObject();
        
        try
        {
            bodyVaule.put("scheduleid", scheduleid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        requestObj =
            NetRequestController.getPredefineObj("leaderschedule",
                "LeaderScheduleAdapter",
                "getLeaderScheduleDetail",
                "general",
                bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
