package com.centit.app.cmipmodule.tzgg.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * @Description<功能详细描述>
 * 
 * @author  rqj 
 * @Version  [版本号, 2015-9-15]
 */
/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-15]
 */
public class DemoDataResponse implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * VPN信息
     */
    private static String     vpnInfo;
    
    /**
     * IP信息
     */
    private static String     serverInfo;
    
    /**
     * 获取 vpnInfo
     * 
     * @return 返回 vpnInfo
     * @author rqj
     */
    public static String getVpnInfo()
    {
        return vpnInfo;
    }
    
    /**
     * 设置 vpnInfo
     * 
     * @param vpnInfo 对vpnInfo进行赋值
     * @author rqj
     */
    public static void setVpnInfo(String vpnInfo)
    {
        DemoDataResponse.vpnInfo = vpnInfo;
    }
    
    /**
     * 获取 serverInfo
     * 
     * @return 返回 serverInfo
     * @author rqj
     */
    public static String getServerInfo()
    {
        return serverInfo;
    }
    
    /**
     * 设置 serverInfo
     * 
     * @param serverInfo 对serverInfo进行赋值
     * @author rqj
     */
    public static void setServerInfo(String serverInfo)
    {
        DemoDataResponse.serverInfo = serverInfo;
    }
}
