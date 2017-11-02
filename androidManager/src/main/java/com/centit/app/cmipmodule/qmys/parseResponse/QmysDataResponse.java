/*
 * File name:  YunTuDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.qmys.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-10-12]
 */
public class QmysDataResponse implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    // "id":"id",
    // "donor":"合计数",
    // "dates":"日期",
    // "terrace":"过滤条件",
    // "annual_target":"月度目标/年度目标",
    // "monthly_undertake":"月度承接",
    // "undertake_rate":"承接率",
    // "actual":"实际",
    // "monthly_all":"月累计",
    // "last_year_total":"上年合计",
    // "annual_total_target":"年累目标",
    // "annual_all":"年累计",
    // "increment":"增量",
    // "sameperiod":"同期",
    // "completion_rate":"完成率",
    // "compare_sameperiod":"同比",
    // "profit_rate":"利润率"
    
    private String            id;
    
    private String            monthly_undertake;
    
    private String            terrace;
    
    private String            completion_rate;
    
    private String            donor;
    
    private String            dates;
    
    private String            annual_target;
    
    private String            actual;
    
    private String            undertake_rate;
    
    private String            compare_sameperiod;
    
    private String            sameperiod;
    
    private String            monthly_all;
    
    private String            last_year_total;
    
    private String            annual_total_target;
    
    private String            annual_all;
    
    private String            increment;
    
    private String            profit_rate;
    
    public String getMonthly_all()
    {
        return monthly_all;
    }
    
    public void setMonthly_all(String monthly_all)
    {
        this.monthly_all = monthly_all;
    }
    
    public String getLast_year_total()
    {
        return last_year_total;
    }
    
    public void setLast_year_total(String last_year_total)
    {
        this.last_year_total = last_year_total;
    }
    
    public String getAnnual_total_target()
    {
        return annual_total_target;
    }
    
    public void setAnnual_total_target(String annual_total_target)
    {
        this.annual_total_target = annual_total_target;
    }
    
    public String getAnnual_all()
    {
        return annual_all;
    }
    
    public void setAnnual_all(String annual_all)
    {
        this.annual_all = annual_all;
    }
    
    public String getIncrement()
    {
        return increment;
    }
    
    public void setIncrement(String increment)
    {
        this.increment = increment;
    }
    
    public String getProfit_rate()
    {
        return profit_rate;
    }
    
    public void setProfit_rate(String profit_rate)
    {
        this.profit_rate = profit_rate;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getMonthly_undertake()
    {
        return monthly_undertake;
    }
    
    public void setMonthly_undertake(String monthly_undertake)
    {
        this.monthly_undertake = monthly_undertake;
    }
    
    public String getTerrace()
    {
        return terrace;
    }
    
    public void setTerrace(String terrace)
    {
        this.terrace = terrace;
    }
    
    public String getCompletion_rate()
    {
        return completion_rate;
    }
    
    public void setCompletion_rate(String completion_rate)
    {
        this.completion_rate = completion_rate;
    }
    
    public String getDonor()
    {
        return donor;
    }
    
    public void setDonor(String donor)
    {
        this.donor = donor;
    }
    
    public String getDates()
    {
        return dates;
    }
    
    public void setDates(String dates)
    {
        this.dates = dates;
    }
    
    public String getAnnual_target()
    {
        return annual_target;
    }
    
    public void setAnnual_target(String annual_target)
    {
        this.annual_target = annual_target;
    }
    
    public String getActual()
    {
        return actual;
    }
    
    public void setActual(String actual)
    {
        this.actual = actual;
    }
    
    public String getUndertake_rate()
    {
        return undertake_rate;
    }
    
    public void setUndertake_rate(String undertake_rate)
    {
        this.undertake_rate = undertake_rate;
    }
    
    public String getCompare_sameperiod()
    {
        return compare_sameperiod;
    }
    
    public void setCompare_sameperiod(String compare_sameperiod)
    {
        this.compare_sameperiod = compare_sameperiod;
    }
    
    public String getSameperiod()
    {
        return sameperiod;
    }
    
    public void setSameperiod(String sameperiod)
    {
        this.sameperiod = sameperiod;
    }
    
    private boolean                isOpen         = false;
    
    private List<QmysDataResponse> mDataResponses = new ArrayList<QmysDataResponse>();
    
    public boolean isOpen()
    {
        return isOpen;
    }
    
    public void setOpen(boolean isOpen)
    {
        this.isOpen = isOpen;
    }
    
    public List<QmysDataResponse> getmDataResponses()
    {
        return mDataResponses;
    }
    
    public void setmDataResponses(List<QmysDataResponse> mDataResponses)
    {
        this.mDataResponses = mDataResponses;
    }
    
}
