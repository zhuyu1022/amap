/**
 * Copyright (C) 2011 by BESTRUN CO.,LTD.
 * 
 * @Title: StringUtil.java
 * @Package: com.bestrun.android.utils
 * @Description: 字符串相关的帮助工具类
 * @author: Yang
 * @date: 2011-10-8 15:39:37
 * @version: 1.0
 */
package com.centit.core.tools.utils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MIP_StringEnCodeUtil
{
    public static final String US_ASCII   = "US-ASCII";
    
    public static final String ISO_8859_1 = "ISO-8859-1";
    
    public static final String UTF_8      = "UTF-8";
    
    public static final String UTF_16BE   = "UTF-16BE";
    
    public static final String UTF_16LE   = "UTF-16LE";
    
    public static final String UTF_16     = "UTF-16";
    
    public static final String GBK        = "GBK";
    
    public static final String GB2312     = "gb2312";
    
    public static final String EMPTY      = "";
    
    /**
     * 检查字符串是否为空，包括NULL、空串和只有空格的字符串
     * 
     * @param x
     * @return
     */
    public static boolean isEmpty(String x)
    {
        return x == null || x.trim().length() == 0;
    }
    
    /**
     * 
     * 判断字符串是否为纯数字[0-9\.]
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric(String str)
    {
        return isNumeric(str, false);
    }
    
    /**
     * 
     * 判断字符串是否为纯数字[0-9\.]，包含正负数。
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric(String str, boolean includeNagetive)
    {
        String strPattern = "^\\d+(\\.\\d+)?$";
        if (includeNagetive)
        {
            strPattern = "^[+-]?\\d+(\\.\\d+)?$";
        }
        Pattern pattern = Pattern.compile(strPattern);
        return pattern.matcher(str).matches();
    }
    
    /**
     * 获得以字节为单位的字符串长度
     * 
     * @param s
     * @return
     */
    public static int getWordCount(String s)
    {
        
        s = s.replaceAll("[^\\x00-\\xff]", "**");
        int length = s.length();
        return length;
    }
    
    /**
     * 将字符串列表转化为一个字符串, 用@param<sep>分隔
     * 
     * @param stringList 待转化的字符串列表
     * @param sep 分隔符
     * @param addQuotar 是否需要给元素添加引号，默认为true
     * @return
     */
    public static String listToString(List<String> stringList, String sep, boolean addQuotar)
    {
        if (stringList == null)
        {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList)
        {
            if (flag)
            {
                result.append(sep);
            }
            else
            {
                flag = true;
            }
            if (addQuotar)
            {
                result.append("'").append(string).append("'");
            }
            else
            {
                result.append(string);
            }
        }
        return result.toString();
    }
    
    /**
     * 将字符串列表转化为一个字符串, 用@param<sep>分隔
     * 
     * @param stringList 待转化的字符串列表
     * @param sep 分隔符
     * @return
     */
    public static String listToString(List<String> stringList, String sep)
    {
        return listToString(stringList, sep, true);
    }
    
    /**
     * 拼凑URL字符串
     * 
     * @param url1 第一个URL
     * @param url2 第二个URL
     * @return
     */
    public static String combineUrl(String url1, String url2)
    {
        String sep = "/";
        boolean hasEnd = url1.endsWith(sep);
        boolean hasStart = url2.startsWith(sep);
        if (hasEnd && hasStart)
        {
            return url1.concat(url2.substring(1));
        }
        else if (!hasEnd && !hasStart)
        {
            return url1.concat(sep).concat(url2);
        }
        else
        {
            return url1.concat(url2);
        }
    }
    
    /**
     * 从字符串中提取数字
     * 
     * @param temp
     * @return
     */
    public static String getNumbers(String string)
    {
        // TODO Auto-generated method stub
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(string);
        return m.replaceAll("").trim();
    }
    
    /**
     * 取小数点后2位
     * 
     * @param str
     * @return
     */
    public static String Keep2df(String str)
    {
        if (str.indexOf(".") != -1 && str.length() > 5)
        {
            if (str.substring(str.indexOf(".")).length() > 3)
            {
                str = str.substring(0, str.indexOf(".") + 3);
            }
        }
        return str;
    }
    
    /**
     * 将字符串编码格式转成GB2312
     * 
     * @param str
     * @return
     */
    public static String TranEncodeTOGB(String str)
    {
        try
        {
            String gStr = new String(str.getBytes("UTF-8"), "GB2312");
            // String strEncode = StringUtil.getEncoding(str);
            // String utf8 = new String(str.getBytes("UTF-8"));
            // String unicode = new String(utf8.getBytes(), "UTF-8");
            // System.out.println(unicode);
            // String gbk = new String(unicode.getBytes("GBK"));
            // System.out.println("strEncode" + strEncode);
            // String temp = new String(str.getBytes(strEncode), "gbk");
            return gStr;
        }
        catch (java.io.IOException ex)
        {
            return null;
        }
    }
    
    /**
     * 判断字符串的编码
     * 
     * @param str
     * @return
     */
    public static String getEncoding(String str)
    {
        String encode = "GB2312";
        try
        {
            if (str.equals(new String(str.getBytes(encode), encode)))
            {
                String s = encode;
                return s;
            }
        }
        catch (Exception exception)
        {
        }
        encode = "ISO-8859-1";
        try
        {
            if (str.equals(new String(str.getBytes(encode), encode)))
            {
                String s1 = encode;
                return s1;
            }
        }
        catch (Exception exception1)
        {
        }
        encode = "UTF-8";
        try
        {
            if (str.equals(new String(str.getBytes(encode), encode)))
            {
                String s2 = encode;
                return s2;
            }
        }
        catch (Exception exception2)
        {
        }
        encode = "GBK";
        try
        {
            if (str.equals(new String(str.getBytes(encode), encode)))
            {
                String s3 = encode;
                return s3;
            }
        }
        catch (Exception exception3)
        {
        }
        return "";
    }
    
    public static String toISO_8859_1(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, ISO_8859_1);
    }
    
    public static String toGB2312(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, GB2312);
    }
    
    public static String toUTF_8(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, UTF_8);
    }
    
    public static String toUTF_16BE(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, UTF_16BE);
    }
    
    public static String toUTF_16LE(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, UTF_16LE);
    }
    
    public static String toUTF_16(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, UTF_16);
    }
    
    public static String toGBK(String str)
        throws UnsupportedEncodingException
    {
        return changeCharset(str, GBK);
    }
    
    public static String changeCharset(String str, String newCharset)
        throws UnsupportedEncodingException
    {
        if (str != null)
        {
            // 用默认字符编码解码字符串。
            
            byte[] bs = str.getBytes();
            // 用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }
    
    public static String changeCharset(String str, String oldCharset, String newCharset)
        throws UnsupportedEncodingException
    {
        if (str != null)
        {
            // 用旧的字符编码解码字符串。解码可能会出现异常。
            byte[] bs = str.getBytes(oldCharset);
            // 用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }
}
