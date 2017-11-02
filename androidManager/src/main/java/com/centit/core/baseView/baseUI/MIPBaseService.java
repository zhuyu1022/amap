package com.centit.core.baseView.baseUI;

import android.app.Service;

import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler.CustomHanler;

/**
 * Created by zhu_yu on 2017/10/16.
 */

public abstract class MIPBaseService extends Service {

    protected boolean isActivityDestroyed = false;




    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        // ((GlobalState)this.getApplication()).removeActivity(this);
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
