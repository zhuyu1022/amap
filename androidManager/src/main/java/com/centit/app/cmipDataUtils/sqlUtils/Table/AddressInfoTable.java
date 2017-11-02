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
public class AddressInfoTable implements BaseColumns
{
    
    public static final int    ADDRESS_INFO     = Constant_DB.ADDRESSINFO_FLAG;
    
    public static final String TABLE_NAME       = "addressInfoTable";
    
    public static final Uri    CONTENT_URI      = Uri.parse("content://" + Constant_DB.AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * 当前用户ID
     */
    public static final String OPENID           = "openId";
    
    /**
     * 名称
     */
    public static final String NAME             = "name";
    
    /**
     * 当前ID
     */
    public static final String MCURID           = "mcurid";
    
    /**
     * 父节点iD
     */
    public static final String MPID             = "mpid";
    
    /**
     * 是否是部门，true(1) 是， false(0) 不是（该属性为用户）
     */
    public static final String ISDEP            = "isdep";
    
    /**
     * 办公室号码（属性为用户时）
     */
    public static final String OFFICE           = "office";
    
    /**
     * 办公室号码（属性为用户时）
     */
    public static final String OFFNUM           = "offnum";
    
    /**
     * 手机号码（属性为用户时）
     */
    public static final String MOBILE           = "mobile";
    
    /**
     * 邮件（属性为用户时）
     */
    public static final String EMAIL            = "email";
    
    /**
     * 是否展开（属性为用户时）true(1) 是， false(0)
     */
    public static final String ISARROW          = "isarrow";
    
    // position
    public static final String NUM              = "num";
    
    public static final String PNAME            = "pname";
    
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                                                    + AddressInfoTable.OPENID + " TEXT ," + AddressInfoTable.NAME
                                                    + " TEXT ," + AddressInfoTable.MCURID + " TEXT ,"
                                                    + AddressInfoTable.MPID + " TEXT ," + AddressInfoTable.ISDEP
                                                    + "  TEXT ," + AddressInfoTable.OFFICE + " TEXT ,"
                                                    + AddressInfoTable.OFFNUM + " TEXT ," + AddressInfoTable.MOBILE
                                                    + " TEXT ," + AddressInfoTable.EMAIL + " TEXT ,"
                                                    + AddressInfoTable.NUM + " TEXT ," + AddressInfoTable.PNAME
                                                    + " TEXT ," + AddressInfoTable.ISARROW + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL   = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, ADDRESS_INFO);
    }
}
