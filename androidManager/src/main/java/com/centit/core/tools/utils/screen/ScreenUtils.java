/*
 * File name:  ScreenUtils.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2015-5-27
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.core.tools.utils.screen;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.centit.core.tools.logManger.LogUtil;
import com.centit.core.tools.utils.MIP_FileUtils;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2015-5-27]
 */
public class ScreenUtils {

	public static Bitmap getScreenBitmap(Activity mActivity) {

		WindowManager windowManager = mActivity.getWindowManager();

		Display display = windowManager.getDefaultDisplay();

		int w = display.getWidth();

		int h = display.getHeight();

		Bitmap bitmap = Bitmap.createBitmap(w, h, Config.ARGB_8888);

		// 获取屏幕

		View decorview = mActivity.getWindow().getDecorView();

		decorview.setDrawingCacheEnabled(true);

		bitmap = decorview.getDrawingCache();
		decorview.setDrawingCacheEnabled(false);

		return bitmap;
	}

	public static Bitmap getCurrentImage(Activity mActivity) {
		LogUtil.i("=======  getCurrentImage 01");
		// 构建Bitmap

		WindowManager windowManager = mActivity.getWindowManager();

		Display display = windowManager.getDefaultDisplay();

		int w = display.getWidth();

		int h = display.getHeight();

		Bitmap Bmp = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		LogUtil.i("=======  getCurrentImage 02");
		// 获取屏幕

		View decorview = mActivity.getWindow().getDecorView();

		decorview.setDrawingCacheEnabled(true);

		Bmp = decorview.getDrawingCache();
//		if (Bmp != null) {
//			Bmp.recycle();
//			Bmp = null;
//		}
		
		LogUtil.i("=======  getCurrentImage 04");
		decorview.setDrawingCacheEnabled(false);
		LogUtil.i("=======  getCurrentImage 05");
		
		
		return Bmp;

	}

	/**
	 * 
	 * 获取和保存当前屏幕的截图
	 */

	public static void GetandSaveCurrentImage(Activity mActivity,
			String mSaveScreenPath) {
		LogUtil.i("=======  GetandSaveCurrentImage 01");

		if (!checkSdCard()) {
			return;
		}
		// 构建Bitmap

		WindowManager windowManager = mActivity.getWindowManager();
		

		

		Display display = windowManager.getDefaultDisplay();

		int w = display.getWidth();

		int h = display.getHeight();

//		Bitmap Bmp = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		LogUtil.i("=======  GetandSaveCurrentImage 02");
		// 获取屏幕

		View decorview = mActivity.getWindow().getDecorView();
		
		decorview.buildDrawingCache(); // 获取状态栏高度
		Rect rect = new Rect();
		decorview.getWindowVisibleDisplayFrame(rect);
		int statusBarHeights = rect.top;

		decorview.setDrawingCacheEnabled(true);
//		Bmp = decorview.getDrawingCache();
		
		Bitmap btmap = Bitmap.createBitmap(decorview.getDrawingCache(), 0,
				statusBarHeights, w, h - statusBarHeights);
		
		btmap = MIP_FileUtils.resizeImage(btmap, w/4, (h-statusBarHeights)/4);
		
		LogUtil.i("=======  GetandSaveCurrentImage 03");
		try {

			MIP_FileUtils.createSubDir(mSaveScreenPath);
			File savefile = new File(mSaveScreenPath);
			if (!savefile.exists()) {
				savefile.createNewFile();
			}

			FileOutputStream fos = null;

			fos = new FileOutputStream(savefile);

			if (null != fos) {

				btmap.compress(Bitmap.CompressFormat.PNG, 90, fos);

				fos.flush();

				fos.close();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		if (btmap != null) {
			btmap.recycle();
			btmap = null;
		}
		LogUtil.i("=======  GetandSaveCurrentImage 04");
		decorview.setDrawingCacheEnabled(false);
		LogUtil.i("=======  GetandSaveCurrentImage 05");
	}

	/**
	 * 
	 * 获取SDCard的目录路径功能
	 * 
	 * @return
	 */

	private static boolean checkSdCard() {
		// 判断SDCard是否存在

		boolean sdcardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);

		if (sdcardExist) {

			return true;
		}

		return false;

	}
}
