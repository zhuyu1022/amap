package com.centit.core.tools.netUtils.baseReqeust.baseHandle;

import java.io.InputStream;

/**
 * 处理返回数据流的接口类，提供了NetDataBackHandler（）方法解析返回数据
 * 
 * @author ren_qiujing
 * 
 */
public interface DownloadEntityHandle
{
    /**
     * @param in 输入的报文
     * @param onProgressListen 处理过程中的监听返回
     * @return
     * @throws Exception
     */
    public Object downloadHandler(InputStream in, ProcessEntityHandle onProgressListen)
        throws Exception;
}
