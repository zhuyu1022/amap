package com.centit.app.cmipThirtpart.cmippushmgr;

import android.content.Context;
import android.content.Intent;

public interface MsgPushFactory {
      public void init(Context mContext);
      public void onStart(Context mContext);
      public void onStop(Context mContext);
      public void sendMsgToServer(Context mContext,Intent intent);
}
