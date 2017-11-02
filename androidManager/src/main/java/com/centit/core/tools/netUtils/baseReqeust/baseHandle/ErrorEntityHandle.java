/*
 * File name:  ErrorHandleIntface.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-9-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.baseReqeust.baseHandle;

import com.centit.core.tools.exceptionManager.MIPException;

/**
 * 请求出错的情况下，处理返回数据的接口，各个业务需要封装该接口
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-9-29]
 */
public interface ErrorEntityHandle
{
    public boolean ErrorHandle(int errorCode)
        throws MIPException;
}
