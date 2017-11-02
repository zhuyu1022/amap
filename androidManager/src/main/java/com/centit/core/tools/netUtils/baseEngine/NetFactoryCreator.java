package com.centit.core.tools.netUtils.baseEngine;

import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

public interface NetFactoryCreator
{
    /**
     * 创建网络访问实例
     * 
     * @return
     */
    NetTask create();
}
