package com.centit.amap.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.centit.amap.MainActivity;
import com.centit.amap.R;
import com.centit.amap.avtivity.SettingActivity;
import com.centit.amap.constant.Constant;
import com.centit.amap.database.Location;
import com.centit.amap.database.MapDatebaseManager;
import com.centit.amap.net.ServiceImpl;
import com.centit.amap.net.ServiceImplNew;
import com.centit.amap.util.BatteryUtils;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SystemUtils;
import com.centit.amap.util.ToastUtil;
import com.centit.core.baseView.baseUI.MIPBaseService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MapService extends MIPBaseService {


    private static final String TAG = "MapService";
    //上传坐标请求码
    private static final int REQUEST_UPLOAD = 0;
    //日期格式
    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    //android原生定位管理器
    private LocationManager lm;
    //声明AMapLocationClientOption对象
    private AMapLocationClientOption mLocationOption = null;
    //声明AMapLocationClient类对象
    private AMapLocationClient mLocationClient = null;
    //定位距离 5米
    private int locationDistance = 10;
    //定位最小距离 3米
    private static final int minLocationDistance = 1;
    //默认定位间隔时间 5秒
    private static final int intervaTime = 5000;
    //数据库操作类
    MapDatebaseManager dbManager;
    private String mUserid;

    private MapBinder mBinder = new MapBinder();


    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    private List<Location> locationList = new ArrayList<>();
    //服务自动停止时间
    private String endTime = "";


    //用于获取service实例
    public class MapBinder extends Binder {
        public MapService getService() {
            return MapService.this;
        }

    }


    public MapService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        LogUtil.d("");

        super.onCreate();
        //初始化数据
        initDate();
        //前台进程
        startForeground();
        //初始化定位配置
        initMap();
        dbManager = new MapDatebaseManager(this);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //注册卫星监听
        lm.addGpsStatusListener(listener);
        //startAlarmService();
        //重复发送广播，检查各个service运行情况
        startBroadcast();
        //开启alarmservice不断唤醒cpu 检查 mapservice
        if (!SystemUtils.isServiceRunning(this, Constant.MapAlarmCheckService)) {
            Intent intent1 = new Intent(this, MapAlarmCheckService.class);
            startService(intent1);
        }
        //定时上传定位点，非常重要！！！！！
        startUploadService();

        //注册广播，用于监听 是否到时间停止mapservice
       // registerReceiver(myBroadCastReceiver,intentFilter);
    }

    //将service变为前台进程
    private void startForeground() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("巡防轨迹")
                .setContentText("正在运行")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_logo))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }

    private void initDate() {

        mUserid = (String) SharedUtil.getValue(MapService.this, SharedUtil.userid, "");
        String distance = (String) SharedUtil.getValue(MapService.this, SharedUtil.distance, "10");
        if (!TextUtils.isEmpty(distance)) {
            locationDistance = Integer.parseInt(distance);
        }
        endTime = (String) SharedUtil.getValue(MapService.this, SharedUtil.endTime, "2017-12-10");

    }


    private void initMap() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。高精度定位模式：会同时使用网络定位和GPS定位，优先返回最高精度的定位结果，以及对应的地址描述信息。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //控制是否返回速度值，当设置为true时会通过手机传感器获取海拔高度,如果手机没有对应的传感器会返回0.0
        // mLocationOption.setSensorEnable(true);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(intervaTime);
        //获取一次定位结果：
        //该方法默认为false。
        //mLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        //mLocationOption.setOnceLocationLatest(true);
        //设置定位距离 为10米
        //mLocationOption.setDeviceModeDistanceFilter(locationDistance);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(10000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
    }

    /**
     * 每隔5秒发送一次广播
     */
    private void startBroadcast() {
        //创建Alarm并启动
        Intent intent = new Intent("LOCATION_CLOCK");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // 每五秒唤醒一次
        long second = 5 * 1000;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), second, pendingIntent);
    }

    /**
     *
     */

    private void startUploadService() {

        boolean stopBySever = (boolean) SharedUtil.getValue(this, SharedUtil.stopBySever, true);
        if (!stopBySever) {{
            //创建Alarm并启动
            Intent intent = new Intent(this, UpLoadPositionService.class);
            startService(intent);
        }}


    }

    private void stopUploadService() {
        Intent intent = new Intent(this, UpLoadPositionService.class);
        stopService(intent);

    }

    /**
     * 定时唤醒cpu
     */
