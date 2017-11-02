package com.centit.app.cmipmodule.person.parseResponse;

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
public class UnCountEntity
{
    private String funcCode = "";
    
    private String count    = "";
    
    private String urgCount = "";
    
    /**
     * <默认构造函数>
     */
    public UnCountEntity(String funcCode, String count, String urgCount)
    {
        super();
        this.funcCode = funcCode;
        this.count = count;
        this.urgCount = urgCount;
    }
    
    public String getUrgCount()
    {
        return urgCount;
    }
    
    public void setUrgCount(String urgCount)
    {
        this.urgCount = urgCount;
    }
    
    /**
     * 获取 funcCode
     * 
     * @return 返回 funcCode
     * @author rqj
     */
    public String getFuncCode()
    {
        return funcCode;
    }
    
    /**
     * 设置 funcCode
     * 
     * @param funcCode 对funcCode进行赋值
     * @author rqj
     */
    public void setFuncCode(String funcCode)
    {
        this.funcCode = funcCode;
    }
    
    /**
     * 获取 count
     * 
     * @return 返回 count
     * @author rqj
     */
    public String getCount()
    {
        return count;
    }
    
    /**
     * 设置 count
     * 
     * @param count 对count进行赋值
     * @author rqj
     */
    public void setCount(String count)
    {
        this.count = count;
    }
    
}
