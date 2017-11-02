package com.centit.app.cmipmodule.person.parseResponse;

import java.io.Serializable;

public class UnCountDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            unhandlecount;
    
    /**
     * 获取 unhandlecount
     * 
     * @return 返回 unhandlecount
     * @author rqj
     */
    public String getUnhandlecount()
    {
        return unhandlecount;
    }
    
    /**
     * 设置 unhandlecount
     * 
     * @param unhandlecount 对unhandlecount进行赋值
     * @author rqj
     */
    public void setUnhandlecount(String unhandlecount)
    {
        this.unhandlecount = unhandlecount;
    }
    
}
