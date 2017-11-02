package com.centit.core.tools.netUtils;

import java.util.ArrayList;
import java.util.LinkedList;

import com.centit.core.tools.netUtils.baseEngine.NetInterface.OnSystemFinishListen;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class NetTaskQueue implements Runnable, OnSystemFinishListen
{
    static String               debug         = "TaskQueue";
    
    @SuppressWarnings("unchecked")
    // 在等待的任务队列
    static LinkedList<NetTask>  tasks_wait    = new LinkedList<NetTask>();
    
    // 正在执行的任务
    static ArrayList<NetTask>   tasks_running = new ArrayList<NetTask>();
    
    // 是否持续运行
    public static boolean       isRun;
    
    // 队列线程
    private static Thread       taskQueueThread;
    
    // runnable保证线程安全
    private static NetTaskQueue runnable      = new NetTaskQueue();        ;
    
    // 最大线程数
    static int                  ThreadMaxNum  = 5;
    
    // 如果队列线程为空或者停止则重新开启
    public static synchronized void serivesRun()
    {
        // TODO Auto-generated method stub
        if (taskQueueThread == null
            || (taskQueueThread != null && taskQueueThread.getState() == Thread.State.TERMINATED))
        {
            taskQueueThread = new Thread(runnable);
            // taskQueueThread.setPriority(Thread.MAX_PRIORITY);
            taskQueueThread.start();
        }
    }
    
    // 线程锁 如果等待队列的任务数不为空，并且当前线程数字少于最大线程数
    public static boolean taskRun()
    {
        synchronized (tasks_wait)
        {
            synchronized (tasks_running)
            {
                return !tasks_wait.isEmpty() && tasks_running.size() < ThreadMaxNum;
            }
        }
    }
    
    public void run()
    {
        // 线程锁 如果等待队列的任务数不为空，并且当前线程数字少于最大线程数
        
        while (taskRun())
        {
            // 添加带执行中动态数组中
            NetTask h;
            synchronized (tasks_wait)
            {
                // 从等待任务的队列中获取并移除此列表的头（第一个元素）
                h = tasks_wait.poll();
                
                // 如果h为空则从队列重新取对象或者任务绑定的状态变化了
                if (h == null)
                {
                    // Log.i(debug , "任务取消 编号" + h.getRequestUIID());
                    continue;
                }
                synchronized (tasks_running)
                {
                    tasks_running.add(h);
                }
                // LogUtil.i(debug, "正在执行任务数" + tasks_running.size() + "/上限" + ThreadMaxNum);
                
                // 为h设置完成或者报错进行监听
                h.setOnSystemFinishListen(runnable);
                // 启动此线程
            }
            h.threadRun();
        }
        
    }
    
    @Override
    public Boolean onSystemFinish(Object data, NetTask t)
    {
        // TODO Auto-generated method stub
        synchronized (tasks_running)
        {
            // 从处理中的动态数组中移除此任务
            tasks_running.remove(t);
            // 通知执行后续未处理的任务
        }
        runnable.run();
        synchronized (tasks_wait)
        {
            if (taskQueueThread != null)
            {
                synchronized (taskQueueThread)
                {
                    // 如果等待队列中的任务
                    if (tasks_wait.isEmpty())
                    {
                        taskQueueThread = null;
                    }
                }
            }
        }
        // t.cacheClear();
        return true;
    }
    
}
