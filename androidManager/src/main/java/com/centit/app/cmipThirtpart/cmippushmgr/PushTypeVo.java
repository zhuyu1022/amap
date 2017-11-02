package com.centit.app.cmipThirtpart.cmippushmgr;

public class PushTypeVo {
    private String type;
    
    private String message;
    
    /**
     * 获取 message
     * 
     * @return 返回 message
     * @author wang_ling
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * 设置 message
     * 
     * @param message 对message进行赋值
     * @author wang_ling
     */
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public PushTypeVo()
    {
        super();
    }
    
    public PushTypeVo(String type)
    {
        super();
        this.type = type;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
}
