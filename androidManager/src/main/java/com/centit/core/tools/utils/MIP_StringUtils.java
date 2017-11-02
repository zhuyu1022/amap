package com.centit.core.tools.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串帮助类
 * 
 * @author gdpancheng@gmail.com 2013-10-22 下午1:09:14
 */
public class MIP_StringUtils
{
    public static final int    TYPE_NUMBER  = 0;
    
    public static final int    TYPE_ENGLISH = 1;
    
    public static final int    TYPE_FUHAO   = 2;
    
    public static final int    TYPE_CHINA   = 3;
    
    public static final String US_ASCII     = "US-ASCII";
    
    public static final String ISO_8859_1   = "ISO-8859-1";
    
    public static final String UTF_8        = "UTF-8";
    
    public static final String UTF_16BE     = "UTF-16BE";
    
    public static final String UTF_16LE     = "UTF-16LE";
    
    public static final String UTF_16       = "UTF-16";
    
    public static final String GBK          = "GBK";
    
    public static final String GB2312       = "gb2312";
    
    public static final String EMPTY        = "";
    
    // --------------------------------------------------------------------------------------------
    // 对于字符串 添加0或者空格的处理
    public static String addPrefix(int num, String prefix)
    {
        return num < 10 ? prefix + num : String.valueOf(num);
    }
    
    public static String addPrefix(String numStr, String prefix)
    {
        int num = Integer.parseInt(numStr);
        return addPrefix(num, prefix);
    }
    
    public static String addPrefixZero(int num)
    {
        return addPrefix(num, "0");
    }
    
    public static String addPrefixZero(String numStr)
    {
        return addPrefix(numStr, "0");
    }
    
    public static String addPrefixHtmlSpace(int num)
    {
        return addPrefix(num, "&nbsp;");
    }
    
    public static String addPrefixHtmlSpace(String numStr)
    {
        return addPrefix(numStr, "&nbsp;");
    }
    
