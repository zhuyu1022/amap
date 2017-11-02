/**
 * Author : hoperun
 * Copyright (c) 2011 hoperun.
 * All rights reserved
 */

package com.centit.app.cmipDataUtils.sqlUtils.SQLCreator;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;
import com.centit.app.cmipDataUtils.sqlUtils.SqlException;
import com.centit.app.cmipDataUtils.sqlUtils.Table.AddressInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.AppInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.CardViewTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ChatMessageTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ChatRoomTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.FileInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ModuleTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ShorCutTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.UserInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.VedioSeriseInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.XXZXDETAILInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.Table.XXZXTYPEInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.dbHelp.MIPDatabaseHelper;

/**
 * ContentProvider
 * 
 * @author mazhicheng
 * @version 1.0
 */
public class MIPDBProvider extends ContentProvider
{
    
    private static final UriMatcher MATHCER = new UriMatcher(UriMatcher.NO_MATCH);
    
    @SuppressWarnings("unused")
    private static final String     TAG     = "MIPProvider";
    
    private MIPDatabaseHelper       MIPProvider;
    
    static
    {
        
        UserInfoTable.getUriMatcherMailInfo(MATHCER);
        ModuleTable.getUriMatcherMailInfo(MATHCER);
        AddressInfoTable.getUriMatcherMailInfo(MATHCER);
        FileInfoTable.getUriMatcherMailInfo(MATHCER);
        ShorCutTable.getUriMatcherMailInfo(MATHCER);
        CardViewTable.getUriMatcherMailInfo(MATHCER);
        AppInfoTable.getUriMatcherMailInfo(MATHCER);
        VedioSeriseInfoTable.getUriMatcherMailInfo(MATHCER);
        
        ChatRoomTable.getUriMatcherMailInfo(MATHCER);
        ChatMessageTable.getUriMatcherMailInfo(MATHCER);
        
        XXZXTYPEInfoTable.getUriMatcherMailInfo(MATHCER);
        XXZXDETAILInfoTable.getUriMatcherMailInfo(MATHCER);
    }
    
    @Override
    public boolean onCreate()
    {
        if (null == MIPProvider)
        {
            MIPProvider = new MIPDatabaseHelper(this.getContext());
            MIPProvider.getReadableDatabase();
        }
        return (null == MIPProvider) ? false : true;
    }
    
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        String tableName = getTableName(uri);
        if (null == tableName)
        {
            throw new IllegalArgumentException(Constant_DB.CONTENTPROVIDER_UNRECOGNIZED_URI + uri);
        }
        SQLiteDatabase db = MIPProvider.getWritableDatabase();
        int row = db.delete(tableName, selection, selectionArgs);
        if (row > 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        
        return row;
    }
    
    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        if ((null == values) || (0 == values.size()) || (null == uri))
        {
            return null;
        }
        
        String tableName = getTableName(uri);
        if (null == tableName)
        {
            throw new IllegalArgumentException(Constant_DB.CONTENTPROVIDER_UNRECOGNIZED_URI + uri);
        }
        
        SQLiteDatabase db = MIPProvider.getWritableDatabase();
        long row = db.insert(tableName, null, values);
        // long row = db.replace(tableName, "NULL", values);
        if (row > 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
            return ContentUris.withAppendedId(uri, row);
        }
        else
        {
            try
            {
                throw new SqlException();
                
            }
            catch (SqlException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        
    }
    
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        
        String tableName = getTableName(uri);
        if (null == tableName)
        {
            throw new IllegalArgumentException(Constant_DB.CONTENTPROVIDER_UNRECOGNIZED_URI + uri);
        }
        
        SQLiteDatabase db = MIPProvider.getReadableDatabase();
        Cursor cursor = db.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
        
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
        
    }
    
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        
        String tableName = getTableName(uri);
        if (null == tableName)
        {
            throw new IllegalArgumentException(Constant_DB.CONTENTPROVIDER_UNRECOGNIZED_URI + uri);
        }
        SQLiteDatabase db = MIPProvider.getWritableDatabase();
        int count = 0;
        count = db.update(tableName, values, selection, selectionArgs);
        
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
    
    /**
     * get database table name according to URI
     * 
     * @param uri URI
     * @return table name
     */
    private static String getTableName(Uri uri)
    {
        if (null == uri)
        {
            return null;
        }
        switch (MATHCER.match(uri))
        {
            case UserInfoTable.USERINFO_INFO:
                return UserInfoTable.TABLE_NAME;
            case ModuleTable.MODULE_INFO:
                return ModuleTable.TABLE_NAME;
            case AddressInfoTable.ADDRESS_INFO:
                return AddressInfoTable.TABLE_NAME;
            case FileInfoTable.FILEINFO_INFO:
                return FileInfoTable.TABLE_NAME;
            case ShorCutTable.ShorCut_INFO:
                return ShorCutTable.TABLE_NAME;
            case CardViewTable.CardView_INFO:
                return CardViewTable.TABLE_NAME;
            case AppInfoTable.APP_INFO:
                return AppInfoTable.TABLE_NAME;
            case VedioSeriseInfoTable.VEDIOSERISEINFO_INFO:
                return VedioSeriseInfoTable.TABLE_NAME;
                
            case ChatRoomTable.CHATROOMINFO_INFO:
                return ChatRoomTable.TABLE_NAME;
            case ChatMessageTable.CHATMESSAGEINFO_INFO:
                return ChatMessageTable.TABLE_NAME;
            case XXZXTYPEInfoTable.XXZXTYPE_INFO:
                return XXZXTYPEInfoTable.TABLE_NAME;
            case XXZXDETAILInfoTable.XXZXDETAIL_INFO:
                return XXZXDETAILInfoTable.TABLE_NAME;
            default:
                return null;
                
        }
    }
    
    @Override
    public String getType(Uri uri)
    {
        // int type = MATHCER.match(uri);
        
        return Constant_DB.CONTENT_TYPE;
        
        // switch (type) {
        //
        // case UserInfoTable.USERINFO_INFO:
        // return UserInfoTable.CONTENT_TYPE;
        // case AppInfoTable.APP_INFO:
        // return AppInfoTable.CONTENT_TYPE;
        // case ModuleTable.MODULE_INFO:
        // return ModuleTable.CONTENT_TYPE;
        //
        // case IndexModuleTable.INDEXMODUEL_INFO:
        // return IndexModuleTable.CONTENT_TYPE;
        //
        // case MailInfoTable.MAILINFO_INFO:
        // return MailInfoTable.CONTENT_TYPE;
        //
        // case MailMessageTable.MAILMESSAGE_INFO:
        // return MailMessageTable.CONTENT_TYPE;
        //
        // case AddressInfoTable.ADDRESS_INFO:
        // return AddressInfoTable.CONTENT_TYPE;
        //
        // case FileInfoTable.FILEINFO_INFO:
        // return FileInfoTable.CONTENT_TYPE;
        //
        // default:
        // throw new IllegalArgumentException(
        // Constant_DB.CONTENTPROVIDER_UNKNOW_URI + uri.getPath());
        // }
    }
}
