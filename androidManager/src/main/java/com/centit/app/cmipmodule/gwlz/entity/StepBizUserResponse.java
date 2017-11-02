package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;
import java.util.List;

public class StepBizUserResponse implements Serializable
{
    
    /**
     * StepBizDeptResponse.java
     */
    private static final long             serialVersionUID = 1L;
    
    private String                        userLable;
    
    private String                        userRoleType;
    
    private String                        limit            = "-1";
    
    private List<StepBizUserInfoResponse> userinfo;
    
    /**
     * 获取 userRoleType
     * 
     * @return 返回 userRoleType
     * @author rqj
     */
    public String getUserRoleType()
    {
        return userRoleType;
    }
    
    /**
     * 设置 userRoleType
     * 
     * @param userRoleType 对userRoleType进行赋值
     * @author rqj
     */
    public void setUserRoleType(String userRoleType)
    {
        this.userRoleType = userRoleType;
    }
    
    /**
     * 获取 userinfo
     * 
     * @return 返回 userinfo
     * @author rqj
     */
    public List<StepBizUserInfoResponse> getUserinfo()
    {
        return userinfo;
    }
    
    /**
     * 设置 userinfo
     * 
     * @param userinfo 对userinfo进行赋值
     * @author rqj
     */
    public void setUserinfo(List<StepBizUserInfoResponse> userinfo)
    {
        this.userinfo = userinfo;
    }
    
    /**
     * 获取 userLable
     * 
     * @return 返回 userLable
     * @author rqj
     */
    public String getUserLable()
    {
        return userLable;
    }
    
    /**
     * 设置 userLable
     * 
     * @param userLable 对userLable进行赋值
     * @author rqj
     */
    public void setUserLable(String userLable)
    {
        this.userLable = userLable;
    }
    
    /**
     * 获取 limit
     * 
     * @return 返回 limit
     * @author rqj
     */
    public String getLimit()
    {
        return limit;
    }
    
    /**
     * 设置 limit
     * 
     * @param limit 对limit进行赋值
     * @author rqj
     */
    public void setLimit(String limit)
    {
        this.limit = limit;
    }
    
}
