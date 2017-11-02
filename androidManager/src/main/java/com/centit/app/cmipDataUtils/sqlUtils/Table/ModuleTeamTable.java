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
public class ModuleTeamTable implements BaseColumns {

	public static final int MODULE_INFO = Constant_DB.MODULE_FLAG;

	public static final String TABLE_NAME = "moduleInfoTable";

	public static final Uri CONTENT_URI = Uri.parse("content://"
			+ Constant_DB.AUTHORITY + "/" + TABLE_NAME);

	/**
	 * 当前用户ID
	 */
	public static final String OPENID = "openId";
	/**
	 * 功能名称
	 */
	public static final String FUNNAME = "funname";

	/**
	 * 功能code
	 */
	public static final String FUNCODE = "funcode";

	// 对于功能的跳转的Activity的路径，对于应用的报名
	public static final String FUNCLASSPATH = "funclasspath";

	public static final String FUNICON = "funicon";

	/**
	 * 类型 0:添加，1:功能， 2:应用 3 web应用
	 */
	public static final String TYPE = "type";

	public static final String VALUE = "value";

	// 是否有权限被添加
	public static final String ISABLE = "isAble";

	// 是否被添加
	public static final String ISADD = "isAdd";
	// 排序
	public static final String SORT = "sort";
	
	//分类中的排序
	public static final String TEAMSORT = "teamsort";
	
	//是否能够获取未读数/待办数
	public static final String COUNT_ABLE = "count_able";
	
	//模板1下数量的图标
	public static final String COUNT_ICON_1 = "count_icon_1";
	
	//模板2下数量的图标
	public static final String COUNT_ICON_2 = "count_icon_2";
	
	//父功能code
	public static final String PCODE = "pcode";
	
	//父功能名称
	public static final String PNAME = "pname";
	
	public static final String ATTAHCURL = "attachURL";
	
	//图标下载地址
	public static final String ICONURL = "iconURL";
	
	//应用包名版本号
	public static final String VERSION = "version";
	
	public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_NAME + "(" + ModuleTeamTable._ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ ModuleTeamTable.OPENID+ " TEXT," 
			+ ModuleTeamTable.FUNNAME + " TEXT," 
			+ ModuleTeamTable.FUNCODE+ " TEXT," 
			+ ModuleTeamTable.FUNCLASSPATH+ " TEXT," 
			+ ModuleTeamTable.FUNICON+ " TEXT," 
			+ ModuleTeamTable.VALUE+ " TEXT," 
			+ ModuleTeamTable.ISABLE+ " TEXT," 
			+ ModuleTeamTable.ISADD+ " TEXT," 
			+ ModuleTeamTable.COUNT_ABLE+ " TEXT," 
			+ ModuleTeamTable.COUNT_ICON_1+ " TEXT," 
			+ ModuleTeamTable.COUNT_ICON_2+ " TEXT,"
			+ ModuleTeamTable.PCODE+ " TEXT," 
			+ ModuleTeamTable.PNAME+ " TEXT,"
			+ ModuleTeamTable.ATTAHCURL+ " TEXT,"
			+ ModuleTeamTable.ICONURL+ " TEXT,"
			+ ModuleTeamTable.VERSION+ " TEXT,"
			+ ModuleTeamTable.SORT+ " int," 
			+ ModuleTeamTable.TEAMSORT+ " int," 
			+ ModuleTeamTable.TYPE + " TEXT )";

	/**
	 * the SQL for dropping database
	 */
	public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	public static void getUriMatcherMailInfo(UriMatcher MATHCER) {
		MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, MODULE_INFO);
	}
}
