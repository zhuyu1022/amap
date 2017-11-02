package com.centit.app.cmipThirtpart.cmipappmgr;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipDataUtils.sqlUtils.Table.AppInfoTable;
import com.centit.core.tools.appPackageManager.AppInfo;
import com.centit.core.tools.appPackageManager.AppPackageUtil;

public class AppDBUtils
{
    /**
     * 保存应用信息
     * 
     * @param appinfos
     */
    public static void insertAppInfo(ContentResolver resolver, AppInfo appinfo)
    {
        String openId = GlobalState.getInstance().getOpenId();
        Uri url = AppInfoTable.CONTENT_URI;
        
        ContentValues values = new ContentValues();
        values.put(AppInfoTable.OPENID, openId);
        values.put(AppInfoTable.APPNAME, appinfo.getAppName());
        values.put(AppInfoTable.APPPACKAGE, appinfo.getPackageName());
        values.put(AppInfoTable.APPVersionName, appinfo.getVersionName());
        values.put(AppInfoTable.APPVersionCode, appinfo.getVersionCode());
        values.put(AppInfoTable.SHOTCUT, appinfo.getIsShortCut() ? Constant_Mgr.Add_0 : Constant_Mgr.No_Add_1);
        values.put(AppInfoTable.TEAMID, "teamid");
        values.put(AppInfoTable.APPID, appinfo.getAppid());
        
        Cursor mCur =
            resolver.query(url, null, AppInfoTable.OPENID + "=? And " + AppInfoTable.APPPACKAGE + "=?", new String[] {
                openId, appinfo.getPackageName()}, null);
        if (mCur == null || mCur.getCount() == 0)
        {
            resolver.insert(url, values);
        }
        
        if (mCur != null)
        {
            mCur.close();
            mCur = null;
        }
        
    }
    
    /**
     * 更新安装的应用信息
     * 
     * @param resolver
     * @param openId
     * @param appinfo
     * @param isShortCut
     */
    public static void updateAppInfo(ContentResolver resolver, String openId, String packageName, boolean isShortCut)
    {
        Uri url = AppInfoTable.CONTENT_URI;
        
        ContentValues values = new ContentValues();
        values.put(AppInfoTable.SHOTCUT, isShortCut ? Constant_Mgr.Add_0 : Constant_Mgr.No_Add_1);
        
        resolver.update(url, values, AppInfoTable.OPENID + "= ? And " + AppInfoTable.APPPACKAGE + "=?", new String[] {
            openId, packageName});
        
    }
    
    /**
     * 删除该条APP信息
     * 
     * @param resolver
     * @param openId
     * @param appinfo
     */
    public static void deleteAppInfo(ContentResolver resolver, String openId, String packageName)
    {
        Uri url = AppInfoTable.CONTENT_URI;
        
        resolver.delete(url, AppInfoTable.OPENID + "= ? And " + AppInfoTable.APPPACKAGE + "=?", new String[] {openId,
            packageName});
    }
    
    /**
     * 查询数据库中已经保存的APP 信息
     * 
     * @param resolver
     * @param openId
     * @return
     */
    public static List<AppInfo> queryAppInfos(Context mContext, boolean flag)
    {
        String openId = GlobalState.getInstance().getOpenId();
        ContentResolver resolver = mContext.getContentResolver();
        List<AppInfo> apps = new ArrayList<AppInfo>();
        
        Uri url = AppInfoTable.CONTENT_URI;
        
        String isAdd = flag ? Constant_Mgr.Add_0 : Constant_Mgr.No_Add_1;
        
        Cursor mCur =
            resolver.query(url, null, AppInfoTable.OPENID + "= ? and " + AppInfoTable.SHOTCUT + " = ?", new String[] {
                openId, isAdd}, null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                AppInfo appInfo = new AppInfo();
                String appName = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPNAME));
                String appPackage = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPPACKAGE));
                String appVersionName = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPVersionName));
                int appVersionCode = mCur.getInt(mCur.getColumnIndex(AppInfoTable.APPVersionCode));
                String isShortCut = mCur.getString(mCur.getColumnIndex(AppInfoTable.SHOTCUT));
                String teamid = mCur.getString(mCur.getColumnIndex(AppInfoTable.TEAMID));
                String appid = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPID));
                
                if (!teamid.equals("teamid") && !teamid.equals(""))
                {
                    continue;
                }
                appInfo.setAppName(appName);
                appInfo.setPackageName(appPackage);
                appInfo.setVersionCode(appVersionCode);
                appInfo.setVersionName(appVersionName);
                
                if (isShortCut != null && isShortCut.equals("1"))
                {
                    appInfo.setIsShortCut(true);
                }
                else
                {
                    appInfo.setIsShortCut(false);
                }
                appInfo.setTeamid(teamid);
                appInfo.setAppid(appid);
                PackageInfo info = AppPackageUtil.getPackageInfo(mContext, appPackage);
                if (info != null)
                {
                    apps.add(appInfo);
                }
            }
            mCur.close();
            mCur = null;
        }
        return apps;
    }
    
    /**
     * 查询数据库中已经保存的APP 信息
     * 
     * @param resolver
     * @param openId
     * @return
     */
    public static AppInfo queryAppInfo(Context mContext, String pgName)
    {
        String openId = GlobalState.getInstance().getOpenId();
        ContentResolver resolver = mContext.getContentResolver();
        
        Uri url = AppInfoTable.CONTENT_URI;
        
        Cursor mCur =
            resolver.query(url,
                null,
                AppInfoTable.OPENID + "= ? and " + AppInfoTable.APPPACKAGE + " = ? ",
                new String[] {openId, pgName},
                null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                AppInfo appInfo = new AppInfo();
                String appName = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPNAME));
                String appPackage = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPPACKAGE));
                String appVersionName = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPVersionName));
                int appVersionCode = mCur.getInt(mCur.getColumnIndex(AppInfoTable.APPVersionCode));
                String isShortCut = mCur.getString(mCur.getColumnIndex(AppInfoTable.SHOTCUT));
                String teamid = mCur.getString(mCur.getColumnIndex(AppInfoTable.TEAMID));
                String appid = mCur.getString(mCur.getColumnIndex(AppInfoTable.APPID));
                
                appInfo.setAppName(appName);
                appInfo.setPackageName(appPackage);
                appInfo.setVersionCode(appVersionCode);
                appInfo.setVersionName(appVersionName);
                
                if (isShortCut != null && isShortCut.equals("1"))
                {
                    appInfo.setIsShortCut(true);
                }
                else
                {
                    appInfo.setIsShortCut(false);
                }
                appInfo.setTeamid(teamid);
                appInfo.setAppid(appid);
                
                PackageInfo info = AppPackageUtil.getPackageInfo(mContext, appPackage);
                if (info != null)
                {
                    if (mCur != null)
                    {
                        mCur.close();
                        mCur = null;
                    }
                    return appInfo;
                }
            }
            mCur.close();
            mCur = null;
        }
        return null;
    }
}
