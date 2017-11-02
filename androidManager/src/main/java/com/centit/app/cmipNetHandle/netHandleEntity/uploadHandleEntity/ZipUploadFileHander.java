package com.centit.app.cmipNetHandle.netHandleEntity.uploadHandleEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.UploadEntityHandle;

/**
 * 上传文件时处理上传流
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class ZipUploadFileHander extends UploadEntityHandle
{
    
    public static final String requestStr   = "requestStr";
    
    public static final String requestFiles = "requestFiles";
    
    private List<FileInfo>     files        = new ArrayList<FileInfo>();
    
    private String             requestObj;
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean uploadHandler(OutputStream out, ProcessEntityHandle listen)
        throws MIPException
    {
        
        if (objectParams != null)
        {
            HashMap<String, Object> map = (HashMap<String, Object>)objectParams;
            
            requestObj = (String)map.get(requestStr);
            files = (List<FileInfo>)map.get(requestFiles);
        }
        
        long allSendSize = 0L;
        if (files != null && files.size() > 0)
        {
            for (FileInfo info : files)
            {
                File file = new File(info.filepath);
                if (file.exists())
                {
                    allSendSize += file.length();
                }
            }
        }
        if (requestObj != null)
        {
            allSendSize += requestObj.length();
        }
        
        // TODO Auto-generated method stub
        ZipOutputStream zipOut = new ZipOutputStream(out);
        FileInputStream in = null;
        try
        {
            if (files != null && files.size() > 0)
            {
                for (FileInfo info : files)
                {
                    File file = new File(info.filepath);
                    if (file.exists())
                    {
                        try
                        {
                            zipOut.putNextEntry(new ZipEntry(info.filename));
                            in = new FileInputStream(file);
                            int nNumber;
                            byte[] buffer = new byte[1024 * 2];
                            long total_sendsize = 0L;
                            long startTime = System.currentTimeMillis();
                            while ((nNumber = in.read(buffer)) != -1)
                            {
                                zipOut.write(buffer, 0, nNumber);
                                total_sendsize += nNumber;
                                long endTime = System.currentTimeMillis();
                                if (endTime - startTime > 10)
                                {
                                    int pro = (int)(100 * (float)total_sendsize / allSendSize);
                                    listen.onProgress(pro);
                                }
                            }
                            zipOut.flush();
                            
                        }
                        catch (IOException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            throw new MIPException(ExceptionConst.IOEXCEPTION, e.toString());
                        }
                        catch (Exception e)
                        {
                            // TODO: handle exception
                            e.printStackTrace();
                            throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
                        }
                        finally
                        {
                            if (in != null)
                            {
                                try
                                {
                                    in.close();
                                }
                                catch (IOException e)
                                {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    
                }
            }
        }
        catch (MIPException e)
        {
            // TODO: handle exception
            throw e;
        }
        
        if (requestObj != null)
        {
            try
            {
                ZipEntry dataEntity = new ZipEntry("data.json");
                zipOut.putNextEntry(dataEntity);
                zipOut.write(requestObj.getBytes("utf-8"));
                // 刷新
                zipOut.flush();
                
            }
            catch (Exception e)
            {
                // TODO: handle exception
                e.printStackTrace();
                throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
            }
        }
        try
        {
            zipOut.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new MIPException(ExceptionConst.IOEXCEPTION, e.toString());
        }
        return true;
    }
}
