/*
 * File name:  PMIPActivit.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-9-12
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.baseView.baseUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.centit.GlobalState;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler.CustomHanler;

/**
 * <一句话功能简述>
 *
 * @Description<功能详细描述>
 *
 * @author ren_qiujing
 * @Version [版本号, 2013-9-12]
 */
public abstract class MIPBaseActivity extends AppCompatActivity
{
    protected String subClassName = "";

    public boolean isActivityDestroyed()
    {
        return isActivityDestroyed;
    }

    public void setActivityDestroyed(boolean isActivityDestroyed)
    {
        this.isActivityDestroyed = isActivityDestroyed;
    }

    protected boolean isActivityDestroyed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        subClassName = this.getClass().getName();
        ((GlobalState)this.getApplication()).addActivity(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        ((GlobalState)this.getApplication()).removeActivity(this);
        isActivityDestroyed = true;
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    protected CustomHanler mHandler = new CustomHanler()
    {

        @Override
        public void PostHandle(int requestType, Object objHeader, Object objBody,
                               boolean error, int errorCode)
        {
            if (!isActivityDestroyed)
            {
                onPostHandle(requestType, objHeader, objBody, error, errorCode);
            }
            else
            {
                LogUtil.i("This Activity is destroyed!");
            }
        }
    };

    abstract public void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode);

}
