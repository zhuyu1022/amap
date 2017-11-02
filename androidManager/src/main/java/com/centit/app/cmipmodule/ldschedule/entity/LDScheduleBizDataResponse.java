package com.centit.app.cmipmodule.ldschedule.entity;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * @Description<功能详细描述>
 * 
 * @author  rqj 
 * @Version  [版本号, 2015-9-15]
 */
/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-15]
 */
public class LDScheduleBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            scheduleid;
    
    private String            scheduletitle;
    
    private String            schedulebegindate;
    
    private String            scheduleenddate;
    
    private String            createdate;
    
    private String            isimportant;
    
    private String            scheduleremark;
    
    private String            address;
    
    private String            leaders          = "";
    
    /**
     * 获取 scheduleid
     * 
     * @return 返回 scheduleid
     * @author rqj
     */
    public String getScheduleid()
    {
        return scheduleid;
    }
    
    /**
     * 设置 scheduleid
     * 
     * @param scheduleid 对scheduleid进行赋值
     * @author rqj
     */
    public void setScheduleid(String scheduleid)
    {
        this.scheduleid = scheduleid;
    }
    
    /**
     * 获取 scheduletitle
     * 
     * @return 返回 scheduletitle
     * @author rqj
     */
    public String getScheduletitle()
    {
        return scheduletitle;
    }
    
    /**
     * 设置 scheduletitle
     * 
     * @param scheduletitle 对scheduletitle进行赋值
     * @author rqj
     */
    public void setScheduletitle(String scheduletitle)
    {
        this.scheduletitle = scheduletitle;
    }
    
    /**
     * 获取 schedulebegindate
     * 
     * @return 返回 schedulebegindate
     * @author rqj
     */
    public String getSchedulebegindate()
    {
        return schedulebegindate;
    }
    
    /**
     * 设置 schedulebegindate
     * 
     * @param schedulebegindate 对schedulebegindate进行赋值
     * @author rqj
     */
    public void setSchedulebegindate(String schedulebegindate)
    {
        this.schedulebegindate = schedulebegindate;
    }
    
    /**
     * 获取 scheduleenddate
     * 
     * @return 返回 scheduleenddate
     * @author rqj
     */
    public String getScheduleenddate()
    {
        return scheduleenddate;
    }
    
    /**
     * 设置 scheduleenddate
     * 
     * @param scheduleenddate 对scheduleenddate进行赋值
     * @author rqj
     */
    public void setScheduleenddate(String scheduleenddate)
    {
        this.scheduleenddate = scheduleenddate;
    }
    
    /**
     * 获取 createdate
     * 
     * @return 返回 createdate
     * @author rqj
     */
    public String getCreatedate()
    {
        return createdate;
    }
    
    /**
     * 设置 createdate
     * 
     * @param createdate 对createdate进行赋值
     * @author rqj
     */
    public void setCreatedate(String createdate)
    {
        this.createdate = createdate;
    }
    
    /**
     * 获取 isimportant
     * 
     * @return 返回 isimportant
     * @author rqj
     */
    public String getIsimportant()
    {
        return isimportant;
    }
    
    /**
     * 设置 isimportant
     * 
     * @param isimportant 对isimportant进行赋值
     * @author rqj
     */
    public void setIsimportant(String isimportant)
    {
        this.isimportant = isimportant;
    }
    
    /**
     * 获取 scheduleremark
     * 
     * @return 返回 scheduleremark
     * @author rqj
     */
    public String getScheduleremark()
    {
        return scheduleremark;
    }
    
    /**
     * 设置 scheduleremark
     * 
     * @param scheduleremark 对scheduleremark进行赋值
     * @author rqj
     */
    public void setScheduleremark(String scheduleremark)
    {
        this.scheduleremark = scheduleremark;
    }
    
    /**
     * 获取 address
     * 
     * @return 返回 address
     * @author rqj
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * 设置 address
     * 
     * @param address 对address进行赋值
     * @author rqj
     */
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    /**
     * 获取 leader
     * 
     * @return 返回 leader
     * @author rqj
     */
    public String getLeader()
    {
        return leaders;
    }
    
    /**
     * 设置 leader
     * 
     * @param leader 对leader进行赋值
     * @author rqj
     */
    public void setLeader(String leader)
    {
        this.leaders = leader;
    }
    
}
