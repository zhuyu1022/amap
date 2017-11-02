package com.centit.app.cmipService;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.centit.GlobalState;
import com.centit.app.cmipConstant.Constant_RequestType;
import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.netUtils.baseEngine.netTask.NetTask;
import com.centit.core.tools.netUtils.baseReqeust.baseHandle.CustomHandler.CustomHanler;

/**
 * 
 * 心跳服务
 * 
 * @author
 * @version [版本号, ]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public final class HeartBitService extends Service
{
    
    public static final String HeartBitServiceTAG = "HeartBitServiceTAG";
    
    private boolean            isStopHeart        = false;
    
    /**
     * 心跳请求
     */
    private NetTask            mHeartBeatTask;
    
    private CustomHanler       mhandHanler        = new CustomHanler()
                                                  {
                                                      
                                                      @Override
                                                      public void PostHandle(int requestType, Object objHeader,
                                                          Object objBody, boolean error, int errorCode)
                                                      {
                                                          // TODO Auto-generated method stub
                                                          onPostHandle(requestType,
                                                              objHeader,
                                                              objBody,
                                                              error,
                                                              errorCode);
                                                      }
                                                      
                                                  };
    
    private Handler            mSendHandler       = new Handler()
                                                  {
                                                      
                                                      @Override
                                                      public void handleMessage(Message msg)
                                                      {
                                                          // TODO Auto-generated method stub
                                                          int what = msg.what;
                                                          switch (what)
                                                          {
                                                              case 0:
                                                                  if (mHeartBeatTask == null)
                                                                  {
                                                                  }
                                                                  break;
                                                              default:
                                                                  break;
                                                          }
                                                          super.handleMessage(msg);
                                                      }
                                                      
                                                  };
    
    /**
     * 网络返回处理函数
     * 
     * @Description<功能详细描述>
     * 
     * @param requestType 请求ID
     * @param objHeader header
     * @param objBody 返回body
     * @param error 是否错误
     * @param errorCode 错误标识
     * @LastModifiedDate：2013-12-2
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    private void onPostHandle(int requestType, Object objHeader, Object objBody, boolean error, int errorCode)
    {
        LogUtil.i("onPostHandle....................");
        
        if (!isStopHeart)
        {
            if (error)
            {
                switch (requestType)
                {
                
                    case Constant_RequestType.HEARTBEAT_REQUEST:
                        mHeartBeatTask = null;
                        if (objBody != null && objBody instanceof String)
                        {
                            try
                            {
                                // RetParseResponse bizResponse =
                                // (RetParseResponse)ParseResponseUtils.parse((String)objBody, RetParseResponse.class);
                                // if (bizResponse != null && "4".equals(bizResponse.getRetCode()))
                                // {
                                // Intent intent = new Intent(HeartBitService.HEATBITSERVICE_RELOAD);
                                // GlobalState.getInstance().sendBroadcast(intent);
                                // }
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        mSendHandler.sendEmptyMessageDelayed(0, GlobalState.getInstance().getHeartTick());
                        break;
                    default:
                        break;
                }
                
            }
            else
            {
                switch (requestType)
                {
                
                    case Constant_RequestType.HEARTBEAT_REQUEST:
                        mHeartBeatTask = null;
                        mSendHandler.sendEmptyMessageDelayed(0, GlobalState.getInstance().getHeartTick());
                        break;
                }
                
                LogUtil.i("onPostHandle.................... 心跳请求失败！");
            }
            
        }
    }
    
    @Override
    public void onCreate()
    {
        super.onCreate();
        LogUtil.i("心跳服务启动中........");
        
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        
        if (mHeartBeatTask == null)
        {
//            mHeartBeatTask =
//                PersonSetSeviceImpl.sendHeartBeat(mHeartBeatTask, mhandHanler, Constant_RequestType.HEARTBEAT_REQUEST);
        }
        return START_FLAG_RETRY;
    }
    
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    
    @Override
    public void onDestroy()
    {
        isStopHeart = true;
        mSendHandler.removeMessages(0);
        mSendHandler.removeMessages(1);
        mSendHandler = null;
        LogUtil.i("心跳服务已经停止........................");
        super.onDestroy();
        
    }
    
}
