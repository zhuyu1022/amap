/*
 * File name:  IPostHandler.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-10-17
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public interface IPostHandler
{
    public void PostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode);
}
