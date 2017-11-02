/*
 * File name:  AddressBookDBUtils.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2015-9-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.addressbook;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.centit.app.cmipDataUtils.sqlUtils.Table.AddressInfoTable;
import com.centit.app.cmipDataUtils.sqlUtils.dbHelp.MIPDatabaseHelper;
import com.centit.app.cmipmodule.addressbook.entity.AddressItemEntity;
import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2015-9-29]
 */
public class AddressBookDBUtils
{
    public static void insertListAddress(Context context, String openId, List<AddressItemEntity> entitys)
    {
        if (entitys == null)
        {
            return;
        }
        
        MIPDatabaseHelper help = new MIPDatabaseHelper(context);
        SQLiteDatabase db = help.getReadableDatabase();
        
        db.beginTransaction();
        try
        {
            int size = entitys.size();
            for (int i = 0; i < size; i++)
            {
                AddressItemEntity entity = entitys.get(i);
                
                String pId = entity.getmPId();
                if (pId == null || pId.trim().equals(""))
                {
                    // pId = "root";
                    entity.setmPId("root");
                }
                
                ContentValues values = new ContentValues();
                values.put(AddressInfoTable.OPENID, openId);
                values.put(AddressInfoTable.NAME, entity.getName());
                values.put(AddressInfoTable.MCURID, entity.getmCurId());
                values.put(AddressInfoTable.NUM, entity.getmPosition());
                values.put(AddressInfoTable.PNAME, entity.getmPName());
                
                values.put(AddressInfoTable.MPID, entity.getmPId());
                values.put(AddressInfoTable.ISDEP, entity.getIsDep() ? "1" : "0");
                values.put(AddressInfoTable.OFFICE, entity.getOffice());
                values.put(AddressInfoTable.OFFNUM, entity.getOfficePhoneNumber());
                values.put(AddressInfoTable.MOBILE, entity.getMobile());
                values.put(AddressInfoTable.EMAIL, entity.getEmail());
                values.put(AddressInfoTable.ISARROW, "0");
                
                db.insert(AddressInfoTable.TABLE_NAME, null, values);
            }
            
            db.setTransactionSuccessful(); // 设置事务处理成功
        }
        catch (Exception e)
        {
            new MIPException(ExceptionConst.SQLITEEXCEPTION, "").printStackTrace();
        }
        finally
        {
            db.endTransaction(); // 处理完成
            db.close();
            help.close();
        }
    }
    
    /**
     * 删除pid的通讯录
     * 
     * @param resolver
     * @param openId
     * @param pid
     */
    public static void deleteAddress(ContentResolver resolver, String openId, String pid)
    {
        Uri uri = AddressInfoTable.CONTENT_URI;
        if (pid == null || pid.equals(""))
        {
            pid = "root";
        }
        
        resolver.delete(uri, AddressInfoTable.OPENID + "=? and " + AddressInfoTable.MPID + " =?", new String[] {openId,
            pid});
    }
    
    /**
     * 查询通讯录
     * 
     * @param resolver
     * @param openId
     * @param pid
     * @return
     */
    public static List<AddressItemEntity> queryAddress(ContentResolver resolver, String openId, String pid)
    {
        List<AddressItemEntity> entitys = new ArrayList<AddressItemEntity>();
        
        Uri uri = AddressInfoTable.CONTENT_URI;
        if (pid == null || pid.equals(""))
        {
            pid = "root";
        }
        
        Cursor mCur =
            resolver.query(uri,
                null,
                AddressInfoTable.OPENID + "=? and " + AddressInfoTable.MPID + " =?",
                new String[] {openId, pid},
                null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                AddressItemEntity entity = new AddressItemEntity();
                
                String name = mCur.getString(mCur.getColumnIndex(AddressInfoTable.NAME));
                String mCurId = mCur.getString(mCur.getColumnIndex(AddressInfoTable.MCURID));
                String mPid = mCur.getString(mCur.getColumnIndex(AddressInfoTable.MPID));
                String isDep = mCur.getString(mCur.getColumnIndex(AddressInfoTable.ISDEP));
                String office = mCur.getString(mCur.getColumnIndex(AddressInfoTable.OFFICE));
                String offnum = mCur.getString(mCur.getColumnIndex(AddressInfoTable.OFFNUM));
                String mobile = mCur.getString(mCur.getColumnIndex(AddressInfoTable.MOBILE));
                String email = mCur.getString(mCur.getColumnIndex(AddressInfoTable.EMAIL));
                String position = mCur.getString(mCur.getColumnIndex(AddressInfoTable.NUM));
                String pName = mCur.getString(mCur.getColumnIndex(AddressInfoTable.PNAME));
                
                entity.setName(name);
                entity.setmCurId(mCurId);
                entity.setmPId(mPid);
                entity.setOffice(office);
                entity.setOfficePhoneNumber(offnum);
                entity.setMobile(mobile);
                entity.setEmail(email);
                if ("1".equals(isDep))
                {
                    entity.setIsDep(true);
                }
                else
                {
                    entity.setIsDep(false);
                }
                
                entity.setArrow(false);
                entity.setmPosition(position);
                entity.setmPName(pName);
                
                entitys.add(entity);
            }
            
            mCur.close();
            mCur = null;
        }
        
        return entitys;
    }
}
