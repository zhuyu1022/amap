/*
 * File name:  AddressItemEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2015-9-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.addressbook.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2015-9-29]
 */
public class AddressItemEntity implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 名称
     */
    private String            Name;
    
    /**
     * 当前ID
     */
    private String            mCurId;
    
    /**
     * 父节点iD
     */
    private String            mPId;
    
    /**
     * 部门posiontion
     */
    private String            mPosition;
    
    /**
     * 父节点名称
     */
    private String            mPName;
    
    /**
     * 是否是部门，true 是， false 不是（该属性为用户）
     */
    private Boolean           isDep;
    
    /**
     * 办公室号码（属性为用户时）
     */
    private String            office;
    
    /**
     * 办公室号码（属性为用户时）
     */
    private String            officePhoneNumber;
    
    /**
     * 手机号码（属性为用户时）
     */
    private String            mobile;
    
    /**
     * 邮件（属性为用户时）
     */
    private String            email;
    
    /**
     * 是否展开（属性为用户时）
     */
    private boolean           isArrow;
    
    private boolean           isChecked;
    
    private String            cId;
    
    public String getName()
    {
        return Name;
    }
    
    public void setName(String name)
    {
        Name = name;
    }
    
    public String getmCurId()
    {
        return mCurId;
    }
    
    public void setmCurId(String mCurId)
    {
        this.mCurId = mCurId;
    }
    
    public String getmPId()
    {
        return mPId;
    }
    
    public void setmPId(String mPId)
    {
        this.mPId = mPId;
    }
    
    public Boolean getIsDep()
    {
        return isDep;
    }
    
    public void setIsDep(Boolean isDep)
    {
        this.isDep = isDep;
    }
    
    public String getOffice()
    {
        return office;
    }
    
    public void setOffice(String office)
    {
        this.office = office;
    }
    
    public String getOfficePhoneNumber()
    {
        return officePhoneNumber;
    }
    
    public void setOfficePhoneNumber(String officePhoneNumber)
    {
        this.officePhoneNumber = officePhoneNumber;
    }
    
    public String getMobile()
    {
        return mobile;
    }
    
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    public boolean isArrow()
    {
        return isArrow;
    }
    
    public void setArrow(boolean isArrow)
    {
        this.isArrow = isArrow;
    }
    
    /**
     * 获取 mPosition
     * 
     * @return 返回 mPosition
     * @author rqj
     */
    public String getmPosition()
    {
        return mPosition;
    }
    
    /**
     * 设置 mPosition
     * 
     * @param mPosition 对mPosition进行赋值
     * @author rqj
     */
    public void setmPosition(String mPosition)
    {
        this.mPosition = mPosition;
    }
    
    public String getmPName()
    {
        return mPName;
    }
    
    public void setmPName(String mPName)
    {
        this.mPName = mPName;
    }
    
    public boolean isChecked()
    {
        return isChecked;
    }
    
    public void setChecked(boolean isChecked)
    {
        this.isChecked = isChecked;
    }
    
    /**
     * 获取 cId
     * 
     * @return 返回 cId
     * @author rqj
     */
    public String getcId()
    {
        return cId;
    }
    
    /**
     * 设置 cId
     * 
     * @param cId 对cId进行赋值
     * @author rqj
     */
    public void setcId(String cId)
    {
        this.cId = cId;
    }
    
}
