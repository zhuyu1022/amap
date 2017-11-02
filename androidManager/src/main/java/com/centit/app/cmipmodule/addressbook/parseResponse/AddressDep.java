package com.centit.app.cmipmodule.addressbook.parseResponse;

import java.io.Serializable;

public class AddressDep implements Serializable
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    public String             sn               = "";
    
    public String             deptid           = "";
    
    public String             deptname         = "";
    
    /**
     * 获取 sn
     * 
     * @return 返回 sn
     * @author rqj
     */
    public String getSn()
    {
        return sn;
    }
    
    /**
     * 设置 sn
     * 
     * @param sn 对sn进行赋值
     * @author rqj
     */
    public void setSn(String sn)
    {
        this.sn = sn;
    }
    
    /**
     * 获取 deptid
     * 
     * @return 返回 deptid
     * @author rqj
     */
    public String getDeptid()
    {
        return deptid;
    }
    
    /**
     * 设置 deptid
     * 
     * @param deptid 对deptid进行赋值
     * @author rqj
     */
    public void setDeptid(String deptid)
    {
        this.deptid = deptid;
    }
    
    /**
     * 获取 deptname
     * 
     * @return 返回 deptname
     * @author rqj
     */
    public String getDeptname()
    {
        return deptname;
    }
    
    /**
     * 设置 deptname
     * 
     * @param deptname 对deptname进行赋值
     * @author rqj
     */
    public void setDeptname(String deptname)
    {
        this.deptname = deptname;
    }
    
}
