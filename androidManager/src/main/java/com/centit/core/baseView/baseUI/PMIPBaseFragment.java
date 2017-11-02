/*
 * File name:  PMIPBaseFragment.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2014-5-5
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.baseView.baseUI;

import android.support.v4.app.FragmentActivity;

import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler.CustomHanler;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-5-5]
 */
public abstract class PMIPBaseFragment extends MIPBaseFragment
{
    protected FragmentActivity mActivity;
    
    protected CustomHanler     mMainViewHandler = new CustomHanler()
                                                {
                                                    
                                                    @Override
                                                    public void PostHandle(int requestType, Object objHeader,
                                                        Object objBody, boolean error, int errorCode)
                                                    {
                                                        if (mActivity != null)
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
    
    abstract public boolean onKeyDown(int keyId);
    
    // abstract public boolean onCleanView();
    
    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.Fragment#onDestroy()
     */
    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        mMainViewHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
    
    /**
     * 重载方法
     * 
     * @author rqj
     */
    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
}
