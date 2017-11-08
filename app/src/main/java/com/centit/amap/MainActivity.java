package com.centit.amap;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.centit.GlobalState;
import com.centit.amap.avtivity.SettingActivity;
import com.centit.amap.constant.Constant;
import com.centit.amap.database.Location;
import com.centit.amap.net.ServiceImpl;
import com.centit.amap.net.ServiceImplNew;
import com.centit.amap.service.MapService;
import com.centit.amap.util.BatteryUtils;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SimpleDialog;
import com.centit.amap.util.SystemUtils;
import com.centit.amap.util.ToastUtil;
import com.centit.amap.view.DownloadDialog;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.core.baseView.baseUI.MIPBaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainActivity extends MIPBaseActivity {
    private static final String TAG = "MainActivity";
    public  static final int REQUEST_SettingActivity = 1;
    public  static final int REQUEST_GPS = 2;
    private static final String DIALOG_DOWNLOAD="DdownloadDialog";

    private Button startBtn;
    private Button stopBtn;
   // private Button downloadBtn;
    private Button testBtn;

    private Button clearLogBtn;

    private ImageView settingImg;
    private MapView mMapView = null;

    //是否绑定服务，用于避免解绑后再次解绑报异常
    private boolean isBind = false;
    //自定义的地图管理器
    private AmapManager amapManager;
    //钉钉参数
private String dingdingStr;
    //初始化地图控制器对象
    AMap aMap;
    //声明AMapLocationClientOption对象
    private AMapLocationClientOption mLocationOption = null;
    //声明AMapLocationClient类对象
    private AMapLocationClient mLocationClient = null;
    //地图摄像机
    private CameraUpdate mUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initDingdingDate();
        initAmap(savedInstanceState);
        initView();
        initGPS();
        bindMapService();
        //下发配置参数
        downloadConfParams();
        //更新新版本
       appVersionCheck();
        //getAppDownloadUrl();
    }

    /**
     *
     */
    private void initDate() {
        //初始化APP配置
        String url=Constant_Mgr.getMIP_BASEURL();
        GlobalState.getInstance().setmRequestURL(url);

        //获取唯一标识IMEI
        TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);

        String devicecode=TelephonyMgr.getDeviceId();
        //  获取手机型号：
        String devicetype= android.os.Build.MODEL;
        //获取手机厂商：
        String carrier= android.os.Build.MANUFACTURER;

       SharedUtil.putValue(this, SharedUtil.devicecode, devicecode);
        SharedUtil.putValue(this, SharedUtil.devicetype, devicetype);
      //Toast.makeText(this, "devicecode:"+devicecode+"devicetype:"+devicetype+"carrier:"+carrier, Toast.LENGTH_LONG).show();
    }


    /**
     * 初始化数据 接受隐式intent参数
     * 用来对接钉钉
     */
    private void initDingdingDate() {
        String corpid =null;
        String userid = null;
        String username =  null;
        String userphoto =  null;
        String departmentid =  null;
        String  departmentname =null;
//临时添加
//         corpid = "ding2ace95aa3863334d35c2f4657eb6378f";
//        userid = "manager6483";
//        username="zhuyu";
//        SharedUtil.putValue(this, SharedUtil.corpid, corpid);
//        SharedUtil.putValue(this, SharedUtil.userid, userid);
//        SharedUtil.putValue(this, SharedUtil.username, username);


        Uri uri = getIntent().getData();
        if (uri != null) {
           String uriStr=uri.toString();
            String host = uri.getHost();
            String scheme = uri.getScheme();

            corpid = uri.getQueryParameter("corpid");
             userid = uri.getQueryParameter("userid");
             username = uri.getQueryParameter("username");
            departmentid = uri.getQueryParameter("departmentid");
            departmentname= uri.getQueryParameter("departmentname");
            dingdingStr="uri全部内容:  "+uriStr+"\nhost:  "+host+"\nscheme:  "+scheme+"\ncorpid:  "+corpid+"\nuserid:  "+userid+"\nusername:  "+username+"\nuserphoto:  "+userphoto;
//
//           // Toast.makeText(this, "funcode:" + funcode + "lname:" + lname, Toast.LENGTH_SHORT).show();
//            //保存参数
            SharedUtil.putValue(this, SharedUtil.corpid, corpid);
            SharedUtil.putValue(this, SharedUtil.userid, userid);
            SharedUtil.putValue(this, SharedUtil.username, username);
            SharedUtil.putValue(this, SharedUtil.departmentid, departmentid);
            SharedUtil.putValue(this, SharedUtil.departmentname, departmentname);

            LogUtil.d( "uri:" + uri.toString());
        }else if (uri==null){
          ;
            if (TextUtils.isEmpty((String) SharedUtil.getValue(this,SharedUtil.corpid,""))){
                dingdingStr="uri为空！";
                SimpleDialog.show(this, "首次打开，请从钉钉打开本应用!", null,new SimpleDialog.OnPositiveClickListener() {
                    @Override
                    public void onPositiveClick() {
                        MainActivity.this.finish();
                    }
                });
            }



        }
    }



    private void initView() {

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        //downloadBtn = (Button) findViewById(R.id.drawBtn);
        testBtn = (Button) findViewById(R.id.testBtn);


        clearLogBtn = (Button) findViewById(R.id.clearLogBtn);
        settingImg= (ImageView) findViewById(R.id.settingImg);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在每次开始定位前，都要先初始化一下
                amapManager.initAmapBeforeStart();
                //开始定位
                startAmapSercvice();



            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMapService();
                //停止服务后，画终点
                amapManager.drawLastPositionFromDB();
            }
        });

    /*    downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Intent intent=new Intent(MainActivity.this, GetConfParamsService.class);
                //startService(intent);
               // startDownload();
                //下载测试
                String url="http://www.centit.com/download/WX/WXGIPEreb_V1.0.0.apk";
                DownloadDialog dialog=DownloadDialog.newInstance(url);
                dialog.show(getSupportFragmentManager(),DIALOG_DOWNLOAD);
            }
        });*/

        clearLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.clearLog(MainActivity.this);
            }
        });


        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test1: 钉钉跳转参数测试
               SimpleDialog.show(MainActivity.this,dingdingStr);
                //test2： 下发配置参数接口
               //downloadConfParams();
                //ServiceImpl.acceptMessage(null,mHandler,ServiceImpl.TYPE_DOWNLOADCONFPARAMS);
            }
        });
        settingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SettingActivity.class);

                MainActivity.this.startActivityForResult(intent,REQUEST_SettingActivity);
            }
        });
    }


    /**
     * 下发配置参数
     */
    private  void downloadConfParams(){
        String corpid = (String) SharedUtil.getValue(this,SharedUtil.corpid,"");
        String userid = (String) SharedUtil.getValue(this,SharedUtil.userid,"");
        ServiceImpl.downloadConfParams(null,mHandler,ServiceImpl.TYPE_DOWNLOADCONFPARAMS,corpid,userid);
    }

    /**
     * 检查新版本
     */
    private void appVersionCheck(){
       /* String corpid = "ding2ace95aa3863334d35c2f4657eb6378f";
        String userid = "manager6483";*/
        String corpid = (String) SharedUtil.getValue(this,SharedUtil.corpid,"");
        String userid = (String) SharedUtil.getValue(this,SharedUtil.userid,"");
      String version=SystemUtils.getVersionName(this);
        ServiceImplNew.appVersionCheck(ServiceImplNew.TYPE_AppVersionCheck,corpid,Constant_Mgr.appType,version,versionCheckCallback);
        //ServiceImpl.appVersionCheck(null,mHandler,ServiceImplNew.TYPE_AppVersionCheck,corpid,Constant_Mgr.appType,version);
    }

    /**
     * 获取app下载地址
     */
    private void getAppDownloadUrl(){
      
        String corpid = (String) SharedUtil.getValue(this,SharedUtil.corpid,"");
        ServiceImplNew.newVersionAppDownloadUrl(ServiceImplNew.TYPE_NewVersionAppDownloadUrl,corpid,appDownloadUrlCallback);
    }




    /**
     * 检查gps
     */
    private void initGPS() {
        // 判断GPS模块是否开启，如果没有则跳转至设置开启界面，设置完毕后返回到首页
        if (!SystemUtils.getGpsStatus(this)) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("提醒：");
            dialog.setMessage("为了更好的为您服务，请您打开您的GPS!");
            dialog.setCancelable(false);
            dialog.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                            // 转到手机设置界面，用户设置GPS
                            Intent intent = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivityForResult(intent, REQUEST_GPS); // 设置完成后返回到原来的界面

                        }
                    });
            dialog.show();
        } else {
        }
    }

    /**
     * 初始化地图参数
     *
     * @param savedInstanceState
     */
    private void initAmap(Bundle savedInstanceState) {
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        amapManager = new AmapManager(this, mMapView);
//        if (aMap == null) {
//            aMap = mMapView.getMap();
//        }
//        //初始化定位
//        mLocationClient = new AMapLocationClient(this);
//        //初始化AMapLocationClientOption对象
//        mLocationOption = new AMapLocationClientOption();
//        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。高精度定位模式：会同时使用网络定位和GPS定位，优先返回最高精度的定位结果，以及对应的地址描述信息。
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        //获取一次定位结果：
//        //该方法默认为false。
//        mLocationOption.setOnceLocation(true);
//        //获取最近3s内精度最高的一次定位结果：
//        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
//        //mLocationOption.setOnceLocationLatest(true);
//        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
//        mLocationOption.setHttpTimeOut(10000);
//        //给定位客户端对象设置定位参数
//        mLocationClient.setLocationOption(mLocationOption);
//        //设置定位回调监听
//        mLocationClient.setLocationListener(mLocationListener);
//        mLocationClient.startLocation();
        //在每次开始定位前，都要先初始化一下
        amapManager.initAmapBeforeStart();
        //开始定位
        startAmapSercvice();

    }


    private void startAmapSercvice() {
        Intent startIntent = new Intent(MainActivity.this, MapService.class);
        isBind = bindService(startIntent, connection, Context.BIND_AUTO_CREATE);
        //开始服务
        startService(startIntent);

    }



    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                    int type = aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    //float speed = aMapLocation.getSpeed();
                    double lat = aMapLocation.getLatitude();//获取纬度
                    double lng = aMapLocation.getLongitude();//获取经度

                    //真实路径点
                    LatLng mTemplatLng = new LatLng(lat, lng);
                    //画完第一个起始点后，将marker点改为小圆点
                    //设置锚点属性锚点
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromResource(R.drawable.point_32));
                    //添加锚点
                    markerOptions.position(mTemplatLng);
                    //画锚点
                    aMap.addMarker(markerOptions);
                    //第一个参数是缩放比例，0是倾斜度，30显示比例
                    mUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(mTemplatLng, 17, 0, 0));
                    aMap.moveCamera(mUpdate);//移动摄像头
                } else {
                    String logStr = "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo();
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    LogUtil.e(logStr);

                }
            }


        }
    };




    MapService.MapBinder stepBinder = null;
    private ServiceConnection connection = new ServiceConnection() {
        /**
         * 在建立起于Service的连接时会调用该方法，目前Android是通过IBind机制实现与服务的连接。
         */
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            LogUtil.d("");
            amapManager.drawLineFromDB();
            //  获得binder实例
            stepBinder = (MapService.MapBinder) iBinder;
            //调用getservice方法获取service实例
            MapService mapService = stepBinder.getService();
            //计步回调定位成功
            mapService.setOnLocationSuccessListener(new MapService.OnLocationSuccessListener() {
                @Override
                public void onSuccess(Location location) {
                    amapManager.onAmapLocationSucces(location);
                    if (!SystemUtils.getGpsStatus(MainActivity.this)){
                        Toast.makeText(MainActivity.this, "Gps已被关闭，请打开！", Toast.LENGTH_SHORT).show();
                    }
                    
                    
                }
            });
            //定位失败
            mapService.setOnLocationFailListener(new MapService.OnLocationFailListener() {
                @Override
                public void onFail(int errorCode, String errorInfo) {

                }
            });
        }

        /**
         * 当与Service之间的连接丢失的时候会调用该方法，。
         * @param componentName 丢失连接的组件名称
         */
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.d("");
        }
    };

    /**
     * 开始服务
     */
    private void bindMapService() {
        Intent startIntent = new Intent(MainActivity.this, MapService.class);
        isBind = bindService(startIntent, connection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 绑定并开始服务
     */
    private void bindAndStartMapService() {
        Intent startIntent = new Intent(MainActivity.this, MapService.class);
        //绑定服务
        isBind = bindService(startIntent, connection, Context.BIND_AUTO_CREATE);
        //开始服务
        startService(startIntent);
        //绑定服务
        isBind = bindService(startIntent, connection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 停止服务
     */
    private void    stopMapService() {

        //由系统或用户停止服务后，不需要重启
        SharedUtil.putValue(MainActivity.this, SharedUtil.isRestartService, false);
        Intent stopIntent = new Intent(MainActivity.this, MapService.class);
        stopService(stopIntent);
        //解绑前判断一下
        if (isBind) {
            unbindService(connection);
            isBind = false;
        }
    }



    Callback versionCheckCallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.code()!=200){
               // Toast.makeText(MainActivity.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
                return;
            }

           String result = response.body().string();
            LogUtil.d("result:"+ result);
            try {
                JSONObject jsonObj = new JSONObject(result);
                if (jsonObj != null) {
                    String retCode = jsonObj.optString("retCode");
                    if (retCode != null && retCode.equals("0")) {
                        // 在此处理业务逻辑
                        JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");
                            if (bizDataJsonObj!=null){
                                String retVersionCode=bizDataJsonObj.optString("retVersionCode");
                                if ("0".equals(retVersionCode)){
                                    //不需要更新
                                }else if("1".equals(retVersionCode)){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            SimpleDialog.forceShow(MainActivity.this, "检查到新版本，是否立刻升级？", null, new SimpleDialog.OnPositiveClickListener() {
                                                @Override
                                                public void onPositiveClick() {
                                                    getAppDownloadUrl();
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                        return;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };



    Callback appDownloadUrlCallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
        }
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String result = response.body().string();
            LogUtil.d("result:"+ result);
            try {
                JSONObject jsonObj = new JSONObject(result);
                if (jsonObj != null) {
                    String retCode = jsonObj.optString("retCode");
                    if (retCode != null && retCode.equals("0")) {
                        // 在此处理业务逻辑
                        JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");
                        if (bizDataJsonObj!=null){

                            JSONArray jsonArray=bizDataJsonObj.optJSONArray("appVersionList");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                if ("0".equals(jsonObject.optString("apptype"))){
                                    String fileUrl=jsonObject.optString("fileurl");
                                    if (!TextUtils.isEmpty(fileUrl)){
                                        DownloadDialog dialog=DownloadDialog.newInstance(fileUrl);
                                        dialog.show(getSupportFragmentManager(),DIALOG_DOWNLOAD);
                                    }
                                    break;
                                }
                            }

                        }
                        return;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_SettingActivity:

                if (resultCode==RESULT_OK&& requestCode == REQUEST_SettingActivity){
                    boolean isClear=data.getExtras().getBoolean("isClear");
                    if (isClear){
                        amapManager.initAmapBeforeStart();
                        LogUtil.clearLog(MainActivity.this);
                    }
              }
                break;
            default:
                break;
        }
    }








    @Override
    protected void onDestroy() {
        LogUtil.d("");
        super.onDestroy();
        //解绑服务，必须要写，不然会报异常
        if (isBind) {
            unbindService(connection);
            isBind = false;
        }
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();

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
                                    String date=bizDataJsonObj.optString("date");;
                                   // GlobalState.getInstance().setDistance(distance);
                                   // GlobalState.getInstance().setTiming(timing);
                                    SharedUtil.putValue(this,SharedUtil.distance,distance);
                                    SharedUtil.putValue(this,SharedUtil.timing,timing);
                                    SharedUtil.putValue(this,SharedUtil.switch_flag,switch_flag);
                                    SharedUtil.putValue(this,SharedUtil.endTime,date);
                                    //如果是0 说明要关闭服务
                                    if ("0".equals(switch_flag)){
                                        stopMapService();
                                        //停止服务后，画终点
                                        amapManager.drawLastPositionFromDB();
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
                    Toast.makeText(this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    protected void onRestart() {
        LogUtil.d("");
        super.onRestart();

    }

    @Override
    protected void onResume() {
        LogUtil.d("");
        super.onResume();
        boolean isTestMode=GlobalState.getInstance().isTestMode();
        if (isTestMode){
           startBtn.setVisibility(View.VISIBLE);
           stopBtn.setVisibility(View.VISIBLE);
            //downloadBtn.setVisibility(View.VISIBLE);
            testBtn.setVisibility(View.VISIBLE);
            clearLogBtn.setVisibility(View.VISIBLE);
        }else{
            startBtn.setVisibility(View.GONE);
            stopBtn.setVisibility(View.GONE);
            //downloadBtn.setVisibility(View.GONE);
            testBtn.setVisibility(View.GONE);
            clearLogBtn.setVisibility(View.GONE);
        }


        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();

       // amapManager.drawLineFromDB();

    }

    @Override
    protected void onPause() {
        LogUtil.d("");
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
          mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }




}
