package com.centit.core.tools.netUtils.baseReqeust.baseParseResponse;

/**
 * 解析返回的报文，报文为格式为“header”（为ResponseHeader）与“body”（加密后的String）
 * 
 * @author: ren_qiujing
 * @version 1.0
 * @createDate 2012-11-19
 */
public class BaseParseResponse
{
    
    protected String         body;
    
    protected ResponseHeader header;
    
    public String getBody()
    {
        return body;
    }
    
    public void setBody(String body)
    {
        this.body = body;
    }
    
    public ResponseHeader getHeader()
    {
        return header;
    }
    
    public void setHeader(ResponseHeader header)
    {
        this.header = header;
    }
}
