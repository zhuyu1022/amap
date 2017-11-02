package com.centit.amap.net;

/**
 * Created by zhu_yu on 2017/10/30.
 */

public interface DownloadListener {
     void onSuccess();
    void onProgress(int progress);
    void onFailed();
    void onCanceled();
    void onPaused();
}
