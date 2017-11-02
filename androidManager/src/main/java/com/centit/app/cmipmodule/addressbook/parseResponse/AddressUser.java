package com.centit.app.cmipmodule.addressbook.parseResponse;

import java.io.Serializable;
import java.util.List;

public class AddressUser implements Serializable
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            sn;
    
    private String            username;
    
    private String            userid;
    
    private String            deptname;
    
    private String            position;
    
    private String            phone;
    
    private String            email;
    
    private String            wechat;
    
    private String            cid;
    
    private List<AddressWay>  addressWay;
    
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
     * 获取 addressWay
     * 
     * @return 返回 addressWay
     * @author rqj
     */
    public List<AddressWay> getAddressWay()
    {
        return addressWay;
    }
    
    /**
     * 设置 addressWay
     * 
     * @param addressWay 对addressWay进行赋值
     * @author rqj
     */
    public void setAddressWay(List<AddressWay> addressWay)
    {
        this.addressWay = addressWay;
    }
    
    /**
     * 获取 position
     * 
     * @return 返回 position
     * @author rqj
     */
    public String getPosition()
    {
        return position;
    }
    
    /**
     * 设置 position
     * 
     * @param position 对position进行赋值
     * @author rqj
     */
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    /**
     * 获取 phone
     * 
     * @return 返回 phone
     * @author rqj
     */
    public String getPhone()
    {
        return phone;
    }
    
    /**
     * 设置 phone
     * 
     * @param phone 对phone进行赋值
     * @author rqj
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    /**
     * 获取 email
     * 
     * @return 返回 email
     * @author rqj
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * 设置 email
     * 
     * @param email 对email进行赋值
     * @author rqj
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * 获取 wechat
     * 
     * @return 返回 wechat
     * @author rqj
     */
    public String getWechat()
    {
        return wechat;
    }
    
    /**
     * 设置 wechat
     * 
     * @param wechat 对wechat进行赋值
     * @author rqj
     */
    public void setWechat(String wechat)
    {
        this.wechat = wechat;
    }
    
    /**
     * 获取 cid
     * 
     * @return 返回 cid
     * @author rqj
     */
    public String getCid()
    {
        return cid;
    }
    
    /**
     * 设置 cid
     * 
     * @param cid 对cid进行赋值
     * @author rqj
     */
    public void setCid(String cid)
    {
        this.cid = cid;
    }
    
}
