/*
 * File name:  MIP_ClassUtils.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  rqj
 * Last modified date:  2015-9-8
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.utils;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-8]
 */
public class MIP_ClassUtils
{
    /**
     * 根据类目，获取类的实例
     * 
     * @return
     */
    public static Class<?> getViewClass(String classView)
    {
        Class<?> onwClass = null;
        try
        {
            onwClass = Class.forName(classView);
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return onwClass;
    }
}
