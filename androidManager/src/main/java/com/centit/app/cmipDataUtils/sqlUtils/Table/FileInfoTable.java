package com.centit.app.cmipDataUtils.sqlUtils.Table;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import com.centit.app.cmipDataUtils.sqlUtils.Constant_DB;

public class FileInfoTable implements BaseColumns
{
    
    public static final int    FILEINFO_INFO    = Constant_DB.FILEINFO_FLAG;
    
    public static final String TABLE_NAME       = "fileInfo";
    
    public static final Uri    CONTENT_URI      = Uri.parse("content://" + Constant_DB.AUTHORITY + "/" + TABLE_NAME);
    
    /**
     * 用户ID
     */
    public static final String USER_ID          = "userid";
    
    /**
     * 文件ID，可能为文件ID、文件在网络上url
     */
    public static final String FILEID           = "fileid";
    
    /**
     * 文件标题
     */
    public static final String FILETITLE        = "filetitle";
    
    /**
     * 文件存储在本地的名字
     */
    public static final String FILENAME         = "filename";
    
    /**
     * 文件存在本地的路径
     */
    public static final String FILEPATH         = "filepath";
    
    /**
     * 文件类型
     */
    public static final String FILETYPE         = "filetype";
    
    // 如果是下载文件，文件的url
    public static final String FILEURL          = "fileurl";
    
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                                                    + FileInfoTable.USER_ID + " TEXT," + FileInfoTable.FILEID
                                                    + " TEXT," + FileInfoTable.FILETITLE + " TEXT,"
                                                    + FileInfoTable.FILENAME + " TEXT," + FileInfoTable.FILEPATH
                                                    + " TEXT," + FileInfoTable.FILEURL + " TEXT,"
                                                    + FileInfoTable.FILETYPE + " TEXT )";
    
    /**
     * the SQL for dropping database
     */
    public static final String DROP_TABLE_SQL   = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public static void getUriMatcherMailInfo(UriMatcher MATHCER)
    {
        MATHCER.addURI(Constant_DB.AUTHORITY, TABLE_NAME, FILEINFO_INFO);
    }
}
