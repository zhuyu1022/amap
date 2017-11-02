package com.centit.amap.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;

import com.centit.amap.net.ServiceImpl;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.core.baseView.baseUI.MIPBaseService;

import org.json.JSONException;
import org.json.JSONObject;

public class GetConfParamsService extends MIPBaseService {

    private static final String TAG = "GetConfParamsService";
    //定时时间
    private int startTime = 10*1000;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private String corpid = "" ;
    private     String userid ="";
    public GetConfParamsService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        corpid= (String) SharedUtil.getValue(this,SharedUtil.corpid,"");
        userid= (String) SharedUtil.getValue(this,SharedUtil.userid,"");
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        downloadConfParams();
        startAlarmService();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtil.d("");
        super.onDestroy();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
        //Toast.makeText(this, "定时下发配置参数服务已停止", Toast.LENGTH_SHORT).show();
    }


    private void downloadConfParams() {



//        String corpid = "ding2ace95aa3863334d35c2f4657eb6378f";
//        String userid = "manager6483";
       ServiceImpl.downloadConfParams(null, mHandler, ServiceImpl.TYPE_DOWNLOADCONFPARAMS, corpid, userid);
    }

    /**
     * 通过Alarm的方式启动服务
     */
    private void startAlarmService() {

        //2、采用AlarmManager的方式实现
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long traggerAtTime = SystemClock.elapsedRealtime() + startTime;
        Intent i = new Intent(GetConfParamsService.this, GetConfParamsService.class);
        pendingIntent = PendingIntent.getService(GetConfParamsService.this, 0, i, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
        }else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
        }
    }

    @Override
    public void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode) {
        if (error) {
            LogUtil.d( requestType+"");
            switch (requestType) {
                case ServiceImpl.TYPE_DOWNLOADCONFPARAMS:

                    if (objBody != null && objBody instanceof String) {
                        try {
                            LogUtil.d("返回的数据为："+ objBody.toString());
                            JSONObject jsonObj = new JSONObject((String) objBody);
                            if (jsonObj != null) {
                                String retCode = jsonObj.optString("retCode");

                                if (retCode != null && retCode.equals("0")) {
                                    // 在此处理业务逻辑
                                    JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");
                                    String distance=bizDataJsonObj.optString("distance");
                                    String timing=bizDataJsonObj.optString("timing");
                                    String switch_flag=bizDataJsonObj.optString("switch_flag");
                                    SharedUtil.putValue(this,SharedUtil.distance,distance);
                                    SharedUtil.putValue(this,SharedUtil.timing,timing);
                                    return;
                                }
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    break;


            }
        } else {
            switch (requestType) {

            }
        }

    }

}
