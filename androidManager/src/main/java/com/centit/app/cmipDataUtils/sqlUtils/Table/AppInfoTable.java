/**
 * Author : Agero
 * Copyright (c) 2011 Agero.
 * All rights reserved
 */

package com.centit.app.cmipDataUtils.sqlUtils.Table;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;

/**
 * 
 * 
 * @author shen_feng
 * @version 1.0
 * @createDate 2013-3-13
 */
public class AppInfoTable implements BaseColumns {

	public static final int APP_INFO = Constant_DB.APPINFO_FLAG;

	public static final String TABLE_NAME = "appInfoTable";

	public static final Uri CONTENT_URI = Uri.parse("content://"
			+ Constant_DB.AUTHORITY + "/" + TABLE_NAME);

	/**
	 * 当前用户ID
	 */
	public static final String OPENID = "openId";

	/**
	 * 应用名称
	 */
	public static final String APPNAME = "appName";

	/**
	 * 应用包名
	 */
	public static final String APPPACKAGE = "packageName";

	/**
	 * 应用版本
	 */
	public static final String APPVersionName = "appVersionname";

	/**
	 * 应用版本
	 */
	public static final String APPVersionCode = "appVersioncode";

	/**
	 * 是否添加到桌面，1 添加到，0 未添加
	 */
	public static final String SHOTCUT = "shortcut";

	/**
	 * 应用组id
	 */
	public static final String TEAMID = "teamid";
	/**
	 * 应用的id
	 */
	public static final String APPID = "appid";

	public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_NAME + "(" + AppInfoTable.OPENID + " TEXT ,"
			+ AppInfoTable.APPNAME + " TEXT ," + AppInfoTable.APPPACKAGE
			+ " TEXT ," + AppInfoTable.APPVersionName + " TEXT ,"
			+ AppInfoTable.TEAMID + " TEXT ," + AppInfoTable.APPVersionCode
			+ " Integer ," + AppInfoTable.SHOTCUT + " TEXT ,"
			+ AppInfoTable.APPID + " TEXT )";

	/**
	 * the SQL for dropping database
	 */
	public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	public static void getUriMatcherMailInfo(UriMatcher MATHCER) {
		MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, APP_INFO);
	}
}
