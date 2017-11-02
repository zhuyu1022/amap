/*
 * File name:  GlobalState.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  extends Android framework for define global state of this application.</br>It can be used by any context
 *              of this application</br>(need get/set method).  
 * Author:  Midnight
 * Last modified date:  2013-8-20
 * Version:  1.0
 * Edit history:  1.新建 -Midnight
 */
package com.centit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipmodule.weather.parseResponse.WeatherDataResponse;
import com.centit.core.tools.encryptManager.AesUtil;
import com.centit.core.tools.exceptionManager.CrashHandler;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.utils.MIP_Constant_Core;
import com.centit.core.tools.utils.MIP_DeviceInfoUtils;
import com.centit.core.tools.utils.MIP_SharedPreferencesUtils;
import com.centit.core.tools.utils.MIP_TimeUtils;
import com.centit.core.tools.utils.OsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 该类用于存放phone ，pad 共用的静态变量，GlobalState为继承Application的类 注意在存储时，将该变量一并存储到sharePreference中，以便在内容消耗殆尽时，可以从本地获取该数据
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-11-12]
 */
public class GlobalState extends Application
{
    /**
     * true-用户名密码登录 false-ca认证登录
     */
    private boolean                   isBaseLogin             = false;
    
    /**
     * GlobalState 单例，给外部使用
     */
    private static GlobalState        instance                = null;
    
    /**
     * 存储sharepreferen的名称
     */
    private final String              share_name              = "data";
    
    /**
     * 当前Activity的list
     */
    private List<Activity>            mActivityList           = new ArrayList<Activity>();
    
    /**
     * 屏幕宽
     */
    private int                       mScreen_With            = -1;
    
    /**
     * 屏幕高
     */
    private int                       mScreen_Height          = -1;
    
    /**
     * 密度
     */
    private int                       mDensityDpi             = -1;
    
    /**
     * 设备ID
     */
    private String                    deviceId                = "";
    
    /**
     * 设备标识，区别phone、pad
     */
    private String                    deviceType              = "";
    
    /**
     * 设备名称
     */
    private String                    deviceName              = "";
    
    /**
     * 系统设备版本号
     */
    private String                    osVersion               = "";
    
    /**
     * 应用版本号
     */
    private String                    lastappVersion          = "";
    
    /**
     * 应用版本号
     */
    private String                    appVersion              = "";
    
    /**
     * 最新版本号，从服务器上获取
     */
    private String                    mNewVersion             = "";
    
    /**
     * 最新版本的URL
     */
    private String                    mNewVersionPath         = "";
    
    /**
     * 版本升级时的策略
     */
    private String                    mNewUdpolicy            = "";
    
    /* 更新日志 */
    private String                    mNewUpdateLog           = "";
    
    /**
     * 是否可以打log，true打印log，false 不打印log
     */
    private Boolean                   WRITE_LOG               = true;
    
    /**
     * 是否将log保存至sd卡，true保存，false 不保存
     */
    private Boolean                   saveLogToSDCard         = false;
    
    /**
     * 写日志时最后一次的时间
     */
    private String                    lastSaveTime            = "";
    
    /**
     * 心跳间隔
     */
    private long                      heartTick               = -1;
    
    /**
     * 部门ID
     */
    private String                    mDepId;
    
    /**
     * 部门名称
     */
    private String                    depName;
    
    private String                    phoneNum;
    
    /**
     * 职位
     */
    private String                    position;
    
    private String                    email;
    
    /**
     * 会话标识
     */
    private String                    SessingId;
    
    /** 用户权限 **/
    private String                    mUserRole;
    
    /** 用户no **/
    private String                    mUserNumber;
    
    /** 所属人id **/
    private String                    mOid;
    
    /** 所属人name **/
    private String                    mOname;
    
    /**
     * 登录时使用的账号
     */
    private String                    LoginName;
    
    /**
     * ca认证时，用户的唯一标志
     */
    private String                    DeviceIMEI;
    
    /**
     * 上传用户登录账号时，用户标识,本次登录成功后记录的用户id
     */
    private String                    OpenId;
    
    /**
     * 上传用户登录账号时，用户密码
     */
    private String                    password;
    
    /**
     * 用戶昵称
     */
    private String                    mUserName               = "";
    
    private String                    mUserId                 = "";
    
    /**
     * 个人签名
     */
    private String                    mPersonSign             = "";
    
    /**
     * 是否记住用户名和密码
     */
    private boolean                   isRemember;
    
    /**
     * 是否绑定
     */
    private boolean                   isBind;
    
    /**
     * ip地址
     */
    private String                    mIPAddr                 = "";
    
    /**
     * 端口
     */
    private String                    mPortNum                = "";
    
    /**
     * 除了"获取服务器信息"接口外，其他所有接口均需要使用该地址
     */
    private String                    mRequestURL             = "";
    
    private long                      mHeartBitTime           = -1;
    
    /**
     * 首頁中聚合模式的，0,1,2
     */
    private int                       JHModuleNumber          = 0;
    
    /**
     * MainActvity 全路径
     */
    private String                    mMainActivitClassPath   = "";
    
    /**
     * 上一次更新天气事件
     */
    private long                      mLastUpdateWeatherTime  = 0L;
    
    // 上一次更新日期时间
    private long                      mLastUpdateDateTime     = 0L;
    
    private long                      mZLXMLastUpdateDateTime = 0L;
    
    private long                      mFWSPLastUpdateDateTime = 0L;
    
    private long                      mSWSPLastUpdateDateTime = 0L;
    
    private long                      mHYGLLastUpdateDateTime = 0L;
    
    /**
     * 上一次更新资讯时间
     */
    private long                      mLastUpdatNewsTime      = 0L;
    
    private String                    unCount                 = "";
    
    // 会议室情况
    private String                    mRoomLists              = "";
    
    // 最后一次获取天气、显示日期
    private String                    mLastDay                = "";
    
    // 模块排序
    // private String mPositionFlag = "";
    
    // 天气的数据
    public static WeatherDataResponse mWeatherInfoData        = null;
    
    // 获取天气的Task
    public static NetTask             mGetWeatherTask         = null;
    
    private long                      mLastSendStepTime       = 0L;
    

    
    private String                    mLastPTKBTime;
    
    private String                    mLastQMYSTime;
    
    private boolean                   isNewXXNotice           = true;
    
    private boolean                   isMDRXX                 = true;
    
    private boolean                   isSoundXX               = true;
    
    private boolean                   isZDXX                  = true;
    
    private boolean                   isBaiduPush             = false;
    
    private int                       mXXUncountTotal         = 0;
    
    private int                       scheduleAlartTime       = 30;
    
    private String                    mlockstatu              = "";
    
    private long                      spaceTime               = 0l;
    
    // 签批格式 1 签批，2 签署
    private String                    mSubType                = "";
    
    private boolean                   isCreateGetPas          = false;
    
    // {Latitude=31.978583, Longitude=118.762327, address=江苏省南京市雨花台区宁双路, Province=江苏, city=南京}
    private String                    mLatitude               = "";
    
    private String                    mLongitude              = "";
    
    private String                    mLocationAddress        = "";
    
    /**
     * 用于存放计时按钮的倒计时时间
     */
    public static Map<String, Long>   timeMap;
    
