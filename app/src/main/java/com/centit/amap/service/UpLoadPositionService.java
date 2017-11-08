package com.centit.amap.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.IntDef;
import android.util.Log;

import com.centit.amap.database.Location;
import com.centit.amap.database.MapDatebaseManager;
import com.centit.amap.net.ServiceImplNew;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SystemUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UpLoadPositionService extends Service {

    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    MapDatebaseManager dbManager;

    //上一次上传服务器时数据库中最后一条记录的id
    int id;

    private String timing="10";
    public UpLoadPositionService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();

        dbManager=new MapDatebaseManager(this);

    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {

        //timing= (String) SharedUtil.getValue(this,SharedUtil.timing,"5");

        //记录数据库中大于该id的所有记录
        List<Location> locationList=dbManager.queryLocationsById(id);
        //记录最新一条记录
        Location lastLocation=new Location();
                List<Location> lastLocationList =    dbManager.querylastLocation(1);
               if (lastLocationList.size()>0){
                    lastLocation=lastLocationList.get(0);
               }
        startUpLoad(lastLocation.lat+"",lastLocation.lng+"",lastLocation.time,locationList);
        //获取数据库中最后一条记录的id
         id =dbManager.querylastId();
        startThisService();



        return super.onStartCommand(intent, flags, startId);
    }



    private void startThisService() {

        long second =Integer.parseInt(timing)*1000;
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long traggerAtTime = SystemClock.elapsedRealtime() + second;
        Intent i = new Intent(UpLoadPositionService.this, UpLoadPositionService.class);
        pendingIntent = PendingIntent.getService(UpLoadPositionService.this, 0, i, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
        }else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
        }
    }

    /**
     * 上传坐标
     *
     * @param lat
     * @param lng
     * @param acquisitiontime
     */
    private void startUpLoad(String lat, String lng, String acquisitiontime,List<Location> locationList) {

        String corpid = (String) SharedUtil.getValue(this,SharedUtil.corpid,"");
        String userid = (String) SharedUtil.getValue(this,SharedUtil.userid,"");
        String username = (String) SharedUtil.getValue(this,SharedUtil.username,"");
        String userphoto = ""; //人员头像
        String daptid = (String) SharedUtil.getValue(this,SharedUtil.departmentid,"");
        String daptname = (String) SharedUtil.getValue(this,SharedUtil.departmentname,"");; //部门名称
        String devicetype =(String) SharedUtil.getValue(this,SharedUtil.devicetype,""); ; //设备类型

        String devicecode = (String) SharedUtil.getValue(this,SharedUtil.devicecode,"");    //设备编号
        String appservion = SystemUtils.getVersionName(this);;    //app版本号

        String gps_flag="1";
        //是否开启GPS：0开启；1未开启

        if (SystemUtils.getGpsStatus(this)){
            gps_flag="0";
        }else{
            gps_flag="1";
        }
        ServiceImplNew.reportUserNewPosition(ServiceImplNew.TYPE_REPORTUSERNEWPOSITION,corpid, userid, username, userphoto, daptid, daptname, lat, lng, devicetype, devicecode, appservion, gps_flag, acquisitiontime,locationList,callback);
    }

    Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            LogUtil.d("链接失败！");
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {


            String result = response.body().string();
            Log.d("result", result);
            try {

                JSONObject jsonObj = new JSONObject(result);
                if (jsonObj != null) {
                    String retCode = jsonObj.optString("retCode");
                    if (retCode != null && retCode.equals("0")) {

                        LogUtil.d("上传成功！");

                        return;
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
    }
}