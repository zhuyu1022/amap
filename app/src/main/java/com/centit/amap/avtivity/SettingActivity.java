package com.centit.amap.avtivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.centit.GlobalState;
import com.centit.amap.R;
import com.centit.amap.constant.Constant;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SystemUtils;
import com.centit.amap.view.SetWebDialog;



public class SettingActivity extends AppCompatActivity implements View.OnClickListener{


    Toolbar toolbar;

    TextView userNameTv;

    RelativeLayout userNameRl;

    ImageView userPhotoImg;

    RelativeLayout userPhotoRl;

    TextView webAddressTv;

    RelativeLayout webAddressRl;

    CheckBox testCheckBox;

    CheckBox logCheckBox;

    RelativeLayout upLoadLogRl;

    TextView versionTv;

    RelativeLayout checkNewVersionRl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initEvent();
    }

    private void initView() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);

        userNameTv= (TextView) findViewById(R.id.userNameTv);

         userNameRl= (RelativeLayout) findViewById(R.id.userNameRl);

         userPhotoImg= (ImageView) findViewById(R.id.userPhotoImg);

         userPhotoRl= (RelativeLayout) findViewById(R.id.userPhotoRl);

         webAddressTv= (TextView) findViewById(R.id.webAddressTv);

         webAddressRl= (RelativeLayout) findViewById(R.id.webAddressRl);

         testCheckBox= (CheckBox) findViewById(R.id.testCheckBox);

         logCheckBox= (CheckBox) findViewById(R.id.logCheckBox);

         upLoadLogRl= (RelativeLayout) findViewById(R.id.upLoadLogRl);

         versionTv= (TextView) findViewById(R.id.versionTv);

         checkNewVersionRl= (RelativeLayout) findViewById(R.id.checkNewVersionRl);

        String url= GlobalState.getInstance().getmIPAddr();
        webAddressTv.setText(url);
        String version=SystemUtils.getVersionName(this);
        versionTv.setText(version);


        boolean isTestMode= GlobalState.getInstance().isTestMode();
        if (isTestMode){
            testCheckBox.setChecked(true);
        }else{
            testCheckBox.setChecked(false);
        }
        boolean isRecordLog= GlobalState.getInstance().isrecordLog();
        if (isRecordLog){
            logCheckBox.setChecked(true);
        }else {
            logCheckBox.setChecked(false);
        }


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //设置显示返回键
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置不显示默认标题
        actionBar.setDisplayShowTitleEnabled(false);

    }


    private  void initEvent(){
        userNameRl.setOnClickListener(this);
        webAddressRl.setOnClickListener(this);
        upLoadLogRl.setOnClickListener(this);
        checkNewVersionRl.setOnClickListener(this);
        logCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    GlobalState.getInstance().setRecordLog(true);
                } else {
                    GlobalState.getInstance().setRecordLog(false);
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
        switch (v.getId()){
            case R.id.userNameRl:
                break;
            case R.id.webAddressRl:
                SetWebDialog dialog=SetWebDialog.newInstance();
                dialog.show(getSupportFragmentManager(),"SetWebDialog");
                dialog.setOnOkClickListener(new SetWebDialog.onOkClickListener() {
                    @Override
                    public void onClick() {
                        String url= GlobalState.getInstance().getmIPAddr();
                        webAddressTv.setText(url);
                    }
                });
                break;
            case R.id.upLoadLogRl:
                break;
            case R.id.checkNewVersionRl:
                break;

            default:

        }
    }

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
}
