/*
 * File name:  ApkDownloadEntityHandler.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wang_ling
 * Last modified date:  2013-10-10
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.SocketException;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.DownloadEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;

/**
 * 下载更新文件时，解析返回的流
 * 
 * @Description<功能详细描述>
 * 
 * @author wang_ling
 * @Version [版本号, 2013-10-10]
 */
public class FileDownloadWithURLHandleEntity implements DownloadEntityHandle
{
    /**
     * 文件存储的位置
     */
    private String mFilePath;
    
    /**
     * 
     * <默认构造函数>
     * 
     * @param requestType 请求类型
     */
    public FileDownloadWithURLHandleEntity(String filePath)
    {
        super();
        this.mFilePath = filePath;
    }
    
    /**
     * 重载方法
     * 
     * @param in 输入流
     * @param onProgressListen 进度监听器
     * @return Object
     * @throws Exception 异常
     * @author wang_ling
     */
    @Override
    public Object downloadHandler(InputStream in, ProcessEntityHandle onProgressListen)
        throws Exception
    {
        long length = 0;
        File file = new File(mFilePath);
        if (file != null && !file.exists())
        {
            File parentFile = new File(file.getParent());
            if (parentFile != null && !parentFile.exists())
            {
                parentFile.mkdirs();
            }
        }
        else
        {
            file.delete();
        }
        FileOutputStream fos = null;
        try
        {
            if (null != onProgressListen)
            {
                length = onProgressListen.getmContentLength();
            }
            fos = new FileOutputStream(file);
            int count = 0;
            byte buf[] = new byte[1024];
            int numread;
            while ((numread = in.read(buf)) != -1)
            {
                fos.write(buf, 0, numread);
                count += numread;
                int progress = (int)(((float)count / length) * 100);
                onProgressListen.onProgress(progress);
            }
            
            if (null != fos)
            {
                fos.close();
            }
        }
        catch (SocketException e)
        {
            e.printStackTrace();
            if (null != fos)
            {
                fos.close();
            }
            throw new MIPException(ExceptionConst.SOCKETEXCEPTION, e.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (null != fos)
            {
                fos.close();
            }
            throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
        }
        return null;
    }
}
