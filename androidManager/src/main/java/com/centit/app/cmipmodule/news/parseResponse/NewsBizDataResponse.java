package com.centit.app.cmipmodule.news.parseResponse;

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
public class NewsBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            description;
    
    private String            id;
    
    private String            imageUrl;
    
    private String            link;
    
    private String            publishDate;
    
    private String            title;
    
    private String            createtime;
    
    /** 图片宽度 **/
    private String            imgwidth;
    
    /** 图片高度 **/
    private String            imgheight;
    
    /** 缩略图地址 **/
    private String            thumbimg;
    
    public String getImgwidth()
    {
        return imgwidth;
    }
    
    public void setImgwidth(String imgwidth)
    {
        this.imgwidth = imgwidth;
    }
    
    public String getImgheight()
    {
        return imgheight;
    }
    
    public void setImgheight(String imgheight)
    {
        this.imgheight = imgheight;
    }
    
    public String getThumbimg()
    {
        return thumbimg;
    }
    
    public void setThumbimg(String thumbimg)
    {
        this.thumbimg = thumbimg;
    }
    
    /**
     * 获取 description
     * 
     * @return 返回 description
     * @author rqj
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * 设置 description
     * 
     * @param description 对description进行赋值
     * @author rqj
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * 获取 id
     * 
     * @return 返回 id
     * @author rqj
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * 设置 id
     * 
     * @param id 对id进行赋值
     * @author rqj
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * 获取 imageUrl
     * 
     * @return 返回 imageUrl
     * @author rqj
     */
    public String getImageUrl()
    {
        return imageUrl;
    }
    
    /**
     * 设置 imageUrl
     * 
     * @param imageUrl 对imageUrl进行赋值
     * @author rqj
     */
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
    
    /**
     * 获取 link
     * 
     * @return 返回 link
     * @author rqj
     */
    public String getLink()
    {
        return link;
    }
    
    /**
     * 设置 link
     * 
     * @param link 对link进行赋值
     * @author rqj
     */
    public void setLink(String link)
    {
        this.link = link;
    }
    
    /**
     * 获取 publishDate
     * 
     * @return 返回 publishDate
     * @author rqj
     */
    public String getPublishDate()
    {
        return publishDate;
    }
    
    /**
     * 设置 publishDate
     * 
     * @param publishDate 对publishDate进行赋值
     * @author rqj
     */
    public void setPublishDate(String publishDate)
    {
        this.publishDate = publishDate;
    }
    
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
     * 获取 createtime
     * 
     * @return 返回 createtime
     * @author rqj
     */
    public String getCreatetime()
    {
        return createtime;
    }
    
    /**
     * 设置 createtime
     * 
     * @param createtime 对createtime进行赋值
     * @author rqj
     */
    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }
    
}
