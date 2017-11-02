package com.centit.app.cmipmodule.gwsp.entity;

import java.io.Serializable;

public class GWSPHistoryDataResponse implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String            wfname;
    
    private String            handlename;
    
    private String            handletime;
    
    private String            hid;
    
    private String            opinion;
    
    public String getOpinion()
    {
        return opinion;
    }
    
    public void setOpinion(String opinion)
    {
        this.opinion = opinion;
    }
    
    /**
     * 获取 wfname
     * 
     * @return 返回 wfname
     * @author rqj
     */
    public String getWfname()
    {
        return wfname;
    }
    
    /**
     * 设置 wfname
     * 
     * @param wfname 对wfname进行赋值
     * @author rqj
     */
    public void setWfname(String wfname)
    {
        this.wfname = wfname;
    }
    
    /**
     * 获取 handlename
     * 
     * @return 返回 handlename
     * @author rqj
     */
    public String getHandlename()
    {
        return handlename;
    }
    
    /**
     * 设置 handlename
     * 
     * @param handlename 对handlename进行赋值
     * @author rqj
     */
    public void setHandlename(String handlename)
    {
        this.handlename = handlename;
    }
    
    /**
     * 获取 handletime
     * 
     * @return 返回 handletime
     * @author rqj
     */
    public String getHandletime()
    {
        return handletime;
    }
    
    /**
     * 设置 handletime
     * 
     * @param handletime 对handletime进行赋值
     * @author rqj
     */
    public void setHandletime(String handletime)
    {
        this.handletime = handletime;
    }
    
    /**
     * 获取 hid
     * 
     * @return 返回 hid
     * @author rqj
     */
    public String getHid()
    {
        return hid;
    }
    
    /**
     * 设置 hid
     * 
     * @param hid 对hid进行赋值
     * @author rqj
     */
    public void setHid(String hid)
    {
        this.hid = hid;
    }
    
}
