package com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.DownloadEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;

/**
 * 下载的文件为zip流，流中包括 .json文件和要下载的文件 网络交互时，返回的流内容的类型为 File
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class FileDownloadHandleEntity implements DownloadEntityHandle
{
    /**
     * 文件的下载路径
     */
    private String mFilePath;
    
    /**
	 * 
	 */
    public FileDownloadHandleEntity(String filePath)
    {
        super();
        this.mFilePath = filePath;
    }
    
    /*
     * 下载的流为普通文件，直接将其解析为文件
     */
    @Override
    public Object downloadHandler(InputStream in, ProcessEntityHandle onProgressListen)
        throws Exception
    {
        return Unzip(in, onProgressListen);
    }
    
    private String Unzip(InputStream inputStream, ProcessEntityHandle onProgressListen)
        throws Exception
    {
        
        String UnzipJsonString = "";
        
        long totalLength = 0;
        
        double unzipLength = 0;
        
        int BUFFER = 4096;// 这里缓冲区我们使用4KB，
        String strEntry; // 保存每个zip的条目名称
        BufferedOutputStream dest = null;
        File entryFile = null;
        try
        {
            // 缓冲输出流
            ZipInputStream zis = new ZipInputStream(inputStream);
            ZipEntry entry; // 每个zip条目的实例
            
            if (onProgressListen != null)
            {
                totalLength = onProgressListen.getmContentLength();
            }
            
            while ((entry = zis.getNextEntry()) != null)
            {
                
                int count;
                byte data[] = new byte[BUFFER];
                strEntry = entry.getName();
                
                if (strEntry.endsWith("json"))
                {
                    
                    StringBuffer out = new StringBuffer();
                    byte[] b = new byte[4096];
                    for (int n; (n = zis.read(b)) != -1;)
                    {
                        out.append(new String(b, 0, n));
                    }
                    
                    UnzipJsonString = out.toString();
                }
                else
                {
                    
                    LogUtil.i("entry.getName()=" + entry.getName());
                    
                    entryFile = new File(mFilePath);
                    File entryDir = new File(entryFile.getParent());
                    
                    if (!entryDir.exists())
                    {
                        entryDir.mkdirs();
                    }
                    
                    FileOutputStream fos = new FileOutputStream(entryFile);
                    dest = new BufferedOutputStream(fos, BUFFER);
                    while ((count = zis.read(data, 0, BUFFER)) != -1)
                    {
                        dest.write(data, 0, count);
                        unzipLength = unzipLength + count;
                        onProgressListen.onProgress((int)(((double)(unzipLength) / (double)totalLength) * 100));
                    }
                    
                    dest.flush();
                    dest.close();
                }
            }
            zis.close();
        }
        catch (Exception cwj)
        {
            cwj.printStackTrace();
            if (entryFile != null)
            {
                try
                {
                    entryFile.delete();
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                    throw new Exception("删除文件出错", cwj);
                }
                
            }
            
            throw new Exception("解压文件出错", cwj);
        }
        finally
        {
            if (dest != null)
            {
                dest.close();
            }
        }
        return UnzipJsonString;
        
    }
}
