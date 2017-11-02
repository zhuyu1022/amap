/*
 * File name:  A.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  rqj
 * Last modified date:  2015-9-24
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipThirtpart.cmipmodulemgr;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipDataUtils.sqlUtils.Table.ModuleTable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-24]
 */
public class ModuleDBUtils
{
    /**
     * 插入module信息操作
     * 
     * @param resolver
     */
    public static void inserModuleInfo(ContentResolver resolver, ModuleEntity entity)
    {
        Uri mModuleUrl = ModuleTable.CONTENT_URI;
        ContentValues Moduelvalues = new ContentValues();
        String openId = GlobalState.getInstance().getOpenId();
        Moduelvalues.put(ModuleTable.OPENID, openId);
        Moduelvalues.put(ModuleTable.FUNCODE, entity.getFuncode());
        Moduelvalues.put(ModuleTable.FUNNAME, entity.getFunname());
        Moduelvalues.put(ModuleTable.FUNICON, entity.getFunicon());
        Moduelvalues.put(ModuleTable.FUNICON_L, entity.getFunicon_l());
        Moduelvalues.put(ModuleTable.FUNCLASSPATH, entity.getFunclasspath());
        Moduelvalues.put(ModuleTable.ISABLE, entity.getIsAble());
        Moduelvalues.put(ModuleTable.ISADD, entity.getIsAdd());
        Moduelvalues.put(ModuleTable.SORT_IN_ADDLIST, entity.getSort_in_addlist());
        Moduelvalues.put(ModuleTable.SORT_IN_TEAM, entity.getSort_in_team());
        Moduelvalues.put(ModuleTable.TYPE, entity.getType());
        Moduelvalues.put(ModuleTable.VALUE, entity.getValue());
        
        Moduelvalues.put(ModuleTable.COUNT_ABLE, entity.getCount_able());
        Moduelvalues.put(ModuleTable.COUNT_ICON_1, entity.getCount_icon_1());
        Moduelvalues.put(ModuleTable.COUNT_ICON_2, entity.getCount_icon_2());
        Moduelvalues.put(ModuleTable.COUNT_TYPE, entity.getCount_type());
        
        Moduelvalues.put(ModuleTable.PCODE, entity.getpCode());
        Moduelvalues.put(ModuleTable.PNAME, entity.getpName());
        
        Moduelvalues.put(ModuleTable.ATTAHCURL, entity.getAttachURL());
        Moduelvalues.put(ModuleTable.ICONURL, entity.getIconURL());
        Moduelvalues.put(ModuleTable.VERSION, entity.getVersion());
        
        resolver.insert(mModuleUrl, Moduelvalues);
    }
    
