package com.centit.app.cmipNetHandle.wrapRequest;

import com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity.FileDownloadHandleEntity;
import com.centit.app.cmipNetHandle.netHandleEntity.finishListen.DownloadFileFinishListen;
import com.centit.app.cmipNetHandle.netHandleEntity.processListen.DownloadProcessListen;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity.SendType;
import com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst.BaseWrapRequest;

/**
 * 根据我们预定的请求格式 1.该请求为下载请求，请求参数为预定义的header 和 加密body（本身为JSON格式） 合成的String型 2.URL 为 “baseURL” + MIPSERVER/server/download
 * 3.返回为zip流
 * 
 * @author ren_qiujing
 * 
 */
public class CustomDownloadBaseWrapRequest extends BaseWrapRequest
{
    
    private FileInfo mfileInfo;
    
    public CustomDownloadBaseWrapRequest(String url, int type, FileInfo fileinfo)
    {
        super(url, type);
        mfileInfo = fileinfo;
        mBaseURL = url;
    }
    
    @Override
    public String getURL()
    {
        return mBaseURL;
    }
    
    @Override
    public SendType getSendTYP()
    {
        return SendType.Downloadfiles;
    }
    
    /**
     * 重载方法
     * 
     * @author shen_feng
     */
    @Override
    public void setDownloadEntity()
    {
        mDownloadEntityHandler = new FileDownloadHandleEntity(mfileInfo.getFilepath());
    }
    
    /**
     * 重载方法
     * 
     * @author shen_feng
     */
    @Override
    public void setOnFinishListen()
    {
        // mOnFinishListen = new CustomOnFinishListen(mHandler, mRequestType);
        mOnFinishListen = new DownloadFileFinishListen(mHandler, mRequestType, mfileInfo);
    }
    
    /**
     * 重载方法
     * 
     * @author shen_feng
     */
    @Override
    public void setUploadFileHandlerEntity()
    {
        
    }
    
    /**
     * 重载方法
     * 
     * @author shen_feng
     */
    @Override
    public void setProcessEntityHandler()
    {
        this.mProcessEntityHandler = new DownloadProcessListen(mHandler);
        
    }
}
