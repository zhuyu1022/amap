package com.centit.app.cmipmodule.weather;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class WeatherSeviceImpl
{
    /**
     * <一句话功能简述> 获取天气情况请求
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param cityName
     * @return
     * @LastModifiedDate：2015-9-18
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendGetWeatherRequest(NetTask task, Handler handler, int requestType, String cityName)
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
}
