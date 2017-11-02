/*
 * File name:  CommonOnProcessListen.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-9-28
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipNetHandle.netHandleEntity.processListen;

import android.os.Handler;
import android.os.Message;

import com.centit.app.cmipConstant.Constant_RequestType;
import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;

/**
 * 上传过程中处理类
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-9-28]
 */
public class UpLoadProcessListen extends ProcessEntityHandle
{
    /**
     * 
     * <默认构造函数>
     * 
     * @param handler handler
     */
    public UpLoadProcessListen(Handler handler)
    {
        super(handler);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void onProgress(Object obj)
    {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.obj = (Integer)obj;
        msg.what = Constant_RequestType.REQUEST_UPLOADPROCESSBAR;
        msg.arg1 = Constant_Net.SUCCESS;
        mHandler.sendMessage(msg);
        
    }
}
