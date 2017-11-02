/*
 * File name:  HttpConnectFactory.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ma_zhicheng
 * Last modified date:  13 Sep,2013
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.engine.httpEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerPNames;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ma_zhicheng
 * @Version [版本号, 13 Sep,2013]
 */
public class HttpConnectFactory
{
    private static final String            TAG                   = "HttpConnectFactory";
    
    private static final int               CONNECT_TIMEOUT       = 30000;
    
    private static final int               SO_TIME_OUT           = 40000;
    
    private static final int               TIME_OUT              = 10000;
    
    private static final int               MAX_TOTAL_CONNECTIONS = 10;
    
    private static HttpParams              HTTP_PARAMS           = null;
    
    private static SchemeRegistry          SCHEME_REGISTRY       = new SchemeRegistry();
    
    private static ClientConnectionManager CONNECTION_MANAGER    = null;
    
    static
    {
        HTTP_PARAMS = new BasicHttpParams();
        
        HTTP_PARAMS.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, MAX_TOTAL_CONNECTIONS);
        HttpProtocolParams.setVersion(HTTP_PARAMS, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(HTTP_PARAMS, HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(HTTP_PARAMS, true);
        
        /* 从连接池中取连接的超时时�? */
        ConnManagerParams.setTimeout(HTTP_PARAMS, TIME_OUT);
        
        // 设置最大连接数
        ConnManagerParams.setMaxTotalConnections(HTTP_PARAMS, 600);
        
        // 设置每个路由最大连接数
        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(300);
        ConnManagerParams.setMaxConnectionsPerRoute(HTTP_PARAMS, connPerRoute);
        
        /* 连接超时 */
        HttpConnectionParams.setConnectionTimeout(HTTP_PARAMS, CONNECT_TIMEOUT);
        /* 请求超时 */
        HttpConnectionParams.setSoTimeout(HTTP_PARAMS, SO_TIME_OUT);
        
        SCHEME_REGISTRY.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));// 关键代码--事关线程安全�?
        
        CONNECTION_MANAGER = new ThreadSafeClientConnManager(HTTP_PARAMS, SCHEME_REGISTRY);
    }
    
    private HttpConnectFactory()
    {
        
    }
    
    /**
     * 获得HttpClient
     * 
     * @return
     */
    public static HttpClient getHttpClient()
    {
        HttpClient client = new DefaultHttpClient(CONNECTION_MANAGER, HTTP_PARAMS);
        // HttpClient client = new DefaultHttpClient();
        return client;
    }
    
    private static final class MySSLSocketFactory extends SSLSocketFactory
    {
        private static final String KEY_STORE_TYPE_BKS       = "BKS";
        
        private static final String KEY_STORE_TYPE_P12       = "PKCS12";
        
        private static final String KEY_STORE_PASSWORD       = "";
        
        private static final String KEY_STORE_TRUST_PASSWORD = "";
        
        private static final String KEY_STORE_PATH           = "";
        
        private static final String KEY_STORE_TRUST_PATH     = "";
        
        private static KeyStore     keyStore                 = null;
        
        private static KeyStore     trustStore               = null;
        
        static
        {
            
            InputStream ksIn = null;
            InputStream tsIn = null;
            try
            {
                keyStore = KeyStore.getInstance(KEY_STORE_TYPE_P12);
                ksIn = new FileInputStream(KEY_STORE_PATH);
                keyStore.load(ksIn, KEY_STORE_PASSWORD.toCharArray());
                trustStore = KeyStore.getInstance(KEY_STORE_TYPE_BKS);
                tsIn = new FileInputStream(KEY_STORE_TRUST_PATH);
                trustStore.load(tsIn, KEY_STORE_TRUST_PASSWORD.toCharArray());
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
            catch (CertificateException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (KeyStoreException e)
            {
                e.printStackTrace();
            }
            
        }
        
        /**
         * 知道证书库路径，创建
         * 
         * @throws KeyManagementException
         * @throws UnrecoverableKeyException
         * @throws NoSuchAlgorithmException
         * @throws KeyStoreException
         */
        public MySSLSocketFactory()
            throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException
        {
            super(keyStore, KEY_STORE_PASSWORD, trustStore);
        }
        
    }
    
}
