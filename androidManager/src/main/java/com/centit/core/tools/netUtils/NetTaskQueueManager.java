package com.centit.core.tools.netUtils;

import java.util.ArrayList;
import java.util.LinkedList;

import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public class NetTaskQueueManager
{
    // 在等待的任务队列
    static LinkedList<NetTask> tasks_wait    = NetTaskQueue.tasks_wait;
    
    // 正在执行的任务
    static ArrayList<NetTask>  tasks_running = NetTaskQueue.tasks_running;
    
    // 添加一个任务到队列末尾
    public static boolean add(NetTask bs)
    {
        
        if (bs == null)
        {
            return false;
        }
        synchronized (tasks_wait)
        {
            tasks_wait.add(bs);
            // 启动此服务
            NetTaskQueue.serivesRun();
            return true;
        }
    }
    
    // 添加或者改变一个待处理任务在到队列头
    public static boolean addPoll(NetTask bs)
    {
        if (bs == null)
        {
            return false;
        }
        synchronized (tasks_wait)
        {
            
            tasks_wait.remove(bs);
            tasks_wait.addFirst(bs);
            // 启动此服务
            NetTaskQueue.serivesRun();
            return true;
        }
    }
    
    // // 移除一个正在等待或者处理中的任务
    // public static void remove(NetTask bs)
    // {
    // bs.setWithout();
    // }
    
    // 设置最大线程数0~10之间
    public static void setThreadMaxNum(int num)
    {
        if (num <= 0)
        {
            NetTaskQueue.ThreadMaxNum = 1;
            return;
        }
        if (num > 10)
        {
            NetTaskQueue.ThreadMaxNum = 10;
            return;
        }
        NetTaskQueue.ThreadMaxNum = num;
    }
    
    // 返回当前正在运行执行的任务数
    public static int getThreadCurrentNum()
    {
        return tasks_running.size();
    }
    
    public static void set(NetTask task, Object param)
    {
        task.setParam(param);
        add(task);
    }
}
