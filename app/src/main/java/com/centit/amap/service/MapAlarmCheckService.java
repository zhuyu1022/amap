package com.centit.amap.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;

import com.centit.amap.constant.Constant;
import com.centit.amap.util.LogUtil;
import com.centit.amap.util.SharedUtil;
import com.centit.amap.util.SystemUtils;

public class MapAlarmCheckService extends Service {
    private static final String TAG = "MapAlarmCheckService";
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    public MapAlarmCheckService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d("");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.e( "onStartCommand: alarm服务启动了");
        boolean isRunning=SystemUtils.isServiceRunning(this, Constant.MapService);
        if (!isRunning){
            boolean isRestartService = (boolean) SharedUtil.getValue(this, SharedUtil.isRestartService, false);
            if (isRestartService) {
                LogUtil.e("在alarm服务中发现mapservice已经停止！！！！重新启动！！！");
                LogUtil.save(this, "在alarm服务中发现mapservice已经停止！！！！重新启动！！！\n\n\n");
                Intent i = new Intent(MapAlarmCheckService.this, MapService.class);
                startService(i);
            }
        }

        startAlarmService();
        return super.onStartCommand(intent, flags, startId);
    }


    /**
     * 通过Alarm的方式启动服务
//     */
    private void startAlarmService() {

        long second = 5 * 1000;
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long traggerAtTime = SystemClock.elapsedRealtime() + second;
        Intent i = new Intent(MapAlarmCheckService.this, MapAlarmCheckService.class);
        pendingIntent = PendingIntent.getService(MapAlarmCheckService.this, 0, i, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
        }else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, traggerAtTime, pendingIntent);
        }
    }

    @Override
    public void onDestroy() {
        LogUtil.d("");
        super.onDestroy();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
    }
}
