package com.centit.core.tools.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * 保存图片使用
 * @author rqj
 *
 */
public class MIP_LruMemoryCache extends LruCache<String, Bitmap> {

	public MIP_LruMemoryCache(int maxSize) {
		super(maxSize);
	}
	
	@Override
	protected int sizeOf(String key, Bitmap bitmap) {
		// 每张图片的大小
		return bitmap.getByteCount() / 1024;
	}
	
	/**
	 * 缓存Bitmap
	 * @param key
	 * @param bitmap
	 */
	public void addBitmapToMemoryCache(String key, Bitmap bitmap) {   
	    if (getBitmapFromMemCache(key) == null) { 
	    	put(key, bitmap);
	    }   
	}   
	 
	/**
	 * 获取已经缓存的Bitmap
	 * @param key
	 * @return
	 */
	public Bitmap getBitmapFromMemCache(String key) {   
	    return get(key);   
	} 
	
	/**
	 * 删除Bitmap
	 * @param key
	 */
	public void removeBitmapFromMemCache(String key)
	{
		Bitmap bm = get(key);
		remove(key);
		if(bm != null)
		{
			bm.recycle();
			bm = null;
		}
	}

}

