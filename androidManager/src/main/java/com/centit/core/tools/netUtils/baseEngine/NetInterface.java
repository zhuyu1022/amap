package com.centit.core.tools.netUtils.baseEngine;

import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class NetInterface
{
    /**
     * 任务进行中监听接口
     * 
     * @author ren_qiujing
     * 
     */
    public interface OnProgressListen
    {
        void onProgress(Object obj);
    }
    
    /**
     * 任务完成监听接口
     * 
     * @author ren_qiujing
     * 
     */
    public interface OnFinishListen
    {
        Boolean onFinish(int responseCode, Object data);
    }
    
    /**
     * 任务完成监听接口
     * 
     * @author ren_qiujing
     * 
     */
    public interface OnFinishListen1
    {
        Boolean onFinish(int responseCode, int requestType, Object data);
    }
    
    /**
     * 任务完成监听接口，返回给队列管理器
     * 
     * @author ren_qiujing
     * 
     */
    public interface OnSystemFinishListen
    {
        Boolean onSystemFinish(Object data, NetTask t);
    }
}
