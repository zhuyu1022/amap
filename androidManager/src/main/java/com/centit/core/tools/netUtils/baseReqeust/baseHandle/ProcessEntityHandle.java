/*
 * File name:  ProcessEntityHandler.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-9-30
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.baseReqeust.baseHandle;

import android.os.Handler;

import com.centit.core.tools.netUtils.baseEngine.NetInterface.OnProgressListen;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-9-30]
 */
abstract public class ProcessEntityHandle implements OnProgressListen
{
    protected Handler mHandler;
    
    public long       mContentLength;
    
    public ProcessEntityHandle(Handler handler)
    {
        super();
        // TODO Auto-generated constructor stub
        this.mHandler = handler;
    }
    
    public long getmContentLength()
    {
        return mContentLength;
    }
    
    public void setmContentLength(long mContentLength)
    {
        this.mContentLength = mContentLength;
    }
    
}
