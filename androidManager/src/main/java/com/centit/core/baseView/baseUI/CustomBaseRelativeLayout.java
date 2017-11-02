package com.centit.core.baseView.baseUI;

import android.app.Activity;
import android.widget.RelativeLayout;

import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler.CustomHanler;

abstract public class CustomBaseRelativeLayout extends RelativeLayout
{
    protected MIPBaseActivity mCustomActivity;
    
    protected CustomHanler     mCustomRLHandler = new CustomHanler()
                                                {
                                                    
                                                    @Override
                                                    public void PostHandle(int requestType, Object objHeader,
                                                        Object objBody, boolean error, int errorCode)
                                                    {
                                                        if (mCustomActivity != null
                                                            && !mCustomActivity.isActivityDestroyed())
                                                        {
                                                            onPostHandle(requestType,
                                                                objHeader,
                                                                objBody,
                                                                error,
                                                                errorCode);
                                                        }
                                                        else
                                                        {
                                                            LogUtil.i("This Activity is destroyed!");
                                                        }
                                                    }
                                                };
    
    abstract public void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode);
    
    public CustomBaseRelativeLayout(Activity activity)
    {
        super(activity);
        mCustomActivity = (MIPBaseActivity)activity;
    }
}
