package com.centit.app.cmipService.autoLauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedReceiver extends BroadcastReceiver
{
    public void onReceive(Context context, Intent intent)
    {
        // if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        // {
        // PollingUtils.startPollingBroadcast(context,
        // Constant_Mgr.startPollingTime,
        // StartXMPPServiceBroadReceive.class,
        // "com.hoperun.App.MipService.StartXMPPServiceBroadReceive");
        // }
    }
}
