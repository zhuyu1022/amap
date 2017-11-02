package com.centit.core.tools.netUtils.engine.httpEngine;

import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity;

public class HttpNetParamEntry extends NetParamEntity
{
    /**
     * 编码方式
     */
    public String encoding = "UTF-8";
    
    public String getEncoding()
    {
        return encoding;
    }
    
    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }
}
