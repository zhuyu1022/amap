package com.centit.core.tools.netUtils.baseEngine.netTask;

import android.content.Context;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseEngine.NetInterface.OnFinishListen;
import com.centit.core.tools.netUtils.baseEngine.NetInterface.OnSystemFinishListen;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.DownloadEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.UploadEntityHandle;

/**
 * 网络处理基类
 * 
 * @author ren_qiujing
 * 
 */
public abstract class NetTask implements Runnable
{
    protected Context              mContext;
    
    /** 获得当前自身线程的引用 在threadRun方法 */
    protected Thread               thread;
    
    /** 任务进度监听 */
    protected ProcessEntityHandle  onProcessEntityHandler;
    
    /** 任务完成监听 */
    protected OnFinishListen       onFinishListen;
    
    /** 任务在队列中完成 监听 */
    protected OnSystemFinishListen onSystemFinishListen;
    
    /**
     * 解析返回报文流，解析为String或file文件
     */
    protected DownloadEntityHandle mDownloadEntityHandler;
    
    /**
     * 上传时，将文件转换为文件流
     */
    protected UploadEntityHandle   mUploadHandlerEntity;
    
    /** 线程处理状态，初始值为未处理 */
    protected int                  mSTATUS       = UNTREATED;
    
    /** 处理错误 */
    public final static int        ERROR         = -1;
    
    /** 未处理 */
    public final static int        UNTREATED     = 0;
    
    /** 处理完成 */
    final static int               FINSH         = 1;
    
    /** 正在处理中 */
    public final static int        TREATEDING    = 2;
    
    /** 不处理 */
    public final static int        CANCEL_THREAD = 3;
    
    protected int                  requestType;
    
    /**
     * 连接网络时返回的code，正确返回为-1；
     */
    protected int                  retCode       = -1;
    
    public NetTask(int requestType, Context context)
    {
        
        this.requestType = requestType;
        this.mContext = context;
    }
    
    /**
     * 返回参数
     */
    Object result = null;
    
    /** 启动线程 */
    public void threadRun()
    {
        thread = new Thread(this);
        thread.start();
    }
    
    public abstract void setParam(Object param);
    
    /**
     * 中断线程
     */
    public void shutDownExecute()
    {
        LogUtil.v("the thread was killed!" + Thread.currentThread().getId());
    };
    
    /**
     * 发送数据方法
     * 
     * @param 请求的参数
     * @return 返回的数据
     * @throws Exception
     */
    public abstract Object send()
        throws Exception;
    
    /**
     * 接收数据方法
     * 
     * @return
     */
    public abstract Object receive()
        throws Exception;
    
    /**
     * 请求连接
     */
    public abstract void connect();
    
    /**
     * 关闭连接
     */
    public abstract void close();
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        
        try
        {
            execute();
        }
        catch (MIPException e)
        {
            if (onFinishListen != null)
            {
                if (mSTATUS == CANCEL_THREAD)
                {
                    onFinishListen.onFinish(Constant_Net.CANCEL_REQUEST, "cancel thread!");
                }
                else
                {
                    onFinishListen.onFinish(e.getId(), e.geteInfo());
                }
            }
            if (onSystemFinishListen != null)
            {
                onSystemFinishListen.onSystemFinish("error", this);
            }
        }
        
    }
    
    int responseCode;
    
    // 禁止被重写
    public final Object execute()
        throws MIPException
    {
        // TODO Auto-generated method stub
        mSTATUS = TREATEDING;
        // 失败重联次数
        for (int i = 0; i < Constant_Net.TRY_AGAIN_COUNT; i++)
        {
            try
            {
                result = send();
                
                if (retCode == 200)
                {
                    responseCode = Constant_Net.SUCCESS;
                }
                else
                {
                    responseCode = Constant_Net.RETCODEERROR;
                }
                
                break;
            }
            catch (MIPException e)
            {
                // TODO: handle exception
                LogUtil.e("execute msg=" + e.getMessage());
                try
                {
                    Thread.sleep(Constant_Net.TRY_AGAIN_TIME);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
                
                if (i == Constant_Net.TRY_AGAIN_COUNT - 1)
                {
                    throw e;
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                try
                {
                    Thread.sleep(Constant_Net.TRY_AGAIN_TIME);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
                
                if (i == Constant_Net.TRY_AGAIN_COUNT - 1)
                {
                    throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
                }
            }
        }
        
        if (onFinishListen != null)
        {
            if (mSTATUS == CANCEL_THREAD)
            {
                responseCode = Constant_Net.CANCEL_REQUEST;
                result = "Cancel thread!";
            }
            onFinishListen.onFinish(responseCode, result);
        }
        
        if (onSystemFinishListen != null)
        {
            onSystemFinishListen.onSystemFinish(result, this);
        }
        
        mSTATUS = FINSH;
        return result;
    }
    
    public ProcessEntityHandle getOnProcessEntityHandler()
    {
        return onProcessEntityHandler;
    }
    
    public void setOnProcessEntityHandler(ProcessEntityHandle onProcessEntityHandler)
    {
        this.onProcessEntityHandler = onProcessEntityHandler;
    }
    
    public OnFinishListen getOnFinishListen()
    {
        return onFinishListen;
    }
    
    public void setOnFinishListen(OnFinishListen onFinishListen)
    {
        this.onFinishListen = onFinishListen;
    }
    
    public OnSystemFinishListen getOnSystemFinishListen()
    {
        return onSystemFinishListen;
    }
    
    public void setOnSystemFinishListen(OnSystemFinishListen onSystemFinishListen)
    {
        this.onSystemFinishListen = onSystemFinishListen;
    }
    
    public DownloadEntityHandle getmDownloadEntityHandler()
    {
        return mDownloadEntityHandler;
    }
    
    public void setmDownloadEntityHandler(DownloadEntityHandle mDownloadEntityHandler)
    {
        this.mDownloadEntityHandler = mDownloadEntityHandler;
    }
    
    public UploadEntityHandle getmUploadHandlerEntity()
    {
        return mUploadHandlerEntity;
    }
    
    public void setmUploadHandlerEntity(UploadEntityHandle mUploadHandlerEntity)
    {
        this.mUploadHandlerEntity = mUploadHandlerEntity;
    }
    
    /**
     * 设置网络为不处理
     */
    public void setCancelThread()
    {
        this.mSTATUS = CANCEL_THREAD;
    }
    
    public void cacheClear()
    {
        if (onProcessEntityHandler != null)
            onProcessEntityHandler = null;
        if (onFinishListen != null)
            onFinishListen = null;
        if (onSystemFinishListen != null)
            onSystemFinishListen = null;
        if (thread != null)
            thread = null;
        // if(handler!=null)handler=null;
        // if(singletonName!=null)singletonName=null;
        // if(tag!=null)tag=null;
        //
        // if(taskViewHolder!=null)taskViewHolder=null;
        // if(taskObservable!=null)taskObservable=null;
        // if(context!=null)context=null;
    }
    
}
