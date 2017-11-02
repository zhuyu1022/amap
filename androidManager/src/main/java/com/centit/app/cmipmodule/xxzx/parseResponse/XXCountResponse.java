/*
 * File name:  BookListInfoResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年9月30日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.xxzx.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年9月30日]
 */
public class XXCountResponse implements Serializable
{
    /**
     * XXCountResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    private String            count;
    
    /**
     * 获取 count
     * 
     * @return 返回 count
     * @author rqj
     */
    public String getCount()
    {
        return count;
    }
    
    /**
     * 设置 count
     * 
     * @param count 对count进行赋值
     * @author rqj
     */
    public void setCount(String count)
    {
        this.count = count;
    }
    
}
