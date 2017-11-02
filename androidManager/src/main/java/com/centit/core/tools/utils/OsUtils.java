/*
 * File name:  NetUtils.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ma_zhicheng
 * Last modified date:  13 Sep,2013
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.logManger.LogUtil;

/**
 * 获取网络相关地址，例如ip
 * 
 * @Description 获取网络相关地址，例如ip
 * 
 * @Version [版本号, 13 Sep,2013]
 */
public class OsUtils
{
    
    /**
     * 
     * 获取应用的版本号
     * 
     * @Description 获取应用的版本号
     * 
     * @param context 应用上下文
     * @return 应用的版本号
     * @LastModifiedDate：13 Sep,2013
     * @author ma_zhicheng
     * @EditHistory：<修改内容><修改人>
     */
    public static String getVersionName(Context context)
    {
        String versionName = "";
        try
        {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            versionName = packageManager.getPackageInfo(packageName, 0).versionName;
        }
        catch (NameNotFoundException e)
        {
            LogUtil.e(e);
        }
        return versionName;
    }
    
    /**
     * 
     * 获取存储文件的根路径
     * 
     * @Description 获取存储文件的根路径
     * 
     * @param context 应用上下文
     * @param dStr 文件名
     * @return 文件的根路径
     * @LastModifiedDate：2013-10-25
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static String getApplicationName(Context context, String dStr)
    {
        String mAppName = "";
        
        try
        {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getApplicationInfo().loadLabel(packageManager).toString();
            
            mAppName = "/" + packageName + "/";
        }
        catch (Exception e)
        {
            // TODO: handle exception
            mAppName = dStr;
        }
        
        return mAppName;
    }
    
    /**
     * 
     * 返回应用名称
     * 
     * @Description 获取存储文件的根路径
     * 
     * @param context 应用上下文
     * @param dStr 文件名
     * @return 文件的根路径
     * @LastModifiedDate：2013-10-25
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static String getAppName(Context context, String dStr)
    {
        String mAppName = "";
        
        try
        {
            mAppName = context.getPackageName();
            // PackageManager packageManager = context.getPackageManager();
            // String packageName = context.getApplicationInfo().loadLabel(packageManager).toString();
            
            // mAppName = packageName;
        }
        catch (Exception e)
        {
            // TODO: handle exception
            mAppName = dStr;
        }
        
        return mAppName;
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
     * 
     * 显示键盘
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：<date>
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static void showSoftKey(Activity activity, EditText et)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        
        if (et != null)
        {
            imm.showSoftInput(et, 0);
        }
    }
    
    /**
     * 返回true为空/false不为空
     * 
     * @param str
     * @return
     */
    public static boolean isNull(String str)
    {
        if (str == null || "".equals(str.trim()) || "null".equals(str.trim().toLowerCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 
     * 获取properties中的数据
     * 
     * @Description 根据输入的properties文件名获取其中的数据
     * 
     * @param context 要进行读取操作的上下文
     * @param propertiesName 文件名（不需后缀）
     * @param keyName 获取的数据Key值
     * @return 获取数据的Values
     * @LastModifiedDate：2013-3-13
     * @author Midnight
     * @throws MIPException get exception for debug tools
     * @EditHistory：1.根据输入的properties文件名获取其中的数据
     */
    public static String getPropertiesInfo(Context context, String propertiesName, String keyName)
        throws MIPException
    {
        try
        {
            Properties pro = new Properties();
            
            InputStream is = context.getAssets().open("IAFsource/" + propertiesName + ".properties");
            
            pro.load(is);
            return pro.getProperty(keyName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            new MIPException(ExceptionConst.IOEXCEPTION, e.toString()).printStackTrace();
        }
        
        return "";
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
    
    public static void sendMail(Activity activity, String mailaddress)
    {
        
        Uri uri = Uri.parse("mailto:" + mailaddress);
        
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        
        activity.startActivity(it);
        
    }
    
    public static void gotoWchat(Activity activity)
    {
        try
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(cmp);
            activity.startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(activity, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_LONG).show();
        }
    }
}
