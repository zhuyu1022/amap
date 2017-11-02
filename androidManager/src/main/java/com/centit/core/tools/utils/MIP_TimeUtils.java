package com.centit.core.tools.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MIP_TimeUtils
{
    private static String                mYear;
    
    private static String                mMonth;
    
    private static String                mDay;
    
    private static String                mWay;
    
    public static String                 pattern             = "yyyy-MM-dd E HH:mm:ss";
    
    public static SimpleDateFormat       patternDF           = new SimpleDateFormat(pattern, Locale.CHINA);
    
    public static final SimpleDateFormat yyyyMMdd            = new SimpleDateFormat("yyyy-MM-dd");
    
    public static final SimpleDateFormat yyyyMMddNoSep       = new SimpleDateFormat("yyyyMMdd");
    
    public static final SimpleDateFormat HHmmss              = new SimpleDateFormat("HH:mm:ss");
    
    public static final SimpleDateFormat HHmm                = new SimpleDateFormat("HH:mm");
    
    public static final SimpleDateFormat yyyyMMddHHmmss      = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static final SimpleDateFormat yyyyMMddHHmm        = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public static final SimpleDateFormat yyyyMMddHHmmssNoSep = new SimpleDateFormat("yyyyMMddHHmm");
    
    public static final SimpleDateFormat yyyyMM              = new SimpleDateFormat("yyyy-MM");
    
    public static final SimpleDateFormat yyyyMMCn            = new SimpleDateFormat("yyyy年MM月");
    
    public static final SimpleDateFormat yyyyMMDDCn          = new SimpleDateFormat("yyyy年MM月dd日");
    
    public static final SimpleDateFormat yyyyMMNoSep         = new SimpleDateFormat("yyyyMM");
    
    public static final SimpleDateFormat MMdd                = new SimpleDateFormat("MM.dd");
    
    public static final SimpleDateFormat MMddHHmm            = new SimpleDateFormat("MM-dd HH:mm");
    
    /**
     * 获取当前时间，返回long型
     * 
     * @return
     */
    public static long getCurrentTimeMills()
    {
        return System.currentTimeMillis();
    }
    
    /**
     * 获取当前时间，返回Date 型
     * 
     * @return
     */
    public static Date getCurrentDate()
    {
        return new Date(getCurrentTimeMills());
    }
    
    /**
     * 获取当前时间，返回String 型
     * 
     * @return
     */
    public static String getCurrentStr(SimpleDateFormat format)
    {
        Date d = getCurrentDate();
        return formatDate2Str(d, format);
    }
    
    /**
     * 长整形转date
     * 
     * @param time
     * @return
     */
    public static Date formatLong2Date(long time)
    {
        Date date = null;
        try
        {
            date = new Date(time);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 长整形 转 String
     * 
     * @param time
     * @param format
     * @return
     */
    public static String formatLong2Str(long time, SimpleDateFormat format)
    {
        Date date = formatLong2Date(time);
        if (date != null)
        {
            return formatDate2Str(date, format);
        }
        
        return "";
    }
    
    public static String formatStr2Str(String time)
    {
        String strTime = "";
        if (time != null && !time.equals("") && time.length() == 14)
        {
            strTime =
                time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " "
                    + time.substring(8, 10) + ":" + time.substring(10, 12) + ":" + time.substring(12);
            return strTime;
        }
        return time;
    }
    
    /**
     * Date 转换为String
     * 
     * @param d
     * @param format
     * @return
     */
    public static String formatDate2Str(Date d, SimpleDateFormat format)
    {
        if (d == null)
            return MIP_StringUtils.EMPTY;
        return format.format(d);
    }
    
    /**
     * Date 转换为Long
     * 
     * @param d
     * @param format
     * @return
     */
    public static Long formatDate2Long(Date d)
    {
        if (d == null)
            return 0L;
        
        return d.getTime();
    }
    
    /**
     * Date 转换为Calendar
     * 
     * @param d
     * @param format
     * @return
     */
    public static Calendar formatDate2Calendar(Date d)
    {
        Calendar calendar = Calendar.getInstance();
        if (d == null)
        {
            return null;
        }
        else
        {
            calendar.setTime(d);
        }
        return calendar;
    }
    
    /**
     * String 转为Date
     * 
     * @param mDStr
     * @param format
     * @return
     */
    public static Date formatStr2Date(String mDStr, SimpleDateFormat format)
    {
        if (mDStr == null)
            return null;
        
        Date date = null;
        try
        {
            date = format.parse(mDStr);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 某一种格式的String 转为另一种格式的String
     * 
     * @param strDate
     * @param formatOrg
     * @param formatNew
     * @return
     */
    public static String formatStr2Str(String strDate, SimpleDateFormat formatOrg, SimpleDateFormat formatNew)
    {
        if (strDate == null || strDate.trim().equals(""))
            return MIP_StringUtils.EMPTY;
        
        Date old_date = formatStr2Date(strDate, formatOrg);
        if (old_date != null)
        {
            return formatDate2Str(old_date, formatNew);
        }
        return "";
    }
    
    /**
     * Calendar 转Date
     * 
     * @param calendar
     * @return
     */
    public static Date formatCalendar2Date(Calendar calendar)
    {
        if (calendar == null)
            return null;
        
        return calendar.getTime();
    }
    
    /**
     * 获取当前日期和星期 <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：2017-6-7
     * @author zxm
     * @EditHistory：<修改内容><修改人>
     */
    public static String StringDataAndWeek()
    {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay))
        {
            mWay = "天";
        }
        else if ("2".equals(mWay))
        {
            mWay = "一";
        }
        else if ("3".equals(mWay))
        {
            mWay = "二";
        }
        else if ("4".equals(mWay))
        {
            mWay = "三";
        }
        else if ("5".equals(mWay))
        {
            mWay = "四";
        }
        else if ("6".equals(mWay))
        {
            mWay = "五";
        }
        else if ("7".equals(mWay))
        {
            mWay = "六";
        }
        return mYear + "年" + mMonth + "月" + mDay + "日" + "\t星期" + mWay;
    }
    
    /**
     * Calendar 转String
     * 
     * @param calendar
     * @return
     */
    public static String formatCalendar2String(Calendar calendar, SimpleDateFormat format)
    {
        if (calendar == null)
            return "";
        
        return format.format(calendar.getTime());
    }
    
    public static String formatTime(int seconds)
    {
        String ret = "00:00:00";
        if (seconds <= 0)
            return ret;
        int sec = seconds % 60;
        int min = (seconds / 60) % 60;
        int hr = seconds / 3600;
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), hr, min, sec);
        ret = String.format("%1$tH:%1$tM:%1$tS", new Date(cal.getTimeInMillis()));
        return ret;
    }
    
    public static String secToTime(long seconds)
    {
        String ret = "";
        
        if (seconds <= 0)
        {
            return "0秒";
        }
        
        if (seconds >= 3600 * 24)
        {
            int day = (int)seconds / (3600 * 24);
            seconds = seconds % (3600 * 24);
            ret += day + "天";
        }
        if (seconds >= 3600)
        {
            int hr = (int)seconds / (3600);
            seconds = seconds % (3600);
            ret += hr + "小时";
        }
        if (seconds >= 60)
        {
            int min = (int)seconds / (60);
            seconds = seconds % (60);
            ret += min + "分";
        }
        
        return ret + seconds + "秒";
    }
    
    /**
     * 获得指定日期的前一天 两天的格式是一致的
     * 
     * @param specifiedDay yyyy-mm-dd
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay, SimpleDateFormat format)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = format.parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        
        String dayBefore = format.format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 获得指定日期的后一天
     * 
     * @param specifiedDay yyyy-mm-dd
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay, SimpleDateFormat format)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = format.parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        
        String dayAfter = format.format(c.getTime());
        return dayAfter;
    }
    
    /**
     * 
     * 获取本周一日期
     * 
     * @Description<功能详细描述>
     * 
     * @param date
     * @return
     * @LastModifiedDate：2015-6-11
     * @author Wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static Date getNowWeekMonday(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        return cal.getTime();
    }
    
    /**
     * 取得当前日期是多少周
     * 
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        
        return c.get(Calendar.WEEK_OF_YEAR);
    }
    
    /**
     * 取得指定日期所在周的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        
        return c.getTime();
    }
    
    /**
     * 取得指定日期所在周的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }
    
}