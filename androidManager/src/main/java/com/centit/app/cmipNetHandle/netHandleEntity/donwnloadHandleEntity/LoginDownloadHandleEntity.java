/*
 * File name:  LoginDownloadEntity.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-8-27
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.DownloadEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;

/**
 * 登录时，解析返回流
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-8-27]
 */
public class LoginDownloadHandleEntity implements DownloadEntityHandle
{
    /**
     * 
     * <默认构造函数>
     * 
     * @param requestType 请求id
     */
    public LoginDownloadHandleEntity()
    {
        super();
        // this.requestType = requestType;
    }
    
    @Override
    public Object downloadHandler(InputStream in, ProcessEntityHandle onProgressListen)
        throws Exception
    {
        int buffer = 4096;// 这里缓冲区我们使用4KB，
        String strEntry; // 保存每个zip的条目名称
        String UnzipJsonString = "";
        try
        {
            ZipInputStream zis = new ZipInputStream(in);
            ZipEntry entry; // 每个zip条目的实例
            while ((entry = zis.getNextEntry()) != null)
            {
                try
                {
                    strEntry = entry.getName();
                    if (strEntry.endsWith("json"))
                    {
                        // 解析json文件
                        StringBuffer out = new StringBuffer();
                        byte[] b = new byte[buffer];
                        for (int n; (n = zis.read(b)) != -1;)
                        {
                            out.append(new String(b, 0, n));
                        }
                        UnzipJsonString = out.toString();
                        LogUtil.i("*****UnzipJsonString=" + UnzipJsonString);
                    }
                    else if (strEntry.endsWith("alist"))
                    {
                        // 解析动态的url
                        StringBuffer out = new StringBuffer();
                        byte[] b = new byte[buffer];
                        for (int n; (n = zis.read(b)) != -1;)
                        {
                            out.append(new String(b, 0, n));
                        }
                        String UnzipConfigureString = out.toString();
                        
                        LogUtil.i("UnzipConfigureString====目前没有解析，请加代码" + UnzipConfigureString);
                        if (UnzipConfigureString != null && !"".equals(UnzipConfigureString))
                        {
                            
                        }
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    LogUtil.v("parse failure!");
                    MIPException mipException = new MIPException(ExceptionConst.EXCEPTION, ex.toString());
                    throw mipException;
                }
            }
            zis.close();
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            LogUtil.e(e);
            MIPException mipException = new MIPException(ExceptionConst.EXCEPTION, e.toString());
            throw mipException;
        }
        return UnzipJsonString;
    }
}
