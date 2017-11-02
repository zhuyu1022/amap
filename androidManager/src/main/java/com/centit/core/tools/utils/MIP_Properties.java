package com.centit.core.tools.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;

import com.centit.GlobalState;
import com.centit.core.tools.logManger.LogUtil;

/**
 * 配置文件工具类
 * 
 */
public class MIP_Properties
{
    
    /**
     * 根据文件名和文件路径 读取Properties文件
     * 
     * @param fileName
     * @param dirName
     * @return 设定文件
     */
    public static Properties loadProperties(String fileName, String dirName)
    {
        Properties props = new Properties();
        try
        {
            int id =
                GlobalState.getInstance()
                    .getResources()
                    .getIdentifier(fileName, dirName, GlobalState.getInstance().getPackageName());
            props.load(GlobalState.getInstance().getResources().openRawResource(id));
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
        return props;
    }
    
    /**
     * 读取Properties文件(指定目录)
     * 
     * @param file
     * @return 设定文件
     */
    public static Properties loadConfig(String file)
    {
        Properties properties = new Properties();
        try
        {
            FileInputStream s = new FileInputStream(file);
            properties.load(s);
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
        return properties;
    }
    
    /**
     * 保存Properties(指定目录)
     * 
     * @param file
     * @param properties 设定文件
     */
    public static void saveConfig(String file, Properties properties)
    {
        try
        {
            FileOutputStream s = new FileOutputStream(file, false);
            properties.store(s, "");
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
    }
    
    /**
     * 读取文件 文件在/data/data/package_name/files下 无法指定位置
     * 
     * @param fileName
     * @return 设定文件
     */
    public static Properties loadConfigNoDirs(String fileName)
    {
        Properties properties = new Properties();
        try
        {
            FileInputStream s = GlobalState.getInstance().openFileInput(fileName);
            properties.load(s);
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
        return properties;
    }
    
    /**
     * 保存文件到/data/data/package_name/files下 无法指定位置
     * 
     * @param fileName
     * @param properties 设定文件
     */
    public static void saveConfigNoDirs(String fileName, Properties properties)
    {
        try
        {
            FileOutputStream s = GlobalState.getInstance().openFileOutput(fileName, Context.MODE_PRIVATE);
            properties.store(s, "");
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
    }
    
    /**
     * <一句话功能简述> 获取Asset目录下的配置文件信息
     * 
     * @Description<功能详细描述>
     * 
     * @param fileName
     * @return
     * @LastModifiedDate：2015-8-31
     * @author rqj
     * @EditHistory：<修改内容><修改人>
     */
    public static Properties loadConfigAssets(String fileName)
    {
        
        Properties properties = new Properties();
        try
        {
            InputStream is = GlobalState.getInstance().getAssets().open(fileName);
            properties.load(is);
        }
        catch (Exception e)
        {
            LogUtil.e(e);
        }
        return properties;
    }
}
