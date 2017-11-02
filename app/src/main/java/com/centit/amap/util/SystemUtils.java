package com.centit.amap.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.location.LocationManager;
import android.net.Uri;

import com.centit.core.tools.appPackageManager.AppPackageUtil;

import java.io.File;
import java.util.List;

/**
 * Created by zhu_yu on 2017/10/23.
 */

public class SystemUtils {


    /**
     * 获取gps是否可用
     * @param context
     * @return
     */
    public static boolean getGpsStatus(Context context){
        LocationManager lm= (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gpsStatus=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return gpsStatus;
    }



    /**
     * 安装apk
     *
     */
    public static boolean installApk(Context context, String apkPath)
    {
        File apkfile = new File(apkPath);
        if (!apkfile.exists())
        {
            return false;
        }

        PackageInfo pi = AppPackageUtil.getAPKFilePackageInfo(context, apkPath);
        if (pi == null)
        {
            apkfile.delete();
            return false;
        }

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        context.startActivity(i);
        return true;
    }

    /**
     * 卸载apk
     *
     * @param context
     * @param packname
     */
    public static void uninstallApk(Context context, String packname)
    {
        Uri packageURI = Uri.parse("package:" + packname);

        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);

        context.startActivity(uninstallIntent);
    }


    /**
     * 比较版本号
     *
     * @param curVersion
     * @param newVersion
     * @return
     */
    public static boolean compareVersion(String curVersion, String newVersion)
    {
        if (curVersion != null && newVersion != null)
        {
            String curV[] = curVersion.split("\\.");
            String newV[] = newVersion.split("\\.");

            int curCount = curV.length;
            int newCount = newV.length;

            int lowCount = (curCount >= newCount) ? newCount : curCount;

            for (int i = 0; i < lowCount; i++)
            {
                String curVTemp = curV[i];
                String newVTemp = newV[i];
                try
                {
                    Integer iCur = Integer.valueOf(curVTemp);
                    Integer inew = Integer.valueOf(newVTemp);

                    if (iCur < inew)
                    {
                        return true;
                    }
                    else if (iCur > inew)
                    {
                        return false;
                    }
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                }
            }

            if (newCount > curCount)
            {
                return true;
            }

        }

        return false;
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
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(200);

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
        //  Log.d("Service:", "isServiceRunning: "+serviceList.get(i).service.getClassName());

        }
        return isRunning;
    }

}
