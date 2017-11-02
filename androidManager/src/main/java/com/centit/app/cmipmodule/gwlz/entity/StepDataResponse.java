package com.centit.app.cmipmodule.gwlz.entity;

import java.io.Serializable;
import java.util.List;

public class StepDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long          serialVersionUID = 1L;
    
    private List<StepDataItemResponse> nextsteplist;
    
    /**
     * 获取 nextsteplist
     * 
     * @return 返回 nextsteplist
     * @author rqj
     */
    public List<StepDataItemResponse> getNextsteplist()
    {
        return nextsteplist;
    }
    
    /**
     * 设置 nextsteplist
     * 
     * @param nextsteplist 对nextsteplist进行赋值
     * @author rqj
     */
    public void setNextsteplist(List<StepDataItemResponse> nextsteplist)
    {
        this.nextsteplist = nextsteplist;
    }
    
}
