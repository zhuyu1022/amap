package com.centit.app.cmipmodule.addressbook.parseResponse;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class AddressBizResponse extends RetParseResponse
{
    
    private AddressDataResponse bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public AddressDataResponse getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(AddressDataResponse bizData)
    {
        this.bizData = bizData;
    }
    
}
