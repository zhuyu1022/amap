package com.centit.amap.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.centit.amap.R;
import com.centit.amap.net.DownloadListener;
import com.centit.amap.net.DownloadTask;
import com.centit.amap.util.LogUtil;

import java.io.File;

/**
 * Created by zhu_yu on 2017/10/30.
 */

public class DownloadDialog extends DialogFragment {
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_URL = "url";

    private ProgressBar progressBar;
    private TextView progress1Tv;
    private TextView progress2Tv;

    DownloadTask downloadTask = null;

    public static DownloadDialog newInstance(String url) {
        DownloadDialog dialog = new DownloadDialog();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_URL, url);
        dialog.setArguments(bundle);
        return dialog;
    }

    private String url = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LogUtil.d("");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.download_dialog_layout, null);
        initView(view);

        url = getArguments().getString(EXTRA_URL);

//        Dialog dialog = new Dialog(getActivity(),R.style.DialogStyle);
//        // 点击边际可消失
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.setContentView(view);
//        dialog.setTitle("正在更新巡防轨迹");
//
//        return dialog;


        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("正在更新巡防轨迹")
                .setNegativeButton("取消下载", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        downloadTask.cancelDownload();
                    }
                })
                .setNeutralButton("暂停", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        downloadTask.pauseDownload();
                    }
                })
                .setCancelable(false)
                .create();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LogUtil.d("");
        // 点击外部不消失的方法：
        getDialog().setCanceledOnTouchOutside(false);
        // 对于点击返回键不消失，需要监听OnKeyListener:
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
        startDownload(url);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");
    }

    private void initView(View view) {

        progressBar = view.findViewById(R.id.dialog_progressBar);
        progress1Tv = view.findViewById(R.id.dialog_progress1Tv);
        progress2Tv = view.findViewById(R.id.dialog_progress2Tv);
//        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    return true;
//                }
//                return false;
//            }
//
//
//        });
        // getDialog().setCanceledOnTouchOutside(false);

    }


    private void startDownload(String downloadUrl) {
        if (downloadTask == null) {
            downloadTask = new DownloadTask(getActivity(), new DownloadListener() {
                @Override
                public void onSuccess() {
                    progressBar.setProgress(100);
                    progress1Tv.setText("100%");
                    progress2Tv.setText("100/100");

                    getDialog().dismiss();
                    installApk();

                }

                @Override
                public void onProgress(int progress) {
                    progressBar.setProgress(progress);
                    progress1Tv.setText(progress + "%");
                    progress2Tv.setText(progress + "/100");
                }

                @Override
                public void onFailed() {

                }

                @Override
                public void onCanceled() {

                }

                @Override
                public void onPaused() {

                }
            });
            //执行task
            downloadTask.execute(downloadUrl);
        }

    }

    /**
     * 安装apk
     */
    private void installApk() {
        String filename = url.substring(url.lastIndexOf("/"));
        //文件保存在应用关联缓存目录
        File file = new File(getActivity().getExternalFilesDir(null), filename);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + file.toString()), "application/vnd.android.package-archive");
        startActivity(i);
    }

}