    /**
     * 数组拼接成字符串 中间以逗号连接
     * 
     * @author gdpancheng@gmail.com 2014-2-21 下午5:14:52
     * @param data 需要连接的数据
     * @param symbol 连接符
     * @return String
     */
    public static String commaInt(Object[] data, String symbol)
    {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < data.length; i++)
        {
            sbf.append(data[i]);
            if (i < data.length - 1)
            {
                sbf.append(symbol);
            }
        }
        return sbf.toString();
    }
    
    /**
     * 数组拼接成字符串 以逗号隔开
     * 
     * @author gdpancheng@gmail.com 2014-2-21 下午5:15:20
     * @param data
     * @return String
     */
    public static String commaInt(Object[] data)
    {
        return commaInt(data, ",");
    }
    
    // --------------------------------------------------------------------------------------------
    /**
     * 判断是否为空
     * 
     * @author gdpancheng@gmail.com 2013-10-15 下午10:24:22
     * @param text
     * @return boolean
     */
    public static boolean isNull(String text)
    {
        if (text == null || text.length() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * bytes[]转换成Hex字符串,可用于URL转换，IP地址转换.
     * */
    public static String bytesToHexString(byte[] bytes)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++)
        {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1)
            {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
    
    public static String prettyBytes(long value)
    {
        String args[] = {"B", "KB", "MB", "GB", "TB"};
        StringBuilder sb = new StringBuilder();
        int i;
        if (value < 1024L)
        {
            sb.append(String.valueOf(value));
            i = 0;
        }
        else if (value < 1048576L)
        {
            sb.append(String.format("%.1f", value / 1024.0));
            i = 1;
        }
        else if (value < 1073741824L)
        {
            sb.append(String.format("%.2f", value / 1048576.0));
            i = 2;
        }
        else if (value < 1099511627776L)
        {
            sb.append(String.format("%.3f", value / 1073741824.0));
            i = 3;
        }
        else
        {
            sb.append(String.format("%.4f", value / 1099511627776.0));
            i = 4;
        }
        sb.append(' ');
        sb.append(args[i]);
        return sb.toString();
    }
    
    // --------------------------------------------------------------------------------------------
    /**
     * 字符串重复多少遍
     * 
     * @author gdpancheng@gmail.com 2013-10-16 下午10:43:14
     * @param str
     * @param times
     * @return String
     */
    public static String repeat(String str, int times)
    {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < times; i++)
        {
            sbf.append(str);
        }
        return sbf.toString();
    }
    
    //如果str为null，则返回“”
    public static String getValue(String str)
    {
    	if(str == null)
    	{
    		return "";
    	}
    	
    	return str.trim();
    }
    
    /**
     * 获得数组中最长的字符串的长度
     * 
     * @author gdpancheng@gmail.com 2013-10-16 下午10:43:02
     * @param keys
     * @return int
     */
    public static int getLargestLengthInArray(String[] keys)
    {
        int length = 0;
        for (int i = 0; i < keys.length; i++)
        {
            String key = keys[i];
            if (key.length() > length)
            {
                length = key.length();
            }
        }
        return length;
    }
    
    /**
     * 替换string中的指定字符串
     * 
     * @author gdpancheng@gmail.com 2013-10-16 下午10:42:22
     * @param strSearch
     * @param replacement
     * @param body
     * @return String
     */
    public static String replaceAllByStringBuffer(String strSearch, String replacement, String body)
    {
        StringBuffer sbf = new StringBuffer(body);
        int index = 0;
        int offset = 0;
        do
        {
            index = sbf.indexOf(strSearch, offset);
            if (index > -1)
            {
                sbf.replace(index, index + strSearch.length(), replacement);
                /**
                 * 下一次开始的点是index加上置换后的字符串的长度
                 */
                offset = index + replacement.length();
            }
        }
        while (index > -1);
        
        return sbf.toString();
    }
    
    /**
     * 判断 char c 是汉字还是数字 还是字母
     * 
     * @author gdpancheng@gmail.com 2013-10-16 下午10:41:15
     * @param c
     * @return int
     */
    public static int sepMarkNot(char c)
    {
        // 数字 48-57
        if (c > 47 && c < 58)
        {
            return TYPE_NUMBER;
        }
        // 大写字母 65-90
        if (c > 64 && c < 91)
        {
            return TYPE_ENGLISH;
        }
        // 小写字母 97-122
        if (c > 96 && c < 122)
        {
            return TYPE_ENGLISH;
        }
        // 汉字（简体）
        if (c >= 0x4e00 && c <= 0x9fbb)
        {
            return TYPE_CHINA;
        }
        return TYPE_FUHAO;
    }
    
    /**
     * 判断字节数 汉字2个字节英文1个字节
     * 
     * @author gdpancheng@gmail.com 2013-10-16 下午10:43:53
     * @param content
     * @return int
     */
    public static int getLengths(String content)
    {
        int count = 0;
        for (int i = 0; i < content.length(); i++)
        {
            if (sepMarkNot(content.charAt(i)) == TYPE_CHINA)
            {
                count = count + 2;
            }
            else
            {
                count = count + 1;
            }
        }
        return count;
    }
    
    /**
     * 为空或者长度为0(trim())
     * 
     * <pre>
     * isBlank(null) = true;
     * isBlank(&quot;&quot;) = true;
     * isBlank(&quot;  &quot;) = true;
     * isBlank(&quot;a&quot;) = false;
     * isBlank(&quot;a &quot;) = false;
     * isBlank(&quot; a&quot;) = false;
     * isBlank(&quot;a b&quot;) = false;
     * </pre>
     * 
     * @param str
     * @return if string is null or its size is 0 or it is made by space, return true, else return false.
     */
    public static boolean isBlank(String str)
    {
        return (str == null || str.trim().length() == 0);
    }
    
    /**
     * 为空或者长度为0
     * 
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     * 
     * @author gdpancheng@gmail.com 2013-10-16 下午10:48:02
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str)
    {
        return (str == null || str.length() == 0);
    }
    
    /**
     * null string 转为 ""或者string
     * 
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     * 
     * @param str
     * @return
     */
    public static String nullStrToEmpty(String str)
    {
        return (str == null ? "" : str);
    }
    
    /**
     * 首字母大写
     * 
     * <pre>
     * capitalizeFirstLetter(null)     =   null;
     * capitalizeFirstLetter("")       =   "";
     * capitalizeFirstLetter("2ab")    =   "2ab"
     * capitalizeFirstLetter("a")      =   "A"
     * capitalizeFirstLetter("ab")     =   "Ab"
     * capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     * 
     * @param str
     * @return
     */
    public static String capitalizeFirstLetter(String str)
    {
        if (isEmpty(str))
        {
            return str;
        }
        
        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
            : new StringBuilder(str.length()).append(Character.toUpperCase(c)).append(str.substring(1)).toString();
    }
    
    /**
     * encoded(utf-8)转码
     * 
     * <pre>
     * utf8Encode(null)        =   null
     * utf8Encode("")          =   "";
     * utf8Encode("aa")        =   "aa";
     * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
     * </pre>
     * 
     * @param str
     * @return
     * @throws UnsupportedEncodingException if an error occurs
     */
    public static String utf8Encode(String str)
    {
        if (!isEmpty(str) && str.getBytes().length != str.length())
        {
            try
            {
                return URLEncoder.encode(str, "UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }
    
    /**
     * 如果失败 则返回默认值defultReturn
     * 
     * @param str
     * @param defultReturn
     * @return
     */
    public static String utf8Encode(String str, String defultReturn)
    {
        if (!isEmpty(str) && str.getBytes().length != str.length())
        {
            try
            {
                return URLEncoder.encode(str, "UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
                return defultReturn;
            }
        }
        return str;
    }
    
    /**
     * html格式化字符串
     * 
     * <pre>
     * getHrefInnerHtml(null)                                  = ""
     * getHrefInnerHtml("")                                    = ""
     * getHrefInnerHtml("mp3")                                 = "mp3";
     * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
     * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
     * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
     * </pre>
     * 
     * @param href
     * @return <ul>
     *         <li>if href is null, return ""</li>
     *         <li>if not match regx, return source</li>
     *         <li>return the last string that match regx</li>
     *         </ul>
     */
    public static String getHrefInnerHtml(String href)
    {
        if (isEmpty(href))
        {
            return "";
        }
        
        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg, Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches())
        {
            return hrefMatcher.group(1);
        }
        return href;
    }
    
/**
     * 处理html中的特殊字符
     * 
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     * 
     * @param source
     * @return
     */
    public static String htmlEscapeCharsToString(String source)
    {
        return isEmpty(source) ? source : source.replaceAll("&lt;", "<")
            .replaceAll("&gt;", ">")
            .replaceAll("&amp;", "&")
            .replaceAll("&quot;", "\"");
    }
    
    /**
     * 转换半角到全角
     * 
     * <pre>
     * fullWidthToHalfWidth(null) = null;
     * fullWidthToHalfWidth("") = "";
     * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
     * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
     * </pre>
     * 
     * @param s
     * @return
     */
    public static String fullWidthToHalfWidth(String s)
    {
        if (isEmpty(s))
        {
            return s;
        }
        
        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++)
        {
            if (source[i] == 12288)
            {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            }
            else if (source[i] >= 65281 && source[i] <= 65374)
            {
                source[i] = (char)(source[i] - 65248);
            }
            else
            {
                source[i] = source[i];
            }
        }
        return new String(source);
    }
    
    /**
     * 转换全角到半角
     * 
     * <pre>
     * halfWidthToFullWidth(null) = null;
     * halfWidthToFullWidth("") = "";
     * halfWidthToFullWidth(" ") = new String(new char[] {12288});
     * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
     * </pre>
     * 
     * @param s
     * @return
     */
    public static String halfWidthToFullWidth(String s)
    {
        if (isEmpty(s))
        {
            return s;
        }
        
        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++)
        {
            if (source[i] == ' ')
            {
                source[i] = (char)12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            }
            else if (source[i] >= 33 && source[i] <= 126)
            {
                source[i] = (char)(source[i] + 65248);
            }
            else
            {
                source[i] = source[i];
            }
        }
        return new String(source);
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
