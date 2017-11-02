package com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity;

import java.io.InputStream;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.DownloadEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;
import com.centit.core.tools.utils.MIP_InputStreamUtils;

/**
 * 下载流程中处理流的类，流的类型为String
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class StringDownloadHandleEntity implements DownloadEntityHandle
{
    private int requestType;
    
    public StringDownloadHandleEntity(int requestType)
    {
        this.requestType = requestType;
    }
    
    @Override
    public Object downloadHandler(InputStream in, ProcessEntityHandle onProgressListen)
        throws Exception
    {
        // TODO Auto-generated method stub
        String result = "";
        // if (requestType == RequestTypeConstants.GETDOCLISTREQUEST)
        // {
        // SystemClock.sleep(5000);
        // }
        try
        {
            result = MIP_InputStreamUtils.InputStreamTOString(in);
            return result;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LogUtil.v("parse failure!");
            MIPException mipException = new MIPException(ExceptionConst.EXCEPTION, e.toString());
            throw mipException;
        }
        finally
        {
            // in.close();
        }
    }
}