    /**
     * <一句话功能简述> 查询所有的模块
     * 
     * @Description<功能详细描述>
     * 
     * @param resolver
     * @param openId
     * @return
     * @LastModifiedDate：2015-9-24
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static List<ModuleEntity> queryModule(ContentResolver resolver, String openId)
    {
        List<ModuleEntity> lists = new ArrayList<ModuleEntity>();
        Uri mModuleUrl = ModuleTable.CONTENT_URI;
        
        Cursor mCur = resolver.query(mModuleUrl, null, ModuleTable.OPENID + " =? ", new String[] {openId}, null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                ModuleEntity entity = new ModuleEntity();
                entity.setFunclasspath(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCLASSPATH)));
                entity.setFuncode(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCODE)));
                entity.setFunicon(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON)));
                entity.setFunicon_l(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON_L)));
                entity.setFunname(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNNAME)));
                entity.setIsAble(mCur.getString(mCur.getColumnIndex(ModuleTable.ISABLE)));
                entity.setIsAdd(mCur.getString(mCur.getColumnIndex(ModuleTable.ISADD)));
                entity.setSort_in_addlist(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_ADDLIST)));
                entity.setSort_in_team(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_TEAM)));
                entity.setType(mCur.getString(mCur.getColumnIndex(ModuleTable.TYPE)));
                entity.setValue(mCur.getString(mCur.getColumnIndex(ModuleTable.VALUE)));
                
                entity.setCount_able(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ABLE)));
                entity.setCount_icon_1(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_1)));
                entity.setCount_icon_2(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_2)));
                entity.setCount_type(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_TYPE)));
                
                entity.setpCode(mCur.getString(mCur.getColumnIndex(ModuleTable.PCODE)));
                entity.setpName(mCur.getString(mCur.getColumnIndex(ModuleTable.PNAME)));
                
                entity.setAttachURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ATTAHCURL)));
                entity.setIconURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ICONURL)));
                entity.setVersion(mCur.getString(mCur.getColumnIndex(ModuleTable.VERSION)));
                
                lists.add(entity);
            }
            mCur.close();
        }
        return lists;
    }
    
    /**
     * <一句话功能简述> 根据code 查询模块
     * 
     * @Description<功能详细描述>
     * 
     * @param resolver
     * @param openId
     * @return
     * @LastModifiedDate：2015-9-24
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static ModuleEntity queryModule(ContentResolver resolver, String openId, String funcode)
    {
        ModuleEntity entity = null;
        Uri mModuleUrl = ModuleTable.CONTENT_URI;
        
        Cursor mCur =
            resolver.query(mModuleUrl,
                null,
                ModuleTable.OPENID + " =? and " + ModuleTable.FUNCODE + " =? ",
                new String[] {openId, funcode},
                null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                entity = new ModuleEntity();
                entity.setFunclasspath(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCLASSPATH)));
                entity.setFuncode(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCODE)));
                entity.setFunicon(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON)));
                entity.setFunicon_l(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON_L)));
                entity.setFunname(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNNAME)));
                entity.setIsAble(mCur.getString(mCur.getColumnIndex(ModuleTable.ISABLE)));
                entity.setIsAdd(mCur.getString(mCur.getColumnIndex(ModuleTable.ISADD)));
                entity.setSort_in_addlist(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_ADDLIST)));
                entity.setSort_in_team(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_TEAM)));
                entity.setType(mCur.getString(mCur.getColumnIndex(ModuleTable.TYPE)));
                entity.setValue(mCur.getString(mCur.getColumnIndex(ModuleTable.VALUE)));
                
                entity.setCount_able(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ABLE)));
                entity.setCount_icon_1(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_1)));
                entity.setCount_icon_2(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_2)));
                entity.setCount_type(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_TYPE)));
                
                entity.setpCode(mCur.getString(mCur.getColumnIndex(ModuleTable.PCODE)));
                entity.setpName(mCur.getString(mCur.getColumnIndex(ModuleTable.PNAME)));
                
                entity.setAttachURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ATTAHCURL)));
                entity.setIconURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ICONURL)));
                entity.setVersion(mCur.getString(mCur.getColumnIndex(ModuleTable.VERSION)));
                
                break;
            }
            mCur.close();
        }
        return entity;
    }
    
    /**
     * 根据是否有被添加，获取相应的模块 （该模块对于用户必须有权限）
     * 
     * @param resolver
     * @param openId
     * @return
     */
    public static List<ModuleEntity> queryIsAddMoudle(ContentResolver resolver, String isadd, String isAble)
    {
        String openId = GlobalState.getInstance().getOpenId();
        List<ModuleEntity> lists = new ArrayList<ModuleEntity>();
        Uri mModuleUrl = ModuleTable.CONTENT_URI;
        
        Cursor mCur =
            resolver.query(mModuleUrl, null, ModuleTable.OPENID + "=? and " + ModuleTable.ISADD + "=? and "
                + ModuleTable.ISABLE + "=? ", new String[] {openId, isadd, isAble}, null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                ModuleEntity entity = new ModuleEntity();
                entity.setFunclasspath(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCLASSPATH)));
                entity.setFuncode(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCODE)));
                entity.setFunicon(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON)));
                entity.setFunicon_l(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON_L)));
                entity.setFunname(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNNAME)));
                entity.setIsAble(mCur.getString(mCur.getColumnIndex(ModuleTable.ISABLE)));
                entity.setIsAdd(mCur.getString(mCur.getColumnIndex(ModuleTable.ISADD)));
                entity.setSort_in_addlist(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_ADDLIST)));
                entity.setSort_in_team(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_TEAM)));
                entity.setType(mCur.getString(mCur.getColumnIndex(ModuleTable.TYPE)));
                entity.setValue(mCur.getString(mCur.getColumnIndex(ModuleTable.VALUE)));
                
                entity.setAttachURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ATTAHCURL)));
                entity.setCount_able(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ABLE)));
                entity.setCount_icon_1(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_1)));
                entity.setCount_icon_2(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_2)));
                entity.setCount_type(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_TYPE)));
                
                entity.setpCode(mCur.getString(mCur.getColumnIndex(ModuleTable.PCODE)));
                entity.setpName(mCur.getString(mCur.getColumnIndex(ModuleTable.PNAME)));
                
                entity.setIconURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ICONURL)));
                entity.setVersion(mCur.getString(mCur.getColumnIndex(ModuleTable.VERSION)));
                
                lists.add(entity);
            }
            mCur.close();
        }
        return lists;
    }
    
    /**
     * 根据是否有权限，获取所有的模块功能
     * 
     * @param resolver
     * @param openId
     * @return
     */
    public static List<ModuleEntity> queryIsAbleMoudle(ContentResolver resolver, String isAble)
    {
        String openId = GlobalState.getInstance().getOpenId();
        List<ModuleEntity> lists = new ArrayList<ModuleEntity>();
        Uri mModuleUrl = ModuleTable.CONTENT_URI;
        
        Cursor mCur =
            resolver.query(mModuleUrl, null, ModuleTable.OPENID + "=? and " + ModuleTable.ISABLE + "=? ", new String[] {
                openId, isAble}, null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                ModuleEntity entity = new ModuleEntity();
                entity.setFunclasspath(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCLASSPATH)));
                entity.setFuncode(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCODE)));
                entity.setFunicon(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON)));
                entity.setFunicon_l(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON_L)));
                entity.setFunname(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNNAME)));
                entity.setIsAble(mCur.getString(mCur.getColumnIndex(ModuleTable.ISABLE)));
                entity.setIsAdd(mCur.getString(mCur.getColumnIndex(ModuleTable.ISADD)));
                entity.setSort_in_addlist(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_ADDLIST)));
                entity.setSort_in_team(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_TEAM)));
                entity.setType(mCur.getString(mCur.getColumnIndex(ModuleTable.TYPE)));
                entity.setValue(mCur.getString(mCur.getColumnIndex(ModuleTable.VALUE)));
                
                entity.setCount_able(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ABLE)));
                entity.setCount_icon_1(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_1)));
                entity.setCount_icon_2(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_2)));
                entity.setCount_type(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_TYPE)));
                
                entity.setpCode(mCur.getString(mCur.getColumnIndex(ModuleTable.PCODE)));
                entity.setpName(mCur.getString(mCur.getColumnIndex(ModuleTable.PNAME)));
                
                entity.setAttachURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ATTAHCURL)));
                entity.setIconURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ICONURL)));
                entity.setVersion(mCur.getString(mCur.getColumnIndex(ModuleTable.VERSION)));
                
                lists.add(entity);
            }
            mCur.close();
        }
        return lists;
    }
    
    // 登录成功后，更新模块的数据信息
    public static void updateModuleInfo(ContentResolver resolver, ModuleEntity entity)
    {
        String openId = GlobalState.getInstance().getOpenId();
        Uri mCardViewUrl = ModuleTable.CONTENT_URI;
        
        ContentValues Moduelvalues = new ContentValues();
        
        Moduelvalues.put(ModuleTable.FUNNAME, entity.getFunname());
        Moduelvalues.put(ModuleTable.FUNCLASSPATH, entity.getFunclasspath());
        
        Moduelvalues.put(ModuleTable.ISABLE, entity.getIsAble());
        Moduelvalues.put(ModuleTable.PCODE, entity.getpCode());
        Moduelvalues.put(ModuleTable.PNAME, entity.getpName());
        Moduelvalues.put(ModuleTable.FUNICON, entity.getFunicon());
        Moduelvalues.put(ModuleTable.FUNICON_L, entity.getFunicon_l());
        
        Moduelvalues.put(ModuleTable.TYPE, entity.getType());
        
        Moduelvalues.put(ModuleTable.ICONURL, entity.getIconURL());
        Moduelvalues.put(ModuleTable.VERSION, entity.getVersion());
        Moduelvalues.put(ModuleTable.ATTAHCURL, entity.getAttachURL());
        
        Moduelvalues.put(ModuleTable.SORT_IN_TEAM, entity.getSort_in_team());
        
        Moduelvalues.put(ModuleTable.ISADD, entity.getIsAdd());
        
        Moduelvalues.put(ModuleTable.SORT_IN_ADDLIST, entity.getSort_in_addlist());
        
        resolver.update(mCardViewUrl,
            Moduelvalues,
            ModuleTable.OPENID + "=? and " + ModuleTable.FUNCODE + "=? ",
            new String[] {openId, entity.getFuncode()});
    }
    
    // 解析asset 下的模块功能xml时，如果数据库中已经存在了这个模块，则更新相应的数据
    public static void updateFuncModule(ContentResolver resolver, ModuleEntity entity)
    {
        
        Uri mCardViewUrl = ModuleTable.CONTENT_URI;
        
        ContentValues Moduelvalues = new ContentValues();
        String openId = GlobalState.getInstance().getOpenId();
        
        Moduelvalues.put(ModuleTable.FUNCLASSPATH, entity.getFunclasspath());
        Moduelvalues.put(ModuleTable.FUNICON, entity.getFunicon());
        Moduelvalues.put(ModuleTable.FUNICON_L, entity.getFunicon_l());
        Moduelvalues.put(ModuleTable.COUNT_ABLE, entity.getCount_able());
        Moduelvalues.put(ModuleTable.COUNT_ICON_1, entity.getCount_icon_1());
        Moduelvalues.put(ModuleTable.COUNT_ICON_2, entity.getCount_icon_2());
        Moduelvalues.put(ModuleTable.COUNT_TYPE, entity.getCount_type());
        Moduelvalues.put(ModuleTable.VALUE, entity.getValue());
        
        resolver.update(mCardViewUrl,
            Moduelvalues,
            ModuleTable.OPENID + "=? and " + ModuleTable.FUNCODE + "=? ",
            new String[] {openId, entity.getFuncode()});
        
    }
    
    // 更新所有模块的权限
    public static void updateModuleisAble(ContentResolver resolver, String isAble)
    {
        Uri mCardViewUrl = ModuleTable.CONTENT_URI;
        
        ContentValues Moduelvalues = new ContentValues();
        String openId = GlobalState.getInstance().getOpenId();
        Moduelvalues.put(ModuleTable.ISABLE, isAble);
        
        resolver.update(mCardViewUrl, Moduelvalues, ModuleTable.OPENID + "=? ", new String[] {openId});
    }
    
    // 更新功能模块是否已经被添加
    public static void updateModuleisAdd(ContentResolver resolver, String funcode, String isAdd)
    {
        Uri mCardViewUrl = ModuleTable.CONTENT_URI;
        
        ContentValues Moduelvalues = new ContentValues();
        String openId = GlobalState.getInstance().getOpenId();
        Moduelvalues.put(ModuleTable.ISADD, isAdd);
        if (isAdd.equals("" + Constant_Mgr.No_Add_1))
        {
            Moduelvalues.put(ModuleTable.SORT_IN_ADDLIST, 999);
        }
        
        resolver.update(mCardViewUrl,
            Moduelvalues,
            ModuleTable.OPENID + "=? and " + ModuleTable.FUNCODE + "=? ",
            new String[] {openId, funcode});
    }
    
    // 更新排序
    public static void updateModuleSortInAddList(ContentResolver resolver, String funcode, int sort)
    {
        Uri mCardViewUrl = ModuleTable.CONTENT_URI;
        
        ContentValues Moduelvalues = new ContentValues();
        String openId = GlobalState.getInstance().getOpenId();
        
        Moduelvalues.put(ModuleTable.SORT_IN_ADDLIST, sort);
        
        resolver.update(mCardViewUrl,
            Moduelvalues,
            ModuleTable.OPENID + "=? and " + ModuleTable.FUNCODE + "=? ",
            new String[] {openId, funcode});
    }
    
    // 更新是否有获取未读数/待办数的权限
    public static void updateModuleisCount(ContentResolver resolver, String funcode, String isCount)
    {
        Uri mCardViewUrl = ModuleTable.CONTENT_URI;
        
        ContentValues Moduelvalues = new ContentValues();
        String openId = GlobalState.getInstance().getOpenId();
        Moduelvalues.put(ModuleTable.COUNT_ABLE, isCount);
        
        resolver.update(mCardViewUrl,
            Moduelvalues,
            ModuleTable.OPENID + "=? and " + ModuleTable.FUNCODE + "=? ",
            new String[] {openId, funcode});
    }
    
    /**
     * 是否有获取未读数/待办数的权限
     * 
     * @param resolver
     * @param openId
     * @return
     */
    public static List<ModuleEntity> queryIsCountAbleMoudle(ContentResolver resolver, String isAble, String isCountAble)
    {
        String openId = GlobalState.getInstance().getOpenId();
        List<ModuleEntity> lists = new ArrayList<ModuleEntity>();
        Uri mModuleUrl = ModuleTable.CONTENT_URI;
        
        Cursor mCur =
            resolver.query(mModuleUrl, null, ModuleTable.OPENID + "=? and " + ModuleTable.COUNT_ABLE + "=? and "
                + ModuleTable.ISABLE + "=? ", new String[] {openId, isCountAble, isAble}, null);
        
        if (mCur != null)
        {
            while (mCur.moveToNext())
            {
                ModuleEntity entity = new ModuleEntity();
                entity.setFunclasspath(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCLASSPATH)));
                entity.setFuncode(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNCODE)));
                entity.setFunicon(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON)));
                entity.setFunicon_l(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNICON_L)));
                entity.setFunname(mCur.getString(mCur.getColumnIndex(ModuleTable.FUNNAME)));
                entity.setIsAble(mCur.getString(mCur.getColumnIndex(ModuleTable.ISABLE)));
                entity.setIsAdd(mCur.getString(mCur.getColumnIndex(ModuleTable.ISADD)));
                entity.setSort_in_addlist(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_ADDLIST)));
                entity.setSort_in_team(mCur.getInt(mCur.getColumnIndex(ModuleTable.SORT_IN_TEAM)));
                entity.setType(mCur.getString(mCur.getColumnIndex(ModuleTable.TYPE)));
                entity.setValue(mCur.getString(mCur.getColumnIndex(ModuleTable.VALUE)));
                
                entity.setCount_able(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ABLE)));
                entity.setCount_icon_1(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_1)));
                entity.setCount_icon_2(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_ICON_2)));
                entity.setCount_type(mCur.getString(mCur.getColumnIndex(ModuleTable.COUNT_TYPE)));
                
                entity.setIconURL(mCur.getString(mCur.getColumnIndex(ModuleTable.ICONURL)));
                entity.setVersion(mCur.getString(mCur.getColumnIndex(ModuleTable.VERSION)));
                
                lists.add(entity);
            }
            mCur.close();
        }
        return lists;
    }
}
