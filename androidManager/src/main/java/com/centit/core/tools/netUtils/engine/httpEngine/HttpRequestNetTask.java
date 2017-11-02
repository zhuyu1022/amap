package com.centit.core.tools.netUtils.engine.httpEngine;

import android.content.Context;
import android.os.Build;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.utils.MIP_NetworkUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ren_qiujing
 * 
 */
public class HttpRequestNetTask extends NetTask
{
    
    private HttpPost          httpPost       = null;
    
    private HttpGet           httpGet        = null;
    
    private HttpURLConnection urlConn        = null;
    
    private HttpNetParamEntry httpparamEntry = new HttpNetParamEntry();
    
    /**
     * <默认构造函数>
     */
    public HttpRequestNetTask(int requestType, Context Context)
    {
        super(requestType, Context);
        // TODO Auto-generated constructor stub
        this.mSTATUS = NetTask.UNTREATED;
    }
    
    @Override
    public void setParam(Object param)
    {
        // TODO Auto-generated method stub
        if (param instanceof NetParamEntity)
        {
            this.httpparamEntry = (HttpNetParamEntry)param;
        }
        else
        {
            this.httpparamEntry = new HttpNetParamEntry();
        }
        
    }
    
    /**
     * 重载方法
     * 
     * @author ma_zhicheng
     */
    @Override
    public void shutDownExecute()
    {
        // TODO Auto-generated method stub
        setCancelThread();
        if (httpPost != null)
        {
            httpPost.abort();
        }
        
        if (urlConn != null)
        {
            urlConn.disconnect();
        }
        
        if (httpGet != null)
        {
            httpGet.abort();
        }
        super.shutDownExecute();
    }
    
    @Override
    public Object send()
        throws Exception
    {
        // TODO Auto-generated method stub
        Object result = null;
        boolean hasNet = MIP_NetworkUtils.isNetworkAvailable(mContext);
        LogUtil.v("hasNet=" + hasNet);
        if (hasNet == true)
        {
            switch (httpparamEntry.getSendType())
            {
                case Normal:
                case Downloadfiles:
                    try
                    {
                        result = doPostFile();
                    }
                    catch (MIPException e)
                    {
                        // TODO: handle exception
                        throw e;
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                        e.printStackTrace();
                        throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
                    }
                    break;
                case Uploadfiles:
                    try
                    {
                        result = doPostFile();
                    }
                    catch (MIPException e)
                    {
                        // TODO: handle exception
                        LogUtil.save("msg=" + e.getMessage());
                        throw e;
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                        e.printStackTrace();
                        throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
                    }
                    break;
                case DownloadfilesWithUrl:
                    try
                    {
                        result = doGetFileWithUrl();
                    }
                    catch (MIPException e)
                    {
                        // TODO: handle exception
                        LogUtil.save("msg=" + e.getMessage());
                        throw e;
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                        e.printStackTrace();
                        throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
                    }
                    break;
                default:
                    break;
            }
        }
        else
        {
            int id = Constant_Net.NO_NET;
            String msg = "没有网络";
            MIPException exception = new MIPException(id, msg);
            throw exception;
        }
        
        return result;
    }
    
