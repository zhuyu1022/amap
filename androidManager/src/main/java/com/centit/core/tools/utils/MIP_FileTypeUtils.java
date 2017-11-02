package com.centit.core.tools.utils;

import java.io.File;

public class MIP_FileTypeUtils
{
    
    public static String distinguishByName(String fileName)
    {
        if (fileName.indexOf(".") > 0)
        {
            
            String fileType = fileName.substring(fileName.indexOf("."), fileName.length());
            if (fileType != null)
            {
                if (fileName.endsWith("jpg") || fileName.endsWith("png") || fileName.endsWith("jpeg")
                    || fileName.endsWith("JPG") || fileName.endsWith("PNG") || fileName.endsWith("JPEG"))
                {
                    return "IMG";
                }
                else if (fileName.endsWith("doc") || fileName.endsWith("DOC") || fileName.endsWith("docx")
                    || fileName.endsWith("DOCX"))
                {
                    return "DOC";
                }
                else if (fileName.endsWith("mp4") || fileName.endsWith("MP4"))
                {
                    return "MP4";
                }
                else if (fileName.endsWith("pdf") || fileName.endsWith("PDF"))
                {
                    return "PDF";
                }
                else if (fileName.endsWith("xls") || fileName.endsWith("XLS") || fileName.endsWith("xlsx")
                    || fileName.endsWith("XLSX"))
                {
                    return "XLS";
                }
                else if (fileName.endsWith("zip") || fileName.endsWith("rar") || fileName.endsWith("ZIP")
                    || fileName.endsWith("RAR"))
                {
                    return "ZIP";
                }
                else if (fileName.endsWith("ppt") || fileName.endsWith("PPT") || fileName.endsWith("pptx")
                    || fileName.endsWith("PPTX"))
                {
                    return "PPT";
                }
                else if (fileName.endsWith("txt") || fileName.endsWith("TXT") || fileName.endsWith("xml")
                    || fileName.endsWith("XML"))
                {
                    
                    return "TXT";
                }
            }
            
        }
        return "OTHER";
        
    }
    
    public static String distinguish(File file)
    {
        String name = file.getName();
        if (file.isDirectory())
        {
            return "DIR";
        }
        else
        {
            if (name != null && name != "")
            {
                if (name.endsWith("jpg") || name.endsWith("png") || name.endsWith("jpeg") || name.endsWith("JPG")
                    || name.endsWith("PNG") || name.endsWith("JPEG"))
                {
                    return "IMG";
                }
                else if (name.endsWith("doc") || name.endsWith("DOC") || name.endsWith("docx") || name.endsWith("DOCX"))
                {
                    return "DOC";
                }
                else if (name.endsWith("mp4") || name.endsWith("MP4"))
                {
                    return "MP4";
                }
                else if (name.endsWith("pdf") || name.endsWith("PDF"))
                {
                    return "PDF";
                }
                else if (name.endsWith("xls") || name.endsWith("XLS") || name.endsWith("xlsx") || name.endsWith("XLSX"))
                {
                    return "XLS";
                }
                else if (name.endsWith("zip") || name.endsWith("rar") || name.endsWith("ZIP") || name.endsWith("RAR"))
                {
                    return "ZIP";
                }
                else if (name.endsWith("ppt") || name.endsWith("PPT"))
                {
                    return "PPT";
                }
                else if (name.endsWith("txt") || name.endsWith("TXT"))
                {
                    
                    return "TXT";
                }
            }
            
        }
        return "OTHER";
        
    }
}
