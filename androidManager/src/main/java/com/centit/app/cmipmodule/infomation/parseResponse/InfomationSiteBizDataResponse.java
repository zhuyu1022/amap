package com.centit.app.cmipmodule.infomation.parseResponse;

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
public class InfomationSiteBizDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    private String            type;
    
    private String            typeName;
    
    /**
     * 获取 type
     * 
     * @return 返回 type
     * @author rqj
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * 设置 type
     * 
     * @param type 对type进行赋值
     * @author rqj
     */
    public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * 获取 typeName
     * 
     * @return 返回 typeName
     * @author rqj
     */
    public String getTypeName()
    {
        return typeName;
    }
    
    /**
     * 设置 typeName
     * 
     * @param typeName 对typeName进行赋值
     * @author rqj
     */
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
    
}
