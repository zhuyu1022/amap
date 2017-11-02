/*
 * File name:  PeopleEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  Administrator
 * Last modified date:  2015-7-11
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.gwlz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author Administrator
 * @Version [版本号, 2015-7-11]
 */
public class SelectedRoleTypeEntity
{
    private String             stepId;
    
    private String             stepName;
    
    // 角色类型
    private String             roleType;
    
    private String             roleName;
    
    private int                limit  = -1;
    
    private boolean            isUser = false;
    
    private List<PeopleEntity> list   = new ArrayList<PeopleEntity>();
    
    /**
     * 获取 stepId
     * 
     * @return 返回 stepId
     * @author rqj
     */
    public String getStepId()
    {
        return stepId;
    }
    
    /**
     * 设置 stepId
     * 
     * @param stepId 对stepId进行赋值
     * @author rqj
     */
    public void setStepId(String stepId)
    {
        this.stepId = stepId;
    }
    
    /**
     * 获取 stepName
     * 
     * @return 返回 stepName
     * @author rqj
     */
    public String getStepName()
    {
        return stepName;
    }
    
    /**
     * 设置 stepName
     * 
     * @param stepName 对stepName进行赋值
     * @author rqj
     */
    public void setStepName(String stepName)
    {
        this.stepName = stepName;
    }
    
    /**
     * 获取 roleType
     * 
     * @return 返回 roleType
     * @author rqj
     */
    public String getRoleType()
    {
        return roleType;
    }
    
    /**
     * 设置 roleType
     * 
     * @param roleType 对roleType进行赋值
     * @author rqj
     */
    public void setRoleType(String roleType)
    {
        this.roleType = roleType;
    }
    
    /**
     * 获取 isUser
     * 
     * @return 返回 isUser
     * @author rqj
     */
    public boolean isUser()
    {
        return isUser;
    }
    
    /**
     * 设置 isUser
     * 
     * @param isUser 对isUser进行赋值
     * @author rqj
     */
    public void setUser(boolean isUser)
    {
        this.isUser = isUser;
    }
    
    /**
     * 获取 list
     * 
     * @return 返回 list
     * @author rqj
     */
    public List<PeopleEntity> getList()
    {
        return list;
    }
    
    /**
     * 设置 list
     * 
     * @param list 对list进行赋值
     * @author rqj
     */
    public void setList(List<PeopleEntity> list)
    {
        this.list = list;
    }
    
    /**
     * 获取 roleName
     * 
     * @return 返回 roleName
     * @author rqj
     */
    public String getRoleName()
    {
        return roleName;
    }
    
    /**
     * 设置 roleName
     * 
     * @param roleName 对roleName进行赋值
     * @author rqj
     */
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    
    /**
     * 获取 limit
     * 
     * @return 返回 limit
     * @author rqj
     */
    public int getLimit()
    {
        return limit;
    }
    
    /**
     * 设置 limit
     * 
     * @param limit 对limit进行赋值
     * @author rqj
     */
    public void setLimit(int limit)
    {
        this.limit = limit;
    }
}
