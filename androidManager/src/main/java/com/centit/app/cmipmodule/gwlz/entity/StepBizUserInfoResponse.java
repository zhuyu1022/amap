package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;

public class StepBizUserInfoResponse implements Serializable
{
    
    /**
     * StepBizDeptInfoResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            userid;
    
    private String            username;
    
    /**
     * 获取 userid
     * 
     * @return 返回 userid
     * @author rqj
     */
    public String getUserid()
    {
        return userid;
    }
    
    /**
     * 设置 userid
     * 
     * @param userid 对userid进行赋值
     * @author rqj
     */
    public void setUserid(String userid)
    {
        this.userid = userid;
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
    
}
