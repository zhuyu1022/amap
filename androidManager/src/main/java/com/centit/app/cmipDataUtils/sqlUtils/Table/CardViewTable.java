package com.centit.app.cmipDataUtils.sqlUtils.Table;

import android.R.integer;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;

public class CardViewTable implements BaseColumns {

	public static final int CardView_INFO = Constant_DB.CARDVIEW_FLAG;

	public static final String TABLE_NAME = "cardviewTable";

	public static final Uri CONTENT_URI = Uri.parse("content://"
			+ Constant_DB.AUTHORITY + "/" + TABLE_NAME);

	//当前用户ID
	public static final String OPENID = "openId";
	
	//属于那种模板ID
	public static final String PAGEID = "pageid";

	//cardview的唯一id
	public static final String CARDCODE = "cardcode";

	//cardView名称
	public static final String CARDNAME = "cardname";

	//cardview 关联的页面路径
	public static final String CARDCLASSPATH = "cardclasspath";
	
	//是否可以编辑，0不可以编辑，必须显示、1 可以被编辑
	public static final String EDITABLE = "editable";
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	
	//是否有权限显示该card 0 有， 1 否
	public static final String ISABLE = "isable";
	
	//是否被添加  0 是，1 否
	public static final String ISADD = "isadd";
	
	//排序号
	public static final String SORT = "sort";
	
	//icon
	public static final String ICON = "icon";

	public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_NAME + "("
			+ CardViewTable.OPENID + " TEXT ,"
			+ CardViewTable.PAGEID + " TEXT ,"
			+ CardViewTable.CARDCODE+ " TEXT ,"
			+ CardViewTable.CARDNAME+ " TEXT ,"
			+ CardViewTable.CARDCLASSPATH+ " TEXT ,"
			+ CardViewTable.EDITABLE+ " TEXT ,"
			+ CardViewTable.TYPE+ " TEXT ,"
			+ CardViewTable.ISABLE+ " TEXT ,"
			+ CardViewTable.ISADD+ " TEXT ,"
			+ CardViewTable.ICON+ " TEXT ,"
			+ CardViewTable.SORT+ " INTEGER ,"
			+ CardViewTable.VALUE + " TEXT )";

	/**
	 * the SQL for dropping database
	 */
	public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	public static void getUriMatcherMailInfo(UriMatcher MATHCER) {
		MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, CardView_INFO);
	}

}
