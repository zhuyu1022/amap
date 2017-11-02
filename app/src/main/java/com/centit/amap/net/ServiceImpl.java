package com.centit.amap.net;

import android.os.Handler;

import com.centit.GlobalState;
import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhu_yu on 2017/10/11.
 */

public class ServiceImpl {
    public static final int TYPE_DOWNLOADCONFPARAMS=1;
    public static final int TYPE_REPORTUSERNEWPOSITION=2;
    public static final int  TYPE_GETNEWVERISION=3;
    public static NetTask downloadConfParams(NetTask task, Handler handler, int requestType, String corpid, String userid)
    {
        GlobalState.getInstance().setmMethodName("/downloadConfParams");


        JSONObject requestObj = new JSONObject();
        try
        {
            requestObj.put("corpid", corpid);
            requestObj.put("userid", userid);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }


    /**
     * 人员位置实时上报
     * @param task
     * @param handler
     * @param requestType
     * @param corpid
     * @param userid
     * @param username
     * @param userphoto
     * @param daptid
     * @param daptname
     * @param lng
     * @param lat
     * @param devicetype
     * @param devicecode
     * @param appservion
     * @param gps_flag
     * @param acquisitiontime
     * @return
     */
    public static NetTask reportUserNewPosition(NetTask task, Handler handler, int requestType,
                                                String corpid,     String userid,    String username,  String userphoto,
                                                String daptid,     String daptname,  String lat,       String lng,
                                                String devicetype ,String devicecode,String appservion,String gps_flag,
                                                String acquisitiontime)
    {
        GlobalState.getInstance().setmMethodName("/reportUserNewPosition");


        JSONObject requestObj = new JSONObject();
        try
        {
            requestObj.put("corpid", corpid);
            requestObj.put("userid", userid);
            requestObj.put("username", username);
            requestObj.put("userphoto", userphoto);
            requestObj.put("daptid", daptid);
            requestObj.put("daptname", daptname);
            requestObj.put("lng", lng);
            requestObj.put("lat", lat);
            requestObj.put("devicetype", devicetype);
            requestObj.put("devicecode", devicecode);
            requestObj.put("appservion", appservion);
            requestObj.put("gps_flag", gps_flag);
            requestObj.put("acquisitiontime", acquisitiontime);

        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }


    /**
     * 获取新版本
     * @param task
     * @param handler
     * @param requestType
     * @param corpid
     * @param userid
     * @param devicetype
     * @return
     */
    public static NetTask getNewVersion(NetTask task, Handler handler, int requestType, String corpid, String userid,String devicetype )
    {
        GlobalState.getInstance().setmMethodName("/downloadConfParams");


        JSONObject requestObj = new JSONObject();
        try
        {
            requestObj.put("corpid", corpid);
            requestObj.put("userid", userid);
            requestObj.put("devicetype", devicetype);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }
/*

"corpid": "企业id",
        "userid": "人员id",
        "username": "人员姓名",
        "userphoto": "人员头像",
        "daptid": "部门id",
        "daptname": "部门名称",
        "lng": "经度",
        "lat": "纬度",
        "devicetype": "设备类型",
        "devicecode": "设备编号",
        "appservion": "app版本号",
        "gps_flag": "是否开启GPS：0开启；1未开启",
        "acquisitiontime": "采集时间（移动端采集时间）yyyyMMddHHmmss"*/



}
