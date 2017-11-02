package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;
import java.util.List;

public class StepDataItemResponse implements Serializable
{
    
    /**
     * StepBizResponse.java
     */
    private static final long         serialVersionUID = 1L;
    
    private String                    stepid;
    
    private String                    stepname;
    
    private List<StepBizUserResponse> userlist;
    
    private List<StepBizDeptResponse> deptlist;
    
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
     * 获取 userlist
     * 
     * @return 返回 userlist
     * @author rqj
     */
    public List<StepBizUserResponse> getUserlist()
    {
        return userlist;
    }
    
    /**
     * 设置 userlist
     * 
     * @param userlist 对userlist进行赋值
     * @author rqj
     */
    public void setUserlist(List<StepBizUserResponse> userlist)
    {
        this.userlist = userlist;
    }
    
    /**
     * 获取 deptlist
     * 
     * @return 返回 deptlist
     * @author rqj
     */
    public List<StepBizDeptResponse> getDeptlist()
    {
        return deptlist;
    }
    
    /**
     * 
     * @param deptlist 对deptlist进行赋值
     * @author rqj
     */
    public void setDeptlist(List<StepBizDeptResponse> deptlist)
    {
        this.deptlist = deptlist;
    }
    
}
