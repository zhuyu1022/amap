package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;

public class HistoryDataResponse implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String            operatdate;
    
    private String            receivedate;
    
    private String            stepid;
    
    private String            stepname;
    
    private String            username;
    
    private String            option;
    
    private String            docurl;
    
    private String            filePw;
    
    private boolean           mStatus          = true;
    
    /**
     * 获取 operatdate
     * 
     * @return 返回 operatdate
     * @author rqj
     */
    public String getOperatdate()
    {
        return operatdate;
    }
    
    /**
     * 设置 operatdate
     * 
     * @param operatdate 对operatdate进行赋值
     * @author rqj
     */
    public void setOperatdate(String operatdate)
    {
        this.operatdate = operatdate;
    }
    
    /**
     * 获取 receivedate
     * 
     * @return 返回 receivedate
     * @author rqj
     */
    public String getReceivedate()
    {
        return receivedate;
    }
    
    /**
     * 设置 receivedate
     * 
     * @param receivedate 对receivedate进行赋值
     * @author rqj
     */
    public void setReceivedate(String receivedate)
    {
        this.receivedate = receivedate;
    }
    
    /**
     * 获取 stepid
     * 
     * @return 返回 stepid
     * @author rqj
     */
    public String getStepid()
    {
        return stepid;
    }
    
    /**
     * 设置 stepid
     * 
     * @param stepid 对stepid进行赋值
     * @author rqj
     */
    public void setStepid(String stepid)
    {
        this.stepid = stepid;
    }
    
    /**
     * 获取 stepname
     * 
     * @return 返回 stepname
     * @author rqj
     */
    public String getStepname()
    {
        return stepname;
    }
    
    /**
     * 设置 stepname
     * 
     * @param stepname 对stepname进行赋值
     * @author rqj
     */
    public void setStepname(String stepname)
    {
        this.stepname = stepname;
    }
    
    /**
     * 获取 username
     * 
     * @return 返回 username
     * @author rqj
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * 设置 username
     * 
     * @param username 对username进行赋值
     * @author rqj
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * 获取 option
     * 
     * @return 返回 option
     * @author rqj
     */
    public String getOption()
    {
        return option;
    }
    
    /**
     * 设置 option
     * 
     * @param option 对option进行赋值
     * @author rqj
     */
    public void setOption(String option)
    {
        this.option = option;
    }
    
    /**
     * 获取 docurl
     * 
     * @return 返回 docurl
     * @author rqj
     */
    public String getDocurl()
    {
        return docurl;
    }
    
    /**
     * 设置 docurl
     * 
     * @param docurl 对docurl进行赋值
     * @author rqj
     */
    public void setDocurl(String docurl)
    {
        this.docurl = docurl;
    }
    
    /**
     * 获取 filePw
     * 
     * @return 返回 filePw
     * @author rqj
     */
    public String getFilePw()
    {
        return filePw;
    }
    
    /**
     * 设置 filePw
     * 
     * @param filePw 对filePw进行赋值
     * @author rqj
     */
    public void setFilePw(String filePw)
    {
        this.filePw = filePw;
    }
    
    /**
     * 获取 mStatus
     * 
     * @return 返回 mStatus
     * @author rqj
     */
    public boolean ismStatus()
    {
        return mStatus;
    }
    
    /**
     * 设置 mStatus
     * 
     * @param mStatus 对mStatus进行赋值
     * @author rqj
     */
    public void setmStatus(boolean mStatus)
    {
        this.mStatus = mStatus;
    }
    
}