    private String                    leadername;
    
    private String                    leaderid;
    
    /** 存放用户头像的本地地址路径 **/
    private String                    userImagePath           = "";


  
    /**
     * 
     * 获取用户本地头像路径
     * 
     * @return
     * @LastModifiedDate：2017-7-6
     * @author zhu_yu
     * @EditHistory：<修改内容><修改人>
     */
    public String getUserImagePath()
    {
        if (userImagePath == null || ("").equals(userImagePath))
        {
            userImagePath = (String)getVaule("userImagePath", "");
        }
        
        return userImagePath;
    }
    
    /**
     * 
     * 设置用户本地头像路径
     * 
     * @return
     * @LastModifiedDate：2017-7-6
     * @author zhu_yu
     * @EditHistory：<修改内容><修改人>
     */
    public void setUserImagePath(String userImagePath)
    {
        this.userImagePath = userImagePath;
        setValue("userImagePath", userImagePath);
    }
    
    /**
     * 获取 leadername
     * 
     * @return 返回 leadername
     * @author zxm
     */
    public String getLeadername()
    {
        if (leadername == null || ("").equals(leadername))
        {
            leadername = (String)getVaule("leaderName", "");
        }
        
        return leadername;
    }
    
    /**
     * 设置 leadername
     * 
     * @param leadername 对leadername进行赋值
     * @author zxm
     */
    public void setLeadername(String leadername)
    {
        this.leadername = leadername;
        setValue("leaderName", leadername);
    }
    
    /**
     * 获取 leaderid
     * 
     * @return 返回 leaderid
     * @author zxm
     */
    public String getLeaderid()
    {
        if (leaderid == null || ("").equals(leaderid))
        {
            leaderid = (String)getVaule("leaderId", "");
        }
        
        return leaderid;
    }
    
    /**
     * 设置 leaderid
     * 
     * @param leaderid 对leaderid进行赋值
     * @author zxm
     */
    public void setLeaderid(String leaderid)
    {
        this.leaderid = leaderid;
        setValue("leaderId", leaderid);
    }
    
    public boolean isCreateGetPas()
    {
        return isCreateGetPas;
    }
    
    public void setCreateGetPas(boolean isCreateGetPas)
    {
        this.isCreateGetPas = isCreateGetPas;
    }
    
    /**
     * 获取 mSubType
     * 
     * @return 返回 mSubType
     * @author rqj
     */
    public String getmSubType()
    {
        if (mSubType == null || ("").equals(mSubType))
        {
            mSubType = (String)getVaule("mSubType", "1");
        }
        return mSubType;
    }
    
    /**
     * 设置 mSubType
     * 
     * @param mSubType 对mSubType进行赋值
     * @author rqj
     */
    public void setmSubType(String mSubType)
    {
        this.mSubType = mSubType;
        setValue("mSubType", mSubType);
    }
    
    /**
     * 获取 mLatitude
     * 
     * @return 返回 mLatitude
     * @author wl
     */
    public String getmLatitude()
    {
        if (mLatitude == null || ("").equals(mLatitude))
        {
            mLatitude = (String)getVaule("mLatitude", "");
        }
        return mLatitude;
    }
    
    /**
     * 设置 mLatitude
     * 
     * @param mLatitude 对mLatitude进行赋值
     * @author wl
     */
    public void setmLatitude(String mLatitude)
    {
        this.mLatitude = mLatitude;
        setValue("mLatitude", mLatitude);
    }
    
    /**
     * 获取 mLongitude
     * 
     * @return 返回 mLongitude
     * @author wl
     */
    public String getmLongitude()
    {
        if (mLongitude == null || ("").equals(mLongitude))
        {
            mLongitude = (String)getVaule("mLongitude", "");
        }
        return mLongitude;
    }
    
    /**
     * 设置 mLongitude
     * 
     * @param mLongitude 对mLongitude进行赋值
     * @author wl
     */
    public void setmLongitude(String mLongitude)
    {
        this.mLongitude = mLongitude;
        setValue("mLongitude", mLongitude);
    }
    
    /**
     * 获取 mLocationAddress
     * 
     * @return 返回 mLocationAddress
     * @author wl
     */
    public String getmLocationAddress()
    {
        if (mLocationAddress == null || ("").equals(mLocationAddress))
        {
            mLocationAddress = (String)getVaule("mLocationAddress", "");
        }
        return mLocationAddress;
    }
    
    /**
     * 设置 mLocationAddress
     * 
     * @param mLocationAddress 对mLocationAddress进行赋值
     * @author wl
     */
    public void setmLocationAddress(String mLocationAddress)
    {
        this.mLocationAddress = mLocationAddress;
        setValue("mLocationAddress", mLocationAddress);
    }
    
    public boolean isBaseLogin()
    {
        return isBaseLogin;
    }
    
    public void setBaseLogin(boolean isBaseLogin)
    {
        this.isBaseLogin = isBaseLogin;
    }
    
    /**
     * 清除sharePre数据
     */
    public void clearSharePrefence()
    {
        deleteSharedPreferences(share_name);
    }
    
    public void setValue(String key, Object value)
    {
        MIP_SharedPreferencesUtils.setValueToSharePre(this, share_name, key, value);
    }
    
    public Object getVaule(String key, Object defValue)
    {
        return MIP_SharedPreferencesUtils.getValeFromSharePre(this, share_name, key, defValue);
    }
    
