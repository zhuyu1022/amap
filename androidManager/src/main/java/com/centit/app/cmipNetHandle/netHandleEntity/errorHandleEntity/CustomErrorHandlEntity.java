/*
 * File name:  LoginErrorHandle.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-9-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipNetHandle.netHandleEntity.errorHandleEntity;

import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ErrorEntityHandle;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-9-29]
 */
public class CustomErrorHandlEntity implements ErrorEntityHandle
{
    
    @Override
    public boolean ErrorHandle(int errorCode)
        throws MIPException
    {
        // TODO Auto-generated method stub
        return false;
    }
    
}
