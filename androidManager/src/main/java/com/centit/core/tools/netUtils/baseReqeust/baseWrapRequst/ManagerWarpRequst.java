/*
 * File name:  ManagerWarpRequst.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2014-2-18
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.Constant_Net;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-2-18]
 */
abstract public class ManagerWarpRequst extends AbstractWrapRequest
{
    
    /**
     * <默认构造函数>
     */
    public ManagerWarpRequst(int type)
    {
        super(type);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 获取StrParam
     * 
     * @param obj
     * @return
     */
    protected Object getBodyParam()
    {
        Object bodyParam = null;
        if (mRequstObject != null)
        {
            bodyParam = mRequstObject.get(Constant_Net.BODYPARAM);
        }
        
        return bodyParam;
    }
    
    // 获取map类型的入参
    protected Object getMapParam()
    {
        Object mapParam = null;
        if (mRequstObject != null)
        {
            mapParam = mRequstObject.get(Constant_Net.BODYMAPPARM);
        }
        return mapParam;
    }
    
    /**
     * 获取FileInfo
     * 
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    protected List<FileInfo> getFileInfos()
    {
        List<FileInfo> mFileInfos = new ArrayList<FileInfo>();
        if (mRequstObject != null)
        {
            Object value = mRequstObject.get(Constant_Net.FILES);
            if (value != null && value instanceof List<?>)
            {
                mFileInfos = (List<FileInfo>)value;
            }
        }
        return mFileInfos;
    }
    
    /**
     * 封装header
     * 
     * @return
     */
    public JSONObject wrapHeader()
    {
        return mHeaderJSONOBJ;
    }
    
    /**
     * 
     * 封装请求的body
     * 
     * @Description<功能详细描述>
     * 
     * @return
     * @LastModifiedDate：17 Sep,2013
     * @author ma_zhicheng
     * @EditHistory：<修改内容><修改人>
     */
    public abstract JSONObject wrapBody();
    
    /**
     * 封装头、body
     * 
     * @param obj
     */
    public abstract String wrapHeadBody();
    
}