    /**
     * 
     * 清空SharedPreferences中的值
     * 
     * @Description 清空SharedPreferences中的值
     * 
     * @LastModifiedDate：2013-11-7
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    @SuppressLint("Override")
    public boolean deleteSharedPreferences(String shareName)
    {
        SharedPreferences sharedoPreferences = this.getSharedPreferences(shareName, Context.MODE_PRIVATE);
        Editor editor = sharedoPreferences.edit();
        editor.clear();
        editor.commit();
        return false;
    }
    
    /**
     * 
     * 获取list
     * 
     * @Description 获取list
     * 
     * @return list
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public List<Activity> getmActivityList()
    {
        return mActivityList;
    }
    
    /**
     * 
     * 设置list
     * 
     * @Description 设置list
     * 
     * @param mActivityList list
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void setmActivityList(List<Activity> mActivityList)
    {
        this.mActivityList = mActivityList;
    }
    
    /**
     * 
     * 添加activity
     * 
     * @Description 添加activity
     * 
     * @param activity activity
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void addActivity(Activity activity)
    {
        if (mActivityList != null && activity != null)
        {
            mActivityList.add(activity);
        }
    }
    
    /**
     * 
     * 移除activity
     * 
     * @Description 移除activity
     * 
     * @param activity activity
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void removeActivity(Activity activity)
    {
        if (mActivityList != null && activity != null)
        {
            if (mActivityList.contains(activity))
            {
                mActivityList.remove(activity);
            }
        }
    }
    
    /**
     * 
     * 退出应用
     * 
     * @Description 退出应用
     * 
     * @LastModifiedDate：2013-10-15
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void exitApplication()
    {
        
        for (Activity activity : mActivityList)
        {
            if (!activity.isFinishing())
            {
                activity.finish();
            }
        }
        mActivityList.clear();
        System.exit(0);
    }
    
    public void finishOtherActivities(String localName)
    {
        if (mActivityList != null && mActivityList.size() > 0)
        {
            ArrayList<Activity> tempList = new ArrayList<Activity>();
            for (Activity activity : mActivityList)
            {
                if (!activity.isFinishing())
                {
                    if (!activity.getLocalClassName().contains(localName))
                    {
                        activity.finish();
                        tempList.add(activity);
                    }
                }
                else
                {
                    tempList.add(activity);
                }
            }
            mActivityList.removeAll(tempList);
        }
    }
    
    /**
     * <一句话功能简述> 注销应用
     * 
     * @Description<功能详细描述>
     * 
     * @param mContext
     * @param mClass
     * @LastModifiedDate：2015-5-11
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public void logoutApplicaion(Context mContext, Class<?> mClass)
    {
        if (mActivityList != null)
        {
            for (Activity activity : mActivityList)
            {
                if (!activity.isFinishing())
                {
                    activity.finish();
                }
            }
            mActivityList.clear();
        }
        Intent intent = new Intent(mContext, mClass);
        mContext.startActivity(intent);
    }
    
    /**
     * 
     * 根据Activity的名字获取Activity的实例
     * 
     * @Description <功能详细描述>
     * 
     * @param localName Activity的名字
     * @return Activity
     * @LastModifiedDate：2013-11-7
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public Activity findActivitieByName(String localName)
    {
        if (mActivityList != null)
        {
            int size = mActivityList.size();
            for (int i = 0; i < size; i++)
            {
                Activity activity = mActivityList.get(i);
                if (activity.getLocalClassName().equalsIgnoreCase(localName))
                {
                    return activity;
                }
            }
        }
        return null;
    }
    
    /**
     * 是否在记录的Activity列表中 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param className
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public boolean isHasActivity(String className)
    {
        if (findActivitieByName(className) != null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity)
    {
        if (activity != null)
        {
            mActivityList.remove(activity);
            activity.finish();
            activity = null;
        }
    }
    
    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls)
    {
        for (Activity activity : mActivityList)
        {
            if (activity.getClass().equals(cls))
            {
                finishActivity(activity);
                break;
            }
        }
    }
    
    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
        GlobalState.setApplication(this);

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        
    }
    
    @Override
    public void onLowMemory()
    {
        // TODO Auto-generated method stub
        super.onLowMemory();
    }
    
    @Override
    public void onTerminate()
    {
        // TODO Auto-generated method stub
        super.onTerminate();
    }
    
    /**
     * 
     * 获取单例
     * 
     * @Description 获取单例
     * 
     * @return 单例
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static GlobalState getInstance()
    {
        if (null == instance)
        {
            instance = new GlobalState();
        }
        return instance;
    }
    
    /**
     * 
     * 设置instance
     * 
     * @Description 设置instance
     * 
     * @param app app
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static void setApplication(Application app)
    {
        instance = (GlobalState)app;
    }
    
    /**
     * 获取屏幕宽
     * 
     * @author wang_ling
     */
    public int getmScreen_With()
    {
        if (mScreen_With == -1)
        {
            mScreen_With = (Integer)getVaule("mScreen_With", -1);
        }
        return mScreen_With;
    }
    
    /**
     * 设置 屏幕宽
     * 
     * @param mScreen_With 对mScreen_With进行赋值
     * @author wang_ling
     */
    public void setmScreen_With(int mScreen_With)
    {
        this.mScreen_With = mScreen_With;
        
        setValue("mScreen_With", mScreen_With);
        
    }
    
    /**
     * 获取屏幕高
     * 
     *
     * @author wang_ling
     */
    public int getmScreen_Height()
    {
        if (mScreen_Height == -1)
        {
            mScreen_Height = (Integer)getVaule("mScreen_Height", -1);
        }
        return mScreen_Height;
    }
    
    /**
     * 设置 屏幕高
     * 
     * @param mScreen_Height
     * @author wang_ling
     */
    public void setmScreen_Height(int mScreen_Height)
    {
        this.mScreen_Height = mScreen_Height;
        
        setValue("mScreen_Height", mScreen_Height);
        
    }
    
    /**
     * 获取屏幕密度
     * 
     *
     * @author wang_ling
     */
    public int getmDensityDpi()
    {
        if (mDensityDpi == -1)
        {
            
            mDensityDpi = (Integer)getVaule("mDensityDpi", -1);
        }
        return mDensityDpi;
    }
    
    /**
     * 设置屏幕密度
     * 
     * @param mDensityDpi 对mDensityDpi进行赋值
     * @author wang_ling
     */
    public void setmDensityDpi(int mDensityDpi)
    {
        this.mDensityDpi = mDensityDpi;
        
        setValue("mDensityDpi", mDensityDpi);
    }
    
    /**
     * 
     * 获取设备id
     * 
     * @Description 获取设备id
     * 
     * @return 设备id
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    @SuppressLint("NewApi")
    public String getDeviceId()
    {
        if (deviceId == null || ("").equals(deviceId))
        {
            deviceId = MIP_DeviceInfoUtils.getDeviceId(this);
        }
        return deviceId;
    }
    
    /**
     * 
     * 设置设备id
     * 
     * @Description 设置设备id
     * 
     * @param deviceId 设备id
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
        
        setValue("deviceId", deviceId);
    }
    
    /**
     * 获取设备类型，pad or phone
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public String getDeviceType()
    {
        if (deviceType == null || deviceType.equals(""))
        {
            deviceType = (String)getVaule("deviceType", "");
        }
        return deviceType;
    }
    
    /**
     * 应用初始化的时候设置备类型，pad or phone <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param deviceType
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
        setValue("deviceType", deviceType);
    }
    
    /**
     * 
     * 获取设备的版本号
     * 
     * @Description 获取设备的版本号
     * 
     * @return 设备的版本号
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public String getOsVersion()
    {
        if (osVersion == null || ("").equals(osVersion))
        {
            osVersion = Build.VERSION.RELEASE;
        }
        return osVersion;
    }
    
    /**
     * 
     * 设置设备的版号
     * 
     * @Description 设置设备的版号
     * 
     * @param osVersion 设备的版号
     * @LastModifiedDate：2013-10-18
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void setOsVersion(String osVersion)
    {
        this.osVersion = osVersion;
        
        setValue("osVersion", osVersion);
    }
    
    /**
     * 
     * 获取应用版本号
     * 
     * @Description<功能详细描述>
     * 
     * @return 应用版本号
     * @LastModifiedDate：2013-10-11
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public String getAppVersion()
    {
        if (appVersion == null || "".equals(appVersion))
        {
            appVersion = OsUtils.getVersionName(this);
        }
        return appVersion;
    }
    
    /**
     * 
     * 设置应用版本号
     * 
     * @Description 设置应用版本号
     * 
     * @param appVersion 应用版本号
     * @LastModifiedDate：2013-10-11
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public void setAppVersion(String appVersion)
    {
        this.appVersion = appVersion;
        
        setValue("appVersion", appVersion);
    }
    
    /**
     * @return the lastappVersion
     */
    public String getLastappVersion()
    {
        if (lastappVersion == null)
        {
            lastappVersion = "";
        }
        return lastappVersion;
    }
    
