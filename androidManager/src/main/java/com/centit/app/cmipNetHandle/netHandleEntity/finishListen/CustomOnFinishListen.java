/*
 * File name:  IAAFOnFinish.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-8-27
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipNetHandle.netHandleEntity.finishListen;

import android.os.Handler;
import android.os.Message;

import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseEngine.NetInterface.OnFinishListen;
import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.BaseParseResponse;
import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.ParseResponseUtils;

/**
 * <一句话功能简述>通常情况下，网络处理结束后，报文的处理调用，返回的数据类型为String
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-8-27]
 */
public class CustomOnFinishListen implements OnFinishListen
{
    
    private Handler mHandler;
    
    private int     requestType;
    
    public CustomOnFinishListen(Handler mHandler, int requestType)
    {
        this.mHandler = mHandler;
        this.requestType = requestType;
    }
    
    /**
     * 重载方法
     * 
     * @param responseCode
     * @param requestType
     * @param data
     * @return
     * @author ma_zhicheng
     */
    @Override
    public Boolean onFinish(int responseCode, Object data)
    {
        Message msg = new Message();
        
        msg.what = requestType;
        msg.arg1 = responseCode;
        switch (responseCode)
        {
            case Constant_Net.SUCCESS:
                if (data != null && data instanceof String)
                {
                    msg.obj = data;
//                    try
//                    {
//                        BaseParseResponse response = ParseResponseUtils.parse((String)data, BaseParseResponse.class);
//
//                        if (response != null)
//                        {
//                            LogUtil.d("body=" + response.getBody() + ";header" + response.getHeader());
//                        }
//                        msg.obj = response;
//                    }
//                    catch (Exception e)
//                    {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                        msg.obj = data;
//                    }
                }
                break;
            default:
                LogUtil.i("网络请求数据时发生错误，请检查！");
                msg.arg1 = responseCode;
                
                msg.obj = "";
                
                break;
        }
        
        mHandler.sendMessage(msg);
        
        return null;
    }
}
