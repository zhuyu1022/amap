package com.centit.core.tools.netUtils.engine.socketEngine;

import com.centit.GlobalState;
import com.centit.core.tools.netUtils.baseEngine.NetFactoryCreator;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

/**
 * Socket网络连接创建类
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-10-17]
 */
public class SocketNetFactoryCreator implements NetFactoryCreator
{
    
    @Override
    public NetTask create()
    {
        // TODO Auto-generated method stub
        return new SocketRequstNetTask(0, GlobalState.getInstance());
    }
    
}
