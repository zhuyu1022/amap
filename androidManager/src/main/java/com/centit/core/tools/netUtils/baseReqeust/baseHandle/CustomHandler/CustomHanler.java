/*
 * File name:  CustomHanler.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-10-17
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.centit.GlobalState;
import com.centit.core.tools.encryptManager.AesUtil;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.BaseParseResponse;
import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.ResponseHeader;
import com.centit.core.tools.utils.MIP_Constant_Core;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class CustomHanler extends Handler implements IPostHandler
{
    
    @Override
    public void handleMessage(Message msg)
    {
        int requestType = msg.what;
        int errorCode = msg.arg1;
        
        if (errorCode == Constant_Net.SUCCESS)
        {
            
            Object header = null;
            Object body = null;
            
            if (msg.obj == null)
            {
                header = "数据返回为null！";
                body = "";
            }
            else if (msg.obj instanceof BaseParseResponse)
            {
                try
                {
                    BaseParseResponse response = (BaseParseResponse)msg.obj;
                    
                    if (response != null)
                    {
                        header = response.getHeader();
                        LogUtil.i("header=" + header);
                        if (header != null && header instanceof ResponseHeader)
                        {
                            ResponseHeader newheader = (ResponseHeader)header;
                            if ("4".equals(newheader.getRetCode()) || "3".equals(newheader.getRetCode()))
                            {
                                Intent intent = new Intent();
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                                // intent.setClass(GlobalState.getInstance(),
                                // DeviceLostActivity.class);
                                // GlobalState.getInstance().startActivity(intent);
                                
                                ComponentName cn =
                                    new ComponentName(GlobalState.getInstance().getPackageName(),
                                        "com.centit.project.mgr.cmipActivity.DeviceLostActivity");
                                intent.setComponent(cn);
                                intent.putExtra("retCode", newheader.getRetCode());
                                GlobalState.getInstance().startActivity(intent);
                                return;
                            }
                            
                            // String userId = newheader.getUserId();
                            //
                            // if(userId != null && !userId.trim().equals(""))
                            // GlobalState.getInstance().setOpenId(userId);
                            // GlobalState.getInstance().setSessingId(
                            // newheader.getSessionId());
                        }
                        
                        body = AesUtil.decrypt(response.getBody(), MIP_Constant_Core.MOA_deviceKey);
                        
                        if (body != null && body.equals("null"))
                        {
                            body = null;
                        }
                        LogUtil.i("body=" + body);
                    }
                }
                catch (Exception e)
                {
                    LogUtil.d("网络请求返回正常，但返回数据异常!");
                    e.printStackTrace();
                }
            }
            else
            {
                header = "";
                body = msg.obj;
            }
            errorCode = Constant_Net.SUCCESS;
            PostHandle(requestType, header, body, true, errorCode);
        }
        else
        {
            if (msg.obj == null)
            {
                msg.obj = "";
            }
            
            LogUtil.d("请求业务返回数据错误，错误的类别是 ：" + errorCode + "错误的信息是：" + msg.obj);
            switch (errorCode)
            {
                case Constant_Net.NO_NET:
                    errorCode = Constant_Net.NO_NET;
                    break;
                case Constant_Net.TIME_OUT_ERROR:
                    errorCode = Constant_Net.TIME_OUT_ERROR;
                    break;
                case Constant_Net.CANCEL_REQUEST:
                    errorCode = Constant_Net.CANCEL_REQUEST;
                    break;
                default:
                    errorCode = Constant_Net.RETCODEERROR;
                    break;
            }
            PostHandle(requestType, "", msg.obj, false, errorCode);
        }
        super.handleMessage(msg);
    }
    
    @Override
    public void PostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode)
    {
        
    }
}
