package com.centit.app.cmipNetHandle.wrapRequest;

import com.centit.app.cmipNetHandle.netHandleEntity.donwnloadHandleEntity.FileDownloadWithURLHandleEntity;
import com.centit.app.cmipNetHandle.netHandleEntity.finishListen.DownloadFileFinishListen;
import com.centit.app.cmipNetHandle.netHandleEntity.processListen.DownloadProcessListen;
import com.centit.core.tools.fileManager.FileInfo;
import com.centit.core.tools.netUtils.baseEngine.netParam.NetParamEntity.SendType;
import com.centit.core.tools.netUtils.baseReqeust.baseWrapRequst.BaseWrapRequest;

/**
 * 向URL请求 返回的流为文件实体
 * 
 * 
 * @author ren_qiujing
 * 
 */
public class FileDownloadWithURLBaseWrapRequest extends BaseWrapRequest {

	private FileInfo mfileInfo;

	public FileDownloadWithURLBaseWrapRequest(int type, String url,
			FileInfo fileinfo) {
		super(url, type);
		this.mfileInfo = fileinfo;
		mBaseURL = url;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getURL() {
		return mBaseURL;
	}

	@Override
	public SendType getSendTYP() {
		return SendType.DownloadfilesWithUrl;
	}

	/**
	 * 重载方法
	 * 
	 * @author shen_feng
	 */
	@Override
	public void setDownloadEntity() {
		mDownloadEntityHandler = new FileDownloadWithURLHandleEntity(
				mfileInfo.getFilepath());
	}

	/**
	 * 重载方法
	 * 
	 * @author shen_feng
	 */
	@Override
	public void setOnFinishListen() {
		mOnFinishListen = new DownloadFileFinishListen(mHandler, mRequestType,
				mfileInfo);
	}

	/**
	 * 重载方法
	 * 
	 * @author shen_feng
	 */
	@Override
	public void setUploadFileHandlerEntity() {

	}

	/**
	 * 重载方法
	 * 
	 * @author shen_feng
	 */
	@Override
	public void setProcessEntityHandler() {
		this.mProcessEntityHandler = new DownloadProcessListen(mHandler);
	}
}
