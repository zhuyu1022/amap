/*
 * File name:  ParseXmlUtils.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  Administrator
 * Last modified date:  2015-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipThirtpart.cmipmodulemgr;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.content.res.AssetManager;
import android.util.Xml;

import com.centit.GlobalState;
import com.centit.core.tools.logManger.LogUtil;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author Administrator
 * @Version [版本号, 2015-9-22]
 */
public class ModuleParseXmlUtils
{
    /**
     * <一句话功能简述> 解析功能
     * 
     * @Description<功能详细描述>
     * 
     * @param input
     * @return
     * @throws Exception
     * @LastModifiedDate：2015-9-22
     * @author Administrator
     * @EditHistory：<修改内容><修改人>
     */
    private static List<ModuleEntity> parseFuncion(InputStream input)
        throws Exception
    {
        List<ModuleEntity> lists = null;
        ModuleEntity module = null;
        
        XmlPullParser pullParser = Xml.newPullParser();
        pullParser.setInput(input, "UTF-8"); // 为Pull解释器设置要解析的XML数据
        String value = "";
        int event = pullParser.getEventType();
        
        while (event != XmlPullParser.END_DOCUMENT)
        {
            switch (event)
            {
                case XmlPullParser.START_DOCUMENT:
                    lists = new ArrayList<ModuleEntity>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("module".equals(pullParser.getName()))
                    {
                        module = new ModuleEntity();
                    }
                    if ("funcode".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setFuncode(value);
                    }
                    if ("funclasspath".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setFunclasspath(value);
                    }
                    if ("funicon".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        // module.setFunicon(value);
                        module.setFunicon_l(value);
                    }
                    
                    if ("value".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setValue(value);
                    }
                    
                    if ("count_able".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setCount_able(value);
                    }
                    if ("count_icon_1".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setCount_icon_1(value);
                    }
                    if ("count_icon_2".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setCount_icon_2(value);
                    }
                    
                    if ("type".equals(pullParser.getName()))
                    {
                        value = pullParser.nextText();
                        module.setCount_type(value);
                    }
                    break;
                
                case XmlPullParser.END_TAG:
                    if ("module".equals(pullParser.getName()))
                    {
                        lists.add(module);
                        module = null;
                    }
                    break;
            }
            event = pullParser.next();
        }
        return lists;
    }
    
    /**
     * 根据assets文件下文件名，获取所有功能
     * 
     * @Description<功能详细描述>
     * 
     * @param filename
     * @return
     * @LastModifiedDate：2015-9-22
     * @author Administrator
     * @EditHistory：<修改内容><修改人>
     */
    public static List<ModuleEntity> parseModule(String filename)
    {
        List<ModuleEntity> lists = null;
        
        AssetManager am = GlobalState.getInstance().getAssets();
        InputStream is = null;
        try
        {
            is = am.open(filename);
            try
            {
                lists = ModuleParseXmlUtils.parseFuncion(is);
                LogUtil.i("");
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (lists == null)
        {
            lists = new ArrayList<ModuleEntity>();
        }
        return lists;
        
    }
}