    /**
     * @param lastappVersion the lastappVersion to set
     */
    public void setLastappVersion(String lastappVersion)
    {
        this.lastappVersion = lastappVersion;
        setValue("lastappVersion", lastappVersion);
    }
    
    /**
     * 服务器上最新版本号 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public String getmNewVersion()
    {
        if (mNewVersion == null || mNewVersion.equals(""))
        {
            
            mNewVersion = (String)getVaule("mNewVersion", "");
            
        }
        return mNewVersion;
    }
    
    /**
     * <一句话功能简述> 设置服务器上最新版本号
     * 
     * @Description<功能详细描述>
     * 
     * @param mNewVersion
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void setmNewVersion(String mNewVersion)
    {
        this.mNewVersion = mNewVersion;
        
        setValue("mNewVersion", mNewVersion);
    }
    
    /**
     * <一句话功能简述> 最新版本下载地址
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public String getmNewVersionPath()
    {
        if (mNewVersionPath == null || mNewVersionPath.equals(""))
        {
            
            mNewVersionPath = (String)getVaule("mNewVersionPath", "");
            
        }
        return mNewVersionPath;
    }
    
    /**
     * 设置最新版本下载地址 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param mNewVersionPath
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void setmNewVersionPath(String mNewVersionPath)
    {
        this.mNewVersionPath = mNewVersionPath;
        setValue("mNewVersionPath", mNewVersionPath);
    }
    
    /**
     * <一句话功能简述> 更新策略
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public String getmNewUdpolicy()
    {
        if (mNewUdpolicy == null || mNewUdpolicy.equals(""))
        {
            
            mNewUdpolicy = (String)getVaule("mNewUdpolicy", "");
            
        }
        return mNewUdpolicy;
    }
    
    /**
     * <一句话功能简述> 设置更新策略
     * 
     * @Description<功能详细描述>
     * 
     * @param mNewUdpolicy
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void setmNewUdpolicy(String mNewUdpolicy)
    {
        this.mNewUdpolicy = mNewUdpolicy;
        setValue("mNewUdpolicy", mNewUdpolicy);
    }
    
    /**
     * 获取 mNewUpdateLog
     * 
     * @return 返回 mNewUpdateLog
     * @author rqj
     */
    public String getmNewUpdateLog()
    {
        if (mNewUpdateLog == null || mNewUpdateLog.equals(""))
        {
            mNewUpdateLog = (String)getVaule("mNewUpdateLog", "");
        }
        return mNewUpdateLog;
    }
    
    /**
     * 设置 mNewUpdateLog
     * 
     * @param mNewUpdateLog 对mNewUpdateLog进行赋值
     * @author rqj
     */
    public void setmNewUpdateLog(String mNewUpdateLog)
    {
        this.mNewUpdateLog = mNewUpdateLog;
        setValue("mNewUpdateLog", mNewUpdateLog);
    }
    
    /**
     * 控制台是否打印log <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public Boolean getWRITE_LOG()
    {
        return WRITE_LOG;
    }
    
    public void setWRITE_LOG(Boolean wRITE_LOG)
    {
        WRITE_LOG = wRITE_LOG;
    }
    
    /**
     * <一句话功能简述> 是否将log写入sd卡
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public Boolean getSaveLogToSDCard()
    {
        return saveLogToSDCard;
    }
    
    public void setSaveLogToSDCard(Boolean saveLogToSDCard)
    {
        this.saveLogToSDCard = saveLogToSDCard;
    }
    
    /**
     * <一句话功能简述> 获取部门名称
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public String getDepName()
    {
        if (depName == null || depName.equals(""))
        {
            depName = (String)getVaule("depName", "");
        }
        return depName;
    }
    
    public void setDepName(String depName)
    {
        this.depName = depName;
        setValue("depName", depName);
    }
    
    /**
     * 获取 phoneNum
     * 
     * @return 返回 phoneNum
     * @author wl
     */
    public String getPhoneNum()
    {
        if (phoneNum == null || phoneNum.equals(""))
        {
            phoneNum = (String)getVaule("phoneNum", "");
        }
        return phoneNum;
    }
    
