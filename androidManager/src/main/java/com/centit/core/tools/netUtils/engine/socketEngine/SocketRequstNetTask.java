package com.centit.core.tools.netUtils.engine.socketEngine;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import android.content.Context;

import com.centit.core.tools.netUtils.Constant_Net;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.utils.MIP_InputStreamUtils;

public class SocketRequstNetTask extends NetTask
{
    /**
     * <默认构造函数>
     */
    public SocketRequstNetTask(int requestType, Context context)
    {
        super(requestType, context);
        // TODO Auto-generated constructor stub
    }
    
    Socket              socket;
    
    SocketNetParamEntry socketNetParam;
    
    @Override
    public void setParam(Object param)
    {
        // TODO Auto-generated method stub
        if (param instanceof SocketNetParamEntry)
        {
            socketNetParam = (SocketNetParamEntry)param;
        }
        else
        {
            socketNetParam = new SocketNetParamEntry();
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
        if (socket != null && socket.isConnected())
        {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            if (socketNetParam.getStrParam() != null)
            {
                out.writeBytes(socketNetParam.getStrParam());
            }
            out.flush();
            out.close();
        }
        else
        {
            return false;
        }
        return true;
    }
    
    @Override
    public Object receive()
        throws Exception
    {
        // TODO Auto-generated method stub
        if (socket != null && socket.isConnected())
        {
            InputStream in = socket.getInputStream();
            
            String result = MIP_InputStreamUtils.InputStreamTOString(in);
            
            return result;
        }
        else
        {
            return null;
        }
    }
    
    @Override
    public void connect()
    {
        // TODO Auto-generated method stub
        if (socket == null)
        {
            socket = new Socket();
        }
        
        if (!socket.isConnected())
        {
            InetSocketAddress address = new InetSocketAddress(socketNetParam.getUrl(), socketNetParam.getPORT());
            try
            {
                socket.connect(address, Constant_Net.SOCKET_CONNECTION_TIMEOUT);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    @Override
    public void close()
    {
        // TODO Auto-generated method stub
        if (socket != null && socket.isConnected())
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public boolean isConnect()
    {
        if (socket != null)
        {
            return socket.isConnected();
        }
        else
        {
            return false;
        }
    }
}
