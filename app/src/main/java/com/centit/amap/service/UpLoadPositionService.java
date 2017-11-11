package com.centit.amap.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

import com.centit.amap.MainActivity;
import com.centit.amap.database.Location;
import com.centit.amap.database.MapDatebaseManager;
import com.centit.amap.net.ServiceImpl;
import com.centit.amap.net.ServiceImplNew;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SystemUtils;
import com.centit.core.baseView.baseUI.MIPBaseService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UpLoadPositionService extends MIPBaseService {

    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    MapDatebaseManager dbManager;

    //上一次上传服务器时数据库中最后一条记录的id
    int id;


    String lastTime="";

    private String timing="60";
    //定时请求配置参数
    private  static final long getConfParamsTime=3*60*1000;
    String endTime="";

    //日期格式
    private SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
    //日期格式
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private boolean isStop=false;

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
        LogUtil.d("上传服务创建");
        dbManager=new MapDatebaseManager(this);
//  检查结束时间
        checkEndTime();
        //获取间隔时间
        timing= (String) SharedUtil.getValue(UpLoadPositionService.this,SharedUtil.timing,"60");
        long second =Integer.parseInt(timing)*1000;
        lastTime= (String) SharedUtil.getValue(this,SharedUtil.lastTime,"");
        //延时启动handler
        upLoadhandler.postDelayed(upLoadRunnable, second);
        getConfParamsHandler.postDelayed(getConfParamsRunnable ,getConfParamsTime);
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
            LogUtil.d("上传服务启动");

        return super.onStartCommand(intent, flags, startId);
    }


/*
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
    }*/


    private void checkEndTime(){
        endTime=(String) SharedUtil.getValue(UpLoadPositionService.this,SharedUtil.endTime,"");
        Date date=new Date();
        String currentDate = dfDate.format(date);
        //endTime="201711092358";
        if (currentDate.equals(endTime)) {
            LogUtil.d("发送停止 MapService的广播。。。>>>");
            Intent intent = new  Intent();
            //设置intent的动作为com.example.broadcast，可以任意定义
            intent.setAction("STOPMAPSERVICE");
            //发送无序广播
            sendBroadcast(intent);
        }
    }



   // 1，首先创建一个Handler对象
    Handler upLoadhandler=new Handler();

//2，然后创建一个Runnable对象
    Runnable  upLoadRunnable=new Runnable(){
        @Override
        public void run() {
            //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作
            //每次都去从本地拿最新的配置参数，确保每一次都是有效的
            timing= (String) SharedUtil.getValue(UpLoadPositionService.this,SharedUtil.timing,"60");
            long second =Integer.parseInt(timing)*1000;
            lastTime= (String) SharedUtil.getValue(UpLoadPositionService.this,SharedUtil.lastTime,"");
            //检查结束时间是否匹配
            checkEndTime();
            LogUtil.d("handler方式启动！");

            //记录数据库中大于该id的所有记录
           // List<Location> locationList=dbManager.queryLocationsById(id);
            //  从数据库中查询大于改时间的所有数据
            List<Location> locationList=dbManager.queryLocationsByTime(lastTime);
            //记录最新一条记录
            Location lastLocation=new Location();
            List<Location> lastLocationList =    dbManager.querylastLocation(1);

            if (lastLocationList.size()>0){
                lastLocation=lastLocationList.get(0);
                //如果没有记录，即本次时间段内没有采集到点 ，则放入上次定位的最新的点
                if (locationList.size()==0){
                    locationList.add(lastLocation);
                }
            }
            startUpLoad(lastLocation.lat+"",lastLocation.lng+"",lastLocation.time,locationList);
            //获取数据库中最后一条记录的id
            //id =dbManager.querylastId();
            //查询数据库中最后一条记录的time，也就是定位时间，这个数值在上传成功后再保存在本地，非常重要！！！！上传失败的话不要保存该值，会重新从数据库中把上次失败上传的数值一起重新上传！！！
            lastTime=dbManager.querylastTime();




            //如果没有接收到停止服务的广播，继续循环
            if (!isStop){
                upLoadhandler.postDelayed(this, second);
            }
        }
    };




    // 1，首先创建一个Handler对象
    Handler getConfParamsHandler=new Handler();

    //2，然后创建一个Runnable对象
    Runnable getConfParamsRunnable=new Runnable(){
        @Override
        public void run() {
            LogUtil.d("handler方式启动！");
            // TODO Auto-generated method stub
            //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作
            downloadConfParams();
            long second =3*60*1000;
            //如果没有接收到停止服务的广播，继续循环
            if (!isStop){
                upLoadhandler.postDelayed(this, second);
            }
        }
    };














//3，使用PostDelayed方法，两秒后调用此Runnable对象

   // 实际上也就实现了一个2s的一个定时器

