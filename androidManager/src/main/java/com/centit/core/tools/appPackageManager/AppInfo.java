package com.centit.core.tools.appPackageManager;

import java.io.Serializable;

public class AppInfo implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            appName          = "";
    
    private String            packageName      = "";
    
    private String            versionName      = "";
    
    private int               versionCode      = 0;
    
    // private Drawable appIcon=null;
    
    private Boolean           isShortCut       = false;
    
    private int               bgColorRes       = -1;
    
    private int               bgSpace          = -1;
    
    private boolean           isAddApp         = false;
    
    private String            teamid           = "";
    
    private String            appid            = "";
    
    public String getAppName()
    {
        return appName;
    }
    
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    
    public String getPackageName()
    {
        return packageName;
    }
    
    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }
    
    public String getVersionName()
    {
        return versionName;
    }
    
    public void setVersionName(String versionName)
    {
        this.versionName = versionName;
    }
    
    public int getVersionCode()
    {
        return versionCode;
    }
    
    public void setVersionCode(int versionCode)
    {
        this.versionCode = versionCode;
    }
    
    // public Drawable getAppIcon() {
    // return appIcon;
    // }
    //
    // public void setAppIcon(Drawable appIcon) {
    // this.appIcon = appIcon;
    // }
    
    public Boolean getIsShortCut()
    {
        return isShortCut;
    }
    
    public void setIsShortCut(Boolean isShortCut)
    {
        this.isShortCut = isShortCut;
    }
    
    public int getBgColorRes()
    {
        return bgColorRes;
    }
    
    public void setBgColorRes(int bgColorRes)
    {
        this.bgColorRes = bgColorRes;
    }
    
    public int getBgSpace()
    {
        return bgSpace;
    }
    
    public void setBgSpace(int bgSpace)
    {
        this.bgSpace = bgSpace;
    }
    
    /**
     * 获取 isAddApp
     * 
     * @return 返回 isAddApp
     * @author ren_qiujing
     */
    public boolean isAddApp()
    {
        return isAddApp;
    }
    
    /**
     * 设置 isAddApp
     * 
     * @param isAddApp 对isAddApp进行赋值
     * @author ren_qiujing
     */
    public void setAddApp(boolean isAddApp)
    {
        this.isAddApp = isAddApp;
    }
    
    /**
     * 获取 teamid
     * 
     * @return 返回 teamid
     * @author ren_qiujing
     */
    public String getTeamid()
    {
        return teamid;
    }
    
    /**
     * 设置 teamid
     * 
     * @param teamid 对teamid进行赋值
     * @author ren_qiujing
     */
    public void setTeamid(String teamid)
    {
        this.teamid = teamid;
    }
    
    /**
     * 获取 appid
     * 
     * @return 返回 appid
     * @author ren_qiujing
     */
    public String getAppid()
    {
        return appid;
    }
    
    /**
     * 设置 appid
     * 
     * @param appid 对appid进行赋值
     * @author ren_qiujing
     */
    public void setAppid(String appid)
    {
        this.appid = appid;
    }
    
}
