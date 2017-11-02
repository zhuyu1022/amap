package com.centit.app.cmipmodule.hygl.parseResponse;

import java.util.ArrayList;

public class HYListSortVo
{
    private String                  date;
    
    private ArrayList<HYListDataVo> data;
    
    public HYListSortVo()
    {
        super();
    }
    
    public HYListSortVo(String date, ArrayList<HYListDataVo> data)
    {
        super();
        this.date = date;
        this.data = data;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public ArrayList<HYListDataVo> getData()
    {
        return data;
    }
    
    public void setData(ArrayList<HYListDataVo> data)
    {
        this.data = data;
    }
}
