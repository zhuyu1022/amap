package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.io.Serializable;

public class ScheduleDataVo implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 8623429402446870468L;
    
    // "id":"日程id",
    // "title":"标题",
    // "address":"地点",
    // "starttime":"开始时间",
    // "endtime":"结束时间",
    // "content":"内容"
    /** 日程id **/
    private String            id;
    
    /** 标题 **/
    private String            title;
    
    /** 地点 **/
    private String            location;
    
    /** 开始时间 **/
    private String            starttime;
    
    /** 结束时间 **/
    private String            endtime;
    
    /** 内容 **/
    private String            content;
    
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
     * 获取 title
     * 
     * @return 返回 title
     * @author wl
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 设置 title
     * 
     * @param title 对title进行赋值
     * @author wl
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * 获取 address
     * 
     * @return 返回 address
     * @author wl
     */
    public String getAddress()
    {
        return location;
    }
    
    /**
     * 设置 address
     * 
     * @param address 对address进行赋值
     * @author wl
     */
    public void setAddress(String address)
    {
        this.location = address;
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
     * 获取 content
     * 
     * @return 返回 content
     * @author wl
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author wl
     */
    public void setContent(String content)
    {
        this.content = content;
    }
    
}
