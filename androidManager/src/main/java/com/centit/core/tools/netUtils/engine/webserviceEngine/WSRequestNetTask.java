package com.centit.core.tools.netUtils.engine.webserviceEngine;

import android.content.Context;

import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;

/**
 * WebService 访问网络
 * 
 * @author ren_qiujing
 * 
 */
public class WSRequestNetTask extends NetTask
{
    /**
     * <默认构造函数>
     */
    public WSRequestNetTask(int requestType, Context context)
    {
        super(requestType, context);
        // TODO Auto-generated constructor stub
    }
    
    WSNetParamEntry wsparamEntry;
    
    @Override
    public void setParam(Object param)
    {
        // TODO Auto-generated method stub
        if (param instanceof WSNetParamEntry)
        {
            this.wsparamEntry = (WSNetParamEntry)param;
        }
        else
        {
            this.wsparamEntry = new WSNetParamEntry();
        }
    }
    
    @Override
    public void shutDownExecute()
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public Object send()
        throws Exception
    {
        // TODO Auto-generated method stub
        Object result = null;
        // try
        // {
        // result = post(wsparamEntry.getMethodname(), wsparamEntry.getMapParam(), wsparamEntry.getNAME_SPCAE());
        // }
        // catch (Exception e)
        // {
        // // TODO: handle exception
        // e.printStackTrace();
        // throw e;
        // }
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
    
    // /**
    // * 发送数据
    // *
    // * @param methodName WS中的方法名
    // * @param map 请求的map参数
    // * @param nameSpace 请求的命名空间
    // * @return
    // * @throws Exception
    // */
    // @SuppressWarnings("unchecked")
    // public SoapObject post(String methodName, Object map, String nameSpace)
    // throws Exception
    // {
    //
    // String soapAction = nameSpace + methodName;
    //
    // // 指定WebService的命名空间和调用的方法名
    // SoapObject rpc = new SoapObject(nameSpace, methodName);
    // // 设置需调用WebService接口需要传入的参数
    // if (map != null)
    // {
    // for (Entry<String, Object> entry : ((HashMap<String, Object>)map).entrySet())
    // {
    // System.out.print(entry.getKey() + " ");
    //
    // String key = (String)entry.getKey();
    // Object val = entry.getValue();
    //
    // rpc.addProperty(key, val);
    // }
    // }
    // // 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
    // SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    // envelope.bodyOut = rpc;
    // // 设置是否调用的是dotNet开发的WebService
    // envelope.dotNet = false;
    // // 设置连接超时时间
    // HttpTransportSE transport = new HttpTransportSE(wsparamEntry.getUrl(), Constant_Net.WS_CONNECTION_TIMEOUT);
    // try
    // {
    // // 调用WebService
    // transport.call(soapAction, envelope);
    // }
    // catch (IOException e)
    // {
    // e.printStackTrace();
    // throw e;
    // }
    // catch (XmlPullParserException e)
    // {
    // e.printStackTrace();
    // throw e;
    // }
    // // 获取返回的数据
    // SoapObject soapObject = (SoapObject)envelope.bodyIn;
    // return soapObject;
    // }
}
