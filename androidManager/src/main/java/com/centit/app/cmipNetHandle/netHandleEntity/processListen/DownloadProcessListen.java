/*
 * File name:  ApkDownloadProcessListen.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wang_ling
 * Last modified date:  2013-10-10
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
 * 下载更新过程中处理的类
 * 
 * @Description<功能详细描述>
 * 
 * @author wang_ling
 * @Version [版本号, 2013-10-10]
 */
public class DownloadProcessListen extends ProcessEntityHandle
{
    
    /**
     * <默认构造函数>
     */
    public DownloadProcessListen(Handler handler)
    {
        super(handler);
    }
    
    /**
     * 重载方法
     * 
     * @param obj
     * @author wang_ling
     */
    @Override
    public void onProgress(Object obj)
    {
        Message msg = new Message();
        msg.obj = (Integer)obj;
        msg.what = Constant_RequestType.REQUEST_DOWNLOADPROCESSBAR;
        msg.arg1 = Constant_Net.SUCCESS;
        mHandler.sendMessage(msg);
    }
    
}
