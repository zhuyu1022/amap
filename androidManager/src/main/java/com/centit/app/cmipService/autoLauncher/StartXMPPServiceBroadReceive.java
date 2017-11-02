package com.centit.app.cmipService.autoLauncher;

import java.util.List;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartXMPPServiceBroadReceive extends BroadcastReceiver
{
    @SuppressWarnings("deprecation")
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("com.hoperun.App.MipService.StartXMPPServiceBroadReceive"))
        {
            
            // String className = "com.hoperun.App.MIPTHRPART.XMPPUtils.Client.NotificationService";
            // boolean isRunning = isServiceRunning(context, className);
            //
            // boolean isConnection = false;
            // XMPPConnection connection = XmppManager.getConnection();
            // String userId = GlobalState.getInstance().getOpenId();
            //
            // if (connection != null && connection.isConnected() && connection.getUser() != null
            // && connection.getUser().contains(userId))
            // {
            // isConnection = true;
            // }
            //
            // if (!isRunning || !isConnection)
            // {
            // Resources resources = context.getResources();
            // int iconId = -1;
            // try
            // {
            // iconId =
            // resources.getIdentifier(context.getPackageName() + ":drawable/" + "notification", null, null);
            //
            // }
            // catch (Exception e)
            // {
            // // TODO: handle exception
            // }
            //
            // ServiceManager serviceManager = new ServiceManager(context);
            // try
            // {
            // if (connection != null)
            // {
            // connection.disconnect();
            // }
            // // XmppManager.removeAccount();
            // serviceManager.stopService();
            //
            // if (iconId != -1)
            // {
            // serviceManager.setNotificationIcon(iconId);
            // }
            //
            // serviceManager.startService();
            //
            // }
            // catch (Exception e)
            // {
            // serviceManager.stopService();
            // // TODO: handle exception
            // if (iconId != -1)
            // {
            // serviceManager.setNotificationIcon(iconId);
            // }
            // serviceManager.startService();
            // }
            //
            // }
            //
        }
    }
    
    /**
     * 判断service是否正在运行
     * 
     * @param mContext
     * @param className
     * @return
     */
    public static boolean isServiceRunning(Context mContext, String className)
    {
        
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(50);
        
        if (!(serviceList.size() > 0))
        {
            return false;
        }
        
        for (int i = 0; i < serviceList.size(); i++)
        {
            if (serviceList.get(i).service.getClassName().equals(className) == true)
            {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }
}
