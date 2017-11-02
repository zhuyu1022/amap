package com.centit.core.tools.encryptManager;

/**
 * MD5工具类 <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author sun_yao
 * @Version [版本号, 2013-9-4]
 */
public class MD5
{
    /**
     * 
     * 获取md5
     * 
     * @Description 获取md5
     * 
     * @param source 源字符串
     * @return MD5加密字符串
     * @LastModifiedDate：2013-10-25
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static String getMD5(String source)
    {
        if (source != null)
        {
            return getMD5(source.getBytes());
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 
     * 获取md5
     * 
     * @Description 获取md5
     * 
     * @param source 源byte数组
     * @return MD5加密字符串
     * @LastModifiedDate：2013-10-25
     * @author wang_ling
     * @EditHistory：<修改内容><修改人>
     */
    public static String getMD5(byte[] source)
    {
        String s = null;
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final int temp = 0xf;
        final int arraySize = 32;
        final int strLen = 16;
        final int offset = 4;
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte[] tmp = md.digest();
            char[] str = new char[arraySize];
            int k = 0;
            for (int i = 0; i < strLen; i++)
            {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> offset & temp];
                str[k++] = hexDigits[byte0 & temp];
            }
            s = new String(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
}
