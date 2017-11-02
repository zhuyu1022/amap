package com.centit.core.tools.netUtils.baseReqeust.baseHandle;

import java.io.OutputStream;

/**
 * 处理上传文件的接口类，提供uploadHandler()方法实现，如何上传文件
 * 
 * @author ren_qiujing
 * 
 */
public abstract class UploadEntityHandle
{
    protected Object objectParams;
    
    /**
     * 将文件写入到outputStream流的方法
     * 
     * @param out
     * @param listen
     * @throws Exception
     */
    abstract public boolean uploadHandler(OutputStream out, ProcessEntityHandle listen)
        throws Exception;
    
    public Object getObject()
    {
        return objectParams;
    }
    
    public void setObject(Object object)
    {
        this.objectParams = object;
    }
}
