package com.centit.core.tools.utils;

import android.content.res.Resources;

import com.centit.GlobalState;

public class MIP_R
{
	/**
     * 根据资源名称获取资源的id
     * 
     * @param mContext
     * @param name
     * @param defType
     * @return
     */
    private static int getResId(String name, String defType)
    {
    	String pageName = GlobalState.getInstance().getApplicationContext().getPackageName();
        Resources mResources = GlobalState.getInstance().getResources();
        return mResources.getIdentifier(name, defType, pageName);
    }
    
    /**
     * 获取String型资源的ID
     * 
     * @param name
     * @return
     */
    public  static int String(String name)
    {
        return getResId(name, "string");
    }
    
    /**
     * 获取Color型资源的ID
     * 
     * @param name
     * @return
     */
    public  static int Color(String name)
    {
        return getResId(name, "color");
    }
    
    /**
     * 获取布局文件中某个id型资源的ID
     * 
     * @param name
     * @return
     */
    public  static int Id(String name)
    {
        return getResId(name, "id");
    }
    
    /**
     * 获取Drawable型资源的ID
     * 
     * @param name
     * @return
     */
    public  static int Drawable(String name)
    {
        return getResId(name, "drawable");
    }
    
    /**
     * 获取Style型资源的ID
     * 
     * @param name
     * @return
     */
    public  static int Style(String name)
    {
        return getResId(name, "style");
    }
    
    /**
     * 获取Layout型资源的ID
     * 
     * @param name
     * @return
     */
    public  static int Layout(String name)
    {
        return getResId(name, "layout");
    }
}
