package com.centit.app.cmipmodule.hygl.parseResponse;

import java.io.Serializable;

public class HYListDataVo implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 8623429402446870468L;
    
    /** 日程id **/
    private String            id;
    
    /** 用于二维码扫描 **/
    private String            uuid;
    
    /** 标题 **/
    private String            name;
    
    /** 地点 **/
    private String            location;
    
    /** 开始时间 **/
    private String            starttime;
    
    /** 结束时间 **/
    private String            endtime;
    
    /** 发起人id **/
    private String            createuserid;
    
    /** 发起人姓名 **/
    private String            createusername;
    
    /** 是否已经签到 Y-已签到，N-未签到 **/
    private String            issign;                                 // "issign": "N",
                                                                       
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author wl
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author wl
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 uuid
     * 
     * @return 返回 uuid
     * @author wl
     */
    public String getUuid()
    {
        return uuid;
    }
    
    /**
     * 设置 uuid
     * 
     * @param uuid 对uuid进行赋值
     * @author wl
     */
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    /**
     * 获取 name
     * 
     * @return 返回 name
     * @author wl
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 设置 name
     * 
     * @param name 对name进行赋值
     * @author wl
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 获取 location
     * 
     * @return 返回 location
     * @author wl
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * 设置 location
     * 
     * @param location 对location进行赋值
     * @author wl
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    /**
     * 获取 starttime
     * 
     * @return 返回 starttime
     * @author wl
     */
    public String getStarttime()
    {
        return starttime;
    }
    
    /**
     * 设置 starttime
     * 
     * @param starttime 对starttime进行赋值
     * @author wl
     */
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }
    
    /**
     * 获取 endtime
     * 
     * @return 返回 endtime
     * @author wl
     */
    public String getEndtime()
    {
        return endtime;
    }
    
    /**
     * 设置 endtime
     * 
     * @param endtime 对endtime进行赋值
     * @author wl
     */
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    
    /**
     * 获取 createuserid
     * 
     * @return 返回 createuserid
     * @author wl
     */
    public String getCreateuserid()
    {
        return createuserid;
    }
    
    /**
     * 设置 createuserid
     * 
     * @param createuserid 对createuserid进行赋值
     * @author wl
     */
    public void setCreateuserid(String createuserid)
    {
        this.createuserid = createuserid;
    }
    
    /**
     * 获取 createusername
     * 
     * @return 返回 createusername
     * @author wl
     */
    public String getCreateusername()
    {
        return createusername;
    }
    
    /**
     * 设置 createusername
     * 
     * @param createusername 对createusername进行赋值
     * @author wl
     */
    public void setCreateusername(String createusername)
    {
        this.createusername = createusername;
    }
    
    /**
     * 获取 issign
     * 
     * @return 返回 issign
     * @author wl
     */
    public String getIssign()
    {
        return issign;
    }
    
    /**
     * 设置 issign
     * 
     * @param issign 对issign进行赋值
     * @author wl
     */
    public void setIssign(String issign)
    {
        this.issign = issign;
    }
    
}
