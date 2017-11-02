package com.centit.app.cmipmodule.hygl.parseResponse;

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
public class HYListBizResponse extends RetParseResponse
{
    private List<HYListDataVo> bizData;
    
    /**
     * 获取 bizData
     * 
     * @return 返回 bizData
     * @author wl
     */
    public List<HYListDataVo> getBizData()
    {
        return bizData;
    }
    
    /**
     * 设置 bizData
     * 
     * @param bizData 对bizData进行赋值
     * @author wl
     */
    public void setBizData(List<HYListDataVo> bizData)
    {
        this.bizData = bizData;
    }
    
}