    /**
     * 设置 phoneNum
     * 
     * @param phoneNum 对phoneNum进行赋值
     * @author wl
     */
    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
        setValue("phoneNum", phoneNum);
    }
    
    /**
     * 获取 position
     * 
     * @return 返回 position
     * @author wl
     */
    public String getPosition()
    {
        if (position == null || position.equals(""))
        {
            position = (String)getVaule("position", "");
        }
        return position;
    }
    
    /**
     * 设置 position
     * 
     * @param position 对position进行赋值
     * @author wl
     */
    public void setPosition(String position)
    {
        this.position = position;
        setValue("position", position);
    }
    
    /**
     * 获取 email
     * 
     * @return 返回 email
     * @author wl
     */
    public String getEmail()
    {
        
        if (email == null || email.equals(""))
        {
            email = (String)getVaule("email", "");
        }
        return email;
    }
    
    /**
     * 设置 email
     * 
     * @param email 对email进行赋值
     * @author wl
     */
    public void setEmail(String email)
    {
        this.email = email;
        setValue("email", email);
    }
    
    /**
     * 获取 mUserRole
     * 
     * @return 返回 mUserRole
     * @author wl
     */
    public String getmUserRole()
    {
        if (mUserRole == null || mUserRole.equals(""))
        {
            mUserRole = (String)getVaule("mUserRole", "");
        }
        return mUserRole;
    }
    
    /**
     * 设置 mUserRole
     * 
     * @param mUserRole 对mUserRole进行赋值
     * @author wl
     */
    public void setmUserRole(String mUserRole)
    {
        this.mUserRole = mUserRole;
        setValue("mUserRole", mUserRole);
    }
    
    /**
     * 获取 mUserNumber
     * 
     * @return 返回 mUserNumber
     * @author wl
     */
    public String getmUserNumber()
    {
        if (mUserNumber == null || mUserNumber.equals(""))
        {
            mUserNumber = (String)getVaule("mUserNumber", "");
        }
        return mUserNumber;
    }
    
    /**
     * 设置 mUserNumber
     * 
     * @param mUserNumber 对mUserNumber进行赋值
     * @author wl
     */
    public void setmUserNumber(String mUserNumber)
    {
        this.mUserNumber = mUserNumber;
        setValue("mUserNumber", mUserNumber);
    }
    
    /**
     * 获取 mOid
     * 
     * @return 返回 mOid
     * @author wl
     */
    public String getmOid()
    {
        if (mOid == null || mOid.equals(""))
        {
            mOid = (String)getVaule("mOid", "");
        }
        return mOid;
    }
    
    /**
     * 设置 mOid
     * 
     * @param mOid 对mOid进行赋值
     * @author wl
     */
    public void setmOid(String mOid)
    {
        this.mOid = mOid;
        setValue("mOid", mOid);
    }
    
    /**
     * 获取 mOname
     * 
     * @return 返回 mOname
     * @author wl
     */
    public String getmOname()
    {
        if (mOname == null || mOname.equals(""))
        {
            mOname = (String)getVaule("mOname", "");
        }
        return mOname;
    }
    
    /**
     * 设置 mOname
     * 
     * @param mOname 对mOname进行赋值
     * @author wl
     */
    public void setmOname(String mOname)
    {
        this.mOname = mOname;
        setValue("mOname", mOname);
    }
    
    /**
     * <一句话功能简述> 获取sessingId
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public String getSessingId()
    {
        if (SessingId == null || SessingId.equals(""))
        {
            SessingId = (String)getVaule("SessingId", "");
        }
        return SessingId;
    }
    
    /**
     * <一句话功能简述> 设置sessingId
     * 
     * @Description<功能详细描述>
     * 
     * @param sessingId
     * @LastModifiedDate：2015-9-6
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void setSessingId(String sessingId)
    {
        SessingId = sessingId;
        setValue("SessingId", SessingId);
    }
    
    /**
     * @return the loginName
     */
    public String getLoginName()
    {
        if (LoginName == null || LoginName.equals(""))
        {
            LoginName = (String)getVaule("LoginName", "");
        }
        return LoginName;
    }
    
    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName)
    {
        LoginName = loginName;
        setValue("LoginName", LoginName);
    }
    
    public String getDeviceIMEI()
    {
        if (DeviceIMEI == null || DeviceIMEI.equals(""))
        {
            DeviceIMEI = (String)getVaule("DeviceIMEI", "");
        }
        return DeviceIMEI;
    }
    
    public void setDeviceIMEI(String deviceIMEI)
    {
        DeviceIMEI = deviceIMEI;
        setValue("DeviceIMEI", DeviceIMEI);
    }
    
    /**
     * 获取用户id
     */
    public String getOpenId()
    {
        if (OpenId == null || OpenId.equals(""))
        {
            OpenId = (String)getVaule("OpenId", "");
        }
        return OpenId;
    }
    
    /**
     * 设置用户id
     */
    public void setOpenId(String openId)
    {
        OpenId = openId;
        setValue("OpenId", OpenId);
    }
    
    /**
     * 获取用户密码
     */
    public String getPassword()
    {
        
        password = (String)getVaule("password", "");
        password = AesUtil.decrypt(password, MIP_Constant_Core.MOA_deviceKey);
        
        return password;
    }
    
    /**
     * 设置用户密码
     */
    public void setPassword(String mpassword)
    {
        this.password = AesUtil.encrypt(mpassword, MIP_Constant_Core.MOA_deviceKey);
        setValue("password", password);
    }
    
    /**
     * 是否记住用户名
     */
    public boolean isRemember()
    {
        isRemember = (Boolean)getVaule("isRemember", false);
        return isRemember;
    }
    
    /**
     * 设置是否记住用户名
     */
    public void setRemember(boolean isRemember)
    {
        this.isRemember = isRemember;
        setValue("isRemember", isRemember);
    }
    
    /**
     * 是否绑定
     */
    public boolean isBind()
    {
        if (!isBind)
        {
            isBind = (Boolean)getVaule("isBind", false);
        }
        return isBind;
    }
    
    /**
     * 设置是否版本
     */
    public void setBind(boolean isBind)
    {
        this.isBind = isBind;
        setValue("isBind", isBind);
    }
    
    /**
     * 获取部门id
     */
    public String getmDepId()
    {
        if (mDepId == null || "".equals(mDepId))
        {
            mDepId = (String)getVaule("mDepId", "");
        }
        return mDepId;
    }
    
    /**
     * 设置部门id
     */
    public void setmDepId(String mDepId)
    {
        this.mDepId = mDepId;
        setValue("mDepId", mDepId);
    }
    
    /**
     * 获取请求Ip
     */
    public String getmIPAddr()
    {
        if (mIPAddr == null || "".equals(mIPAddr))
        {
            mIPAddr = (String)getVaule("mIPAddr", Constant_Mgr.mConIP);
        }
        
        return mIPAddr;
    }
    
    /**
     * 设置Ip
     */
    public void setmIPAddr(String mIPAddr)
    {
        this.mIPAddr = mIPAddr;
        setValue("mIPAddr", mIPAddr);
        
    }
    
    /**
     * 获取端口
     */
    public String getmPortNum()
    {
        if (mPortNum == null || "".equals(mPortNum))
        {
            mPortNum = (String)getVaule("mPortNum", Constant_Mgr.mConPort);
        }
        
        return mPortNum;
    }
    
    /**
     * 设置端口
     */
    public void setmPortNum(String mPortNum)
    {
        this.mPortNum = mPortNum;
        setValue("mPortNum", mPortNum);
    }
    
    /**
     * @return the mRequestURL
     */
    public String getmRequestURL()
    {
        if (mRequestURL == null || "".equals(mRequestURL))
        {
            mRequestURL = (String)getVaule("mRequestURL", "");
        }
        return mRequestURL;
    }
    
    /**
     * @param mRequestURL the mRequestURL to set
     */
    public void setmRequestURL(String mRequestURL)
    {
        this.mRequestURL = mRequestURL;
        setValue("mRequestURL", mRequestURL);
    }
    
    /**
     * 获取用户名称
     */
    public String getmUserName()
    {
        if (mUserName == null || "".equals(mUserName))
        {
            mUserName = (String)getVaule("mUserName", "");
        }
        return mUserName;
    }
    
    /**
     * 设置用户名称
     */
    public void setmUserName(String mUserName)
    {
        this.mUserName = mUserName;
        setValue("mUserName", mUserName);
    }
    
    /**
     * @return the lastSaveTime
     */
    public String getLastSaveTime()
    {
        if (lastSaveTime == null || lastSaveTime.equals(""))
        {
            lastSaveTime = (String)getVaule("lastSaveTime", "");
        }
        return lastSaveTime;
    }
    
    /**
     * @param lastSaveTime the lastSaveTime to set
     */
    public void setLastSaveTime(String lastSaveTime)
    {
        this.lastSaveTime = lastSaveTime;
        setValue("lastSaveTime", lastSaveTime);
    }
    
    /**
     * 获取心跳时间
     * 
     * @return
     */
    public long getHeartTick()
    {
        if (heartTick == -1)
        {
            heartTick = (Long)getVaule("heartTick", 60 * 1000);
        }
        return heartTick;
    }
    
    /**
     * 设置心跳时间
     * 
     * @param mheartTick
     */
    public void setHeartTick(long mheartTick)
    {
        this.heartTick = mheartTick;
        setValue("heartTick", heartTick);
    }
    
    /**
     * 获取 jHModuleNumber
     * 
     * @return 返回 jHModuleNumber
     * @author rqj
     */
    public int getJHModuleNumber()
    {
        if (JHModuleNumber == 0)
        {
            JHModuleNumber = (Integer)getVaule("JHModuleNumber", 0);
        }
        return JHModuleNumber;
    }
    
    /**
     * 设置 jHModuleNumber
     *
     * @param jHModuleNumber 对jHModuleNumber进行赋值
     * @author rqj
     */
    public void setJHModuleNumber(int jHModuleNumber)
    {
        JHModuleNumber = jHModuleNumber;
        setValue("JHModuleNumber", JHModuleNumber);
    }

    /**
     * @return the mMainActivitClassPath
     */
    public String getmMainActivitClassPath()
    {
        if (mMainActivitClassPath == null || mMainActivitClassPath.equals(""))
        {
            mMainActivitClassPath = (String)getVaule("mMainActivitClassPath", "");
        }
        return mMainActivitClassPath;
    }

    /**
     * @param mMainActivitClassPath the mMainActivitClassPath to set
     */
    public void setmMainActivitClassPath(String mMainActivitClassPath)
    {
        this.mMainActivitClassPath = mMainActivitClassPath;
        setValue("mMainActivitClassPath", mMainActivitClassPath);
    }

    /**
     * @return the mHeartBitTime
     */
    public long getmHeartBitTime()
    {
        if (mHeartBitTime == -1)
        {
            mHeartBitTime = (Long)getVaule("mHeartBitTime", 60 * 1000);
        }
        return mHeartBitTime;
    }

    /**
     * @param mHeartBitTime
     */
    public void setmHeartBitTime(long mHeartBitTime)
    {
        this.mHeartBitTime = mHeartBitTime;
        setValue("mHeartBitTime", mHeartBitTime);
    }

    /**
     * @return the mLastUpdateWeatherTime
     */
    public long getmLastUpdateWeatherTime()
    {
        if (mLastUpdateWeatherTime == 0)
        {
            mLastUpdateWeatherTime = (Long)getVaule("mLastUpdateWeatherTime", 0l);
        }
        return mLastUpdateWeatherTime;
    }

    /**
     * @param mLastUpdateWeatherTime the mLastUpdateWeatherTime to set
     */
    public void setmLastUpdateWeatherTime(long mLastUpdateWeatherTime)
    {
        this.mLastUpdateWeatherTime = mLastUpdateWeatherTime;
        setValue("mLastUpdateWeatherTime", mLastUpdateWeatherTime);
    }

    /**
     * @return the mLastUpdatNewsTime
     */
    public long getmLastUpdatNewsTime()
    {
        if (mLastUpdatNewsTime == 0)
        {
            mLastUpdatNewsTime = (Long)getVaule("mLastUpdatNewsTime", MIP_TimeUtils.getCurrentTimeMills());
        }
        return mLastUpdatNewsTime;
    }

    /**
     * @param mLastUpdatNewsTime the mLastUpdatNewsTime to set
     */
    public void setmLastUpdatNewsTime(long mLastUpdatNewsTime)
    {
        this.mLastUpdatNewsTime = mLastUpdatNewsTime;
        setValue("mLastUpdatNewsTime", mLastUpdatNewsTime);
    }

    @SuppressLint("NewApi")
    public String getDeviceName()
    {
        if (deviceName == null || ("").equals(deviceName))
        {
            deviceName = MIP_DeviceInfoUtils.getDeviceName(this);
        }
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;

        setValue("deviceName", deviceName);
    }

    /**
     * 获取 unCount
     *
     * @return 返回 unCount
     * @author rqj
     */
    public String getUnCount()
    {
        if (unCount == null || ("").equals(unCount))
        {
            unCount = (String)getVaule("unCount", "");
        }
        return unCount;
    }

    /**
     * 设置 unCount
     *
     * @param unCount 对unCount进行赋值
     * @author rqj
     */
    public void setUnCount(String unCount)
    {
        this.unCount = unCount;
        setValue("unCount", unCount);
    }

    /**
     * 获取 mRoomLists
     *
     * @return 返回 mRoomLists
     * @author rqj
     */
    public String getmRoomLists()
    {
        if (mRoomLists == null || ("").equals(mRoomLists))
        {
            mRoomLists = (String)getVaule("mRoomLists", "");
        }
        return mRoomLists;
    }
    
    /**
     * 设置 mRoomLists
     *
     * @param mRoomLists 对mRoomLists进行赋值
     * @author rqj
     */
    public void setmRoomLists(String mRoomLists)
    {
        this.mRoomLists = mRoomLists;
        setValue("mRoomLists", mRoomLists);
    }

    public String getmLastDay()
    {
        if (mLastDay == null || ("").equals(mLastDay))
        {
            mLastDay = (String)getVaule("mLastDay", "");
        }
        return mLastDay;
    }

    public void setmLastDay(String mLastDay)
    {
        this.mLastDay = mLastDay;
        setValue("mLastDay", mLastDay);
    }
    
    // public String getmPositionFlag()
    // {
    // if (mPositionFlag == null || ("").equals(mPositionFlag))
    // {
    // mPositionFlag = (String)getVaule("mPositionFlag", "");
    // }
    // return mPositionFlag;
    // }
    //
    // public void setmPositionFlag(String mPositionFlag)
    // {
    // this.mPositionFlag = mPositionFlag;
    // setValue("mPositionFlag", mPositionFlag);
    // }
    
    /**
     * 获取 mUserId
     *
     * @return 返回 mUserId
     * @author rqj
     */
    public String getmUserId()
    {
        if (mUserId == null || ("").equals(mUserId))
        {
            mUserId = (String)getVaule("mUserId", "");
        }
        return mUserId;
    }
    
    /**
     * 获取 mPersonSign
     *
     * @return 返回 mPersonSign
     * @author wl
     */
    public String getmPersonSign()
    {
        if (mPersonSign == null || ("").equals(mPersonSign))
        {
            mPersonSign = (String)getVaule("mPersonSign", "");
        }
        return mPersonSign;
    }

    /**
     * 设置 mPersonSign
     *
     * @param mPersonSign 对mPersonSign进行赋值
     * @author wl
     */
    public void setmPersonSign(String mPersonSign)
    {
        this.mPersonSign = mPersonSign;
        setValue("mPersonSign", mPersonSign);
    }

    /**
     * 设置 mUserId
     *
     * @param mUserId 对mUserId进行赋值
     * @author rqj
     */
    public void setmUserId(String mUserId)
    {
        this.mUserId = mUserId;
        setValue("mUserId", mUserId);
    }

    /**
     * 获取 mFWSPLastUpdateDateTime
     *
     * @return 返回 mFWSPLastUpdateDateTime
     * @author wl
     */
    public long getmFWSPLastUpdateDateTime()
    {
        if (mFWSPLastUpdateDateTime == 0L)
        {
            mFWSPLastUpdateDateTime = (Long)getVaule("mFWSPLastUpdateDateTime", 0l);
        }
        return mFWSPLastUpdateDateTime;
    }

    /**
     * 设置 mFWSPLastUpdateDateTime
     *
     * @param mFWSPLastUpdateDateTime 对mFWSPLastUpdateDateTime进行赋值
     * @author wl
     */
    public void setmFWSPLastUpdateDateTime(long mFWSPLastUpdateDateTime)
    {
        this.mFWSPLastUpdateDateTime = mFWSPLastUpdateDateTime;
        setValue("mFWSPLastUpdateDateTime", mFWSPLastUpdateDateTime);
    }

    /**
     * 获取 mSWSPLastUpdateDateTime
     *
     * @return 返回 mSWSPLastUpdateDateTime
     * @author wl
     */
    public long getmSWSPLastUpdateDateTime()
    {
        if (mSWSPLastUpdateDateTime == 0L)
        {
            mSWSPLastUpdateDateTime = (Long)getVaule("mSWSPLastUpdateDateTime", 0l);
        }
        return mSWSPLastUpdateDateTime;
    }
    
    /**
     * 设置 mSWSPLastUpdateDateTime
     *
     * @param mSWSPLastUpdateDateTime 对mSWSPLastUpdateDateTime进行赋值
     * @author wl
     */
    public void setmSWSPLastUpdateDateTime(long mSWSPLastUpdateDateTime)
    {
        this.mSWSPLastUpdateDateTime = mSWSPLastUpdateDateTime;
        setValue("mSWSPLastUpdateDateTime", mSWSPLastUpdateDateTime);
    }

    /**
     * 获取 mHYGLLastUpdateDateTime
     *
     * @return 返回 mHYGLLastUpdateDateTime
     * @author wl
     */
    public long getmHYGLLastUpdateDateTime()
    {
        if (mHYGLLastUpdateDateTime == 0L)
        {
            mHYGLLastUpdateDateTime = (Long)getVaule("mHYGLLastUpdateDateTime", 0l);
        }
        return mHYGLLastUpdateDateTime;
    }

    /**
     * 设置 mHYGLLastUpdateDateTime
     *
     * @param mHYGLLastUpdateDateTime 对mHYGLLastUpdateDateTime进行赋值
     * @author wl
     */
    public void setmHYGLLastUpdateDateTime(long mHYGLLastUpdateDateTime)
    {
        this.mHYGLLastUpdateDateTime = mHYGLLastUpdateDateTime;
        setValue("mHYGLLastUpdateDateTime", mHYGLLastUpdateDateTime);
    }

    public long getmLastUpdateDateTime()
    {
        if (mLastUpdateDateTime == 0L)
        {
            mLastUpdateDateTime = (Long)getVaule("mLastUpdateDateTime", 0l);
        }
        return mLastUpdateDateTime;
    }

    public void setmLastUpdateDateTime(long mLastUpdateDateTime)
    {
        this.mLastUpdateDateTime = mLastUpdateDateTime;
        setValue("mLastUpdateDateTime", mLastUpdateDateTime);
    }

    /**
     * 获取 mZLXMLastUpdateDateTime
     *
     * @return 返回 mZLXMLastUpdateDateTime
     * @author rqj
     */
    public long getmZLXMLastUpdateDateTime()
    {
        if (mZLXMLastUpdateDateTime == 0L)
        {
            mZLXMLastUpdateDateTime = (Long)getVaule("mZLXMLastUpdateDateTime", 0l);
        }
        return mZLXMLastUpdateDateTime;
    }

    /**
     * 设置 mZLXMLastUpdateDateTime
     *
     * @param mZLXMLastUpdateDateTime 对mZLXMLastUpdateDateTime进行赋值
     * @author rqj
     */
    public void setmZLXMLastUpdateDateTime(long mZLXMLastUpdateDateTime)
    {
        this.mZLXMLastUpdateDateTime = mZLXMLastUpdateDateTime;
        setValue("mZLXMLastUpdateDateTime", mZLXMLastUpdateDateTime);
    }

    /**
     * 获取 mLastPTKBTime
     *
     * @return 返回 mLastPTKBTime
     * @author rqj
     */
    public String getmLastPTKBTime()
    {
        if (mLastPTKBTime == null || mLastPTKBTime.equals(""))
        {
            mLastPTKBTime = (String)getVaule("mLastPTKBTime", "");
        }
        return mLastPTKBTime;
    }
    
    /**
     * 设置 mLastPTKBTime
     *
     * @param mLastPTKBTime 对mLastPTKBTime进行赋值
     * @author rqj
     */
    public void setmLastPTKBTime(String mLastPTKBTime)
    {
        this.mLastPTKBTime = mLastPTKBTime;
        setValue("mLastPTKBTime", mLastPTKBTime);
    }

    /**
     * 获取 mLastQMYSTime
     *
     * @return 返回 mLastQMYSTime
     * @author rqj
     */
    public String getmLastQMYSTime()
    {
        if (mLastQMYSTime == null || mLastQMYSTime.equals(""))
        {
            mLastQMYSTime = (String)getVaule("mLastQMYSTime", "");
        }
        return mLastQMYSTime;
    }

    /**
     * 设置 mLastQMYSTime
     *
     * @param mLastQMYSTime 对mLastQMYSTime进行赋值
     * @author rqj
     */
    public void setmLastQMYSTime(String mLastQMYSTime)
    {
        this.mLastQMYSTime = mLastQMYSTime;
        setValue("mLastQMYSTime", mLastQMYSTime);
    }
    
    /**
     * 获取 mLastSendStepTime
     *
     * @return 返回 mLastSendStepTime
     * @author rqj
     */
    public long getmLastSendStepTime()
    {
        if (mLastSendStepTime == 0L)
        {
            mLastSendStepTime = (Long)getVaule("mLastDay", 0L);
        }
        return mLastSendStepTime;
    }

    /**
     * 设置 mLastSendStepTime
     *
     * @param mLastSendStepTime 对mLastSendStepTime进行赋值
     * @author rqj
     */
    public void setmLastSendStepTime(long mLastSendStepTime)
    {
        this.mLastSendStepTime = mLastSendStepTime;
        setValue("mLastSendStepTime", mLastSendStepTime);
    }



    /**
     * 获取 isNewXXNotice
     *
     * @return 返回 isNewXXNotice
     * @author rqj
     */
    public boolean isNewXXNotice()
    {
        if (!isNewXXNotice)
        {
            isNewXXNotice = (Boolean)getVaule("isNewXXNotice", false);
        }
        return isNewXXNotice;
    }

    /**
     * 设置 isNewXXNotice
     *
     * @param isNewXXNotice 对isNewXXNotice进行赋值
     * @author rqj
     */
    public void setNewXXNotice(boolean isNewXXNotice)
    {
        this.isNewXXNotice = isNewXXNotice;
        setValue("isNewXXNotice", isNewXXNotice);
    }

    /**
     * 获取 isMDRXX
     *
     * @return 返回 isMDRXX
     * @author rqj
     */
    public boolean isMDRXX()
    {
        if (!isMDRXX)
        {
            isMDRXX = (Boolean)getVaule("isMDRXX", false);
        }
        return isMDRXX;
    }

    /**
     * 设置 isMDRXX
     *
     * @param isMDRXX 对isMDRXX进行赋值
     * @author rqj
     */
    public void setMDRXX(boolean isMDRXX)
    {
        this.isMDRXX = isMDRXX;
        setValue("isMDRXX", isMDRXX);
    }

    /**
     * 获取 isSoundXX
     *
     * @return 返回 isSoundXX
     * @author rqj
     */
    public boolean isSoundXX()
    {
        if (!isSoundXX)
        {
            isSoundXX = (Boolean)getVaule("isSoundXX", false);
        }
        return isSoundXX;
    }

    /**
     * 设置 isSoundXX
     *
     * @param isSoundXX 对isSoundXX进行赋值
     * @author rqj
     */
    public void setSoundXX(boolean isSoundXX)
    {
        this.isSoundXX = isSoundXX;
        setValue("isSoundXX", isSoundXX);
    }
    
    /**
     * 获取 isZDXX
     *
     * @return 返回 isZDXX
     * @author rqj
     */
    public boolean isZDXX()
    {
        if (!isZDXX)
        {
            isZDXX = (Boolean)getVaule("isZDXX", false);
        }
        return isZDXX;
    }

    /**
     * 设置 isZDXX
     *
     * @param isZDXX 对isZDXX进行赋值
     * @author rqj
     */
    public void setZDXX(boolean isZDXX)
    {
        this.isZDXX = isZDXX;
        setValue("isZDXX", isZDXX);
    }
    
    /**
     * 获取 isBaiduPush
     *
     * @return 返回 isBaiduPush
     * @author rqj
     */
    public boolean isBaiduPush()
    {
        if (!isBaiduPush)
        {
            isBaiduPush = (Boolean)getVaule("isBaiduPush", false);
        }
        return isBaiduPush;
    }

    /**
     * 设置 isBaiduPush
     *
     * @param isBaiduPush 对isBaiduPush进行赋值
     * @author rqj
     */
    public void setBaiduPush(boolean isBaiduPush)
    {
        this.isBaiduPush = isBaiduPush;
        setValue("isBaiduPush", isBaiduPush);
    }

    /**
     * 获取 mXXUncountTotal
     *
     * @return 返回 mXXUncountTotal
     * @author rqj
     */
    public int getmXXUncountTotal()
    {
        if (mXXUncountTotal == 0)
        {
            mXXUncountTotal = (Integer)getVaule("mXXUncountTotal", 0);
        }
        return mXXUncountTotal;
    }

    /**
     * 设置 mXXUncountTotal
     *
     * @param mXXUncountTotal 对mXXUncountTotal进行赋值
     * @author rqj
     */
    public void setmXXUncountTotal(int mXXUncountTotal)
    {
        this.mXXUncountTotal = mXXUncountTotal;
        setValue("mXXUncountTotal", mXXUncountTotal);
    }

    /**
     * 获取 scheduleAlartTime
     *
     * @return 返回 scheduleAlartTime
     * @author rqj
     */
    public int getScheduleAlartTime()
    {
        if (scheduleAlartTime == 30)
        {
            scheduleAlartTime = (Integer)getVaule("scheduleAlartTime", 30);
        }
        return scheduleAlartTime;
    }

    /**
     * 设置 scheduleAlartTime
     *
     * @param scheduleAlartTime 对scheduleAlartTime进行赋值
     * @author rqj
     */
    public void setScheduleAlartTime(int scheduleAlartTime)
    {
        this.scheduleAlartTime = scheduleAlartTime;
        setValue("scheduleAlartTime", scheduleAlartTime);
    }

    /**
     * 获取 mlockstatu
     *
     * @return 返回 mlockstatu
     * @author rqj
     */
    public String getMlockstatu()
    {
        if (mlockstatu == null || mlockstatu.equals(""))
        {
            mlockstatu = (String)getVaule("mlockstatu", "");
        }
        return mlockstatu;
    }

    /**
     * 设置 mlockstatu
     *
     * @param mlockstatu 对mlockstatu进行赋值
     * @author rqj
     */
    public void setMlockstatu(String mlockstatu)
    {
        this.mlockstatu = mlockstatu;
        setValue("mlockstatu", mlockstatu);
    }
    
    
    

    private String                   mMethodName        = "";
    //是否记录日志
    private  boolean recordLog = false;
    //是否由用户停止
    private  boolean isRestartService ;
    private  String devicetype=""; //"设备类型",
    private  String devicecode =  ""; //"设备编号",
    private  String corpid =  "";//"企业id",
    private  String userid =  ""; //"人员id",
    private String username  = ""; //"人员姓名",
    private  String userphoto =  ""; //"人员头像",

    private  String deptname="";
    private  String distance="";
    private String timing="";
    /**
     * 获取url方法名
     */
    public String getmMethodName()
    {
        if (mMethodName == null || "".equals(mMethodName))
        {
            mMethodName = (String)getVaule("mMethodName", "/reportUserNewPosition");
        }

        return mMethodName;
    }

    /**
     * 设置url方法名
     */
    public void setmMethodName(String mMethodName)
    {
        this.mMethodName = mMethodName;
        setValue("mMethodName", mMethodName);
    }


    /*public boolean isrecordLog()
    {
        if (!recordLog)
        {
            recordLog = (Boolean)getVaule("recordLog", false);
        }
        return recordLog;
    }


    public void setRecordLog(boolean recordLog)
    {
        this.recordLog = recordLog;
        setValue("recordLog", recordLog);
    }

    public boolean isRestartService()
    {
        if (!isRestartService)
        {
            isRestartService = (Boolean)getVaule("isRestartService", false);
        }
        return isRestartService;
    }


    public void setRestartService(boolean isRestartService)
    {
        this.isRestartService = isRestartService;
        setValue("isRestartService", isRestartService);
    }

    
    
    public String getDevicetype()
    {
        if (devicetype == null || "".equals(devicetype))
        {
            devicetype = (String)getVaule("devicetype", "");
        }

        return devicetype;
    }

    public void setDevicetype(String devicetype)
    {
        this.devicetype = devicetype;
        setValue("devicetype", devicetype);
    }
    public String getDevicecode()
    {
        if (devicecode == null || "".equals(devicecode))
        {
            devicecode = (String)getVaule("devicecode", "");
        }

        return devicecode;
    }

    public void setDevicecode(String devicecode)
    {
        this.devicecode = devicecode;
        setValue("devicecode", devicecode);
    }
    
    public String getUserid()
    {
        if (userid == null || "".equals(userid))
        {
            userid = (String)getVaule("userid", "");
        }

        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
        setValue("userid", userid);
    }

    public String getUsername()
    {
        if (username == null || "".equals(username))
        {
            username = (String)getVaule("username", "");
        }

        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
        setValue("username", username);
    }
    
    public String getUserphoto()
    {
        if (userphoto == null || "".equals(userphoto))
        {
            userphoto = (String)getVaule("userphoto", "");
        }

        return userphoto;
    }

    public void setUserphoto(String userphoto)
    {
        this.userphoto = userphoto;
        setValue("userphoto", userphoto);
    }
    
    
    public String getDeptname()
    {
        if (deptname == null || "".equals(deptname))
        {
            deptname = (String)getVaule("deptname", "");
        }

        return deptname;
    }

    public void setDeptname(String deptname)
    {
        this.deptname = deptname;
        setValue("deptname", deptname);
    }


    public String getDistance()
    {
        if (distance == null || "".equals(distance))
        {
            distance = (String)getVaule("distance", "");
        }

        return distance;
    }

    public void setDistance(String distance)
    {
        this.distance = distance;
        setValue("distance", distance);
    }

    public String getTiming()
    {
        if (timing == null || "".equals(timing))
        {
            timing = (String)getVaule("timing", "");
        }

        return timing;
    }

    public void setTiming(String timing)
    {
        this.timing = timing;
        setValue("timing", timing);
    }



    public String getCorpid()
    {
        if (corpid == null || "".equals(corpid))
        {
            corpid = (String)getVaule("corpid", "");
        }

        return corpid;
    }

    public void setCorpid(String corpid)
    {
        this.corpid = corpid;
        setValue("corpid", corpid);
    }
    
    */


}
