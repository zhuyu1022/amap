package com.centit.app.cmipmodule.tzgg.parseResponse;

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
public class TZGGDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * 唯一标识
     */
    private String            id;
    
    /**
     * 标题
     */
    private String            title;
    
    // 内容
    private String            content;
    
    // 文件路径
    private String            filepath;
    
    // 时间
    private String            createtime;
    
    /** 0-未读 **/
    private String            isread;
    
    /**
     * 获取 isread
     * 
     * @return 返回 isread
     * @author wl
     */
    public String getIsread()
    {
        return isread;
    }
    
    /**
     * 设置 isread
     * 
     * @param isread 对isread进行赋值
     * @author wl
     */
    public void setIsread(String isread)
    {
        this.isread = isread;
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
     * 获取 content
     * 
     * @return 返回 content
     * @author rqj
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * 设置 content
     * 
     * @param content 对content进行赋值
     * @author rqj
     */
    public void setContent(String content)
    {
        this.content = content;
    }
    
    /**
     * 获取 filepath
     * 
     * @return 返回 filepath
     * @author rqj
     */
    public String getFilepath()
    {
        return filepath;
    }
    
    /**
     * 设置 filepath
     * 
     * @param filepath 对filepath进行赋值
     * @author rqj
     */
    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
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
