package com.centit.core.tools.encryptManager;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Please describe
 * 
 * @author: shen_feng
 * @version 1.0
 * @createDate 2013-1-14
 */
public class AesUtil
{
    
    // static String sKey = "HOPERUN.COM";
    
    /**
     * 密钥如超过16位，截至16位，不足16位，补/000至16位
     * 
     * @param key 原密钥
     * @return 新密钥
     */
    public static String secureBytes(String key)
    {
        if (key.length() > 16)
        {
            key = key.substring(0, 16);
        }
        else if (key.length() < 16)
        {
            StringBuffer buf = new StringBuffer(key);
            for (int i = (key.length() - 1); i < 15; i++)
            {
                buf.append("\000");
            }
            key = buf.toString();
        }
        return key;
    }
    
    /**
     * AES解密
     * 
     * @param sSrc 加过密的字符串
     * @param key 密钥
     * @return 解密后的字符串
     * @throws Exception 异常
     * @EditHistory：modify by wangling 2013-09-26
     */
    public static String decrypt(String sSrc, String key)
    {
        try
        {
            // 判断Key是否正确
            if (key == null)
            {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16)
            {
                key = secureBytes(key);
            }
            byte[] raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = hex2byte(sSrc);
            try
            {
                if (null != encrypted1 && encrypted1.length > 0)
                {
                    byte[] original = cipher.doFinal(encrypted1);
                    String originalString = new String(original, "UTF-8");
                    return originalString;
                }
                else
                {
                    return "";
                }
            }
            catch (Exception e)
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
        
    }
    
    /**
     * @param sSrc sSrc
     * @return sSrc
     */
    public static String encrypt4Contacts(String sSrc)
    {
        return sSrc;
    }
    
    /**
     * AES加密
     * 
     * @param sSrc 加密前的字符串
     * @param sKey 密钥
     * @return 加密后的字符串
     * @throws Exception 异常
     * @EditHistory：modify by wangling 2013-09-26
     */
    public static String encrypt(String sSrc, String key)
    {   
        try
        {
            if (key == null)
            {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16)
            {
                key = secureBytes(key);
            }
            byte[] raw = key.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());
            return byte2hex(encrypted).toLowerCase();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * @param strhex strhex
     * @return byte
     */
    public static byte[] hex2byte(String strhex)
    {
        if (strhex == null)
        {
            return null;
        }
        int l = strhex.length();
        if (l % 2 != 0)
        {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++)
        {
            b[i] = (byte)Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }
    
    /**
     * @param b b
     * @return String
     */
    public static String byte2hex(byte[] b)
    {
        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++)
        {
            stmp = java.lang.Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
            {
                hs.append("0" + stmp);
            }
            else
            {
                hs.append(stmp);
            }
        }
        String s = hs.toString().toUpperCase();
        return s;
    }
}
