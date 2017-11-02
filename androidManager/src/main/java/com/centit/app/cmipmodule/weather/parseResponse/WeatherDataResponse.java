package com.centit.app.cmipmodule.weather.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class WeatherDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long      serialVersionUID = 1L;
    
    /**
     * 城市
     */
    private String                 city;
    
    private List<WeatherIndexInfo> index            = new ArrayList<WeatherIndexInfo>();
    
    /**
     * 多天的天气
     */
    private List<WeatherMoreInfo>  weathers         = new ArrayList<WeatherMoreInfo>();
    
    /**
     * PM2.5
     */
    private String                 pm25;
    
    /**
     * 获取 city
     * 
     * @return 返回 city
     * @author rqj
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * 设置 city
     * 
     * @param city 对city进行赋值
     * @author rqj
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * 获取 weathers
     * 
     * @return 返回 weathers
     * @author rqj
     */
    public List<WeatherMoreInfo> getWeathers()
    {
        return weathers;
    }
    
    /**
     * 设置 weathers
     * 
     * @param weathers 对weathers进行赋值
     * @author rqj
     */
    public void setWeathers(List<WeatherMoreInfo> weathers)
    {
        this.weathers = weathers;
    }
    
    /**
     * 获取 pm25
     * 
     * @return 返回 pm25
     * @author rqj
     */
    public String getPm25()
    {
        return pm25;
    }
    
    /**
     * 设置 pm25
     * 
     * @param pm25 对pm25进行赋值
     * @author rqj
     */
    public void setPm25(String pm25)
    {
        this.pm25 = pm25;
    }
    
    /**
     * 获取 index
     * 
     * @return 返回 index
     * @author rqj
     */
    public List<WeatherIndexInfo> getIndex()
    {
        return index;
    }
    
    /**
     * 设置 index
     * 
     * @param index 对index进行赋值
     * @author rqj
     */
    public void setIndex(List<WeatherIndexInfo> index)
    {
        this.index = index;
    }
    
}
