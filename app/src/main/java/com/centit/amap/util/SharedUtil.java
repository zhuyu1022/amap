package com.centit.amap.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedUtil {
	//记录是否是第一次运行
	public static final String isFirstLaunch = "isFirstLaunch";
	public static final String USERBEAN = "userBean";
	public static final String funcode = "funcode";
	public static final String lname = "lname";


	//是否由用户停止
	public static final String isRestartService = "isRestartService";


    public static final String devicetype="devicetype"; //"设备类型",
    public static final String devicecode =  "devicecode"; //"设备编号",
    public static final String corpid =  "corpid";//"企业id",
    public static final String userid =  "userid"; //"人员id",
	public static final String userphoto  = "userphoto"; //"人员姓名",
    public static final String username  = "username"; //"人员姓名",
	public static final String departmentid="departmentid";
	public static final String departmentname="departmentname";
	public static final String systemversion="systemversion";

	public static final String distance="distance";
	public static final String timing="timing";
	public static final String switch_flag="switch_flag";
		//截至时间
	public static final String endTime="endTime";


	public static void putValue(Context context, String key, Object value) {
		if (value==null){
			return;
		}
		String type = value.getClass().getSimpleName();
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		if ("Integer".equals(type)) {
			editor.putInt(key, (Integer) value);
		} else if ("Boolean".equals(type)) {
			editor.putBoolean(key, (Boolean) value);
		} else if ("String".equals(type)) {
			editor.putString(key, (String) value);
		} else if ("Float".equals(type)) {
			editor.putFloat(key, (Float) value);
		} else if ("Long".equals(type)) {
			editor.putLong(key, (Long) value);
		}
		editor.commit();
	}

	public static Object getValue(Context context, String key, Object defValue) {
		String type = defValue.getClass().getSimpleName();
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		// defValue为为默认值，如果当前获取不到数据就返回它
		if ("Integer".equals(type)) {
			return sharedPreferences.getInt(key, (Integer) defValue);
		} else if ("Boolean".equals(type)) {
			return sharedPreferences.getBoolean(key, (Boolean) defValue);
		} else if ("String".equals(type)) {
			return sharedPreferences.getString(key, (String) defValue);
		} else if ("Float".equals(type)) {
			return sharedPreferences.getFloat(key, (Float) defValue);
		} else if ("Long".equals(type)) {
			return sharedPreferences.getLong(key, (Long) defValue);
		}
		return null;
	}
}
