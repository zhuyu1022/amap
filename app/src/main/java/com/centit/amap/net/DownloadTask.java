package com.centit.amap.net;


import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhu_yu on 2017/10/27.
 */

public class DownloadTask extends AsyncTask<String ,Integer,Integer> {


    public static final int TYPE_SUCCESS=0;
    public static final int TYPE_FAILED=1;
    public static final int TYPE_PAUSED=2;
    public static final int TYPE_CANCELED=3;


    private boolean  isCanceled=false;
    private boolean isPaused=false;
    private DownloadListener listener;
    private Context mContext;
    private int lastProgress;

    public DownloadTask(Context context,DownloadListener listener) {
        mContext=context;
        this.listener=listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        //获取下载url
        String url=params[0];
        //从url中解析出文件名
        String filename=url.substring(url.lastIndexOf("/"));
        //记录已下载的文件长度
        long downloadLength=0;
        //文件保存在应用关联缓存目录
        File file=new File(mContext.getExternalFilesDir(null),filename);
        if (file.exists()){
            //如果文件存在，获取文件长度
            downloadLength=file.length();
        }
        //获取下载文件的总长度
        long contentLength=getContentLength(url);
        if (downloadLength==contentLength){
            //已下载字节和文件总字节长度相等，说明已经下载成功
            return TYPE_SUCCESS;
        }
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .addHeader("RANGE","bytes="+downloadLength+"-")
                .url(url)
                .build();
        //输入流
        InputStream is=null;
        RandomAccessFile savedFile=null;
        try {
            Response response=client.newCall(request).execute();
            if (response!=null){
                is=response.body().byteStream();
                //RandomAccessFile可以零内存追加，支持任意位置读取
               savedFile=new RandomAccessFile(file,"rw");
                //跳过已下载的字节
                savedFile.seek(downloadLength);
                byte []b=new byte[1024];
                int len=0;
                //记录下载的总字节长度
                int total=0;
                while((len=is.read(b))!=-1){
                    if (isCanceled){
                        return TYPE_CANCELED;
                    }else if (isPaused){
                        return TYPE_PAUSED;
                    }else {
                        total+=len;
                        //写入数据
                        savedFile.write(b,0,len);
                        //计算已下载的百分比
                        int progress= (int) ((total+downloadLength)*100/contentLength);
                        //返回进度
                        publishProgress(progress);
                    }
                }
                response.body().close();
                return TYPE_SUCCESS;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

                try {
                    if (is!=null) {
                        is.close();
                    }
                    if (savedFile!=null){
                        savedFile.close();
                    }
                    if (isCanceled&&file!=null){
                        file.delete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }


        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        switch (integer){
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case TYPE_CANCELED:
                listener.onCanceled();
                break;
            case TYPE_PAUSED:
                listener.onPaused();
                break;
            case TYPE_FAILED:
                listener.onFailed();
                break;
            default:
                break;

        }


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int progress=values[0];
        if (progress>lastProgress){
            listener.onProgress(progress);
            lastProgress=progress;
        }

    }

    /**
     * 暂停下载
     */
    public void pauseDownload(){
        isPaused=true;
    }

    /**
     * 取消下载
     */
    public void cancelDownload(){
        isCanceled=true;
    }


    /**
     * 获取下载文件的总长度
     * @param downloadUrl
     * @return
     */
    private long getContentLength(String downloadUrl){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(downloadUrl)
                .build();
        try {
            Response response=client.newCall(request).execute();
            if (response!=null&&response.isSuccessful()){
                Long contentLength=response.body().contentLength();
                response.body().close();
                return contentLength;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return  0;
    }


}
