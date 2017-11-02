package com.centit.core.tools.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.provider.MediaStore.Images.Thumbnails;

/**
 * 获取本地的图片，保存头像等
 * 
 * @Description 获取本地的图片，保存头像等
 * 
 * @author he
 */
public class GetLocalPic {
	/**
	 * 存放图片地址的URL
	 */
	private static List<String> list = new ArrayList<String>();

	/**
	 * 
	 * 通过ContentResolver查找本地图库照片的url
	 * 
	 * @LastModifiedDate：2013-12-6
	 * @author he
	 */
	private static void findimagepath(Context mContext)

	{
		list = new ArrayList<String>();
		ContentResolver cr = mContext.getContentResolver();
		String[] imagedata = { Thumbnails._ID, Thumbnails.IMAGE_ID,
				Thumbnails.DATA };// 找到image
		Cursor cursor = cr.query(Thumbnails.EXTERNAL_CONTENT_URI, imagedata,
				null, null, null); // 利用游标找image
		getColumnData(cursor);
	}

	/**
	 * 
	 * 通过解析游标拿取实际的值
	 * 
	 * @author he
	 */

	private static void getColumnData(Cursor cur)

	{
		if (cur.moveToFirst()) {
			String image_path;
			int dataColumn = cur.getColumnIndex(Thumbnails.DATA);

			do {
				image_path = cur.getString(dataColumn);
				list.add(image_path);
			} while (cur.moveToNext());
		}
	}

	/**
	 * 
	 * 通过查询本地图库，获取所有的图片地址
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param context
	 * @return
	 * @author he
	 * @EditHistory：<修改内容><修改人>
	 */
	public static List<String> getdataForAll(Context context) {
		findimagepath(context);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	/**
	 * 保存头像图片 pathUrl 保存图片的全路径
	 * 
	 * @param _name
	 */
	public static void setSDImg(String pathUrl, Bitmap bitmap) {

		if (!MIP_DeviceInfoUtils.checkSDCard()) {
			return;
		}
		FileOutputStream fOut = null;
		MIP_FileUtils.createSubDir(pathUrl);

		File f = new File(pathUrl);
		try {
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();
			fOut = new FileOutputStream(f);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
			fOut.flush();
			fOut.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * 获取本地图片
	 * 
	 * @Description 获取本地图片
	 * 
	 * @param _imageName
	 *            图片本地路径
	 * @return
	 * @author he
	 * @EditHistory：<修改内容><修改人>
	 */
	public static Bitmap getHeader(String pciPathUrl) {
		File file = new File(pciPathUrl);
		Bitmap result = null;
		if (file == null || !file.exists() || !file.isFile()) {
			return null;
		} else {
			// 此处应该对图片进行缩放
			result = getLocalBit(pciPathUrl);
			// 原始大小
			int bmpWidth = result.getWidth();

			int bmpHeight = result.getHeight();
			// 缩放比例 ：缩放后的宽度为200
			float scaleWidth = (float) 200 / bmpWidth; // 按固定大小缩放 sWidth 写多大就多大

			float scaleHeight = (float) 200 / bmpHeight; //

			Matrix matrix = new Matrix();

			matrix.postScale(scaleWidth, scaleHeight);// 产生缩放后的Bitmap对象

			result = Bitmap.createBitmap(result, 0, 0, bmpWidth, bmpHeight,
					matrix, false);
		}
		return result;
	}

	/**
	 * 
	 * 获取某一文件夹下的图片地址
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param context
	 * @return
	 * @author he
	 * @EditHistory：<修改内容><修改人>
	 */
	public static List<String> getdataInDir() {
		if (!MIP_DeviceInfoUtils.checkSDCard()) {
			return null;
		}
		list = new ArrayList<String>();
		getImageNames(MIP_DeviceInfoUtils.getSDPath());
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public static void getImageNames(String folderPath) {
		if (folderPath == null || "".equals(folderPath)) {
			return;
		}
		File filedir = new File(folderPath);

		String[] filesList = filedir.list();

		if (filesList == null) {
			return;
		}
		for (int i = 0; i < filesList.length; i++) {
			if (filesList[i].startsWith(".") || filesList[i].startsWith("..")) {
				continue;
			}
			File imageFile = new File(folderPath + "/" + filesList[i]);

			if (!imageFile.isDirectory()) {

				if (isImageFile(imageFile.getName())) {
					list.add(imageFile.getPath());
				}
			} else {
				getImageNames(imageFile.getAbsolutePath());
			}
		}
	}

	/**
	 * 
	 * 是否是图片
	 * 
	 * @Description 是否是图片：true 是图片、false 不是图片
	 * @LastModifiedDate：
	 * @author he
	 */
	private static boolean isImageFile(String fileName) {
		String fileEnd = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		if (fileEnd.equalsIgnoreCase("jpg")) {
			return true;
		} else if (fileEnd.equalsIgnoreCase("png")) {
			return true;
		} else if (fileEnd.equalsIgnoreCase("bmp")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 获取本地图片
	 * 
	 * @Description 获取本地图片
	 * @LastModifiedDate：
	 * @author he
	 */
	public static Bitmap getLocalBit(String url) {
		Bitmap bitmap = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(url);
			BufferedInputStream bis = new BufferedInputStream(fis);
			bitmap = BitmapFactory.decodeStream(bis);
			return bitmap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return bitmap;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
