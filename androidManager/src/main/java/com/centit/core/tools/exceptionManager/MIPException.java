/*
 * File name:  Exception.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  Exception Management
 * Author:  Midnight
 * Last modified date:  2013-8-2
 * Version:  0.1
 * Edit history: 1.Create -Midnight
 */
package com.centit.core.tools.exceptionManager;


/**
 * Exception Management
 * 
 * @Description get Exceptions from IAAF then deal and log
 * 
 * @author Midnight
 * @Version [0.1, 2013-8-2]
 */
public class MIPException extends java.lang.Exception
{
    /**
     * serial Version UID(auto)
     */
    private static final long serialVersionUID = 8347586502976506321L;
    
    /**
     * Exception message
     */
    private String            eInfo            = "";
    
    /**
     * Exception ID in ExceptionConst.java
     */
    private int               exceptionID      = 0;
    
    public int getId()
    {
        return exceptionID;
    }
    
    /**
     * 
     * <默认构造函数>
     */
    public MIPException()
    {
        super();
    }
    
    /**
     * 
     * <默认构造函数>
     * 
     * @param info exception information
     */
    public MIPException(String info)
    {
        super(info);
        
        String logInfo = "";
        try
        {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            // 获取打印日志所在的类名
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + info;
            
        }
        catch (Exception e)
        {
            eInfo = info;
        }
        
        eInfo = logInfo;
    }
    
    /**
     * 
     * <默认构造函数>
     * 
     * @param ID exception ID
     * @param info exception information
     */
    public MIPException(int ID, String info)
    {
        super(info);
        
        String className = "";
        String logInfo = "";
        try
        {
            String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            // 获取打印日志所在的类名
            className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            logInfo = className + ":" + methodName + "() line(" + lineNumber + "):" + info;
            
        }
        catch (Exception e)
        {
            eInfo = info;
        }
        eInfo = logInfo;
        exceptionID = ID;
    }
    
    /**
     * 
     * <默认构造函数>
     * 
     * @param ID exception ID
     */
    public MIPException(int ID)
    {
        super();
        exceptionID = ID;
    }
    
    @Override
    public void printStackTrace()
    {
        super.printStackTrace();
        // StackTraceElement[] temp;
        // temp = super.getStackTrace();
        // int templines = temp.length;
        // DebugTool.debugInfoList.add("Exception ID:" + exceptionID + "|" + eInfo);
        // for (int i = 0; i < templines; i++)
        // {
        // DebugTool.debugInfoList.add(temp[i].toString());
        // }
        // templines = DebugTool.debugInfoList.size();
        // // 根据应用中设定的显示最大行数判断是否要移除多余的信息
        // int maxlines = SystemTools.getAppcontext().debugline;
        // for (int i = maxlines; i < templines; i++)
        // {
        // DebugTool.debugInfoList.remove(0);
        // }
    }
    
    public String geteInfo()
    {
        return eInfo;
    }
    
    public void seteInfo(String eInfo)
    {
        this.eInfo = eInfo;
    }
    
    public static void setExceptionInfo(String eInfo)
    {
        
    }
    
}
