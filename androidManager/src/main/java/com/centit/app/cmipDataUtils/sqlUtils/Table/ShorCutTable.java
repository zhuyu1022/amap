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
 * @author 
 * @version 1.0
 * @createDate 2013-3-13
 */
public class ShorCutTable implements BaseColumns {

	public static final int ShorCut_INFO = Constant_DB.SHORTCUT_FLAG;

	public static final String TABLE_NAME = "shortCutTable";

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

	/**
	 * 功能code
	 */
	public static final String TYPE = "type";

	public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_NAME + "(" + ShorCutTable.OPENID + " TEXT ,"
			+ ShorCutTable.FUNNAME + " TEXT ," + ShorCutTable.FUNCODE
			+ " TEXT ," + ShorCutTable.TYPE + " TEXT )";

	/**
	 * the SQL for dropping database
	 */
	public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	public static void getUriMatcherMailInfo(UriMatcher MATHCER) {
		MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, ShorCut_INFO);
	}
}