//    private void startAlarmService() {
//        long second = 5 * 1000;
//        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        long traggerAtTime = SystemClock.elapsedRealtime() + second;
//        Intent i = new Intent(this, MapAlarmCheckService.class);
//        pendingIntent = PendingIntent.getService(this, 0, i, 0);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
//        }else {
//            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
//        }
//    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d("");
        new Thread(new Runnable() {
            @Override
            public void run() {
                noGpsTime = 0;
                mLocationClient.startLocation();
            }
        }).start();
        // startAlarmService();
        return super.onStartCommand(intent, flags, startId);
    }


    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //如果没有被服务器停止z再去做业务逻辑处理
                    boolean stopBySever= (boolean) SharedUtil.getValue(MapService.this,SharedUtil.stopBySever,true);
                    if (stopBySever) {
                        LogUtil.d("被服务器停止了，不做地址解析！");
                        return;
                    }

                    checkService();
                    //初始化参数，避免服务器更新了，及时保存到本地，使得配置起作用
                    initDate();
                    Date date = new Date();
                    //可在其中解析amapLocation获取相应内容。
                    int type = aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    //float speed = aMapLocation.getSpeed();
                    double lat = aMapLocation.getLatitude();//获取纬度
                    double lng = aMapLocation.getLongitude();//获取经度
                    String address = aMapLocation.getAddress();//地址
                    String street = aMapLocation.getStreet();//街道信息
                    //Date date = new Date(aMapLocation.getTime());//定位时间
                    String time = DATEFORMAT.format(date);
                    //生成location实例
                    Location location = new Location(time, lat, lng, street, mUserid, 0);
                    //后面吧业务逻辑放在这里，type为2的情况就不要记录了，用户压根就没动
                    //if (type != AMapLocation.LOCATION_TYPE_SAME_REQ) {
                    //定位type 为 2 ，且数据库中有 记录，结束，不打点
                    if (type == AMapLocation.LOCATION_TYPE_SAME_REQ&&dbManager.query().size()>0){
                        LogUtil.d("定位类型为2，当前用户静止，不打点");
                        LogUtil.save(MapService.this,"定位类型为2，高德判断当前用户静止，不打点\n");
                        ToastUtil.show(MapService.this,"定位类型为2，高德判断当前用户静止，不打点");
                        return;
                    }
                    //如果数据库中有一个以上的点，才计算两点之间的距离
                        if (dbManager.query().size()>0) {
                            //查找上一个定位点
                            Location lastlocation = dbManager.querylastLocation(1).get(0);
                            DPoint startPoint = new DPoint(lastlocation.lat, lastlocation.lng);
                            DPoint endPoint = new DPoint(lat, lng);
                            //获得本次定位点和上次定位点的距离
                            float distance = CoordinateConverter.calculateLineDistance(startPoint, endPoint);
                            //大于最小定位距离时才定位
                            if (distance < minLocationDistance) {
                                LogUtil.d("定位距离小于1m，不打点");
                                LogUtil.save(MapService.this,"定位距离小于1m，不打点\n");
                                ToastUtil.show(MapService.this,"本次定位距离小于1m，不打点");
                                return;
                            }
                        }

                        //保存到数据库
                        dbManager.add(location);
                        //回调接口
                        if (mSuccessListener != null) {
                            mSuccessListener.onSuccess(location);
                        }
                        //上传坐标   上传的接口放在 uploadservice中了，这里不再上传！！
                        //  startUpLoad(lat+"",lng+"",time);
                        //当通过gps获取到地址后，且当前是高精度定位模式下，改成仅设备模式，节省电量
                        if (type == AMapLocation.LOCATION_TYPE_GPS && mLocationOption.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Hight_Accuracy) {
                            //mLocationClient.stopLocation();
                            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
                            mLocationOption.setDeviceModeDistanceFilter(locationDistance);
                            mLocationClient.setLocationOption(mLocationOption);
                            //mLocationClient.startLocation();
                            LogUtil.save(MapService.this, "已获取到gps信号，切换回设备模式\n");
                            ToastUtil.show(MapService.this,"已获取到gps信号，切换回设备模式");
                        }


                        //在设备模式下实时检查服务器的定位距离是否变更
                        if (mLocationOption.getLocationMode()==AMapLocationClientOption.AMapLocationMode.Device_Sensors){
                           String distance = (String) SharedUtil.getValue(MapService.this, SharedUtil.distance, "10");
                            if (!TextUtils.isEmpty(distance)) {

                                if (locationDistance!=Integer.parseInt(distance)){
                                    mLocationOption.setDeviceModeDistanceFilter(locationDistance);
                                    mLocationClient.setLocationOption(mLocationOption);
                                    locationDistance = Integer.parseInt(distance);
                                }

                            }
                        }
                        //获取电池电量
                        String battery = BatteryUtils.getBatteryPercent(MapService.this) + "%";
                        String logStr = "\ntype:" + type + "\tlat:" + lat + "\tlng:" + lng + " \taddress:" + street + "\t time:" + time + "\nlocationDistance:" + locationDistance + " \n电量：" + battery + "\n 定位精度：" + mLocationOption.getLocationMode();
                        LogUtil.save(MapService.this, logStr);
                        LogUtil.d(logStr);
                        // Toast.makeText(MapService.this, logStr, Toast.LENGTH_SHORT).show();
                        ToastUtil.show(MapService.this, logStr);
                   // }


                } else {

                    String logStr = "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo()+"\n";
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    LogUtil.e(logStr);
                    LogUtil.save(MapService.this, logStr);
                    ToastUtil.show(MapService.this, logStr);

                    //回调接口
                    if (mFailListener != null) {
                        mFailListener.onFail(aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
                    }
                    //定位失败后重新开启高精度定位模式，定时定位方式，尝试再次定位
                    //mLocationClient.stopLocation();
                    mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                    mLocationOption.setInterval(intervaTime);
                    mLocationClient.setLocationOption(mLocationOption);
                    // mLocationClient.startLocation();

                }
            }


        }
    };


    int noGpsTime = 0;
    // 状态监听
    GpsStatus.Listener listener = new GpsStatus.Listener() {
        public void onGpsStatusChanged(int event) {
            switch (event) {
                // 第一次定位
                case GpsStatus.GPS_EVENT_FIRST_FIX:
                    LogUtil.d("第一次定位");
                    break;
                // 卫星状态改变
                case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                    // LogUtil.d("卫星状态改变");
                    // 获取当前状态
                    GpsStatus gpsStatus = lm.getGpsStatus(null);
                    // 获取卫星颗数的默认最大值
                    int maxSatellites = gpsStatus.getMaxSatellites();
                    // 创建一个迭代器保存所有卫星
                    Iterator<GpsSatellite> iters = gpsStatus.getSatellites()
                            .iterator();
                    int count = 0;

                    while (iters.hasNext() && count <= maxSatellites) {
                        GpsSatellite s = iters.next();
                        //返回卫星的信噪比
                        float snr = s.getSnr();
                        if (snr > 0) {
                            count++;
                        }
                    }
                    //在gps卫星信号数量少于4个的情况下 且定位模式为设备模式的情况,切换到高精度模式
                    if (count < 4 && mLocationOption.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                        //累加无信号时间
                        noGpsTime++;
                        String logStr = "\n搜索到：" + count + "颗有效卫星,没有gps信号时间" + noGpsTime+"\n";
                        LogUtil.d(logStr);
                        //记录日志
                        LogUtil.save(MapService.this, logStr);
                        // Toast.makeText(MapService.this, "无卫星时间"+noGpsTime, Toast.LENGTH_SHORT).show();
                        ToastUtil.show(MapService.this, "无卫星时间:" + noGpsTime);
                        //持续时间10秒以上
                        if (noGpsTime >= 5) {

                            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                            mLocationOption.setInterval(intervaTime);
                            mLocationClient.setLocationOption(mLocationOption);
                            //mLocationClient.startLocation();
                            noGpsTime = 0;
                            LogUtil.save(MapService.this, "\n已经持续10秒无卫星信号，切换回高精度模式\n");
                            Toast.makeText(MapService.this, "当前无法获取gps信号，转为高精度定位模式", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        noGpsTime = 0;
                    }

                    // Toast.makeText(MapService.this, "搜索到：" + count + "颗有效卫星", Toast.LENGTH_SHORT).show();
                    break;
                // 定位启动
                case GpsStatus.GPS_EVENT_STARTED:
                    LogUtil.d("定位启动");
                    break;
                // 定位结束
                case GpsStatus.GPS_EVENT_STOPPED:
                    LogUtil.d("定位结束");
                    break;
            }
        }

        ;
    };

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
        String time=DATEFORMAT.format(new Date());

        LogUtil.save(this,"开始上传位置，上传时间："+time+"所有坐标点：共"+locationList.size()+"个\n");
        for (int i = 0; i <locationList.size() ; i++) {
            Location location =locationList.get(i);
            LogUtil.save(this,"lat："+location.lat+"   lng:"+location.lng+"    time:"+location.time+"\n");
        }
        ServiceImplNew.reportUserNewPosition(ServiceImplNew.TYPE_REPORTUSERNEWPOSITION,corpid, userid, username, userphoto, daptid, daptname, lat, lng, devicetype, devicecode, systemversion,appservion, gps_flag, acquisitiontime,locationList,callback);
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

    /**
     * 计算前n个点的平均速度
     */
    private float getSpeed(int n) {
        float speed = 0;
        float distance = 0;
        //  获得最后几个点
        List<Location> locationList = dbManager.querylastLocation(n);
        //倒数第一个点
        //Location location1=locationList.get(0);
        //倒数第二个点
        // Location location2=locationList.get(1);
        //  获取这几个点中最早的一个点


        if (locationList.size() < 2) {
            return speed;
        }


        for (int i = 0; i < locationList.size(); i++) {
            if (i + 1 == locationList.size()) {
                break;
            }
            Location locationStart = locationList.get(i + 1);
            Location locationEnd = locationList.get(i);
            DPoint startPoint = new DPoint(locationStart.lat, locationStart.lng);
            DPoint endPoint = new DPoint(locationEnd.lat, locationEnd.lng);
            distance += CoordinateConverter.calculateLineDistance(startPoint, endPoint);

        }
        try {
            Date dateStart = DATEFORMAT.parse(locationList.get(0).time);
            Date dateEnd = DATEFORMAT.parse(locationList.get(locationList.size() - 1).time);
            long time = (dateStart.getTime() - dateEnd.getTime()) / 1000;
            if (time != 0) {
                speed = distance / time;
            }
            Log.d(TAG, "getSpeed: time:" + time + "speed:" + speed);
            //避免出现负数的情况
            return Math.abs(speed);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    private OnLocationSuccessListener mSuccessListener;
    private OnLocationFailListener mFailListener;

    /**
     * 定位成功监听器
     */
    public interface OnLocationSuccessListener {
        void onSuccess(Location location);
    }

    /**
     * 定位成功监听器
     */
    public interface OnLocationFailListener {
        void onFail(int errorCode, String errorInfo);
    }

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnLocationSuccessListener(OnLocationSuccessListener listener) {
        this.mSuccessListener = listener;
    }

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnLocationFailListener(OnLocationFailListener listener) {
        this.mFailListener = listener;
    }

    @Override
    public void onDestroy() {
        LogUtil.d("");
        super.onDestroy();

        //注销广播
      //  unregisterReceiver(myBroadCastReceiver);
        //停止上传service
        stopUploadService();
        //销毁定位客户端,停止定位后，本地定位服务并不会被销毁
        mLocationClient.stopLocation();
        // 销毁定位客户端之后，若要重新开启定位请重新New一个AMapLocationClient对象。
        mLocationClient.onDestroy();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
        //Toast.makeText(this, "服务已停止", Toast.LENGTH_SHORT).show();
        ToastUtil.show(this, "服务已停止");
        //如果不是用户销毁的，则重新启动服务
        boolean stopBySever = (boolean) SharedUtil.getValue(MapService.this, SharedUtil.stopBySever, true);
        if (!stopBySever) {
            Intent intent = new Intent(this, MapService.class);
            this.startService(intent);
            Toast.makeText(this, "服务已重新开始", Toast.LENGTH_SHORT).show();
        }
        Intent intent1 = new Intent(this, MapAlarmCheckService.class);
        getApplication().stopService(intent1);

    }

    @Override
    public void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode) {


        if (error) {
            Log.d(TAG, "requestType: " + requestType);
            switch (requestType) {
                case REQUEST_UPLOAD:

                    if (objBody != null && objBody instanceof String) {
                        try {
                            Log.d("返回的数据为：", objBody.toString());
                            JSONObject jsonObj = new JSONObject((String) objBody);
                            if (jsonObj != null) {
                                String retCode = jsonObj.optString("retCode");

                                if (retCode != null && retCode.equals("0")) {

                                    //Toast.makeText(this, "上传成功！", Toast.LENGTH_LONG).show();
                                    ToastUtil.show(this, "上传成功!");
                                    return;
                                } else {
                                    ToastUtil.show(this, "上传失败!");
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
   /* //new出上边定义好的BroadcastReceiver
    MapService.MyBroadCastReceiver myBroadCastReceiver = new MapService.MyBroadCastReceiver();

    //实例化过滤器并设置要过滤的广播
    IntentFilter intentFilter = new IntentFilter("STOPMAPSERVICE");

    class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: 时间到了，接收到停止MAPSERVICE服务的广播");
            mLocationClient.stopLocation();
        }
    }*/


    private void checkService(){
        boolean isRunning=SystemUtils.isServiceRunning(this, Constant.MapService);
        isRunning=SystemUtils.isServiceRunning(this, Constant.MapAlarmCheckService);
        if (!isRunning){
            boolean stopBySever = (boolean) SharedUtil.getValue(this, SharedUtil.stopBySever, true);
            LogUtil.e("在MapService中发现后台MapAlarmCheckService服务停掉了");
            if (!stopBySever) {
                Date date=new Date();
                String time=DATEFORMAT.format(date);
                LogUtil.save(this,time+"在广播中发现后台MapAlarmCheckService服务停掉了!!!!!!!重新启动!!!\n\n\n");
                LogUtil.e("重新启动!!!");
                Intent locationIntent = new Intent(this, MapAlarmCheckService.class);
                this.startService(locationIntent);
            }
        }
        isRunning=SystemUtils.isServiceRunning(this, Constant.UpLoadPositionService);
        if (!isRunning){
            boolean stopBySever = (boolean) SharedUtil.getValue(this, SharedUtil.stopBySever, true);
            LogUtil.e("在MapService中发现后台UploadPositionService服务停掉了");
            if (!stopBySever) {
                Date date=new Date();
                String time=DATEFORMAT.format(date);
                LogUtil.save(this,time+"在广播中发现后台UpLoadPositionService服务停掉了!!!!!!!重新启动!!!\n\n\n");
                LogUtil.e("重新启动!!!");
                Intent locationIntent = new Intent(this, UpLoadPositionService.class);
                this.startService(locationIntent);
            }
        }
    }








}
