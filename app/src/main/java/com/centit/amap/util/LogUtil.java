package com.centit.amap.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by zhu_yu on 2017/10/25.
 */

public class LogUtil {
    //是否打印日志
    public static final  boolean  writeLog=true;

    public static final String logFileName="LocatonLog.txt";

    private final static int   num_3=3;
    public static void  d(String msg){
        if (writeLog){
            String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
            // 获取打印日志所在的类名
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
           // String tag= className + ":" + methodName + "() line(" + lineNumber + "):";
            Log.d(className, methodName+ ":" +msg);
        }
    }

    public static void  v(String msg){
        if (writeLog){
            String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
            // 获取打印日志所在的类名
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            // String tag= className + ":" + methodName + "() line(" + lineNumber + "):";
            Log.v(className, methodName+ ":" +msg);
        }
    }
    public static void  i(String msg){
        if (writeLog){
            String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
            // 获取打印日志所在的类名
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            // String tag= className + ":" + methodName + "() line(" + lineNumber + "):";
            Log.i(className, methodName+ ":" +msg);
        }
    }

    public static void  w(String msg){
        if (writeLog){
            String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
            // 获取打印日志所在的类名
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            // String tag= className + ":" + methodName + "() line(" + lineNumber + "):";
            Log.w(className, methodName+ ":" +msg);
        }
    }
    public static void  e(String msg){
        if (writeLog){
            String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
            // 获取打印日志所在的类名
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            // 获取打印日志所在的方法名
            String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
            // 获取日志所在的行号
            int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
            // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
            // String tag= className + ":" + methodName + "() line(" + lineNumber + "):";
            Log.e(className, methodName+ ":" +msg);
        }
    }








    //写数据到SD中的文件
    public static void save(Context context, String write_str) {
        if (writeLog){
            try {
                File file = new File(context.getExternalCacheDir(), logFileName);
                FileOutputStream fout = new FileOutputStream(file, true);
                byte[] bytes = write_str.getBytes();
                fout.write(bytes);
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
