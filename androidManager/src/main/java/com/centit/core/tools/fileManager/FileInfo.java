package com.centit.core.tools.fileManager;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.BaseParseResponse;

/**
 * 描述一个文件的类
 * 
 * @author ren_qiujing
 * 
 */
public class FileInfo
{
    /**
     * 文件路径
     */
    public String            filepath;
    
    public String            filetitle;
    
    public String            fileuiid;
    
    /**
     * 文件名称
     */
    public String            filename;
    
    /**
     * 文件类型
     */
    public String            filetype;
    
    /**
     * 文件唯一标识
     */
    public String            fileOnlyId;
    
    /**
     * 文件大小
     */
    public String            fileSize;
    
    /**
     * 文件创建时间
     */
    public String            fileCreateTime;
    
    /**
     * 文件创建时间
     */
    public String            fileLastModifyTime;
    
    /**
     * 下载文件时，返回的内容，可能为空，可能又值
     */
    public BaseParseResponse retResponse;
    
    /**
     * 文件下载时的路径
     */
    public String            fileDownloadUrl;
    
    public String getFilepath()
    {
        return filepath;
    }
    
    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }
    
    public String getFilename()
    {
        return filename;
    }
    
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    
    public String getFiletype()
    {
        return filetype;
    }
    
    public void setFiletype(String filetype)
    {
        this.filetype = filetype;
    }
    
    public String getFileOnlyId()
    {
        return fileOnlyId;
    }
    
    public void setFileOnlyId(String fileOnlyId)
    {
        this.fileOnlyId = fileOnlyId;
    }
    
    public String getFileSize()
    {
        return fileSize;
    }
    
    public void setFileSize(String fileSize)
    {
        this.fileSize = fileSize;
    }
    
    public String getFileCreateTime()
    {
        return fileCreateTime;
    }
    
    public void setFileCreateTime(String fileCreateTime)
    {
        this.fileCreateTime = fileCreateTime;
    }
    
    public String getFileLastModifyTime()
    {
        return fileLastModifyTime;
    }
    
    public void setFileLastModifyTime(String fileLastModifyTime)
    {
        this.fileLastModifyTime = fileLastModifyTime;
    }
    
    public String getFiletitle()
    {
        return filetitle;
    }
    
    public void setFiletitle(String filetitle)
    {
        this.filetitle = filetitle;
    }
    
    public String getFileuiid()
    {
        return fileuiid;
    }
    
    public void setFileuiid(String fileuiid)
    {
        this.fileuiid = fileuiid;
    }
    
    public BaseParseResponse getRetResponse()
    {
        return retResponse;
    }
    
    public void setRetResponse(BaseParseResponse retResponse)
    {
        this.retResponse = retResponse;
    }
    
    public String getFileDownloadUrl()
    {
        return fileDownloadUrl;
    }
    
    public void setFileDownloadUrl(String fileDownloadUrl)
    {
        this.fileDownloadUrl = fileDownloadUrl;
    }
    
}
