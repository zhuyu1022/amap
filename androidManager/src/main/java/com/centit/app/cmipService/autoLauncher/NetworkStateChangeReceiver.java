/*
 * File name:  NetStateChangeListen.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2014-10-27
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipService.autoLauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.centit.core.tools.utils.MIP_NetworkUtils;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-10-27]
 */
public class NetworkStateChangeReceiver extends BroadcastReceiver
{
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO Auto-generated method stub
        boolean success = MIP_NetworkUtils.isNetworkAvailable(context);
        
        // if (success)
        // {
        //
        // PollingUtils.stopPollingBroadCast(context,
        // StartXMPPServiceBroadReceive.class,
        // "com.hoperun.App.MipService.StartXMPPServiceBroadReceive");
        // Intent iXmppHeart = new Intent(context, NotificationReceiver.class);
        // context.stopService(iXmppHeart);
        //
        // PollingUtils.startPollingBroadcast(context,
        // Constant_Mgr.startPollingTime,
        // StartXMPPServiceBroadReceive.class,
        // "com.hoperun.App.MipService.StartXMPPServiceBroadReceive");
        //
        // }
        // else
        // {
        //
        // PollingUtils.stopPollingBroadCast(context,
        // StartXMPPServiceBroadReceive.class,
        // "com.hoperun.App.MipService.StartXMPPServiceBroadReceive");
        // Intent iXmppHeart = new Intent(context, NotificationReceiver.class);
        // context.stopService(iXmppHeart);
        // disConnectionXMPP();
        // }
    } // 如果无网络连接activeInfo为null
    
    // public void disConnectionXMPP()
    // {
    // XMPPConnection connection = XmppManager.getConnection();
    // if (connection != null)
    // {
    // connection.disconnect();
    // }
    // }
}
