package com.centit.core.tools.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MIP_DateUtil
{
    private static String                 pattern             = "yyyy-MM-dd E HH:mm:ss";
    
    private static SimpleDateFormat       patternDF           = new SimpleDateFormat(pattern, Locale.CHINA);
    
    private static final SimpleDateFormat yyyyMMdd            = new SimpleDateFormat("yyyy-MM-dd");
    
    private static final SimpleDateFormat yyyyMMddNoSep       = new SimpleDateFormat("yyyyMMdd");
    
    private static final SimpleDateFormat yyyyMMddHHMMSSNoSep = new SimpleDateFormat("yyyyMMddHHmmss");
    
    private static final SimpleDateFormat HHmmss              = new SimpleDateFormat("HH:mm:ss");
    
    private static final SimpleDateFormat yyyyMMddHHmmss      = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private static final SimpleDateFormat yyyyMMddHHmm        = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    private static final SimpleDateFormat yyyyMMddHHmmssNoSep = new SimpleDateFormat("yyyyMMddHHmm");
    
    private static final SimpleDateFormat yyyyMM              = new SimpleDateFormat("yyyy-MM");
    
    public static final SimpleDateFormat  yyyyMMCn            = new SimpleDateFormat("yyyy年MM月");
    
    public static final SimpleDateFormat  yyyyMMNoSep         = new SimpleDateFormat("yyyyMM");
    
    private static final SimpleDateFormat MMdd                = new SimpleDateFormat("MM.dd");
    
    private static final SimpleDateFormat HHmm                = new SimpleDateFormat("HH:mm");
    
    private static final SimpleDateFormat MMddNopoint         = new SimpleDateFormat("MM月dd日");
    
    private static final SimpleDateFormat MMdd_HHMM           = new SimpleDateFormat("MM月dd日 HH:mm");
    
    public static String makeCurrentDateTimeStr()
    {
        return patternDF.format(getCurrentDate());
    }
    
    public static String formatDate(Date d)
    {
        if (d == null)
            return MIP_StringEnCodeUtil.EMPTY;
        return yyyyMMdd.format(d);
    }
    
    public static Date formatDateValue(Date d)
    {
        if (d == null)
            return null;
        String strDate = yyyyMMdd.format(d);
        return formatStrDate(strDate);
    }
    
    public static String formatDate(Date d, String format)
    {
        if (d == null)
            return MIP_StringEnCodeUtil.EMPTY;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }
    
    public static String formatDate(Date d, SimpleDateFormat format)
    {
        if (d == null)
            return MIP_StringEnCodeUtil.EMPTY;
        return format.format(d);
    }
    
    public static Date formatStrDate(String d)
    {
        if (d == null)
            return getCurrentDate();
        
        Date date = null;
        try
        {
            date = yyyyMMdd.parse(d);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return getCurrentDate();
        }
        return date;
    }
    
    public static Date formatStrDateNoSep(String d)
    {
        if (d == null)
            return getCurrentDate();
        
        Date date = null;
        try
        {
            date = yyyyMMddNoSep.parse(d);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return getCurrentDate();
        }
        return date;
    }
    
    public static Date formatStrDateTime(String d)
    {
        if (d == null)
            return getCurrentDate();
        
        Date date = null;
        try
        {
            date = yyyyMMddHHmmss.parse(d);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return getCurrentDate();
        }
        return date;
    }
    
    public static Date formatStrDateTimeNoSep(String d)
    {
        if (d == null)
            return getCurrentDate();
        
        Date date = null;
        try
        {
            date = yyyyMMddHHmmssNoSep.parse(d);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return getCurrentDate();
        }
        return date;
    }
    
    /**
     * 
     * <一句话功能简述>
     * 
     * @Description<功能详细描述>
     * 
     * @param d yyyy-MM-dd HH:mm
     * @return
     * @LastModifiedDate：2015-6-11
     * @author Wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static Date formatStrDateTimeNoSep1(String d)
    {
        if (d == null)
            return getCurrentDate();
        
        Date date = null;
        try
        {
            date = yyyyMMddHHmm.parse(d);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return getCurrentDate();
        }
        return date;
    }
    
    public static String formatDate(String strDate)
    {
        if (strDate == null || strDate.trim().equals(""))
            return MIP_StringEnCodeUtil.EMPTY;
        try
        {
            return yyyyMMdd.format(yyyyMMdd.parse(strDate));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return MIP_StringEnCodeUtil.EMPTY;
        }
    }
    
    public static String formatTime(Date d)
    {
        if (d == null)
            return MIP_StringEnCodeUtil.EMPTY;
        return HHmmss.format(d);
    }
    
    public static String formatTime(String strTime)
    {
        Date date;
        if (strTime == null || strTime.length() <= 0)
        {
            return "";
        }
        try
        {
            date = yyyyMMddHHmmss.parse(strTime);
            return HHmmss.format(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return "";
    }
    
    public static String formatDateTime(Date d)
    {
        if (d == null)
            return MIP_StringEnCodeUtil.EMPTY;
        return yyyyMMddHHmmss.format(d);
    }
    
    public static String formatDateTimeNoSep(Date d)
    {
        if (d == null)
            return MIP_StringEnCodeUtil.EMPTY;
        return yyyyMMddHHmmssNoSep.format(d);
    }
    
    public static String formatyyMM(Date d)
    {
        if (d == null)
        {
            return MIP_StringEnCodeUtil.EMPTY;
        }
        return yyyyMM.format(d);
    }
    
    /**
     * yyyyMMddHHmmss--->yyyyMMdd
     * 
     * @param text
     * @return
     */
    public static String renderDate(String text)
    {
        if (MIP_StringEnCodeUtil.isEmpty(text))
        {
            return MIP_StringEnCodeUtil.EMPTY;
        }
        int idx = text.indexOf(" ");
        if (idx <= 0)
        {
            return text;
        }
        return text.substring(0, idx).trim();
    }
    
    /**
     * yyyyMMddHHmmss--->yyyyMMdd
     * 
     * @param text
     * @return
     */
    public static String renderTime(String text)
    {
        if (MIP_StringEnCodeUtil.isEmpty(text))
        {
            return MIP_StringEnCodeUtil.EMPTY;
        }
        int idx = text.indexOf(" ");
        if (idx <= 0)
        {
            return text;
        }
        return text.substring(idx).trim();
    }
    
    public static String formatNextMonthDate(String date)
    {
        String strDate = "";
        Date d = formatStrDate(date);
        Date currentDate = d;
        if (currentDate == null)
        {
            Date nextMonth = new Date(getCurrentDate().getTime() + (24 * 60 * 60 * 1000));
            strDate = formatDate(nextMonth);
        }
        else
        {
            Date nextMonth = new Date(currentDate.getTime() + (24 * 60 * 60 * 1000));
            strDate = formatDate(nextMonth);
        }
        return strDate;
    }
    
    public static String formatPrevMonthDate(Date date)
    {
        Calendar cal = Calendar.getInstance();
        if (date != null)
        {
            cal.setTimeInMillis(date.getTime());
        }
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        String strTime = formatDate(new Date(cal.getTimeInMillis()));
        return strTime.replace("-", "").substring(0, 6);
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
    
    public static String formatYearMonth(Date date)
    {
        String str = "";
        if (date == null)
        {
            str = yyyyMMNoSep.format(getCurrentDate());
        }
        else
        {
            str = yyyyMMNoSep.format(date);
        }
        return str;
    }
    
    public static String formatYearMonth()
    {
        return formatYearMonth(null);
    }
    
    public static String formatYearMonth(Date date, int tick)
    {
        Calendar cal = Calendar.getInstance();
        if (date != null)
        {
            cal.setTimeInMillis(date.getTime());
        }
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + tick);
        
        String yearMonth = yyyyMMNoSep.format(new Date(cal.getTimeInMillis()));
        return yearMonth;
    }
    
    public static String formatYearMonthCn(Date date, int tick)
    {
        Calendar cal = Calendar.getInstance();
        if (date != null)
        {
            cal.setTimeInMillis(date.getTime());
        }
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + tick);
        
        String yearMonth = yyyyMMCn.format(new Date(cal.getTimeInMillis()));
        return yearMonth;
    }
    
    public static String formatYearMonthCn(Date date)
    {
        String yearMonth = "";
        if (date != null)
        {
            yearMonth = yyyyMMCn.format(date);
        }
        return yearMonth;
    }
    
    public static String formatYMD(Date date)
    {
        String str = "";
        if (date == null)
        {
            str = yyyyMMddNoSep.format(getCurrentDate());
        }
        else
        {
            str = yyyyMMddNoSep.format(date);
        }
        str = str.replaceAll("-", "");
        return str;
    }
    
    public static String getToday()
    {
        String str = "";
        str = yyyyMMddNoSep.format(getCurrentDate());
        return str;
    }
    
    public static Long getLongTime(String str)
    {
        if (str == null)
        {
            str = yyyyMMddHHMMSSNoSep.format(getCurrentDate());
        }
        
        Long time = 0l;
        try
        {
            time = Long.parseLong(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return time;
    }
    
    public static String formatYMD()
    {
        return formatYMD(null);
    }
    
    public static Date getCurrentDate()
    {
        return new Date(System.currentTimeMillis());
    }
    
    public static long getCurrentTimeMills()
    {
        return System.currentTimeMillis();
    }
    
    /**
     * 月-日
     * 
     * @param date
     * @return
     */
    public static String formatMD(String date)
    {
        if (MIP_StringEnCodeUtil.isEmpty(date))
        {
            return "";
        }
        String strDate = "";
        try
        {
            strDate = MMdd.format(formatStrDate(date));
        }
        catch (Exception e)
        {
            return "";
        }
        return strDate;
    }
    
    public static Date parseString(String s)
    {
        Date date = new Date(Long.parseLong(s));
        return date;
    }
    
    public static String formatDate2Chinese(String strDate)
    {
        if (strDate == null || strDate.length() != 14)
        {
            return null;
        }
        
        String result = "";
        result = strDate.substring(0, 4) + "年";
        result += changeDate(strDate.substring(4, 6)) + "月";
        result += changeDate(strDate.substring(6, 8)) + "日";
        result += changeDate(strDate.substring(8, 10)) + "点";
        result += changeDate(strDate.substring(10, 12)) + "分";
        
        return result;
    }
    
    public static String formatDateToChinese(String str)
    {
        System.out.println("str：" + str);
        Date date = new Date(Long.parseLong(str));
        String strDate = formatDateTimeNoSep(date);
        System.out.println("strDate：" + strDate);
        if (strDate == null || strDate.length() != 14)
        {
            return null;
        }
        
        String result = "";
        result = strDate.substring(0, 4) + "年";
        result += changeDate(strDate.substring(4, 6)) + "月";
        result += changeDate(strDate.substring(6, 8)) + "日";
        result += changeToAPm(strDate.substring(8, 10)) + "点";
        result += changeDate(strDate.substring(10, 12)) + "分";
        result += changeDate(strDate.substring(12, 14)) + "秒";
        
        return result;
    }
    
    private static String changeDate(String str)
    {
        String result = "";
        try
        {
            result = String.valueOf(Integer.parseInt(str));
        }
        catch (NumberFormatException e)
        {
            result = str;
        }
        
        return result;
    }
    
    private static String changeToAPm(String str)
    {
        String result = "";
        try
        {
            int temp = Integer.parseInt(str);
            if (temp > 12)
            {
                temp -= 12;
                result = "下午" + String.valueOf(temp);
            }
            else
            {
                result = "上午" + String.valueOf(temp);
            }
        }
        catch (NumberFormatException e)
        {
            result = str;
        }
        
        return result;
    }
    
    public static String formateMillisToHHSSMM(long milliseconds)
    {
        Date date = new Date(milliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return formatter.format(date);
    }
    
    public static String formateMillisToYYYYMMDDHHSS(long milliseconds)
    {
        Date date = new Date(milliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        // formatter.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return formatter.format(date);
    }
    
    public static String formateMillisToHHMM(long milliseconds)
    {
        Date date = new Date(milliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        // formatter.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return formatter.format(date);
    }
    
    /**
     * yyyyMMddHHmmss--->HH:mm
     * 
     * @return
     */
    public static String formate1(String yyyyMMddHHmmss)
    {
        Date date = formatStrDateTimeNoSep(yyyyMMddHHmmss);
        return formatDate(date, "HH:mm");
    }
    
    /**
     * yyyyMMdd---->yyyy年MM月dd日
     * 
     * @param yyyyMMdd
     * @return
     */
    public static String formate2(String yyyyMMdd)
    {
        Date date = formatStrDateNoSep(yyyyMMdd);
        return formatDate(date, "yyyy年MM月dd日");
    }
    
    /**
     * yyyyMMddHHmmss--->any
     * 
     * @return
     */
    public static String formate3(String yyyyMMddHHmmss, String formate)
    {
        Date date = formatStrDateTimeNoSep(yyyyMMddHHmmss);
        return formatDate(date, formate);
    }
    
    /**
     * yyyyMMdd---->any
     * 
     * @param yyyyMMdd
     * @return
     */
    public static String formate4(String yyyyMMdd, String formate)
    {
        Date date = formatStrDateNoSep(yyyyMMdd);
        return formatDate(date, formate);
    }
    
    public static String formate5(String yyyyMMdd, String formate)
    {
        Date date = formatStrDate(yyyyMMdd);
        return formatDate(date, formate);
    }
    
    public static String getCurYear()
    {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        return yyyy.format(new Date());
    }
    
    public static String getCurDay()
    {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyyMMdd");
        return yyyy.format(new Date());
    }
    
    public static String getCurTime()
    {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return yyyy.format(new Date());
    }
    
    public static String getCurTime1()
    {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyyMMddHHmmss");
        return yyyy.format(new Date());
    }
    
    public static String getHourAndMinute(String dateStr)
    {
        String hourandminute = "";
        if (dateStr.length() > 15)
        {
            hourandminute = dateStr.substring(11, 16);
        }
        else if (dateStr.length() > 11)
        {
            hourandminute = dateStr.substring(11);
        }
        else
        {
            hourandminute = dateStr;
        }
        return hourandminute;
    }
    
    /**
     * 获得指定日期的前一天
     * 
     * @param specifiedDay yyyy-mm-dd
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay)
    {// 可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 获得指定日期的后一天
     * 
     * @param specifiedDay yyyy-mm-dd
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
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
    public static String getFirstDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy-MM-dd");
        return yyyy.format(c.getTime());
        // return c.getTime();
    }
    
    /**
     * 取得指定日期所在周的最后一天
     * 
     * @param date
     * @return
     */
    public static String getLastDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy-MM-dd");
        return yyyy.format(c.getTime());
        // return c.getTime();
    }
    
    private static String getPreWeekDay(String dateStr)
    {
        
        getPreWeekDay(dateStr);
        Date date = null;
        try
        {
            date = yyyyMMdd.parse(dateStr);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return "";
    }
    
    /**
     * 
     * 日期String转date
     * 
     * @Description<功能详细描述>
     * 
     * @param dateStr yyyy-MM-dd HH:mm
     * @return
     * @LastModifiedDate：2016-2-22
     * @author wl
     * @EditHistory：<修改内容><修改人>
     */
    public static long DateStringToLong(String dateStr)
    {
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt = null;
        try
        {
            dt = sdf.parse(dateStr);
        }
        catch (java.text.ParseException e)
        {
            e.printStackTrace();
        }
        return dt.getTime();
        
    }
    
    // 获取当天日
    public static int getCurrentDay()
    {
        Date dt = getCurrentDate();
        if (dt != null)
        {
            return dt.getDate();
        }
        return 1;
    }
    
    // 获取星期*
    public static String getCurrentWeek()
    {
        Date dt = getCurrentDate();
        if (dt != null)
        {
            int day = dt.getDay();
            
            switch (day)
            {
                case 0:
                    
                    return "星期日";
                case 1:
                    
                    return "星期一";
                case 2:
                    
                    return "星期二";
                case 3:
                    
                    return "星期三";
                case 4:
                    
                    return "星期四";
                case 5:
                    
                    return "星期五";
                    
                case 6:
                    
                    return "星期六";
                    
                default:
                    break;
            }
        }
        return "";
    }
    
    public static String convertLong2Hour(String time)
    {
        String hourtime = "";
        try
        {
            Date d = yyyyMMddHHMMSSNoSep.parse(time);
            
            hourtime = HHmm.format(d);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return hourtime;
    }
    
    public static String convertLong2Day(String time)
    {
        String daytime = "";
        try
        {
            Date d = yyyyMMddHHMMSSNoSep.parse(time);
            
            daytime = yyyyMMdd.format(d);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return daytime;
    }
    
    public static String toDateDayOrHour(String time)
    {
        String ret = "";
        
        try
        {
            Date d = yyyyMMddHHmmss.parse(time);
            
            ret = MMddNopoint.format(d);
            
            String cDate = MMddNopoint.format(getCurrentDate());
            
            if (ret.equals(cDate))
            {
                ret = HHmm.format(d);
            }
        }
        catch (Exception e)
        {
            ret = "";
            e.printStackTrace();
        }
        
        return ret;
    }
    
    public static String toMMDDHHMM(String time)
    {
        String ret = "";
        
        try
        {
            Date d = yyyyMMddHHmmss.parse(time);
            
            ret = MMdd_HHMM.format(d);
            
        }
        catch (Exception e)
        {
            ret = "";
            e.printStackTrace();
        }
        
        return ret;
    }
    
    // 判断当前时间是否是在两个时间之内
    @SuppressWarnings("deprecation")
    public static boolean isBetweenTime(int startHour, int startMin, int endHour, int endMin)
    {
        Date cD = getCurrentDate();
        int hour = cD.getHours();
        int min = cD.getMinutes();
        
        long cTime = hour * 60 + min;
        
        long startTime = startHour * 60 + startMin;
        long endTime = endHour * 60 + endMin;
        if (cTime > startTime && cTime < endTime)
        {
            return true;
        }
        return false;
    }
}