package com.centit.app.cmipmodule.tzgg;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class TZGGSeviceImpl
{
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param loginName
     * @param password
     * @return
     * @LastModifiedDate：2017年2月17日
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendTZGGListRequest(NetTask task, Handler handler, int requestType, String keywords,
        String currenttime, String pagesize)
    {
        JSONObject bodyVaule = new JSONObject();
        try
        {
            bodyVaule.put("keywords", keywords);
            bodyVaule.put("pagesize", pagesize);
            bodyVaule.put("currenttime", currenttime);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject requestObj =
            NetRequestController.getPredefineObj("notice", "NoticeAdapter", "getNotice", "general", bodyVaule);
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
}
