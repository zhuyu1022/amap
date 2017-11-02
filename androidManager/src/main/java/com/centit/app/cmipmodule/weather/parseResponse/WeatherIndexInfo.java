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
public class WeatherIndexInfo implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * 穿衣/洗车/旅游/运动/感冒/紫外线强度
     */
    public String             title;
    
    /**
     * 
     */
    public String             zs;
    
    /**
     * 
     */
    public String             tipt;
    
    /**
     * 
     */
    public String             des;
    
    /**
     * 获取 title
     * 
     * @return 返回 title
     * @author rqj
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 设置 title
     * 
     * @param title 对title进行赋值
     * @author rqj
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * 获取 zs
     * 
     * @return 返回 zs
     * @author rqj
     */
    public String getZs()
    {
        return zs;
    }
    
    /**
     * 设置 zs
     * 
     * @param zs 对zs进行赋值
     * @author rqj
     */
    public void setZs(String zs)
    {
        this.zs = zs;
    }
    
    /**
     * 获取 tipt
     * 
     * @return 返回 tipt
     * @author rqj
     */
    public String getTipt()
    {
        return tipt;
    }
    
    /**
     * 设置 tipt
     * 
     * @param tipt 对tipt进行赋值
     * @author rqj
     */
    public void setTipt(String tipt)
    {
        this.tipt = tipt;
    }
    
    /**
     * 获取 des
     * 
     * @return 返回 des
     * @author rqj
     */
    public String getDes()
    {
        return des;
    }
    
    /**
     * 设置 des
     * 
     * @param des 对des进行赋值
     * @author rqj
     */
    public void setDes(String des)
    {
        this.des = des;
    }
    
}
