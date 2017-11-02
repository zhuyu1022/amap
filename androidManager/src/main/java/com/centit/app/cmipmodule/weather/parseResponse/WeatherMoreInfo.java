package com.centit.app.cmipmodule.weather.parseResponse;

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
public class WeatherMoreInfo implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * 时间
     */
    private String            date;
    
    /**
     * 全天天气
     */
    private String            tempInterval;
    
    /**
     * 天气
     */
    private String            weather;
    
    /**
     * 风向
     */
    private String            wind;
    
    /**
     * 天气图片
     */
    private String            dayPic;
    
    /**
     * <默认构造函数>
     */
    public WeatherMoreInfo(String date, String tempInterval, String weather, String wind, String dayPic)
    {
        super();
        this.date = date;
        this.tempInterval = tempInterval;
        this.weather = weather;
        this.wind = wind;
        this.dayPic = dayPic;
    }
    
    /**
     * 获取 date
     * 
     * @return 返回 date
     * @author Administrator
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * 设置 date
     * 
     * @param date 对date进行赋值
     * @author Administrator
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * 获取 tempInterval
     * 
     * @return 返回 tempInterval
     * @author Administrator
     */
    public String getTempInterval()
    {
        return tempInterval;
    }
    
    /**
     * 设置 tempInterval
     * 
     * @param tempInterval 对tempInterval进行赋值
     * @author Administrator
     */
    public void setTempInterval(String tempInterval)
    {
        this.tempInterval = tempInterval;
    }
    
    /**
     * 获取 weather
     * 
     * @return 返回 weather
     * @author Administrator
     */
    public String getWeather()
    {
        return weather;
    }
    
    /**
     * 设置 weather
     * 
     * @param weather 对weather进行赋值
     * @author Administrator
     */
    public void setWeather(String weather)
    {
        this.weather = weather;
    }
    
    /**
     * 获取 wind
     * 
     * @return 返回 wind
     * @author Administrator
     */
    public String getWind()
    {
        return wind;
    }
    
    /**
     * 设置 wind
     * 
     * @param wind 对wind进行赋值
     * @author Administrator
     */
    public void setWind(String wind)
    {
        this.wind = wind;
    }
    
    /**
     * 获取 dayPic
     * 
     * @return 返回 dayPic
     * @author rqj
     */
    public String getDayPic()
    {
        return dayPic;
    }
    
    /**
     * 设置 dayPic
     * 
     * @param dayPic 对dayPic进行赋值
     * @author rqj
     */
    public void setDayPic(String dayPic)
    {
        this.dayPic = dayPic;
    }
}
