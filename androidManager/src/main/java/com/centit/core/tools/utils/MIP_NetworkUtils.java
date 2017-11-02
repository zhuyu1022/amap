package com.centit.core.tools.utils;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;

/**
 * @author
 * 
 */
public class MIP_NetworkUtils
{
    
    /**
     * 判断网络连接状态
     * 
     * @param context
     * @return 如果当前网络是连通状态，返回true 否则 false.
     */
    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null && info.length != 0)
            {
                for (int i = 0; i < info.length; i++)
                {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * wifi是否打开
     */
    public static boolean isWifiConnect(Context context)
    {
        ConnectivityManager mgrConn = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mgrConn != null)
        {
            
            NetworkInfo mWifi = mgrConn.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            
            if (mWifi != null)
            {
                return mWifi.isConnected();
            }
        }
        return false;
    }
    
    /**
     * 判断当前是否非wifi网络连接
     * 
     * @param context
     * @return boolean
     */
    public static boolean notWifiConnect(Context context)
    {
        ConnectivityManager connectivityManager =
            (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                return true;
            }
        }
        
        return false;
    }
    
    // 是否处于漫游状态
    public static boolean haveInternet(Context context)
    {
        NetworkInfo info =
            (NetworkInfo)((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        
        if (info == null || !info.isConnected())
        {
            return false;
        }
        if (info.isRoaming())
        {
            // here is the roaming option you can change it if you want to
            // disable internet while roaming, just return false
            // 是否在漫游，可根据程序需求更改返回值
            return false;
        }
        return true;
    }
    
    /**
     * GPRS网络开关 反射ConnectivityManager中hide的方法setMobileDataEnabled 可以开启和关闭GPRS网络
     * 
     * @param isEnable
     * @throws Exception
     */
    public static void toggleGprs(Context context, boolean isEnable)
        throws Exception
    {
        ConnectivityManager connManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null)
        {
            Class<?> cmClass = connManager.getClass();
            Class<?>[] argClasses = new Class[1];
            argClasses[0] = boolean.class;
            
            // 反射ConnectivityManager中hide的方法setMobileDataEnabled，可以开启和关闭GPRS网络
            Method method = cmClass.getMethod("setMobileDataEnabled", argClasses);
            method.invoke(connManager, isEnable);
        }
    }
    
    /**
     * WIFI网络开关
     * 
     * @param enabled
     * @return 设置是否success
     */
    public static boolean toggleWiFi(Context context, boolean enabled)
    {
        ConnectivityManager connManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null)
        {
            WifiManager wm = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            
            if (wm != null)
            {
                return wm.setWifiEnabled(enabled);
            }
            
        }
        return false;
        
    }
    
    /**
     * 
     * @return 是否处于飞行模式
     */
    public static boolean isAirplaneModeOn(Context context)
    {
        boolean isEnabled = false;
        ConnectivityManager connManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null)
        {
            // 返回值是1时表示处于飞行模式
            int modeIdx = Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0);
            isEnabled = (modeIdx == 1);
        }
        return isEnabled;
    }
    
    /**
     * 飞行模式开关
     * 
     * @param setAirPlane
     */
    public static void toggleAirplaneMode(Context context, boolean setAirPlane)
    {
        ConnectivityManager connManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null)
        {
            Settings.System.putInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, setAirPlane ? 1 : 0);
            // 广播飞行模式信号的改变，让相应的程序可以处理。
            // 不发送广播时，在非飞行模式下，Android 2.2.1上测试关闭了Wifi,不关闭正常的通话网络(如GMS/GPRS等)。
            // 不发送广播时，在飞行模式下，Android 2.2.1上测试无法关闭飞行模式。
            Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            // intent.putExtra("Sponsor", "Sodino");
            // 2.3及以后，需设置此状态，否则会一直处于与运营商断连的情况
            intent.putExtra("state", setAirPlane);
            context.sendBroadcast(intent);
        }
    }
    
    // 获取本机Mac
    public static String getLocalMacAddress(Context context)
    {
        WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        
        String mac = "";
        if (wifi != null)
        {
            WifiInfo info = wifi.getConnectionInfo();
            if (info != null)
            {
                mac = info.getMacAddress();
            }
        }
        
        return mac == null ? "" : mac;
    }
    
    /**
     * 获取IP
     * 
     * @param context
     * @return
     */
    public static String getIpAddress(Context context)
    {
        if (isWifiConnect(context))
        {
            return getWIFIIpAddress(context);
        }
        else if (notWifiConnect(context))
        {
            return getGPRSIpAddress();
        }
        else
        {
            return "";
        }
    }
    
    /**
     * 获取WIFI连接的情况的IP
     * 
     * @return
     */
    private static String getWIFIIpAddress(Context context)
    {
        String ip = "";
        if (isWifiConnect(context))
        {
            WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            if (wifiManager != null)
            {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null)
                {
                    ip = intToIp(wifiInfo.getIpAddress());
                }
            }
        }
        return ip == null ? "" : ip;
    }
    
    // ip转换
    private static String intToIp(int i)
    {
        
        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + (i >> 24 & 0xFF);
    }
    
    /**
     * 获取GPRS连接的情况的IP
     * 
     * @return
     */
    private static String getGPRSIpAddress()
    {
        
        String ip = "";
        try
        {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)
            {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress() != null)
                    {
                        ip = inetAddress.getHostAddress().toString();
                    }
                }
            }
        }
        catch (SocketException ex)
        {
            Log.e("WifiPreference IpAddress", ex.toString());
        }
        return ip == null ? "" : ip;
    }
    
    /**
     * 获取连接的wifi的名称
     * 
     * @param context
     * @return
     */
    public static String getConnectWifiSsid(Context context)
    {
        if (isWifiConnect(context))
        {
            WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            if (wifiManager != null)
            {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null)
                {
                    return wifiInfo.getSSID();
                }
            }
        }
        
        return "";
    }
}
