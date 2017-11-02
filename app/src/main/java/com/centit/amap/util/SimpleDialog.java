package com.centit.amap.util;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class SimpleDialog {
	public static void show(Context context, String msg) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(true);
		// dialog.setNegativeButton("取消", new DialogInterface.OnClickListener()
		// {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which)
		// {
		//
		// }
		// });
		dialog.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		dialog.show();
	}

	public static void show(Context context, String msg, final OnPositiveClickListener positiveListener) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(true);
//		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//			}
//		});
		dialog.setPositiveButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (positiveListener != null) {
					positiveListener.onPositiveClick();
				}
			}
		});

		dialog.show();
	}

	public static void show(Context context, String msg, final OnNegativeClickListener negativeListener) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(true);
		dialog.setNegativeButton("取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (negativeListener != null) {
					negativeListener.onNegativeClick();
				}
			}
		});
//		dialog.setPositiveButton("确定", new OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//			}
//		});

		dialog.show();
	}

	public static void show(Context context, String msg, final OnNegativeClickListener negativeListener, final OnPositiveClickListener positiveListener) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(true);
		dialog.setNegativeButton("取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (negativeListener != null) {
					negativeListener.onNegativeClick();
				}
			}
		});
		dialog.setPositiveButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (positiveListener != null) {
					positiveListener.onPositiveClick();
				}

			}
		});

		dialog.show();
	}

	
	
	
	
	public static void forceShow(Context context, String msg) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(false);
		// dialog.setNegativeButton("取消", new DialogInterface.OnClickListener()
		// {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which)
		// {
		//
		// }
		// });
		dialog.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		dialog.show();
	}

	public static void forceShow(Context context, String msg, final OnPositiveClickListener positiveListener) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(false);
//		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//			}
//		});
		dialog.setPositiveButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (positiveListener != null) {
					positiveListener.onPositiveClick();
				}
			}
		});

		dialog.show();
	}

	public static void forceShow(Context context, String msg, final OnNegativeClickListener negativeListener) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(false);
		dialog.setNegativeButton("取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (negativeListener != null) {
					negativeListener.onNegativeClick();
				}
			}
		});
//		dialog.setPositiveButton("确定", new OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//			}
//		});

		dialog.show();
	}

	public static void forceShow(Context context, String msg, final OnNegativeClickListener negativeListener, final OnPositiveClickListener positiveListener) {
		// android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth
		Builder dialog = new Builder(context);

		dialog.setTitle("提示");
		dialog.setMessage(msg);
		dialog.setCancelable(false);
		dialog.setNegativeButton("取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (negativeListener != null) {
					negativeListener.onNegativeClick();
				}
			}
		});
		dialog.setPositiveButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (positiveListener != null) {
					positiveListener.onPositiveClick();
				}

			}
		});

		dialog.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public interface OnPositiveClickListener {
		public void onPositiveClick();
	}

	public interface OnNegativeClickListener {
		public void onNegativeClick();
	}

}
