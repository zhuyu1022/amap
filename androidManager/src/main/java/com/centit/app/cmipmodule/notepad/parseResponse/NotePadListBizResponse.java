package com.centit.app.cmipmodule.notepad.parseResponse;

import java.util.ArrayList;
import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

public class NotePadListBizResponse extends RetParseResponse
{
    private List<NotePadListDataResponse> bizData = new ArrayList<NotePadListDataResponse>();
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author rqj
     */
    public List<NotePadListDataResponse> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author rqj
     */
    public void setBizData(List<NotePadListDataResponse> bizData)
    {
        this.bizData = bizData;
    }
    
}
