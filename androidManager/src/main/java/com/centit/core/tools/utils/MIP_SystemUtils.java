package com.centit.core.tools.utils;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.centit.GlobalState;
import com.centit.core.tools.appPackageManager.AppPackageUtil;
import com.centit.core.tools.logManger.LogUtil;

/**
 * 获取相关系统信息
 * 
 */
public class MIP_SystemUtils
{
    
    public static String UA = Build.MODEL;
    
    /**
     * 获取应用程序名称
     * 
     * @return
     * @return String
     */
    public static String getAppName()
    {
        return getAppName(null);
    }
    
    /**
     * 获取应用程序名称
     * 
     * @param packageName
     * @return
     * @return String
     */
    public static String getAppName(String packageName)
    {
        String applicationName;
        
        if (packageName == null)
        {
            packageName = GlobalState.getInstance().getPackageName();
        }
        
        try
        {
            PackageManager packageManager = GlobalState.getInstance().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            applicationName = GlobalState.getInstance().getString(packageInfo.applicationInfo.labelRes);
        }
        catch (Exception e)
        {
            LogUtil.e(e);
            applicationName = "";
        }
        
        return applicationName;
    }
    
    /**
     * 获取版本名称
     * 
     * @return
     * @return String
     */
    public static String getAppVersionNumber()
    {
        return getAppVersionNumber(null);
    }
    
    /**
     * 获取版本名称
     * 
     * @param packageName
     * @return
     * @return String
     */
    public static String getAppVersionNumber(String packageName)
    {
        String versionName;
        
        if (packageName == null)
        {
            packageName = GlobalState.getInstance().getPackageName();
        }
        
        try
        {
            PackageManager packageManager = GlobalState.getInstance().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionName = packageInfo.versionName;
        }
        catch (Exception e)
        {
            LogUtil.e(e);
            versionName = "";
        }
        
        return versionName;
    }
    
    /**
     * 获取应用程序的版本号
     * 
     * @return
     * @return String
     */
    public static String getAppVersionCode()
    {
        return getAppVersionCode(null);
    }
    
    /**
     * 
     * 调用系统的打电话功能
     * 
     * @Description<功能详细描述>
     * 
     * @param activity
     * @param phoneNum
     * @LastModifiedDate：<date>
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static void gotoCall(Activity activity, String phoneNum)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNum));
        activity.startActivity(intent);
    }
    
    /**
     * 
     * 调用系统发送短信功能
     * 
     * @Description<功能详细描述>
     * 
     * @param activity
     * @param phoneNum
     * @LastModifiedDate：<date>
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static void sendMessage(Activity activity, String phoneNum)
    {
        Intent intent2 = new Intent();
        intent2.setAction(Intent.ACTION_SENDTO);
        intent2.setData(Uri.parse("smsto:" + phoneNum));
        intent2.putExtra("sms_body", "");
        activity.startActivity(intent2);
    }
    
    /**
     * 获取指定应用程序的版本号
     * 
     * @param packageName
     * @return
     * @return String
     */
    public static String getAppVersionCode(String packageName)
    {
        String versionCode;
        
        if (packageName == null)
        {
            packageName = GlobalState.getInstance().getPackageName();
        }
        
        try
        {
            PackageManager packageManager = GlobalState.getInstance().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionCode = Integer.toString(packageInfo.versionCode);
        }
        catch (Exception e)
        {
            LogUtil.e(e);
            versionCode = "";
        }
        
        return versionCode;
    }
    
    /**
     * 获取SDK版本
     * 
     * @return
     * @return int
     */
    public static int getSdkVersion()
    {
        try
        {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        }
        catch (Exception e)
        {
            LogUtil.e(e);
            return 3;
        }
    }
    
