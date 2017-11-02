package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.util.List;

import com.centit.core.tools.netUtils.baseReqeust.baseParseResponse.RetParseResponse;

/**
 * 
 * 新闻中心返回
 * 
 * @Description<功能详细描述>
 * 
 * @author wang_ling
 * @Version [版本号, 2014-7-17]
 */
public class SchedueListBizResponse extends RetParseResponse
{
    private List<ScheduleDataVo> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author wl
     */
    public List<ScheduleDataVo> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author wl
     */
    public void setBizData(List<ScheduleDataVo> bizData)
    {
        this.bizData = bizData;
    }
    
}
