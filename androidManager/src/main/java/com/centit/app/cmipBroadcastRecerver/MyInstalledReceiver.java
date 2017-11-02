/*
 * File name:  Mybroadcast.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2014-5-30
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipBroadcastRecerver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.centit.core.baseView.baseinterface.IInstallToActivity;
import com.centit.core.tools.logManger.LogUtil;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-5-30]
 */
public class MyInstalledReceiver extends BroadcastReceiver
{
    private IInstallToActivity listen;
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
        {
            String packageName = intent.getDataString();
            
            if (listen != null)
            {
                LogUtil.i("安装了 :" + packageName);
                listen.onInstallListen(packageName);
            }
            
        }
        
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
        {
            String packageName = intent.getDataString();
            
            if (listen != null)
            {
                LogUtil.i("卸载了 :" + packageName);
                listen.onUnInstallListen(packageName);
            }
            
        }
    }
    
    public IInstallToActivity getListen()
    {
        return listen;
    }
    
    public void setListen(IInstallToActivity listen)
    {
        this.listen = listen;
    }
}
