package com.centit.core.tools.netUtils.engine.webserviceEngine;

import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity;

public class WSNetParamEntry extends NetParamEntity
{
    /**
     * WS时访问时，需要命名空间
     */
    public String NAME_SPCAE;
    
    /**
     * WS访问时的方法名
     */
    public String methodname = "";
    
    public String getNAME_SPCAE()
    {
        return NAME_SPCAE;
    }
    
    public void setNAME_SPCAE(String nAME_SPCAE)
    {
        NAME_SPCAE = nAME_SPCAE;
    }
    
    public String getMethodname()
    {
        return methodname;
    }
    
    public void setMethodname(String methodname)
    {
        this.methodname = methodname;
    }
    
}
