package com.centit.amap.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.centit.GlobalState;
import com.centit.amap.R;
import com.centit.amap.util.LogUtil;
import com.centit.app.cmipConstant.Constant_Mgr;


/**
 * Created by zhu_yu on 2017/10/30.
 */

public class SetWebDialog extends DialogFragment {



    private EditText webAddressEt;




    public static SetWebDialog newInstance() {
        SetWebDialog dialog = new SetWebDialog();
//        Bundle bundle = new Bundle();
//        bundle.putString(EXTRA_URL, url);
//        dialog.setArguments(bundle);
        return dialog;
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LogUtil.d("");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.set_web_dialog_layout, null);
        webAddressEt=view.findViewById(R.id.dialog_webAddressEt);
        String url= GlobalState.getInstance().getmIPAddr();
        webAddressEt.setText(url);
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("请输入服务器地址")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                        String ip = webAddressEt.getText().toString().trim();
                        String port = "";
                        GlobalState.getInstance().setmIPAddr(ip);
                        GlobalState.getInstance().setmPortNum(port);
                        String url = "http://" + ip;
                        if (!port.equals(""))
                        {
                            url = url + ":" + port;
                        }
                        GlobalState.getInstance().setmRequestURL(url);

                        if (listener!=null){
                            listener.onClick();
                        }


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

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");
    }


    public void setOnOkClickListener(onOkClickListener listener){
        this.listener=listener;
    }
    private  onOkClickListener listener;
    public interface  onOkClickListener {
     void onClick();
}





}
