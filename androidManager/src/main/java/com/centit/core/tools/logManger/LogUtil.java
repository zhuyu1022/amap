package com.centit.core.tools.logManger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

import com.centit.GlobalState;
import com.centit.core.tools.utils.OsUtils;

public class LogUtil
{
    /**
     * Tag
     */
    private static String           TAG      = "LogUtil";
    
    /**
     * 常量3
     */
    private final static int        num_3    = 3;
    
    private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 日志的输出格式
                                                                                            
    private static SimpleDateFormat logfile  = new SimpleDateFormat("yyyy-MM-dd");         // 日志文件格式
                                                                                            
    /**
     * 是否打印log
     * 
     * @return
     */
    private static Boolean isWRITELOG()
    {
        // return true;
        return GlobalState.getInstance().getWRITE_LOG();
    }
    
    private static Boolean isSaveToSdcard()
    {
        // return true;
        return GlobalState.getInstance().getSaveLogToSDCard();
    }
    
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param tag tag
     * @param msg msg
     * @LastModifiedDate：2013-10-18
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    @SuppressWarnings("unused")
    public static void v(String msg)
    {
        if (isWRITELOG())
        {
            String className = "";
            String logInfo = "";
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.v(TAG, logInfo + msg);
        }
    }
    
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param tag tag
     * @param msg msg
     * @LastModifiedDate：2013-10-18
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    @SuppressWarnings("unused")
    public static void d(String msg)
    {
        
        if (isWRITELOG())
        {
            String className = "";
            String logInfo = "";
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.d(TAG, logInfo + msg);
        }
        
    }
    
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param tag tag
     * @param msg msg
     * @LastModifiedDate：2013-10-18
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    @SuppressWarnings("unused")
    public static void i(String msg)
    {
        if (isWRITELOG())
        {
            String className = "";
            String logInfo = "";
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.i(TAG, logInfo + msg);
        }
    }
    
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param tag tag
     * @param msg msg
     * @LastModifiedDate：2013-10-18
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static void e(String msg)
    {
        if (isWRITELOG())
        {
            String className = "";
            String logInfo = "";
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.e(TAG, logInfo + msg);
        }
    }
    
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param tag tag
     * @param msg msg
     * @LastModifiedDate：2013-10-18
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static void e(Exception ex)
    {
        if (isWRITELOG())
        {
            String className = "";
            String logInfo = "";
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.e(TAG, logInfo, ex);
        }
    }
    
    /**
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param tag tag
     * @param msg msg
     * @LastModifiedDate：2013-10-18
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static void w(String msg)
    {
        if (isWRITELOG())
        {
            String className = "";
            String logInfo = "";
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.w(TAG, logInfo + msg);
        }
    }
    
    /**
     * 打开日志文件并写入日志
     * 
     * @return
     * **/
    public static void save(String text)
    {// 新建或打开日志文件
        String logInfo = "";
        if (isWRITELOG())
        {
            String className = "";
            
            try
            {
                String fullClassName = Thread.currentThread().getStackTrace()[num_3].getClassName();
                // 获取打印日志所在的类名
                className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
                // 获取打印日志所在的方法名
                String methodName = Thread.currentThread().getStackTrace()[num_3].getMethodName();
                // 获取日志所在的行号
                int lineNumber = Thread.currentThread().getStackTrace()[num_3].getLineNumber();
                // 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
                logInfo = className + ":" + methodName + "() line(" + lineNumber + "):";
                
            }
            catch (Exception e)
            {
                Log.e(TAG, "log error");
            }
            Log.i(TAG, logInfo + text);
        }
        
        if (!isSaveToSdcard())
        {
            return;
        }
        
        Date nowtime = new Date();
        String needWriteMessage = myLogSdf.format(nowtime) + logInfo + text + "\r\n";
        
        if (!GlobalState.getInstance().getLastSaveTime().equals(logfile.format(nowtime)))
        {
            String line1 = "******************************************************\r\n\r\n";
            String line2 = "********************" + logfile.format(nowtime) + "************************\r\n";
            needWriteMessage = line1 + line2 + needWriteMessage;
            
            GlobalState.getInstance().setLastSaveTime(logfile.format(nowtime));
        }
        
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            String path =
                Environment.getExternalStorageDirectory().getAbsolutePath()
                    + OsUtils.getApplicationName(GlobalState.getInstance().getApplicationContext(), "/MIP/") + "/log/";
            File dirFile = new File(path);
            if (dirFile != null && !dirFile.exists())
            {
                dirFile.mkdirs();
            }
            
            File file = new File(path + "/logfile.txt");
            
            if (file != null && (file.length() - 50 * 1024 * 1024) > 0)
            {
                file.delete();
            }
            
            FileWriter filerWriter = null;
            BufferedWriter bufWriter = null;
            try
            {
                filerWriter = new FileWriter(file, true);// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
                bufWriter = new BufferedWriter(filerWriter);
                bufWriter.write(needWriteMessage);
                bufWriter.newLine();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally
            {
                if (bufWriter != null)
                {
                    try
                    {
                        bufWriter.close();
                        bufWriter = null;
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (filerWriter != null)
                {
                    try
                    {
                        filerWriter.close();
                        filerWriter = null;
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
