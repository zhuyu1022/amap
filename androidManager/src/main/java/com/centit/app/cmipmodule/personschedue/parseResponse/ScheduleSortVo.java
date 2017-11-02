package com.centit.app.cmipmodule.personschedue.parseResponse;

import java.util.ArrayList;

public class ScheduleSortVo<T>
{
    private String       date;
    
    private ArrayList<T> data;
    
    public ScheduleSortVo()
    {
        super();
    }
    
    public ScheduleSortVo(String date, ArrayList<T> data)
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
    
    public ArrayList<T> getData()
    {
        return data;
    }
    
    public void setData(ArrayList<T> data)
    {
        this.data = data;
    }
}