//4，如果想要关闭此定时器，可以这样操作
//handler.removeCallbacks(runnable);








    //new出上边定义好的BroadcastReceiver
    UpLoadPositionService.MyBroadCastReceiver myBroadCastReceiver = new UpLoadPositionService.MyBroadCastReceiver();
    //实例化过滤器并设置要过滤的广播
    IntentFilter intentFilter = new IntentFilter("STOPMAPSERVICE");
    class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("MyBroadCastReceiver", "onReceive: 时间到了，接收到停止MAPSERVICE服务的广播");
                isStop=true;
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
        String userphoto =(String) SharedUtil.getValue(this,SharedUtil.userphoto,"");; //人员头像
        String daptid = (String) SharedUtil.getValue(this,SharedUtil.departmentid,"");
        String daptname = (String) SharedUtil.getValue(this,SharedUtil.departmentname,"");; //部门名称
        String devicetype =(String) SharedUtil.getValue(this,SharedUtil.devicetype,""); ; //设备类型

        String devicecode = (String) SharedUtil.getValue(this,SharedUtil.devicecode,"");    //设备编号
        String systemversion=(String) SharedUtil.getValue(this,SharedUtil.systemversion,""); //系统版本号
        String appservion = SystemUtils.getVersionName(this);;    //app版本号

        String gps_flag="1";
        //是否开启GPS：0开启；1未开启

        if (SystemUtils.getGpsStatus(this)){
            gps_flag="0";
        }else{
            gps_flag="1";
        }
        String time=df.format(new Date());

        LogUtil.save(UpLoadPositionService.this,"开始上传位置，上传时间："+time+"所有坐标点：共"+locationList.size()+"个\n");
        for (int i = 0; i <locationList.size() ; i++) {
            Location location =locationList.get(i);
            LogUtil.save(UpLoadPositionService.this,"lat："+location.lat+"   lng:"+location.lng+"    time:"+location.time+"\n");
        }
        ServiceImplNew.reportUserNewPosition(ServiceImplNew.TYPE_REPORTUSERNEWPOSITION,corpid, userid, username, userphoto, daptid, daptname, lat, lng, devicetype, devicecode, systemversion,appservion, gps_flag, acquisitiontime,locationList,callback);
    }


    /**
     * 下发配置参数
     */
    private void downloadConfParams() {
        String corpid = (String) SharedUtil.getValue(this, SharedUtil.corpid, "");
        String userid = (String) SharedUtil.getValue(this, SharedUtil.userid, "");
        ServiceImpl.downloadConfParams(null, mHandler, ServiceImpl.TYPE_DOWNLOADCONFPARAMS, corpid, userid);
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
                        LogUtil.save(UpLoadPositionService.this,"上传成功！,上传间隔时间："+timing+"秒");

                        //在定位成功后保存数据库中


                        //一定要及时保存在本地，app重新进入的时候需要这个值，能够避免重复上传本地的点
                        SharedUtil.putValue(UpLoadPositionService.this,SharedUtil.lastTime,lastTime);


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
        LogUtil.d("上传服务销毁");
        super.onDestroy();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
    }

    @Override
    public void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode) {
        if (error) {
            LogUtil.d(requestType + "");
            switch (requestType) {
                case ServiceImpl.TYPE_DOWNLOADCONFPARAMS:

                    if (objBody != null && objBody instanceof String) {
                        try {
                            LogUtil.d("返回的数据为：" + objBody.toString());
                            JSONObject jsonObj = new JSONObject((String) objBody);
                            if (jsonObj != null) {
                                String retCode = jsonObj.optString("retCode");

                                if (retCode != null && retCode.equals("0")) {
                                    // 在此处理业务逻辑
                                    JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");
                                    String distance = bizDataJsonObj.optString("distance");
                                    String timing = bizDataJsonObj.optString("timing");
                                    String switch_flag = bizDataJsonObj.optString("switch_flag");
                                    String date = bizDataJsonObj.optString("date");
                                    ;
                                    // GlobalState.getInstance().setDistance(distance);
                                    // GlobalState.getInstance().setTiming(timing);
                                    SharedUtil.putValue(this, SharedUtil.distance, distance);
                                    SharedUtil.putValue(this, SharedUtil.timing, timing);
                                    SharedUtil.putValue(this, SharedUtil.switch_flag, switch_flag);
                                    SharedUtil.putValue(this, SharedUtil.endTime, date);
                                    //如果是0 说明要关闭服务
                                    if ("0".equals(switch_flag)) {
                                        Intent intent = new  Intent();
                                        //设置intent的动作为com.example.broadcast，可以任意定义
                                        intent.setAction("STOPMAPSERVICE");
                                        //发送无序广播
                                        sendBroadcast(intent);
                                    }


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
                case ServiceImpl.TYPE_DOWNLOADCONFPARAMS:
                 //   Toast.makeText(this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
