package com.centit.app.cmipmodule.addressbook.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2015-1-21]
 */
public class AddressDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private List<AddressUser> userlist         = new ArrayList<AddressUser>();
    
    private List<AddressDep>  cdeptlist        = new ArrayList<AddressDep>();
    
    private String            deptname;
    
    private String            deptid;
    
    /**
     * 获取 userlist
     * 
     * @return 返回 userlist
     * @author rqj
     */
    public List<AddressUser> getUserlist()
    {
        return userlist;
    }
    
    /**
     * 设置 userlist
     * 
     * @param userlist 对userlist进行赋值
     * @author rqj
     */
    public void setUserlist(List<AddressUser> userlist)
    {
        this.userlist = userlist;
    }
    
    /**
     * 获取 cdeptlist
     * 
     * @return 返回 cdeptlist
     * @author rqj
     */
    public List<AddressDep> getCdeptlist()
    {
        return cdeptlist;
    }
    
    /**
     * 设置 cdeptlist
     * 
     * @param cdeptlist 对cdeptlist进行赋值
     * @author rqj
     */
    public void setCdeptlist(List<AddressDep> cdeptlist)
    {
        this.cdeptlist = cdeptlist;
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
    
}
