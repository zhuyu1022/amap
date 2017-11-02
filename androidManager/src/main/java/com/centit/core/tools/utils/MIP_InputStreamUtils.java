package com.centit.core.tools.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author
 * @mail
 * 
 */
public class MIP_InputStreamUtils
{
    
    final static int BUFFER_SIZE = 4096;
    
    /**
     * 将InputStream转换成String
     * 
     * @param in InputStream
     * @return String
     * @throws Exception
     * 
     */
    public static String InputStreamTOString(InputStream in)
        throws Exception
    {
        
        // ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // byte[] data = new byte[BUFFER_SIZE];
        // int count = -1;
        // while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
        // outStream.write(data, 0, count);
        
        // return new String(outStream.toByteArray(), "ISO-8859-1");
        
        StringBuffer ss = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;)
        {
            ss.append(new String(b, 0, n));
        }
        
        return ss.toString();
        
    }
    
    /**
     * 将InputStream转换成某种字符编码的String
     * 
     * @param in
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String InputStreamTOString(InputStream in, String encoding)
        throws Exception
    {
        
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
            outStream.write(data, 0, count);
        
        String ret = new String(outStream.toByteArray(), encoding);
        
        return ret;
    }
    
    /**
     * 将InputStream转换成某种字符编码的String
     * 
     * @param in
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String InputStreamTOStringWithoutEncode(InputStream in)
        throws Exception
    {
        
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
            outStream.write(data, 0, count);
        
        String ret = new String(outStream.toByteArray());
        
        return ret;
    }
    
    /**
     * 将String转换成InputStream
     * 
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream StringTOInputStream(String in)
        throws Exception
    {
        
        ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("ISO-8859-1"));
        return is;
    }
    
    /**
     * 将InputStream转换成byte数组
     * 
     * @param in InputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] InputStreamTOByte(InputStream in)
        throws IOException
    {
        
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
            outStream.write(data, 0, count);
        
        return outStream.toByteArray();
    }
    
    /**
     * 将byte数组转换成InputStream
     * 
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream byteTOInputStream(byte[] in)
        throws Exception
    {
        
        ByteArrayInputStream is = new ByteArrayInputStream(in);
        return is;
    }
    
    /**
     * 将byte数组转换成String
     * 
     * @param in
     * @return
     * @throws Exception
     */
    public static String byteTOString(byte[] in)
        throws Exception
    {
        
        InputStream is = byteTOInputStream(in);
        return InputStreamTOString(is);
    }
    
}
