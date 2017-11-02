/*
 * File name:  AddressWay.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2015-1-21
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.addressbook.parseResponse;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2015-1-21]
 */
public class AddressWay
{
    // "id":"联系方式id",
    // "type":"联系方式类型",
    // "value":"联系方式"
    private String id;
    
    private String type;
    
    private String value;
    
    public AddressWay()
    {
        
    }
    
    public AddressWay(String id, String type, String value)
    {
        this.id = id;
        this.type = type;
        this.value = value;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
}
