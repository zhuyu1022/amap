/*
 * File name:  PhoneInfoUtils.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2015-1-23
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.lang.reflect.Field;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.location.LocationManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import com.centit.GlobalState;
import com.centit.core.tools.logManger.LogUtil;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2015-1-23]
 */
public class MIP_DeviceInfoUtils
{
    
    public static String toDeviceInfoString(Context mContext)
    {
        return "phoneInfo =" + getPhoneInfo() + "\ngetPhoneNum=" + getPhoneNum(mContext) + "\ngetIMSI="
            + getIMSI(mContext) + "\ngetIMEI=" + getIMEI(mContext) + "\ngetDeviceId=" + getDeviceId(mContext) + "\n";
    }
    
    /**
     * @Title: getMobileInfo
     * @Description: 获取手机的硬件信息
     * @param @return 设定文件
     * @return String 返回类型
     */
    public static String getMobileInfo()
    {
        StringBuffer sb = new StringBuffer();
        /**
         * 通过反射获取系统的硬件信息 获取私有的信息
         */
        try
        {
            Field[] fields = Build.class.getDeclaredFields();
            for (Field field : fields)
            {
                field.setAccessible(true);
                String name = field.getName();
                String value = field.get(null).toString();
                sb.append(name + "=" + value);
                sb.append("\n");
            }
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
        return sb.toString();
    }
    
    /**
     * 获取手机信息 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static String getPhoneInfo()
    {
        String phoneInfo = "Product: " + android.os.Build.PRODUCT;
        phoneInfo += ", CPU_ABI: " + android.os.Build.CPU_ABI;
        phoneInfo += ", TAGS: " + android.os.Build.TAGS;
        phoneInfo += ", VERSION_CODES.BASE: " + android.os.Build.VERSION_CODES.BASE;
        phoneInfo += ", MODEL: " + android.os.Build.MODEL;
        phoneInfo += ", SDK: " + android.os.Build.VERSION.SDK;
        phoneInfo += ", VERSION.RELEASE: " + android.os.Build.VERSION.RELEASE;
        phoneInfo += ", DEVICE: " + android.os.Build.DEVICE;
        phoneInfo += ", DISPLAY: " + android.os.Build.DISPLAY;
        phoneInfo += ", BRAND: " + android.os.Build.BRAND;
        phoneInfo += ", BOARD: " + android.os.Build.BOARD;
        phoneInfo += ", FINGERPRINT: " + android.os.Build.FINGERPRINT;
        phoneInfo += ", ID: " + android.os.Build.ID;
        phoneInfo += ", MANUFACTURER: " + android.os.Build.MANUFACTURER;
        phoneInfo += ", USER: " + android.os.Build.USER;
        
        return phoneInfo;
    }
    
    /**
     * 获取手机号 <一句话功能简述> 部分手机无法获取
     * 
     * @Description<功能详细描述>
     * 
     * @param mContext
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static String getPhoneNum(Context mContext)
    {
        TelephonyManager mTm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTm != null)
        {
            return mTm.getLine1Number();
        }
        return "";
    }
    
    /**
     * 获取IMSI <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param mContext
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static String getIMSI(Context mContext)
    {
        TelephonyManager mTm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTm != null)
        {
            return mTm.getSubscriberId();
        }
        return "";
    }
    
    /**
     * 获取IMEI <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param mContext
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static String getIMEI(Context mContext)
    {
        TelephonyManager mTm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTm != null)
        {
            return mTm.getDeviceId();
        }
        return "";
    }
    
    /**
     * 获取deviceId
     * 
     * @param mContext
     * @return
     */
    public static String getDeviceId(Context mContext)
    {
        String deviceId = getIMEI(mContext);
        
        if (deviceId == null || deviceId.equals(""))
        {
            deviceId = Secure.getString(mContext.getContentResolver(), Secure.ANDROID_ID);
            if (deviceId == null || deviceId.equals("") || deviceId.equals("9774d56d682e549c"))
            {
                deviceId = "";
            }
        }

         return deviceId;
    }
    
    public static String getDeviceName(Context mContext)
    {
        
        String deviceName = android.os.Build.MODEL;
        
        if (deviceName == null)
        {
            deviceName = "";
        }
        
        return deviceName;
    }
    
    /**
     * 获取分辨率 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param mActivity
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static Point getResolution(Activity mActivity)
    {
        
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        
        return new Point(dm.widthPixels, dm.heightPixels);
    }
    
    /**
     * 获取dpi <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param mActivity
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static int getDpi(Activity mActivity)
    {
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        
        return dm.densityDpi;
    }
    
    /**
     * dp转px
     * 
     * @author "" 2013-10-22 下午1:11:48
     * @param dipValue
     * @return int
     */
    public static int dip2px(float dipValue)
    {
        final float scale = GlobalState.getInstance().getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }
    
    /**
     * px转dip TODO(这里用一句话描述这个方法的作用)
     * 
     * @author "" 2013-10-22 下午1:12:09
     * @param pxValue
     * @return
     * @return int
     */
    public static int px2dip(float pxValue)
    {
        final float scale = GlobalState.getInstance().getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
    
    /**
     * 获取通知栏高度
     * 
     * @author "" 2012-2-12 下午07:37:13
     * @Title: getBarHeight
     * @param @param context
     * @param @return 设定文件
     * @return int 返回类型
     */
    public static int getBarHeight()
    {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try
        {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = GlobalState.getInstance().getResources().getDimensionPixelSize(x);
        }
        catch (Exception e1)
        {
            LogUtil.e(e1);
        }
        return sbar;
    }
    
    /**
     * 外部存储是否可用,SD卡是否被挂载
     * 
     * @return
     */
    public static boolean externalMemoryAvailable()
    {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }
    
    /**
     * 获取跟目录
     * 
     * @return
     * @LastModifiedDate：2013-9-27
     * @author shen_feng
     * @EditHistory：<修改内容><修改人>
     */
    public static String getSDPath()
    {
        File sdDir = null;
        if (checkSDCard())
        {
            sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
        }
        else
        {
            sdDir = new File("");
        }
        return sdDir.toString();
        
    }
    
    /**
     * 判断是否有大于remindSpace（字节）足够的空间
     * 
     * @param remindSpace
     * @return
     */
    public static boolean isEnoughSpace(long remindSpace)
    {
        if (remindSpace == -1 || remindSpace == 0)
        {
            remindSpace = 5 * 1024 * 1024;
        }
        
        if (checkSDCard())
        {
            
            long space = getAvailableExternalMemorySize();
            
            if (space > remindSpace)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 
     * 检查sd卡是否能读写
     * 
     * @return
     * @LastModifiedDate：2013-9-27
     * @author shen_feng
     * @EditHistory：<修改内容><修改人>
     */
    public static boolean checkSDCard()
    {
        
        if (externalMemoryAvailable())
        {
            File f = Environment.getExternalStorageDirectory();
            if (f.canRead() && f.canWrite())
            {
                return true;
            }
            return false;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 获取手机外部可用空间大小，字节
     * 
     * @return
     */
    public static long getAvailableExternalMemorySize()
    {
        if (externalMemoryAvailable())
        {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            return availableBlocks * blockSize;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * 
     * 获取手机内部总空间大小
     * 
     * @return
     */
    
    public static long getTotalInternalMemorySize()
    {
        
        File path = Environment.getDataDirectory();// Gets the Android data
                                                   // directory
        
        StatFs stat = new StatFs(path.getPath());
        
        long blockSize = stat.getBlockSize(); // 每个block 占字节数
        
        long totalBlocks = stat.getBlockCount(); // block总数
        
        return totalBlocks * blockSize;
        
    }
    
    /**
     * 
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-1-23
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static boolean getIsRoot()
    {
        boolean bool = false;
        try
        {
            if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists()))
            {
                bool = false;
            }
            else
            {
                bool = true;
            }
        }
        catch (Exception e)
        {
            
        }
        return bool;
    }
    
    /**
     * 应用程序运行命令获取 Root权限，设备必须已破解(获得ROOT权限)
     * 
     * @return 应用程序是/否获取Root权限
     */
    public static boolean getRootPermission(Context mContext)
    {
        Process process = null;
        DataOutputStream os = null;
        String pkgCodePath = mContext.getPackageCodePath();
        try
        {
            String cmd = "ls " + pkgCodePath;
            process = Runtime.getRuntime().exec("su"); // 切换到root帐号
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(cmd + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        }
        catch (Exception e)
        {
            return false;
        }
        finally
        {
            try
            {
                if (os != null)
                {
                    os.close();
                }
                process.destroy();
            }
            catch (Exception e)
            {
            }
        }
        return true;
    }
    
    /**
     * 检查sim的状态
     * 
     * @return String
     */
    public static String getSimState(Context context)
    {
        TelephonyManager mTm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTm != null)
        {
            switch (mTm.getSimState())
            {
                case android.telephony.TelephonyManager.SIM_STATE_UNKNOWN:
                    return "未知SIM状态_" + android.telephony.TelephonyManager.SIM_STATE_UNKNOWN;
                case android.telephony.TelephonyManager.SIM_STATE_ABSENT:
                    return "没插SIM卡_" + android.telephony.TelephonyManager.SIM_STATE_ABSENT;
                case android.telephony.TelephonyManager.SIM_STATE_PIN_REQUIRED:
                    return "锁定SIM状态_需要用户的PIN码解锁_" + android.telephony.TelephonyManager.SIM_STATE_PIN_REQUIRED;
                case android.telephony.TelephonyManager.SIM_STATE_PUK_REQUIRED:
                    return "锁定SIM状态_需要用户的PUK码解锁_" + android.telephony.TelephonyManager.SIM_STATE_PUK_REQUIRED;
                case android.telephony.TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                    return "锁定SIM状态_需要网络的PIN码解锁_" + android.telephony.TelephonyManager.SIM_STATE_NETWORK_LOCKED;
                case android.telephony.TelephonyManager.SIM_STATE_READY:
                    return "就绪SIM状态_" + android.telephony.TelephonyManager.SIM_STATE_READY;
                default:
                    return "未知SIM状态_" + android.telephony.TelephonyManager.SIM_STATE_UNKNOWN;
                    
            }
        }
        return "";
    }
    
    /**
     * 获取手机信号状态
     * 
     * @return String
     */
    public static String getPhoneType(Context context)
    {
        TelephonyManager mTm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        
        if (mTm != null)
        {
            switch (mTm.getPhoneType())
            {
                case android.telephony.TelephonyManager.PHONE_TYPE_NONE:
                    return "PhoneType: 无信号_" + android.telephony.TelephonyManager.PHONE_TYPE_NONE;
                case android.telephony.TelephonyManager.PHONE_TYPE_GSM:
                    return "PhoneType: GSM信号_" + android.telephony.TelephonyManager.PHONE_TYPE_GSM;
                case android.telephony.TelephonyManager.PHONE_TYPE_CDMA:
                    return "PhoneType: CDMA信号_" + android.telephony.TelephonyManager.PHONE_TYPE_CDMA;
                default:
                    return "PhoneType: 无信号_" + android.telephony.TelephonyManager.PHONE_TYPE_NONE;
            }
        }
        return "";
    }
    
    /**
     * 服务商名称：例如：中国移动、联通 　　 SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断). 　　
     */
    public static String getSimOpertorName(Context context)
    {
        
        TelephonyManager mTm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        
        if (mTm != null && mTm.getSimState() == android.telephony.TelephonyManager.SIM_STATE_READY)
        {
            StringBuffer sb = new StringBuffer();
            sb.append("SimOperatorName: ").append(mTm.getSimOperatorName());
            sb.append("\n");
            sb.append("SimOperator: ").append(mTm.getSimOperator());
            sb.append("\n");
            sb.append("Phone:").append(mTm.getLine1Number());
            return sb.toString();
        }
        else
        {
            StringBuffer sb = new StringBuffer();
            sb.append("SimOperatorName: ").append("未知");
            sb.append("\n");
            sb.append("SimOperator: ").append("未知");
            return sb.toString();
        }
    }
    
    /**
     * 获取电话状态
     * 
     * @return String
     */
    public static String getCallState(Context context)
    {
        TelephonyManager mTm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTm != null)
        {
            switch (mTm.getCallState())
            {
                case android.telephony.TelephonyManager.CALL_STATE_IDLE:
                    return "电话状态[CallState]: 无活动";
                case android.telephony.TelephonyManager.CALL_STATE_OFFHOOK:
                    return "电话状态[CallState]: 无活动";
                case android.telephony.TelephonyManager.CALL_STATE_RINGING:
                    return "电话状态[CallState]: 无活动";
                default:
                    return "电话状态[CallState]: 未知";
            }
        }
        return "";
    }
    
    // Gps是否可用
    public static boolean isGpsEnable(Context context)
    {
        LocationManager locationManager = ((LocationManager)context.getSystemService(Context.LOCATION_SERVICE));
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
    
    /**
     * 打开GPS <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param context
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static void toggleGPS(Context context)
    {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try
        {
            context.startActivity(intent);
            
        }
        catch (ActivityNotFoundException ex)
        {
            
            // General settings activity
            intent.setAction(Settings.ACTION_SETTINGS);
            try
            {
                context.startActivity(intent);
            }
            catch (Exception e)
            {
            }
        }
    }
    
}
