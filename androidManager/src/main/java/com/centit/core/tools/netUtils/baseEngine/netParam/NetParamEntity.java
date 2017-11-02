package com.centit.core.tools.netUtils.baseEngine.netParam;

import java.util.HashMap;
import java.util.List;

import android.os.Handler;

import com.centit.core.tools.fileManager.FileInfo;

/**网络连接时，传递的参数
 * @author ren_qiujing
 *
 */
/**
 * @author ren_qiujing
 * 
 */
public class NetParamEntity
{
    /**
     * url连接地址
     */
    protected String                  url;
    
    /**
     * 请求参数为String类型
     */
    protected String                  strParam;
    
    /**
     * 请求参数为 map类型
     */
    protected HashMap<String, String> mapParam;
    
    /**
     * 发送的文件
     */
    protected List<FileInfo>          files;
    
    /**
     * 请求业务类型
     */
    protected int                     requestType;
    
    /**
     * 报文返回时，用到的Handler
     */
    protected Handler                 mHandler;
    
    // /**
    // * 解析返回报文流，解析为String或file文件
    // */
    // public DownloadEntityHandler entityHandler;
    //
    // /**
    // * 上传文件时，将文件转换为文件流
    // */
    // public UploadFileHandlerEntity uploadHandler;
    
    /**
     * 何种请求：上传普通数据、上传文件、下载文件
     */
    protected SendType                sendType = SendType.Normal;
    
    /**
     * 
     * 获取sendType
     * 
     * @Description 获取sendType
     * @return
     */
    public SendType getSendType()
    {
        return sendType;
    }
    
    /**
     * 设置sendType
     * 
     * @Description 设置sendType
     * @param sendType
     */
    public void setSendType(SendType sendType)
    {
        this.sendType = sendType;
    }
    
    // public UploadFileHandlerEntity getUploadHandler()
    // {
    // return uploadHandler;
    // }
    //
    // public void setUploadHandler(UploadFileHandlerEntity uploadHandler)
    // {
    // this.uploadHandler = uploadHandler;
    // }
    //
    // public DownloadEntityHandler getEntityHandler()
    // {
    // return entityHandler;
    // }
    //
    // public void setEntityHandler(DownloadEntityHandler entityHandler)
    // {
    // this.entityHandler = entityHandler;
    // }
    /**
     * 
     * 获取url
     * 
     * @Description 获取url
     * @return
     */
    public String getUrl()
    {
        return url;
    }
    
    /**
     * 设置url
     * 
     * @Description 设置url
     * @param url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    /**
     * 
     * 获取strParam
     * 
     * @Description 获取strParam
     * @return
     */
    public String getStrParam()
    {
        return strParam;
    }
    
    /**
     * 设置strParam
     * 
     * @Description 设置strParam
     * @param strParam
     */
    public void setStrParam(String strParam)
    {
        this.strParam = strParam;
    }
    
    /**
     * 
     * 获取mapParam
     * 
     * @Description 获取mapParam
     * @return
     */
    public HashMap<String, String> getMapParam()
    {
        return mapParam;
    }
    
    /**
     * 设置mapParam
     * 
     * @Description 设置mapParam
     * @param mapParam
     */
    public void setMapParam(HashMap<String, String> mapParam)
    {
        this.mapParam = mapParam;
    }
    
    /**
     * 
     * 获取files
     * 
     * @Description 获取files
     * @return
     */
    public List<FileInfo> getFiles()
    {
        return files;
    }
    
    /**
     * 设置files
     * 
     * @Description 设置files
     * @param files
     */
    public void setFiles(List<FileInfo> files)
    {
        this.files = files;
    }
    
    /**
     * 
     * 获取requestType
     * 
     * @Description 获取requestType
     * @return
     */
    public int getRequestType()
    {
        return requestType;
    }
    
    /**
     * 设置requestType
     * 
     * @Description 设置requestType
     * @param requestType
     */
    public void setRequestType(int requestType)
    {
        this.requestType = requestType;
    }
    
    /**
     * 
     * 获取mHandler
     * 
     * @Description 获取mHandler
     * @return
     */
    public Handler getmHandler()
    {
        return mHandler;
    }
    
    /**
     * 设置mHandler
     * 
     * @Description 设置mHandler
     * @param mHandler
     */
    public void setmHandler(Handler mHandler)
    {
        this.mHandler = mHandler;
    }
    
    /**
     * 请求类型
     * 
     * @author ren_qiujing
     * 
     */
    public enum SendType
    {
        Normal, // 发送普通数据请求
        Uploadfiles, // 上传文件
        Downloadfiles, // 下载文件
        DownloadfilesWithUrl, // 通过url直接下载文件
        DownloadfilesFromSer
        
    }
    
}
