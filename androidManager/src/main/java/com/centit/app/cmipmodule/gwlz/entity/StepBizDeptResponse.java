package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;
import java.util.List;

public class StepBizDeptResponse implements Serializable
{
    
    /**
     * StepBizDeptResponse.java
     */
    private static final long             serialVersionUID = 1L;
    
    private String                        deptRoleType;
    
    private String                        deptLable;
    
    private String                        limit            = "-1";
    
    private List<StepBizDeptInfoResponse> deptinfo;
    
    /**
     * 获取 deptinfo
     * 
     * @return 返回 deptinfo
     * @author rqj
     */
    public List<StepBizDeptInfoResponse> getDeptinfo()
    {
        return deptinfo;
    }
    
    /**
     * 设置 deptinfo
     * 
     * @param deptinfo 对deptinfo进行赋值
     * @author rqj
     */
    public void setDeptinfo(List<StepBizDeptInfoResponse> deptinfo)
    {
        this.deptinfo = deptinfo;
    }
    
    /**
     * 获取 deptRoleType
     * 
     * @return 返回 deptRoleType
     * @author rqj
     */
    public String getDeptRoleType()
    {
        return deptRoleType;
    }
    
    /**
     * 设置 deptRoleType
     * 
     * @param deptRoleType 对deptRoleType进行赋值
     * @author rqj
     */
    public void setDeptRoleType(String deptRoleType)
    {
        this.deptRoleType = deptRoleType;
    }
    
    /**
     * 获取 deptLable
     * 
     * @return 返回 deptLable
     * @author rqj
     */
    public String getDeptLable()
    {
        return deptLable;
    }
    
    /**
     * 设置 deptLable
     * 
     * @param deptLable 对deptLable进行赋值
     * @author rqj
     */
    public void setDeptLable(String deptLable)
    {
        this.deptLable = deptLable;
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
