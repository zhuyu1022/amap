package com.centit.app.cmipNetHandle.wrapRequest;

import java.util.HashMap;
import java.util.List;

import com.centit.app.cmipConstant.Constant_Mgr;
import com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity.StringDownloadHandleEntity;
import com.centit.app.cmipNetHandle.netHandleEntity.finishListen.CustomOnFinishListen;
import com.centit.app.cmipNetHandle.netHandleEntity.processListen.UpLoadProcessListen;
import com.centit.app.cmipNetHandle.netHandleEntity.uploadHandleEntity.ZipUploadFileHander;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity.SendType;
import com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst.BaseWrapRequest;

/**
 * 根据我们预定的请求格式 1.该请求为基本请求，请求参数为将“预定义的header 和 加密body（本身为JSON格式）
 * 合成的String型”和文件本身封装为zip流 2.URL 为 “baseURL” + MIPSERVER/server/upload
 * 3.返回为文本格式其数据类型为JSON
 * 
 * @author ren_qiujing
 * 
 */
public class CustomUploadBaseWrapRequest extends BaseWrapRequest {

	public CustomUploadBaseWrapRequest(String url, int type) {
		super(url,type);
		mBaseURL = url;
	}

	@Override
	public String getURL() {
		return mBaseURL;
	}

	@Override
	public SendType getSendTYP() {
		return SendType.Uploadfiles;
	}

	@Override
	public void setDownloadEntity() {
		// TODO Auto-generated method stub
		mDownloadEntityHandler = new StringDownloadHandleEntity(mRequestType);
	}

	@Override
	public void setUploadFileHandlerEntity() {
		// TODO Auto-generated method stub
		mUpLoadFileHandlerEntity = new ZipUploadFileHander();

		List<FileInfo> infos = getFileInfos();

		if (infos != null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(ZipUploadFileHander.requestStr, param.getStrParam());
			map.put(ZipUploadFileHander.requestFiles, infos);

			mUpLoadFileHandlerEntity.setObject(map);
		} else {
			ShowErrorLog(0);
		}
	}

	@Override
	public void setOnFinishListen() {
		// TODO Auto-generated method stub
		mOnFinishListen = new CustomOnFinishListen(mHandler, mRequestType);

	}

	@Override
	public void setProcessEntityHandler() {
		// TODO Auto-generated method stub
		this.mProcessEntityHandler = new UpLoadProcessListen(mHandler);
	}

}
