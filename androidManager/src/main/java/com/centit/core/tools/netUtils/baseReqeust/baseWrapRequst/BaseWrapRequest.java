/*
 * File name:  getCityList.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wen_tao
 * Last modified date:  2013-11-27
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst;

import java.util.HashMap;

import org.json.JSONObject;

import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity.SendType;

/**
 * 封装请求 以hoperun预定义的方式封装请求
 * 
 * @Description
 * 
 * @author
 * @Version [版本号, 2013-11-27]
 */
abstract public class BaseWrapRequest extends ManagerWarpRequst {

	public BaseWrapRequest(String url, int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String wrapHeadBody() {
		// TODO Auto-generated method stub
		JSONObject header = wrapHeader();
		JSONObject body = wrapBody();
		return addRequestBlcok(header, body);
	}

	@Override
	public JSONObject wrapBody() {
		// TODO Auto-generated method stub
		Object body = getBodyParam();
		JSONObject bodyObj = new JSONObject();
		if (body != null && body instanceof JSONObject) {
			bodyObj = (JSONObject) body;
		} else {
			ShowErrorLog(0);
		}

		return bodyObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setParamEntry() {
		// TODO Auto-generated method stub
		String strParam = wrapHeadBody();
		String strURL = getURL();
		SendType type = getSendTYP();

		HashMap<String, String> mapParam = null;
		if (getMapParam() != null && getMapParam() instanceof HashMap<?, ?>) {
			mapParam = (HashMap<String, String>) getMapParam();
		}

		param.setStrParam(strParam);
		param.setMapParam(mapParam);
		param.setUrl(strURL);
		param.setSendType(type);
	}

	public abstract String getURL();

	public abstract SendType getSendTYP();

}
