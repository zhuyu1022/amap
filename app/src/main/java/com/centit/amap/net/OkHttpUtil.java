package com.centit.amap.net;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by zhuyu on 2017/11/4.
 */

public class OkHttpUtil {


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String FILE = "application/octet-stream";
    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 100;
    public final static int WRITE_TIMEOUT = 60;

    private static OkHttpClient client;
    //非常有必要，要不此类还是可以被new，但是无法避免反射，好恶心
    private OkHttpUtil(){

    }
    public static OkHttpClient getInstance() {
        if (client == null)
        {
            synchronized (OkHttpUtil.class)
            {
                if (client == null)
                {
                    client = new OkHttpClient.Builder()
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                            .build();
                }
            }
        }
        return client;
    }


    public static void post(String url, JSONObject jsonObject, Callback callback) {
        Log.d("post:","url:"+url);
        Log.d("post:","jsonObject:"+jsonObject.toString());
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void post(String url, String json, Callback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
       client.newCall(request).enqueue(callback);
    }

    public static void postFile(String url, String filePath, Callback callback) {
        Log.d("postFile:","url:"+url);
        Log.d("postFile:","filePath:"+filePath);
        File file = new File(filePath);
        if (!file.exists()) {
           return;
        }
            RequestBody fileBody = RequestBody.create(MediaType.parse(FILE), file);
            RequestBody requestBody = new MultipartBody.Builder().addFormDataPart("filename", file.getName(), fileBody).build();

            Request requestPostFile = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

        client.newCall(requestPostFile).enqueue(callback);
    }





}
