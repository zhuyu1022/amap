package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchedueListDataResponse implements Serializable
{
    
    /**
     * serialVersionUID<用一句话描述这个变量表示什么>
     * 
     * @author wang_ling
     */
    private static final long    serialVersionUID = 1L;
    
    private List<ScheduleDataVo> schedulelist     = new ArrayList<ScheduleDataVo>();
    
    public List<ScheduleDataVo> getSchedulelist()
    {
        return schedulelist;
    }
    
    public void setSchedulelist(List<ScheduleDataVo> schedulelist)
    {
        this.schedulelist = schedulelist;
    }
    
}
