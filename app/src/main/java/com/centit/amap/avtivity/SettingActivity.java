package com.centit.amap.avtivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.centit.GlobalState;
import com.centit.amap.AmapManager;
import com.centit.amap.MainActivity;
import com.centit.amap.R;
import com.centit.amap.constant.Constant;
import com.centit.amap.net.ServiceImplNew;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SimpleDialog;
import com.centit.amap.util.SystemUtils;
import com.centit.amap.view.DownloadDialog;
import com.centit.amap.view.SetWebDialog;
import com.centit.app.cmipConstant.Constant_Mgr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String DIALOG_DOWNLOAD = "DdownloadDialog";
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    Toolbar toolbar;

    TextView userNameTv;

    RelativeLayout userNameRl;
    ImageView userPhotoImg;
    RelativeLayout userPhotoRl;
    TextView webAddressTv;
    RelativeLayout webAddressRl;
    RelativeLayout testRl;
    CheckBox testCheckBox;
    RelativeLayout logRl;
    CheckBox logCheckBox;

    RelativeLayout upLoadLogRl;

    TextView versionTv;

    RelativeLayout checkNewVersionRl;

    //private Button uploadBtn;
    RelativeLayout clearRl;
    //private Button clearBtn;

    private SwipeRefreshLayout swipRefreshLayout;

    File newfile;


    private boolean isClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        initView();
        initEvent();
    }

    private void initView() {


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        userNameTv = (TextView) findViewById(R.id.userNameTv);

        userNameRl = (RelativeLayout) findViewById(R.id.userNameRl);

//         userPhotoImg= (ImageView) findViewById(R.id.userPhotoImg);
//
//         userPhotoRl= (RelativeLayout) findViewById(R.id.userPhotoRl);

        webAddressTv = (TextView) findViewById(R.id.webAddressTv);

        webAddressRl = (RelativeLayout) findViewById(R.id.webAddressRl);

        testCheckBox = (CheckBox) findViewById(R.id.testCheckBox);

        logCheckBox = (CheckBox) findViewById(R.id.logCheckBox);

        upLoadLogRl = (RelativeLayout) findViewById(R.id.upLoadLogRl);

        versionTv = (TextView) findViewById(R.id.versionTv);

        checkNewVersionRl = (RelativeLayout) findViewById(R.id.checkNewVersionRl);

        //uploadBtn= (Button) findViewById(R.id.upLoadBtn);

        testRl = (RelativeLayout) findViewById(R.id.testRl);

        logRl = (RelativeLayout) findViewById(R.id.logRl);

        clearRl = (RelativeLayout) findViewById(R.id.clearRl);

        // clearBtn= (Button) findViewById(R.id.clearBtn);
        swipRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipRefreshLayout);
        swipRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        //去掉测试按钮布局
        boolean isTestMode = GlobalState.getInstance().isTestMode();
       /* if (isTestMode) {
            testRl.setVisibility(View.VISIBLE);
        } else {
            testRl.setVisibility(View.GONE);
        }*/

        boolean isRealEnvironment = Constant_Mgr.isRealEnvironment;
        if (isRealEnvironment) {
            upLoadLogRl.setVisibility(View.GONE);
            webAddressRl.setVisibility(View.GONE);
        } else {
            upLoadLogRl.setVisibility(View.VISIBLE);
            webAddressRl.setVisibility(View.VISIBLE);
        }


        String userName = (String) SharedUtil.getValue(this, SharedUtil.username, "");
        userNameTv.setText(userName);
        String url = GlobalState.getInstance().getmIPAddr();
        String port = GlobalState.getInstance().getmPortNum();
        if (TextUtils.isEmpty(port)) {
            webAddressTv.setText(url);
        } else {
            webAddressTv.setText(url + ":" + port);
        }

        String version = SystemUtils.getVersionName(this);
        versionTv.setText(version);


        if (isTestMode) {
            testCheckBox.setChecked(true);
        } else {
            testCheckBox.setChecked(false);
        }
        boolean isRecordLog = GlobalState.getInstance().isrecordLog();
        if (isRecordLog) {
            logCheckBox.setChecked(true);
            upLoadLogRl.setVisibility(View.VISIBLE);
        } else {
            logCheckBox.setChecked(false);
            upLoadLogRl.setVisibility(View.GONE);
        }


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //设置显示返回键
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置不显示默认标题
        actionBar.setDisplayShowTitleEnabled(false);

    }


    private void initEvent() {
        userNameRl.setOnClickListener(this);
        webAddressRl.setOnClickListener(this);
        upLoadLogRl.setOnClickListener(this);
        checkNewVersionRl.setOnClickListener(this);
        //uploadBtn.setOnClickListener(this);
        // clearBtn.setOnClickListener(this);
        testRl.setOnClickListener(this);
        logRl.setOnClickListener(this);
        clearRl.setOnClickListener(this);
        logCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    GlobalState.getInstance().setRecordLog(true);
                    upLoadLogRl.setVisibility(View.VISIBLE);
                } else {
                    GlobalState.getInstance().setRecordLog(false);
                    upLoadLogRl.setVisibility(View.GONE);
                }
            }
        });

        testCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    GlobalState.getInstance().setTestMode(true);
                } else {
                    GlobalState.getInstance().setTestMode(false);
                }
            }
        });

        swipRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                SettingActivity.this.finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userNameRl:
                break;
            case R.id.webAddressRl:
                SetWebDialog dialog = SetWebDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "SetWebDialog");
                dialog.setOnOkClickListener(new SetWebDialog.onOkClickListener() {
                    @Override
                    public void onClick() {

                        String url = GlobalState.getInstance().getmIPAddr();
                        String port = GlobalState.getInstance().getmPortNum();
                        if (TextUtils.isEmpty(port)) {
                            webAddressTv.setText(url);
                        } else {
                            webAddressTv.setText(url + ":" + port);
                        }


                    }
                });
                break;
            case R.id.upLoadLogRl:
                swipRefreshLayout.setRefreshing(true);
                File oldfile = new File(getExternalCacheDir(), "LocatonLog.txt");
                if (oldfile.exists()) {
                    //日期格式

                    String date = df.format(new Date());
                    String newFileName = "Android_" + SystemUtils.getVersionName(this) + "_" + date + ".txt";
                    newfile = new File(getExternalCacheDir(), newFileName);
                    CopyFile(oldfile.getPath(), newfile.getPath());
                } else {
                    Toast.makeText(SettingActivity.this, "日志不存在！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkNewVersionRl:
                swipRefreshLayout.setRefreshing(true);
                appVersionCheck();
                break;
//            case R.id.upLoadBtn:
//
//                break;
            case R.id.clearRl:
                isClear = true;
                Intent intent = new Intent();
                intent.putExtra("isClear", isClear);
                setResult(RESULT_OK, intent);
                Toast.makeText(this, "清除成功！", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.clearBtn:
//
//                break;
            default:

        }
    }


    /**
     * 检查新版本
     */
    private void appVersionCheck() {
       /* String corpid = "ding2ace95aa3863334d35c2f4657eb6378f";
        String userid = "manager6483";*/
        String corpid = (String) SharedUtil.getValue(this, SharedUtil.corpid, "");
        String version = SystemUtils.getVersionName(this);
        ServiceImplNew.appVersionCheck(ServiceImplNew.TYPE_AppVersionCheck, corpid, Constant_Mgr.appType, version, versionCheckCallback);

    }

    /**
     * 获取app下载地址
     */
    private void getAppDownloadUrl() {

        String corpid = (String) SharedUtil.getValue(this, SharedUtil.corpid, "");
        ServiceImplNew.newVersionAppDownloadUrl(ServiceImplNew.TYPE_NewVersionAppDownloadUrl, corpid, appDownloadUrlCallback);
    }


    /**
     * 删除文件
     *
     * @param filepath
     */
    private void delete(String filepath) {
        try {
            File file = new File(filepath);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //文件拷贝
    //要复制的目录下的所有非子目录(文件夹)文件拷贝
    public int CopyFile(String fromFile, String toFile) {

        try {
            InputStream fosfrom = new FileInputStream(fromFile);
            OutputStream fosto = new FileOutputStream(toFile);
            byte bt[] = new byte[1024];
            int c;
            while ((c = fosfrom.read(bt)) > 0) {
                fosto.write(bt, 0, c);
            }
            fosfrom.close();
            fosto.close();
            //上传文件
            ServiceImplNew.uploadFile(ServiceImplNew.TYPE_UploadFile, toFile, callback);
            return 0;

        } catch (Exception ex) {
            return -1;
        }
    }


    Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    swipRefreshLayout.setRefreshing(false);
                }
            });

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

            if (response.code() != 200) {
                // Toast.makeText(SettingActivity.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
                return;
            }
            String result = response.body().string();
            Log.d("result", result);
            try {

                JSONObject jsonObj = new JSONObject(result);
                if (jsonObj != null) {
                    String retCode = jsonObj.optString("retCode");
                    if (retCode != null && retCode.equals("0")) {
//                        "assetid": "文件id"，
//                        "filename":"文件名称"
                        //清除sd卡中的日志
                        if (newfile.exists()) {

                            newfile.delete();
                        }
                        LogUtil.d("上传成功！");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipRefreshLayout.setRefreshing(false);
                                Toast.makeText(SettingActivity.this, "日志上传成功！", Toast.LENGTH_SHORT).show();
                            }
                        });


                        return;
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };

    Callback versionCheckCallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    swipRefreshLayout.setRefreshing(false);
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.code() != 200) {
                // Toast.makeText(SettingActivity.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
                return;
            }
            String result = response.body().string();
            LogUtil.d("result:" + result);
            try {
                JSONObject jsonObj = new JSONObject(result);
                if (jsonObj != null) {
                    String retCode = jsonObj.optString("retCode");
                    if (retCode != null && retCode.equals("0")) {
                        // 在此处理业务逻辑
                        JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");
                        if (bizDataJsonObj != null) {
                            final String retVersionCode = bizDataJsonObj.optString("retVersionCode");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    swipRefreshLayout.setRefreshing(false);

                                    if ("0".equals(retVersionCode)) {
                                        //不需要更新
                                        SimpleDialog.show(SettingActivity.this, "已是最新版本，无需更新！");
                                    } else if ("1".equals(retVersionCode)) {

                                        SimpleDialog.forceShow(SettingActivity.this, "检查到新版本，是否立刻升级？", null, new SimpleDialog.OnPositiveClickListener() {
                                            @Override
                                            public void onPositiveClick() {
                                                getAppDownloadUrl();
                                            }
                                        });

                                    }
                                }
                            });
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

            //Toast.makeText(SettingActivity.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();


            String result = response.body().string();
            LogUtil.d("result:" + result);
            try {
                JSONObject jsonObj = new JSONObject(result);
                if (jsonObj != null) {
                    String retCode = jsonObj.optString("retCode");
                    if (retCode != null && retCode.equals("0")) {
                        // 在此处理业务逻辑
                        JSONObject bizDataJsonObj = jsonObj.optJSONObject("bizData");
                        if (bizDataJsonObj != null) {

                            JSONArray jsonArray = bizDataJsonObj.optJSONArray("appVersionList");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if ("0".equals(jsonObject.optString("apptype"))) {
                                    String fileUrl = jsonObject.optString("fileurl");
                                    if (!TextUtils.isEmpty(fileUrl)) {
                                        DownloadDialog dialog = DownloadDialog.newInstance(fileUrl);
                                        dialog.show(getSupportFragmentManager(), DIALOG_DOWNLOAD);
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
    protected void onResume() {
        LogUtil.d("");
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("");
    }

    public void setClearMapListener() {

    }

    interface clearMapListener {
        public void clear();
    }


}
