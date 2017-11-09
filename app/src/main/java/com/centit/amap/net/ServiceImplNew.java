package com.centit.amap.net;

import android.os.Handler;

import com.centit.GlobalState;
import com.centit.amap.database.Location;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Callback;

/**
 * Created by zhu_yu on 2017/10/11.
 */

public class ServiceImplNew {
    public static final int TYPE_DOWNLOADCONFPARAMS = 1;
    public static final int TYPE_REPORTUSERNEWPOSITION = 2;
    public static final int TYPE_GETNEWVERISION = 3;
    public static final int TYPE_AppVersionCheck = 4;
    public static final int TYPE_NewVersionAppDownloadUrl = 5;
    public static final int TYPE_UploadFile = 6;

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
     * @param requestType
     * @param corpid
     * @param userid
     * @param username
     * @param userphoto

     * @param lng
     * @param lat
     * @param devicetype
     * @param devicecode
     * @param appservion
     * @param gps_flag
     * @param acquisitiontime
     * @return
     */
 /*   public static void reportUserNewPosition( int requestType,
                                                String corpid, String userid, String username, String userphoto,
                                                String daptid, String daptname, String lat, String lng,
                                                String devicetype, String devicecode, String appservion, String gps_flag,
                                                String acquisitiontime,Callback callback) {
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

        OkHttpUtil.getInstance();
        OkHttpUtil.post(Constant_Mgr.getMIP_BAES_URL(), requestObj, callback);
    }*/


    public static void reportUserNewPosition(int requestType,
                                             String corpid, String userid, String username, String userphoto,
                                             String deptid, String deptname, String lat, String lng,
                                             String devicetype, String devicecode,String systemversion  ,String appservion,
                                             String gps_flag,
                                             String acquisitiontime, List<Location> pointList, Callback callback) {
        GlobalState.getInstance().setmMethodName("/reportUserNewPosition");


        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("corpid", corpid);
            requestObj.put("userid", userid);
            requestObj.put("username", username);
            requestObj.put("userphoto", userphoto);
            requestObj.put("deptid", deptid);
            requestObj.put("deptname", deptname);
            requestObj.put("lng", lng);
            requestObj.put("lat", lat);
            requestObj.put("devicetype", devicetype);
            requestObj.put("devicecode", devicecode);
            requestObj.put("systemversion", systemversion);
            requestObj.put("appservion", appservion);
            requestObj.put("gps_flag", gps_flag);
            requestObj.put("acquisitiontime", acquisitiontime);

            JSONArray jsonArray=new JSONArray();
            for (int i = 0; i <pointList.size() ; i++) {
                JSONObject positionObject=new JSONObject();
                positionObject.put("lng",pointList.get(i).lng);
                positionObject.put("lat",pointList.get(i).lat);
                positionObject.put("acquisitiontime",pointList.get(i).time);
                jsonArray.put(positionObject);
            }
            requestObj.put("pointList",jsonArray);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        OkHttpUtil.getInstance();
        OkHttpUtil.post(Constant_Mgr.getMIP_BAES_URL(), requestObj, callback);
    }







    /**
     * 检查新版本
     *

     * @param requestType
     * @param corpid
     * @return
     */
    public static void  appVersionCheck(int requestType, String corpid, String apptype, String version,Callback callback) {

        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("corpid", corpid);
            requestObj.put("apptype", apptype);
            requestObj.put("version", version);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url=Constant_Mgr.getMIP_BASEURL()+"/wzInternetConference/service/file/appVersionCheck";
        OkHttpUtil.getInstance();
        OkHttpUtil.post(url, requestObj, callback);
    }


    public static void  newVersionAppDownloadUrl(int requestType, String corpid,Callback callback) {
        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("corpid", corpid);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url=Constant_Mgr.getMIP_BASEURL()+"/wzInternetConference/service/file/newVersionAppDownloadUrl";
        OkHttpUtil.getInstance();
        OkHttpUtil.post(url, requestObj, callback);
    }








    /**
     *
     * @param requestType
     * @param filePath
     * @param callback
     */
    public static void  uploadFile(int requestType, String filePath,Callback callback) {

        String url=Constant_Mgr.getMIP_BASEURL()+"/wzInternetConference/service/file/fileUpload";
        OkHttpUtil.getInstance();
        OkHttpUtil.postFile(url,filePath,callback);
    }


}