    /**
     * 发送普通数据
     * 
     * @return 将返回inputStream流 转成byte[]之后为下步处理
     * @throws Exception
     */
    public Object doPost()
        throws Exception
    {
        Object result = null;
        
        if (httpPost != null)
        {
            httpPost = null;
        }
        
        httpPost = new HttpPost(httpparamEntry.getUrl());

        
        List<NameValuePair> paramPairs = null;
        String paramStr = "";
        
        if (httpparamEntry.getMapParam() != null)
        {
            paramPairs = new ArrayList<NameValuePair>();
            
            for (Map.Entry<String, String> entry : httpparamEntry.getMapParam().entrySet())
            {
                paramPairs.add(new BasicNameValuePair(entry.getKey(), new String(entry.getValue().getBytes(), "UTF-8")));
            }
        }
        
        if (httpparamEntry.getStrParam() != null && !"".equals(httpparamEntry.getStrParam()))
        {
            paramStr = (String)httpparamEntry.getStrParam();
        }
        
        // 绑定到请求 Entity,key/value类型的参数
        if (paramPairs != null && paramPairs.size() > 0)
        {
            httpPost.setEntity(new UrlEncodedFormEntity(paramPairs, httpparamEntry.getEncoding()));
        }
        
        // http请求的实体信息
        if (paramStr != null && !"".equals(paramStr))
        {
            String value = new String(paramStr.getBytes("UTF-8"), "ISO-8859-1");
            // LogUtil.v("mzc", "httppost value = " + value);
            httpPost.setEntity(new StringEntity(value));
        }
        
        // HttpClient httpClient = new DefaultHttpClient();
        HttpClient httpClient = HttpConnectFactory.getHttpClient();
        HttpResponse httpResponse = null;
        try
        {
            // 发送请求
            httpResponse = httpClient.execute(httpPost);
            
            if (httpResponse != null)
            {
                int code = httpResponse.getStatusLine().getStatusCode();
                LogUtil.v("code = " + code);
                if (code == HttpStatus.SC_OK)
                {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    
                    if (httpEntity != null)
                    {
                        InputStream inputStream = httpEntity.getContent();
                        if (mDownloadEntityHandler != null)
                        {
                            if (onProcessEntityHandler != null)
                            {
                                onProcessEntityHandler.setmContentLength(httpEntity.getContentLength());
                            }
                            result = mDownloadEntityHandler.downloadHandler(inputStream, onProcessEntityHandler);
                        }
                        inputStream.close();
                    }
                }
                retCode = code;
            }
        }
        catch (ConnectTimeoutException e)
        {
            e.printStackTrace();
            throw new MIPException(Constant_Net.TIME_OUT_ERROR, e.toString());
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
            throw new MIPException(ExceptionConst.UNKNOWNHOSTEXCEPTION, e.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new MIPException(ExceptionConst.IOEXCEPTION, e.toString());
        }
        catch (MIPException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
    /**
     * 发送文件方法
     * 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public Object doPostFile()
        throws Exception
    {
        Object result = null;
        // 获得的数据String resultData = "";
        URL ur = null;
        
        DataOutputStream outDown = null;
        try
        {
            // 构造一个URL对象
            ur = new URL(httpparamEntry.getUrl());
        }
        catch (MalformedURLException e)
        {
            LogUtil.e("MalformedURLException");
            e.printStackTrace();
            throw new MIPException(ExceptionConst.MALFORMEDURLEXCEPTION, e.toString());
        }
        
        try
        {
            if (ur != null)
            {
                // 使用HttpURLConnection打开连接
                urlConn = (HttpURLConnection)ur.openConnection();
                // 设置以POST方式
                urlConn.setRequestMethod("POST");
                // 默认为post请求,设立需要设置为true
                urlConn.setDoOutput(true);
                urlConn.setDoInput(true);
                
                // Post 请求不能使用缓存
                urlConn.setUseCaches(false);
                
                urlConn.setConnectTimeout(Constant_Net.HTTP_CONNECTION_TIMEOUT);
                urlConn.setReadTimeout(Constant_Net.HTTP_SO_TIMEOUT);
                urlConn.setInstanceFollowRedirects(true);
                // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
                urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConn.setRequestProperty("Content-Type", "application/json");

                // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
                // 要注意的是connection.getOutputStream会隐含的进行connect
                
                // 如果是NOTE II 不设置该属性，否则会导致点击发送时失败，暂时这么处理，后期研究
                if (Build.MODEL != null
                    && (Build.MODEL.equalsIgnoreCase("GT-N7100") || Build.MODEL.equalsIgnoreCase("GT-N7108")
                        || Build.MODEL.equalsIgnoreCase("GT-N7102") || Build.MODEL.equalsIgnoreCase("GT-N719")))
                {
                    LogUtil.i("NO progress");
                }
                // else
                // {
                // 不使用缓存，直接上传到服务器，不知道文件长度,上传进度条使用
                // urlConn.setChunkedStreamingMode(1 * 1024);
                // }
                
                if (httpparamEntry.getMapParam() != null)
                {
                    for (Map.Entry<String, String> entry : httpparamEntry.getMapParam().entrySet())
                    {
                        urlConn.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    
                }
                urlConn.connect();
                
                if (mUploadHandlerEntity != null)
                {
                    try
                    {
                        mUploadHandlerEntity.uploadHandler(urlConn.getOutputStream(), onProcessEntityHandler);
                    }
                    catch (MIPException e)
                    {
                        // TODO: handle exception
                        throw e;
                    }
                }
                else
                {
                    outDown = new DataOutputStream(urlConn.getOutputStream());
                    
                    // 要上传的参数
                    String content = httpparamEntry.getStrParam();
                    
                    if (content != null)
                    {// 将要上传的内容写入流中
                        outDown.writeBytes(content);
                    }
                }
                int code = urlConn.getResponseCode();
                if (code == HttpStatus.SC_OK)
                {
                    InputStream inputStream = urlConn.getInputStream();
                    if (mDownloadEntityHandler != null)
                    {
                        if (onProcessEntityHandler != null)
                        {
                            onProcessEntityHandler.setmContentLength(urlConn.getContentLength());
                        }
                        result = mDownloadEntityHandler.downloadHandler(inputStream, onProcessEntityHandler);
                    }
                    else
                    {
                        
                        StringBuffer ss = new StringBuffer();
                        byte[] b = new byte[4096];
                        for (int n; (n = inputStream.read(b)) != -1;)
                        {
                            ss.append(new String(b, 0, n));
                        }
                        result = ss.toString();
                    }
                    
                    inputStream.close();
                }
                retCode = code;
            }
        }
        catch (MIPException e)
        {
            // TODO: handle exception
            throw e;
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
        }
        finally
        {
            if (outDown != null)
            {
                outDown.close();
            }
        }
        
        return result;
    }
    
    /**
     * @return
     * @throws Exception
     */
    public Object doGetFileWithUrl()
        throws Exception
    {
        Object result = null;
        
        if (httpGet != null)
        {
            httpGet = null;
        }
        
        httpGet = new HttpGet(httpparamEntry.getUrl());
        
        HttpClient httpClient = HttpConnectFactory.getHttpClient();
        HttpResponse httpResponse = null;
        try
        {
            // 发送请求
            httpResponse = httpClient.execute(httpGet);
            
            if (httpResponse != null)
            {
                int code = httpResponse.getStatusLine().getStatusCode();
                if (code == HttpStatus.SC_OK)
                {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    
                    if (httpEntity != null)
                    {
                        InputStream inputStream = httpEntity.getContent();
                        // LogUtil.v("mzc", "inputStream = " + inputStream);
                        if (mDownloadEntityHandler != null)
                        {
                            if (onProcessEntityHandler != null)
                            {
                                onProcessEntityHandler.setmContentLength(httpEntity.getContentLength());
                            }
                            result = mDownloadEntityHandler.downloadHandler(inputStream, onProcessEntityHandler);
                        }
                        inputStream.close();
                    }
                }
                retCode = code;
            }
        }
        catch (ConnectTimeoutException e)
        {
            e.printStackTrace();
            throw new MIPException(Constant_Net.TIME_OUT_ERROR, e.toString());
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
            throw new MIPException(ExceptionConst.UNKNOWNHOSTEXCEPTION, e.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new MIPException(ExceptionConst.IOEXCEPTION, e.toString());
        }
        catch (MIPException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
    @Override
    public Object receive()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void connect()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void close()
    {
        // TODO Auto-generated method stub
    }
    
    public static class UniqueHttpClient
    {
        public ThreadLocal<DefaultHttpClient> uniqueLocal = new ThreadLocal<DefaultHttpClient>()
                                                          {
                                                              @Override
                                                              public DefaultHttpClient initialValue()
                                                              {
                                                                  
                                                                  BasicHttpParams httpParameters =
                                                                      new BasicHttpParams();
                                                                  HttpConnectionParams.setConnectionTimeout(httpParameters,
                                                                      Constant_Net.HTTP_CONNECTION_TIMEOUT);
                                                                  HttpConnectionParams.setSoTimeout(httpParameters,
                                                                      Constant_Net.HTTP_SO_TIMEOUT);
                                                                  
                                                                  ConnManagerParams.setTimeout(httpParameters,
                                                                      Constant_Net.HTTP_TIMEOUT);
                                                                  
                                                                  DefaultHttpClient client;
                                                                  
                                                                  SchemeRegistry registry = new SchemeRegistry();
                                                                  registry.register(new Scheme(
                                                                      Constant_Net.HTTP_SCHEME_HTTP_NAME,
                                                                      PlainSocketFactory.getSocketFactory(),
                                                                      Constant_Net.HTTP_SCHEME_HTTP_PORT));
                                                                  
                                                                  registry.register(new Scheme(
                                                                      Constant_Net.HTTP_SCHEME_HTTPS_NAME,
                                                                      SSLSocketFactory.getSocketFactory(),
                                                                      Constant_Net.HTTP_SCHEME_HTTPS_PORT));
                                                                  
                                                                  ClientConnectionManager conMgr =
                                                                      new ThreadSafeClientConnManager(httpParameters,
                                                                          registry);
                                                                  
                                                                  client =
                                                                      new DefaultHttpClient(conMgr, httpParameters);
                                                                  return client;
                                                              }
                                                          };
    }
}
