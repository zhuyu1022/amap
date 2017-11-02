package com.centit.app.cmipNetHandle.wrapRequest;

import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity.LoginDownloadHandleEntity;
import com.centit.app.cmipNetHandle.netHandleEntity.finishListen.CustomOnFinishListen;
import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity.SendType;
import com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst.BaseWrapRequest;

/**
 * 根据我们预定的请求格式 1.该请求为基本请求，请求参数为预定义的header 和 加密body（本身为JSON格式） 合成的String型 2.URL 为
 * “baseURL” + MIPSERVER/server/baseServlet 3.返回为文本格式其数据类型为JSON
 * 
 * @author ren_qiujing
 * 
 */
public class LoginBaseWrapRequest extends BaseWrapRequest {

	public LoginBaseWrapRequest(String url, int type) {
		super(url,type);
		// TODO Auto-generated constructor stub
		mBaseURL = url;
	}

	@Override
	public String getURL() {
		return mBaseURL;
	}

	@Override
	public SendType getSendTYP() {
		return SendType.Downloadfiles;
	}

	@Override
	public void setDownloadEntity() {
		// TODO Auto-generated method stub
		mDownloadEntityHandler = new LoginDownloadHandleEntity();
	}

	@Override
	public void setUploadFileHandlerEntity() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnFinishListen() {
		// TODO Auto-generated method stub
		mOnFinishListen = new CustomOnFinishListen(mHandler, mRequestType);

	}

	@Override
	public void setProcessEntityHandler() {
		// TODO Auto-generated method stub

	}

}
