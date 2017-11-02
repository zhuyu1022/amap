package com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst;

import android.os.Handler;

import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.core.tools.encryptManager.AesUtil;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.NetTaskQueueManager;
import com.centit.core.tools.netUtils.baseEngine.NetInterface.OnFinishListen;
import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.DownloadEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.ProcessEntityHandle;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.UploadEntityHandle;
import com.centit.core.tools.netUtils.engine.httpEngine.HttpNetParamEntry;
import com.centit.core.tools.utils.MIP_Constant_Core;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Atom框架工具
 * 
 * @author ma zhicheng
 * 
 */
public abstract class AbstractWrapRequest
{
    
    protected int                     mRequestType;
    
    protected String                  mBaseURL;
    
    protected Handler                 mHandler;
    
    protected HashMap<String, Object> mRequstObject;
    
    protected NetParamEntity          param;
    
    protected OnFinishListen          mOnFinishListen;
    
    protected ProcessEntityHandle     mProcessEntityHandler;
    
    protected DownloadEntityHandle    mDownloadEntityHandler;
    
    protected UploadEntityHandle      mUpLoadFileHandlerEntity;
    
    protected JSONObject              mHeaderJSONOBJ;
    
    public AbstractWrapRequest(int type)
    {
        this.mRequestType = type;
    }
    
    /**
     * 
     * 设置请求参数
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：17 Sep,2013
     * @author ma_zhicheng
     * @EditHistory：<修改内容><修改人>
     */
    public abstract void setParamEntry();
    
    public abstract void setDownloadEntity();
    
    public abstract void setUploadFileHandlerEntity();
    
    public abstract void setOnFinishListen();
    
    public abstract void setProcessEntityHandler();
    
    /**
     * 
     * 向服务器端请求
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：17 Sep,2013
     * @author ma_zhicheng
     * @EditHistory：<修改内容><修改人>
     */
    public final void wrapRequestNew(Handler mHandler, JSONObject headerObj, int requestType, NetTask httpTask,
                                     JSONObject object)
    {
        this.mHandler = mHandler;
        this.mRequestType = requestType;
        this.mHeaderJSONOBJ = headerObj;
        //this.mRequstObject = object;

        LogUtil.save("任务请求ID为 " + requestType);
        if (headerObj != null)
        {
            LogUtil.save(headerObj.toString());
        }
        if (object != null)
        {
            LogUtil.save(object.toString());
        }
        param = new HttpNetParamEntry();
        
        //setParamEntry();
        if(object != null)
        {
            //param.setMapParam(object);
            param.setStrParam(object.toString());
        }

        param.setUrl(Constant_Mgr.getMIP_BAES_URL());

        httpTask.setParam(param);
        
        setDownloadEntity();
        setUploadFileHandlerEntity();
        setOnFinishListen();
        setProcessEntityHandler();
        
        LogUtil.save(param.getUrl());
        
        if (mOnFinishListen != null)
        {
            httpTask.setOnFinishListen(mOnFinishListen);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 结束时的监听事件，请检查是否要设置！");
        }
        
        if (mProcessEntityHandler != null)
        {
            httpTask.setOnProcessEntityHandler(mProcessEntityHandler);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 交互过程中的监听事件，请检查是否要输入设置！");
        }
        
        if (mDownloadEntityHandler != null)
        {
            httpTask.setmDownloadEntityHandler(mDownloadEntityHandler);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 返回流的处理接口，请检查是否要输入设置！");
        }
        
        if (mUpLoadFileHandlerEntity != null)
        {
            httpTask.setmUploadHandlerEntity(mUpLoadFileHandlerEntity);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 上传流的处理接口，请检查是否要输入设置！");
        }
        
        NetTaskQueueManager.add(httpTask);
    }

    public final void wrapRequest(Handler mHandler, JSONObject headerObj, int requestType, NetTask httpTask,
                                  HashMap<String, Object> object)
    {
        this.mHandler = mHandler;
        this.mRequestType = requestType;
        this.mHeaderJSONOBJ = headerObj;
        this.mRequstObject = object;

        LogUtil.save("任务请求ID为 " + requestType);
        if (headerObj != null)
        {
            LogUtil.save(headerObj.toString());
        }
        if (object != null)
        {
            LogUtil.save(object.toString());
        }
        param = new HttpNetParamEntry();

        setParamEntry();

        httpTask.setParam(param);

        setDownloadEntity();
        setUploadFileHandlerEntity();
        setOnFinishListen();
        setProcessEntityHandler();

        LogUtil.save(param.getUrl());

        if (mOnFinishListen != null)
        {
            httpTask.setOnFinishListen(mOnFinishListen);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 结束时的监听事件，请检查是否要设置！");
        }

        if (mProcessEntityHandler != null)
        {
            httpTask.setOnProcessEntityHandler(mProcessEntityHandler);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 交互过程中的监听事件，请检查是否要输入设置！");
        }

        if (mDownloadEntityHandler != null)
        {
            httpTask.setmDownloadEntityHandler(mDownloadEntityHandler);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 返回流的处理接口，请检查是否要输入设置！");
        }

        if (mUpLoadFileHandlerEntity != null)
        {
            httpTask.setmUploadHandlerEntity(mUpLoadFileHandlerEntity);
        }
        else
        {
            // LogUtil.i("", "你没有设置任务请求ID为 " + requestType +
            // " 上传流的处理接口，请检查是否要输入设置！");
        }

        NetTaskQueueManager.add(httpTask);
    }
    
    /**
     * 
     * 封装请求中添加header和body
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：17 Sep,2013
     * @author ma_zhicheng
     * @EditHistory：<修改内容><修改人>
     */
    public static String addRequestBlcok(JSONObject header, JSONObject body)
    {
        
        Map<String, Object> clientData = new HashMap<String, Object>();
        
        if (header != null)
        {
            clientData.put("header", header);
            
        }
        if (body != null)
        {
            clientData.put("body", AesUtil.encrypt(body.toString(), MIP_Constant_Core.MOA_deviceKey));
            
        }
        String obj = new JSONObject(clientData).toString();
        return obj;
    }
    
    public void ShowErrorLog(int type)
    {
        switch (type)
        {
            case 0:
                LogUtil.i("输入参数不是预定义的格式！");
                break;
            
            default:
                break;
        }
    }
}
