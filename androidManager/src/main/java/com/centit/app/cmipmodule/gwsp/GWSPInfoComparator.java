package com.centit.app.cmipmodule.gwsp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import android.net.ParseException;

import com.centit.app.cmipmodule.gwsp.entity.GWSPHistoryDataResponse;

public class GWSPInfoComparator implements Comparator<GWSPHistoryDataResponse>
{
    
    @Override
    public int compare(GWSPHistoryDataResponse arg0, GWSPHistoryDataResponse arg1)
    {
        // TODO Auto-generated method stub
        long seq1 = 0L;
        long seq2 = 0L;
        try
        {
            seq1 = Long.parseLong(arg0.getHandletime());
            seq2 = Long.parseLong(arg1.getHandletime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return (int)(seq1 - seq2);
    }
    
    public static Date stringToDate(String strTime)
        
        throws ParseException
    {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date date = null;
        
        try
        {
            date = formatter.parse(strTime);
        }
        catch (java.text.ParseException e)
        {
            e.printStackTrace();
        }
        
        return date;
        
    }
}
