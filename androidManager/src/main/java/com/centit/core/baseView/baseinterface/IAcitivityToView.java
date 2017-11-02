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

import android.content.Intent;

/**
 * <一句话功能简述> View的生命周期，与Activity一致，在MainActivity中调用
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-5-30]
 */
public interface IAcitivityToView
{
    /**
     * <一句话功能简述> 网络返回的处理方法
     * 
     * @Description<功能详细描述>
     * 
     * @param requestType
     * @param objHeader
     * @param objBody
     * @param error
     * @param errorCode
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode);
    
    /**
     * <一句话功能简述> 初始化数据
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void initData();
    
    /**
     * <一句话功能简述> 初始化view
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void initView();
    
    /**
     * <一句话功能简述> 初始化监听事件
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void initListener();
    
    /**
     * 销毁card view时的调用
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void onViewDestroy();
    
    /**
     * Acitivity中的onActivityResult最后会被调用
     * 
     * @Description<功能详细描述>
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void onViewActivityResult(int arg0, int arg1, Intent arg2);
    
    /**
     * Acitivity中的onKeyDown最后会被调用
     * 
     * @Description<功能详细描述>
     * 
     * @param keyId
     * @return
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public boolean onViewKeyDown(int keyId);
    
    /**
     * <一句话功能简述> mianview 向card中传数据
     * 
     * @Description<功能详细描述>
     * 
     * @LastModifiedDate：2015-9-8
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public void onMianView2Card(int type , Object obj);
    
    /**
     * 注册广播
     */
    public void onViewRegisterReceiver();
}
