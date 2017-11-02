/*
 * File name:  IInstallToMainActivity.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2014-5-30
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.baseView.baseinterface;

/**
 * <一句话功能简述>
 * apk安装监听
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-5-30]
 */
public interface IInstallToActivity
{
    public void onInstallListen(String packageName);
    
    public void onUnInstallListen(String packageName);
}
