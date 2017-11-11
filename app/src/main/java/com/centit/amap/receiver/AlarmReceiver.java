package com.centit.amap.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.centit.amap.constant.Constant;
import com.centit.amap.service.MapAlarmCheckService;
import com.centit.amap.service.MapService;
import com.centit.amap.service.UpLoadPositionService;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SystemUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmReceiver extends BroadcastReceiver {
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("LOCATION_CLOCK")) {
            LogUtil.e("接收到定时定位广播请求");
            boolean isRunning=SystemUtils.isServiceRunning(context, Constant.MapService);
            if (!isRunning){
                boolean isRestartService = (boolean) SharedUtil.getValue(context, SharedUtil.isRestartService, false);
                LogUtil.e("在广播中发现后台MapService服务停掉了");
                if (isRestartService) {
                    Date date=new Date();
                    String time=df.format(date);
                    LogUtil.save(context,time+"在广播中发现后台MapService服务停掉了!!!!!!!重新启动!!!\n\n\n");
                    LogUtil.e("重新启动!!!");
                    Intent locationIntent = new Intent(context, MapService.class);
                    context.startService(locationIntent);
                }
            }
            isRunning=SystemUtils.isServiceRunning(context, Constant.MapAlarmCheckService);
            if (!isRunning){
                boolean isRestartService = (boolean) SharedUtil.getValue(context, SharedUtil.isRestartService, false);
                LogUtil.e("在广播中发现后台MapAlarmCheckService服务停掉了");
                if (isRestartService) {
                    Date date=new Date();
                    String time=df.format(date);
                    LogUtil.save(context,time+"在广播中发现后台MapAlarmCheckService服务停掉了!!!!!!!重新启动!!!\n\n\n");
                    LogUtil.e("重新启动!!!");
                    Intent locationIntent = new Intent(context, MapAlarmCheckService.class);
                    context.startService(locationIntent);
                }

            }
            isRunning=SystemUtils.isServiceRunning(context, Constant.UpLoadPositionService);
            if (!isRunning){
                boolean isRestartService = (boolean) SharedUtil.getValue(context, SharedUtil.isRestartService, false);
                LogUtil.e("在广播中发现后台UploadPositionService服务停掉了");
                if (isRestartService) {
                    Date date=new Date();
                    String time=df.format(date);
                    LogUtil.save(context,time+"在广播中发现后台UpLoadPositionService服务停掉了!!!!!!!重新启动!!!\n\n\n");
                    LogUtil.e("重新启动!!!");
                    Intent locationIntent = new Intent(context, UpLoadPositionService.class);
                    context.startService(locationIntent);
                }
            }

        }
    }
}
