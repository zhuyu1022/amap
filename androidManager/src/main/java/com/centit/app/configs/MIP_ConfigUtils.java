/*
 * File name:  MIP_Intent.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  rqj
 * Last modified date:  2015-9-7
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.configs;

import android.content.Intent;

/**
 * <一句话功能简述> Activity之间的跳转
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-7]
 */
public class MIP_ConfigUtils
{
    /**
     * phone主页的全路径
     */
    public static String phone_MainActivtiy = "com.centit.project.ui.MainActivity";
    
    /**
     * pad设备的全路径
     */
    public static String pad_MainActivtiy   = "com.centit.project.ui.MainActivity";
    
    // /**
    // * 获取类
    // *
    // * @return
    // */
    // public static Class<?> getMainActivityClass()
    // {
    // Class<?> onwClass = null;
    // if (GlobalState.getInstance().getDeviceType().equals("aPad"))
    // {
    // try
    // {
    // onwClass = Class.forName(pad_MainActivtiy);
    // }
    // catch (ClassNotFoundException e)
    // {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // else
    // {
    // try
    // {
    // onwClass = Class.forName(phone_MainActivtiy);
    // }
    // catch (ClassNotFoundException e)
    // {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // return onwClass;
    // }
    
    /**
     * <一句话功能简述> 设置intent FLAG_ACTIVITY_NO_USER_ACTION 属性
     * 
     * @Description<功能详细描述>
     * 
     * @param intent
     * @return
     * @LastModifiedDate：2015-9-7
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static Intent setUSERACTION(Intent intent)
    {
        if (intent != null && ((intent.getFlags() & Intent.FLAG_ACTIVITY_NO_USER_ACTION) == 0))
        {
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
        }
        return intent;
    }
}
