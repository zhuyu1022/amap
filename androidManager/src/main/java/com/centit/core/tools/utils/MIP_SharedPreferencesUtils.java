package com.centit.core.tools.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.centit.core.tools.logManger.LogUtil;

/**
 * sharePreference处理操作
 * 
 * @author ren_qiujing
 * 
 */
public class MIP_SharedPreferencesUtils
{
    /**
     * 设置变量到sharePrefernce中
     * 
     * @param key
     * @param value
     */
    public static void setValueToSharePre(Context mContext, String share_name, String key, Object value)
    {
        SharedPreferences sharedoPreferences = mContext.getSharedPreferences(share_name, Context.MODE_PRIVATE);
        Editor editor = sharedoPreferences.edit();
        
        if (value instanceof String)
        {
            
            editor.putString(key, (String)value);
            
        }
        else if (value instanceof Integer)
        {
            
            editor.putInt(key, (Integer)value);
            
        }
        else if (value instanceof Long)
        {
            
            editor.putLong(key, (Long)value);
            
        }
        else if (value instanceof Float)
        {
            editor.putFloat(key, (Float)value);
            
        }
        else if (value instanceof Boolean)
        {
            editor.putBoolean(key, (Boolean)value);
        }
        else
        {
            LogUtil.i("setValueToSharePre  no matching type");
        }
        
        editor.commit();
    }
    
    public static Object getValeFromSharePre(Context mContext, String share_name, String key, Object defValue)
    {


        SharedPreferences sharedoPreferences = mContext.getSharedPreferences(share_name, Context.MODE_PRIVATE);
        
        if (defValue instanceof String)
        {
            
            return sharedoPreferences.getString(key, (String)defValue);
            
        }
        else if (defValue instanceof Integer)
        {
            
            return sharedoPreferences.getInt(key, (Integer)defValue);
            
        }
        else if (defValue instanceof Long)
        {
            
            return sharedoPreferences.getLong(key, (Long)defValue);
            
        }
        else if (defValue instanceof Float)
        {
            return sharedoPreferences.getFloat(key, (Float)defValue);
            
        }
        else if (defValue instanceof Boolean)
        {
            return sharedoPreferences.getBoolean(key, (Boolean)defValue);
            
        }
        else
        {
            LogUtil.i("setValueToSharePre  no matching type");
        }
        
        return defValue;
    }
    
}
