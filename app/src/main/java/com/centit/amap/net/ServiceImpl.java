package com.centit.amap.net;

import android.os.Handler;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Callback;

/**
 * Created by zhu_yu on 2017/10/11.
 */

public class ServiceImpl {
    public static final int TYPE_DOWNLOADCONFPARAMS = 1;
    public static final int TYPE_REPORTUSERNEWPOSITION = 2;
    public static final int TYPE_GETNEWVERISION = 3;

    public static NetTask downloadConfParams(NetTask task, Handler handler, int requestType, String corpid, String userid) {
        GlobalState.getInstance().setmMethodName("/downloadConfParams");


        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("corpid", corpid);
            requestObj.put("userid", userid);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }


    /**
     * 人员位置实时上报
     *
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
                                                String corpid, String userid, String username, String userphoto,
                                                String daptid, String daptname, String lat, String lng,
                                                String devicetype, String devicecode, String appservion, String gps_flag,
                                                String acquisitiontime) {
        GlobalState.getInstance().setmMethodName("/reportUserNewPosition");


        JSONObject requestObj = new JSONObject();
        try {
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

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }


    /**
     * 获取新版本
     *
     * @param task
     * @param handler
     * @param requestType
     * @param corpid
     * @param userid
     * @param devicetype
     * @return
     */
    public static NetTask getNewVersion(NetTask task, Handler handler, int requestType, String corpid, String userid, String devicetype) {
        GlobalState.getInstance().setmMethodName("/getNewVersion");


        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("corpid", corpid);
            requestObj.put("userid", userid);
            requestObj.put("devicetype", devicetype);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }


    public static NetTask appVersionCheck(NetTask task, Handler handler, int requestType, String corpid, String apptype, String version) {
        GlobalState.getInstance().setmMethodName("/appVersionCheck");


        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("corpid", corpid);
            requestObj.put("apptype", apptype);
            requestObj.put("version", version);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return NetRequestController.sendStrBaseServletNew(task, handler, requestType, requestObj);
    }


}
