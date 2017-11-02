package com.centit.app.cmipmodule.addressbook;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Contacts.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;

import com.centit.app.cmipNetHandle.NetRequestController;
import com.centit.app.cmipmodule.addressbook.entity.AddressItemEntity;
import com.centit.app.cmipmodule.addressbook.parseResponse.AddressBizResponse;
import com.centit.app.cmipmodule.addressbook.parseResponse.AddressDep;
import com.centit.app.cmipmodule.addressbook.parseResponse.AddressUser;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class AddressServiceImpl
{
    /**
     * 获取通讯录接口
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param parentId
     * @return
     */
    public static NetTask sendGetAddress(NetTask task, Handler handler, int requestType, String parentId)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("deptid", parentId);
            bodyVaule.put("keywords", "");
            
            requestObj =
                NetRequestController.getPredefineObj("addr", "AddrAdapter", "getAddressBookList", "general", bodyVaule);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 发送搜索通讯录接口
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param condition
     * @return
     */
    public static NetTask sendSearchGetAddress(NetTask task, Handler handler, int requestType, String keywords)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("deptCode", "");
            bodyVaule.put("keywords", keywords);
            
            requestObj =
                NetRequestController.getPredefineObj("addr", "AddrAdapter", "getAddressBookList", "general", bodyVaule);
            
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 获取同步通讯录 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param task
     * @param handler
     * @param requestType
     * @param deptid
     * @return
     * @LastModifiedDate：2015-1-21
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static NetTask sendTongBuAddress(NetTask task, Handler handler, int requestType, String deptid)
    {
        JSONObject requestObj = null;
        try
        {
            JSONObject bodyVaule = new JSONObject();
            bodyVaule.put("deptid", deptid);
            
            requestObj =
                NetRequestController.getPredefineObj("addrbook",
                    "AddrBookAdapter",
                    "syncContactList",
                    "general",
                    bodyVaule);
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return NetRequestController.sendStrBaseServlet(task, handler, requestType, requestObj);
    }
    
    /**
     * 保存数据库
     * 
     * @param mContext
     * @param openId
     * @param mCurId
     * @param lists
     */
    public static void saveAddressData(final Context mContext, final String openId, final String mCurId,
        final List<AddressItemEntity> lists)
    {
        Thread th = new Thread()
        {
            
            @Override
            public void run()
            {
                AddressBookDBUtils.insertListAddress(mContext, openId, lists);
                
                super.run();
            }
            
        };
        th.start();
    }
    
    /**
     * 获取AddressItemEntity 实例
     * 
     * @param Name
     * @param mCurId
     * @param mPId
     * @param isDep
     * @param office
     * @param officePhoneNumber
     * @param mobile
     * @param email
     * @param isArrow
     * @param mNum
     * @param mPname
     * @return
     */
    public static AddressItemEntity getAddressItem(String Name, String mCurId, String mPId, Boolean isDep,
        String office, String officePhoneNumber, String mobile, String email, boolean isArrow, String mPosition,
        String mPname, String cId)
    {
        AddressItemEntity entity = new AddressItemEntity();
        
        if (mPId == null)
        {
            mPId = "root";
        }
        entity.setName(Name);
        entity.setmCurId(mCurId);
        entity.setmPId(mPId);
        entity.setIsDep(isDep);
        entity.setOffice(office);
        entity.setOfficePhoneNumber(officePhoneNumber);
        entity.setMobile(mobile);
        entity.setEmail(email);
        entity.setArrow(isArrow);
        entity.setmPosition(mPosition);
        entity.setmPName(mPname);
        entity.setcId(cId);
        
        return entity;
        
    }
    
    /**
     * 处理获取的通讯录数据
     * 
     * @param bizResponse
     * @return
     */
    public static List<AddressItemEntity> parseResponse(AddressBizResponse bizResponse)
    {
        
        List<AddressItemEntity> entitys = new ArrayList<AddressItemEntity>();
        
        List<AddressDep> mDeps = bizResponse.getBizData().getCdeptlist();
        
        List<AddressUser> mUsers = bizResponse.getBizData().getUserlist();
        
        String depId = bizResponse.getBizData().getDeptid();
        String depName = bizResponse.getBizData().getDeptname();
        
        if (mUsers != null && mUsers.size() > 0)
        {
            for (int i = 0; i < mUsers.size(); i++)
            {
                AddressUser user = mUsers.get(i);
                
                String WiChat = user.getWechat(); // 微信号
                String MobileNum = user.getPhone(); // 手机号
                String MailAddr = user.getEmail(); // 邮件
                AddressItemEntity entity =
                    getAddressItem(user.getUsername(),
                        user.getUserid(),
                        depId,
                        false,
                        "",
                        WiChat,
                        MobileNum,
                        MailAddr,
                        false,
                        user.getPosition(),
                        depName,
                        user.getCid());
                entitys.add(entity);
            }
        }
        
        if (mDeps != null && mDeps.size() > 0)
        {
            for (int i = 0; i < mDeps.size(); i++)
            {
                AddressDep dep = mDeps.get(i);
                AddressItemEntity entity =
                    getAddressItem(dep.getDeptname(),
                        dep.getDeptid(),
                        depId,
                        true,
                        "",
                        "",
                        "",
                        "",
                        false,
                        "",
                        depName,
                        "");
                entitys.add(entity);
            }
        }
        
        return entitys;
    }
    
    // =====================================================================
    
    // 往数据库中新增联系人
    public static void AddContact(ContentResolver mResolver, String name, String number, String groupName)
    {
        Log.i("hoperun", "name= " + name + ";number=" + number);
        if (!queryFromContact(mResolver, name, number))
        {
            ContentValues values = new ContentValues();
            // 首先向RawContacts.CONTENT_URI执行一个空值插入，目的是获取系统返回的rawContactId
            Uri rawContactUri = mResolver.insert(RawContacts.CONTENT_URI, values);
            
            if (rawContactUri != null)
            {
                long rawContactId = ContentUris.parseId(rawContactUri);
                // 往data表插入姓名数据
                values.clear();
                values.put(Data.RAW_CONTACT_ID, rawContactId);
                values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);// 内容类型
                values.put(StructuredName.GIVEN_NAME, name);
                mResolver.insert(ContactsContract.Data.CONTENT_URI, values);
                // 往data表插入电话数据
                values.clear();
                values.put(Data.RAW_CONTACT_ID, rawContactId);
                values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
                values.put(Phone.NUMBER, number);
                values.put(Phone.TYPE, Phone.TYPE_MOBILE);
                mResolver.insert(ContactsContract.Data.CONTENT_URI, values);
            }
            else
            {
                Log.i("hoperun", "name= " + name + ";number=" + number);
            }
            
        }
        else
        {
            Log.i("hoperun", "repeat name= " + name + ";number=" + number);
        }
    }
    
    private static void addContactToGroup(ContentResolver mResolver, int contactId, int groupId)
    {
        // judge whether the contact has been in the group
        boolean b1 = ifExistContactInGroup(mResolver, contactId, groupId);
        if (b1)
        {
            // the contact has been in the group
            return;
        }
        else
        {
            ContentValues values = new ContentValues();
            values.put(ContactsContract.CommonDataKinds.GroupMembership.RAW_CONTACT_ID, contactId);
            values.put(ContactsContract.CommonDataKinds.GroupMembership.GROUP_ROW_ID, groupId);
            values.put(ContactsContract.CommonDataKinds.GroupMembership.MIMETYPE,
                ContactsContract.CommonDataKinds.GroupMembership.CONTENT_ITEM_TYPE);
            mResolver.insert(ContactsContract.Data.CONTENT_URI, values);
        }
    }
    
    private static boolean ifExistContactInGroup(ContentResolver mResolver, int contactId, int groupId)
    {
        String where =
            Data.MIMETYPE + " = '" + ContactsContract.CommonDataKinds.GroupMembership.CONTENT_ITEM_TYPE + "' AND "
                + Data.DATA1 + " = '" + groupId + "' AND " + Data.RAW_CONTACT_ID + " = '" + contactId + "'";
        Cursor markCursor =
            mResolver.query(ContactsContract.Data.CONTENT_URI,
                new String[] {ContactsContract.Data.DISPLAY_NAME},
                where,
                null,
                null);
        if (markCursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean queryFromContact(ContentResolver mResolver, String name, String number)
    {
        ContentValues values = new ContentValues();
        // 首先向RawContacts.CONTENT_URI执行一个空值插入，目的是获取系统返回的rawContactId
        String where = Data.MIMETYPE + "=? and " + StructuredName.GIVEN_NAME + "=?";
        Cursor mCursor =
            mResolver.query(ContactsContract.Data.CONTENT_URI, null, where, new String[] {
                StructuredName.CONTENT_ITEM_TYPE, name}, null);
        System.out.println("--------------------phone--------------------1");
        if (mCursor != null)
        {
            while (mCursor.moveToNext())
            {
                String rowId = mCursor.getString(mCursor.getColumnIndex(Data.RAW_CONTACT_ID));
                
                String phoneWhere = Data.MIMETYPE + "=? and " + Phone.NUMBER + "=?";
                Cursor mPhoneCur =
                    mResolver.query(ContactsContract.Data.CONTENT_URI, null, phoneWhere, new String[] {
                        Phone.CONTENT_ITEM_TYPE, number}, null);
                if (mPhoneCur != null)
                {
                    while (mPhoneCur.moveToNext())
                    {
                        String phoneRowId = mPhoneCur.getString(mPhoneCur.getColumnIndex(Data.RAW_CONTACT_ID));
                        if (rowId.equals(phoneRowId))
                        {
                            mPhoneCur.close();
                            mCursor.close();
                            return true;
                        }
                    }
                }
                if (mPhoneCur != null)
                {
                    mPhoneCur.close();
                }
            }
        }
        if (mCursor != null)
        {
            mCursor.close();
        }
        return false;
    }
    
}
