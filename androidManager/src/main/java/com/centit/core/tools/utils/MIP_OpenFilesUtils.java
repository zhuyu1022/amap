/*
 * File name:  OpenFiles.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ma_kaiyuan
 * Last modified date:  2014-2-18
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * 打开相应文件的Intent
 * 
 * @Description<功能详细描述>
 * 
 * @author ma_kaiyuan
 * @Version [版本号, 2014-2-18]
 */
public class MIP_OpenFilesUtils
{
    
    public static String[] fileEndingImage   = new String[] {".png", ".gif", ".jpg", ".jpeg", ".bmp"};
    
    public static String[] fileEndingAudio   = new String[] {".mp3", ".wav", ".ogg", ".midi"};
    
    public static String[] fileEndingVideo   = new String[] {".mp4", ".rmvb", ".avi", ".flv"};
    
    public static String[] fileEndingPackage = new String[] {".jar", ".zip", ".rar", ".gz", ".apk", ".img"};
    
    public static String[] fileEndingWebText = new String[] {".htm", ".html", ".php", ".jsp"};
    
    public static String[] fileEndingText    = new String[] {".txt", ".java", ".c", ".cpp", ".py", ".xml", ".json",
        ".log"                               };
    
    public static String[] fileEndingWord    = new String[] {".doc", ".docx"};
    
    public static String[] fileEndingWps     = new String[] {".wps"};
    
    public static String[] fileEndingExcel   = new String[] {".xls", ".xlsx"};
    
    public static String[] fileEndingPPT     = new String[] {".ppt", ".pptx"};
    
    public static String[] fileEndingPdf     = new String[] {".pdf"};
    
    // android获取一个用于打开HTML文件的intent
    public static Intent getHtmlFileIntent(File file)
    {
        Uri uri =
            Uri.parse(file.toString())
                .buildUpon()
                .encodedAuthority("com.android.htmlfileprovider")
                .scheme("content")
                .encodedPath(file.toString())
                .build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");
        return intent;
    }
    
    // android获取一个用于打开图片文件的intent
    public static Intent getImageFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "image/*");
        return intent;
    }
    
    // android获取一个用于打开PDF文件的intent
    public static Intent getPdfFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/pdf");
        return intent;
    }
    
    // android获取一个用于打开文本文件的intent
    public static Intent getTextFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "text/plain");
        return intent;
    }
    
    // android获取一个用于打开音频文件的intent
    public static Intent getAudioFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }
    
    // android获取一个用于打开视频文件的intent
    public static Intent getVideoFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "video/*");
        return intent;
    }
    
    // android获取一个用于打开CHM文件的intent
    public static Intent getChmFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/x-chm");
        return intent;
    }
    
    // android获取一个用于打开Word文件的intent
    public static Intent getWordFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/msword");
        return intent;
    }
    
    // android获取一个用于打开Excel文件的intent
    public static Intent getExcelFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/vnd.ms-excel");
        return intent;
    }
    
    // android获取一个用于打开PPT文件的intent
    public static Intent getPPTFileIntent(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }
    
    // android获取一个用于打开apk文件的intent
    public static Intent getApkFileIntent(File file)
    {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        return intent;
    }
    
    // 定义用于检查要打开的文件的后缀是否在遍历后缀数组中
    public static boolean checkEndsWithInStringArray(String checkItsEnd, String[] fileEndings)
    {
        for (String aEnd : fileEndings)
        {
            if (checkItsEnd.endsWith(aEnd))
                return true;
        }
        return false;
    }
    
    public static String bytesToString(byte[] src)
    {
        String fileHead = new String(src);
        return fileHead;
    }
    
    public static boolean isPDFFile(String filepath)
    {
        try
        {
            FileInputStream is = new FileInputStream(filepath);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            
            String fileHead = bytesToString(b);
            
            if (fileHead.toLowerCase().contains("pdf"))
            {
                return true;
            }
            
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void openFile(FragmentActivity activity, String filepath)
    {
        
        File file = new File(filepath);
        if (file != null && file.exists() && file.isFile())
        {
            String fileName = file.toString();
            Intent intent = null;
            
            if (isPDFFile(filepath))
            {
                intent = MIP_OpenFilesUtils.getPdfFileIntent(file);
            }
            else
            {
                if (checkEndsWithInStringArray(fileName, fileEndingImage))
                {
                    intent = MIP_OpenFilesUtils.getImageFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingWebText))
                {
                    intent = MIP_OpenFilesUtils.getHtmlFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingPackage))
                {
                    intent = MIP_OpenFilesUtils.getApkFileIntent(file);
                    
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingAudio))
                {
                    intent = MIP_OpenFilesUtils.getAudioFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingVideo))
                {
                    intent = MIP_OpenFilesUtils.getVideoFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingText))
                {
                    intent = MIP_OpenFilesUtils.getTextFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingPdf))
                {
                    intent = MIP_OpenFilesUtils.getPdfFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingWord))
                {
                    intent = MIP_OpenFilesUtils.getWordFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingExcel))
                {
                    intent = MIP_OpenFilesUtils.getExcelFileIntent(file);
                }
                else if (checkEndsWithInStringArray(fileName, fileEndingPPT))
                {
                    intent = MIP_OpenFilesUtils.getPPTFileIntent(file);
                }
                else
                {
                    Toast.makeText(activity, "无法打开，请安装相应的软件！", Toast.LENGTH_SHORT).show();
                }
            }
            
            try
            {
                if (intent != null)
                {
                    activity.startActivity(intent);
                }
            }
            catch (Exception e)
            {
                // TODO: handle exception
                Toast.makeText(activity, "无法打开，请安装相应的软件！", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(activity, "无法打开该文件！", Toast.LENGTH_LONG).show();
        }
    }
}
