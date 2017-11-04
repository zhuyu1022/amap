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

import com.amap.api.maps.MapView;
import com.centit.GlobalState;
import com.centit.amap.avtivity.SettingActivity;
import com.centit.amap.constant.Constant;
import com.centit.amap.database.Location;
import com.centit.amap.net.ServiceImpl;
import com.centit.amap.service.MapService;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SimpleDialog;
import com.centit.amap.util.SystemUtils;
import com.centit.amap.view.DownloadDialog;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.core.baseView.baseUI.MIPBaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;


public class MainActivity extends MIPBaseActivity {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_GPS = 1;

    private static final String DIALOG_DOWNLOAD="DdownloadDialog";

    private Button startBtn;
    private Button stopBtn;
    private Button downloadBtn;
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
        getNewVerision();

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
        String deptname =  null;
        Uri uri = getIntent().getData();
        if (uri != null) {
           String uriStr=uri.toString();
            String host = uri.getHost();
            String scheme = uri.getScheme();

            corpid = uri.getQueryParameter("corpid");
             userid = uri.getQueryParameter("userid");
             username = uri.getQueryParameter("username");
             userphoto = uri.getQueryParameter("userphoto");
             deptname = uri.getQueryParameter("deptname");

            dingdingStr="uri全部内容:  "+uriStr+"\nhost:  "+host+"\nscheme:  "+scheme+"\ncorpid:  "+corpid+"\nuserid:  "+userid+"\nusername:  "+username+"\nuserphoto:  "+userphoto;
//
//           // Toast.makeText(this, "funcode:" + funcode + "lname:" + lname, Toast.LENGTH_SHORT).show();
//            //保存参数
            SharedUtil.putValue(this, SharedUtil.corpid, corpid);
            SharedUtil.putValue(this, SharedUtil.userid, userid);
            //SharedUtil.putValue(this, SharedUtil.username, username);
            SharedUtil.putValue(this, SharedUtil.userid, userid);
            //SharedUtil.putValue(this, SharedUtil.deptname, deptname);

            LogUtil.d( "uri:" + uri.toString());
        }else if (uri==null&& TextUtils.isEmpty(corpid)){
            dingdingStr="uri为空！";
            SimpleDialog.show(this, "请从钉钉打开本应用!", null,new SimpleDialog.OnPositiveClickListener() {
                @Override
                public void onPositiveClick() {
                    MainActivity.this.finish();
                }
            });

        }
    }



    private void initView() {

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        downloadBtn = (Button) findViewById(R.id.drawBtn);
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
                //测试
//new Thread(new Runnable() {
//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            Location location=new Location("",32+((double)i)/1000,128+((double)i)/1000,"","",0);
//            amapManager.onAmapLocationSucces(location);
//        }
//    }
//}).start();


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

        downloadBtn.setOnClickListener(new View.OnClickListener() {
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
        });

        clearLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearLog();
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
                MainActivity.this.startActivity(intent);
            }
        });
    }


    /**
     * 下发配置参数
     */
    private  void downloadConfParams(){
        String corpid = "ding2ace95aa3863334d35c2f4657eb6378f";
        String userid = "manager6483";
        ServiceImpl.downloadConfParams(null,mHandler,ServiceImpl.TYPE_DOWNLOADCONFPARAMS,corpid,userid);
    }

    /**
     * 获取新版本
     */
    private void getNewVerision(){
        String corpid = "ding2ace95aa3863334d35c2f4657eb6378f";
        String userid = "manager6483";
        String devicetype ="" ;      ///设备类型
        ServiceImpl.getNewVersion(null,mHandler,ServiceImpl.TYPE_GETNEWVERISION,corpid,userid,devicetype);
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

    }


    private void startAmapSercvice() {


        Intent startIntent = new Intent(MainActivity.this, MapService.class);
        isBind = bindService(startIntent, connection, Context.BIND_AUTO_CREATE);
        //开始服务
        startService(startIntent);
    }


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
                    //speedTv.setText("速度：" + location.speed + "m/s");
                    amapManager.onAmapLocationSucces(location);
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
    private void stopMapService() {

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




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_GPS:
                initGPS();
//                if (resultCode==RESULT_OK){
//
//                }else{
//
//                }
                break;
            default:
                break;
        }
    }






    public void clearLog() {
        try {
            File file = new File(getExternalCacheDir(), "LocatonLog.txt");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

                                   // GlobalState.getInstance().setDistance(distance);
                                   // GlobalState.getInstance().setTiming(timing);
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
                case ServiceImpl.TYPE_GETNEWVERISION:

                    if (objBody != null && objBody instanceof String) {
                        try {
                            LogUtil.d("返回的数据为："+ objBody.toString());
                            JSONObject jsonObj = new JSONObject((String) objBody);
                            if (jsonObj != null) {
                                String retCode = jsonObj.optString("retCode");

                                if (retCode != null && retCode.equals("0")) {
                                    // 在此处理业务逻辑
                                    JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");

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
            downloadBtn.setVisibility(View.VISIBLE);
            testBtn.setVisibility(View.VISIBLE);
            clearLogBtn.setVisibility(View.VISIBLE);
        }else{
            startBtn.setVisibility(View.GONE);
            stopBtn.setVisibility(View.GONE);
            downloadBtn.setVisibility(View.GONE);
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