    /*
     * 判断是否是该签名打包
     */
    public static boolean isRelease(String signatureString)
    {
        final String releaseSignatureString = signatureString;
        if (releaseSignatureString == null || releaseSignatureString.length() == 0)
        {
            throw new RuntimeException("Release signature string is null or missing.");
        }
        
        final Signature releaseSignature = new Signature(releaseSignatureString);
        try
        {
            PackageManager pm = GlobalState.getInstance().getPackageManager();
            PackageInfo pi =
                pm.getPackageInfo(GlobalState.getInstance().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature sig : pi.signatures)
            {
                if (sig.equals(releaseSignature))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            LogUtil.e(e);
            return true;
        }
        return false;
    }
    
    /**
     * <一句话功能简述> 获取签名名
     * 
     * @Description<功能详细描述>
     * 
     * @param packageName
     * @return
     * @LastModifiedDate：2015-8-31
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static String getRelease(String packageName)
    {
        StringBuilder builder = new StringBuilder();
        try
        {
            PackageManager pm = GlobalState.getInstance().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            for (Signature sig : pi.signatures)
            {
                builder.append(sig.toCharsString());
            }
            return builder.toString();
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
        
        return "";
    }
    
    /**
     * 获取sdk版本 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-8-31
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static int getSDKVersion()
    {
        int sdkVersion;
        try
        {
            sdkVersion = Integer.valueOf(android.os.Build.VERSION.SDK);
            
        }
        catch (NumberFormatException e)
        {
            
            sdkVersion = 0;
        }
        return sdkVersion;
    }
    
    /**
     * 判断是否是模拟器
     * 
     * @return
     * @return boolean
     */
    public static boolean isEmulator()
    {
        return Build.MODEL.equals("sdk") || Build.MODEL.equals("google_sdk");
    }
    
    public static boolean hasFroyo()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }
    
    public static boolean hasGingerbread()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }
    
    public static boolean hasGingerbreadMR1()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1;
    }
    
    public static boolean hasHoneycomb()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }
    
    public static boolean hasHoneycombMR1()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }
    
    public static boolean hasICS()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }
    
    public static boolean hasJellyBean()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }
    
    public static boolean hasJellyBeanMR1()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }
    
    public static boolean isTablet(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
    
    public static boolean isHoneycombTablet(Context context)
    {
        return hasHoneycomb() && isTablet(context);
    }
    
    public static boolean isGingerbread()
    {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD
            && Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1;
    }
    
    public static final int DEFAULT_THREAD_POOL_SIZE = getDefaultThreadPoolSize();
    
    /**
     * get recommend default thread pool size
     * 
     * @return if 2 * availableProcessors + 1 less than 8, return it, else return 8;
     * @see {@link #getDefaultThreadPoolSize(int)} max is 8
     */
    public static int getDefaultThreadPoolSize()
    {
        return getDefaultThreadPoolSize(8);
    }
    
    /**
     * get recommend default thread pool size
     * 
     * @param max
     * @return if 2 * availableProcessors + 1 less than max, return it, else return max;
     */
    public static int getDefaultThreadPoolSize(int max)
    {
        int availableProcessors = 2 * Runtime.getRuntime().availableProcessors() + 1;
        return availableProcessors > max ? max : availableProcessors;
    }
    
    /**
     * 
     * 设置手机立刻震动
     * */
    public static void Vibrate(long milliseconds)
    {
        Vibrator vib = (Vibrator)GlobalState.getInstance().getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }
    
    /**
     * 获取手机设置状态 比如蓝牙开启与否
     * 
     * @return String
     */
    public static String getPhoneSettings()
    {
        StringBuffer buf = new StringBuffer();
        String str = Secure.getString(GlobalState.getInstance().getContentResolver(), Secure.BLUETOOTH_ON);
        buf.append("蓝牙:");
        if (str.equals("0"))
        {
            buf.append("禁用");
        }
        else
        {
            buf.append("开启");
        }
        //
        str = Secure.getString(GlobalState.getInstance().getContentResolver(), Secure.BLUETOOTH_ON);
        buf.append("WIFI:");
        buf.append(str);
        
        str = Secure.getString(GlobalState.getInstance().getContentResolver(), Secure.INSTALL_NON_MARKET_APPS);
        buf.append("APP位置来源:");
        buf.append(str);
        
        return buf.toString();
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
     * 
     * 隐藏键盘
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：<date>
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static void hideSoftKey(Activity activity, EditText et)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        
        if (et != null)
        {
            imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
        }
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
