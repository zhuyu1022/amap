package com.centit.amap.util;

import android.content.Context;
import android.os.BatteryManager;

/**
 * Created by zhu_yu on 2017/10/21.
 */

public class BatteryUtils {

    public static String getBatteryPercent(Context context){
        //获取电池电量
        BatteryManager batteryManager=(BatteryManager)context.getSystemService(Context.BATTERY_SERVICE);
        String battery= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            battery = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)+"";
        }
        return battery;
    }


}
