package com.centit.core.tools.netUtils.engine.socketEngine;

import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity;

public class SocketNetParamEntry extends NetParamEntity
{
    private int PORT;
    
    public int getPORT()
    {
        return PORT;
    }
    
    public void setPORT(int pORT)
    {
        PORT = pORT;
    }
}
