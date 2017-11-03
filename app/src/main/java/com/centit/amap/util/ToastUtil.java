package com.centit.amap.util;

import android.content.Context;
import android.widget.Toast;

import com.centit.GlobalState;
import com.centit.amap.constant.Constant;

/**
 * Created by zhuyu on 2017/11/3.
 */

public class ToastUtil {

    public static void  show(Context context,String msg){
        boolean isRecordLog= GlobalState.getInstance().isrecordLog();
        if (isRecordLog){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
