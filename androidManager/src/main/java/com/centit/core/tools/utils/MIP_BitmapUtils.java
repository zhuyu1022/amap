package com.centit.core.tools.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.centit.GlobalState;

/**
 * 图片工具类
 * 
 * @author 2013-10-22 下午12:54:55
 */
public class MIP_BitmapUtils
{
    public static final String        textChangLine = "@";
    
    /**
     * 图片缓存
     */
    private static MIP_LruMemoryCache bitmapCache   = null;
    
    /**
     * 获取bitmapCache
     * 
     * @return the bitmapCache
     */
    public static MIP_LruMemoryCache getBitmapCache()
    {
        if (bitmapCache == null)
        {
            // 获取应用程序最大可用内存
            int maxMemory = (int)Runtime.getRuntime().maxMemory();
            // 设置图片缓存大小为maxMemory的1/6
            int cacheSize = maxMemory / 6;
            
            bitmapCache = new MIP_LruMemoryCache(cacheSize);
        }
        return bitmapCache;
    }
    
    /**
     * 添加Bitmap
     * 
     * @param key
     * @param bitmap
     */
    public static void addBitmap(String key, Bitmap bitmap)
    {
        
        if (getBitmapCache() != null)
        {
            bitmapCache.addBitmapToMemoryCache(key, bitmap);
        }
        
    }
    
    /**
     * 获取Bitmap
     * 
     * @param key
     * @return
     */
    public static Bitmap getBitmap(String key)
    {
        
        if (getBitmapCache() != null)
        {
            return bitmapCache.getBitmapFromMemCache(key);
        }
        return null;
    }
    
    /**
     * 移除Bitmap
     * 
     * @param key
     */
    public static void removeBitmap(String key)
    {
        if (getBitmapCache() != null)
        {
            Bitmap bt = bitmapCache.get(key);
            if (bt != null)
            {
                bt.recycle();
                bt = null;
            }
            bitmapCache.remove(key);
        }
        
    }
    
    /**
     * 缩放图片
     * 
     * @author 2013-10-12 下午3:56:16
     * @param bm
     * @param newWidth
     * @param newHeight
     * @return Bitmap
     */
    public static Bitmap scaleImg(Bitmap bm, int newWidth, int newHeight)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        int newWidth1 = newWidth;
        int newHeight1 = newHeight;
        float scaleWidth = ((float)newWidth1) / width;
        float scaleHeight = ((float)newHeight1) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
    
    /**
     * drawable 转为 Bitmap
     * 
     * @author 2013-10-12 下午3:56:25
     * @param drawable
     * @return Bitmap
     */
    public static Bitmap drawableToBitmap(Drawable drawable)
    {
        Bitmap bitmap =
            Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
    
    /**
     * 缩放Drawable
     * 
     * @author 2013-10-12 下午3:56:40
     * @param drawable
     * @param w
     * @param h
     * @return Drawable
     */
    public static Drawable zoomDrawable(Drawable drawable, int w, int h)
    {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable); // drawable转换成bitmap
        Matrix matrix = new Matrix(); // 创建操作图片用的Matrix对象
        float scaleWidth = ((float)w / width); // 计算缩放比例
        float scaleHeight = ((float)h / height);
        matrix.postScale(scaleWidth, scaleHeight); // 设置缩放比例
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true); // 建立新的bitmap，其内容是对原bitmap的缩放后的图
        return new BitmapDrawable(newbmp); // 把bitmap转换成drawable并返回
    }
    
    /**
     * bitmap 转 Drawable
     * 
     * @author 2013-10-12 下午3:56:49
     * @param bitmap
     * @return Drawable
     */
    public static Drawable bitmap2Drawable(Bitmap bitmap)
    {
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }
    
    /**
     * 图片创建倒影 TODO(这里用一句话描述这个方法的作用)
     * 
     * @author 2013-10-12 下午3:58:39
     * @param originalImage
     * @param number
     * @return Bitmap
     */
    public static Bitmap createReflectedImage(Bitmap originalImage, int number)
    {
        final int reflectionGap = 0; // 倒影和原图片间的距离
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);
        
        double reflectHeight = number / 100.00;
        
        number = (int)(height * reflectHeight);
        // 倒影部分
        Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, number, width, number, matrix, false);
        // 要返回的倒影图片
        Bitmap bitmapWithReflection = Bitmap.createBitmap(width, (height + number), Config.ARGB_8888);
        
        Canvas canvas = new Canvas(bitmapWithReflection);
        // 画原来的图片
        canvas.drawBitmap(originalImage, 0, 0, null);
        
        // Paint defaultPaint = new Paint();
        // //倒影和原图片间的距离
        // canvas.drawRect(0, height, width, height + reflectionGap,
        // defaultPaint);
        // 画倒影部分
        canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);
        
        Paint paint = new Paint();
        LinearGradient shader =
            new LinearGradient(0, originalImage.getHeight(), 0, bitmapWithReflection.getHeight() + reflectionGap,
                0x70ffffff, 0x00ffffff, TileMode.MIRROR);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawRect(0, height, width, bitmapWithReflection.getHeight() + reflectionGap, paint);
        return bitmapWithReflection;
    }
    
    /**
     * 图片增加边框
     * 
     * @author 2013-10-12 下午3:58:28
     * @param bitmap
     * @param color
     * @return Bitmap
     */
    public static Bitmap addFrame(Bitmap bitmap, int color)
    {
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Rect rect = canvas.getClipBounds();
        rect.bottom--;
        rect.right--;
        Paint recPaint = new Paint();
        recPaint.setColor(color);
        recPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, recPaint);
        canvas.drawBitmap(bitmap, 0, 0, null);
        return bitmap2;
    }
    
    /**
     * 字节转图片
     * 
     * @author 2013-10-12 下午3:58:03
     * @param data
     * @return Bitmap
     */
    public static Bitmap getBitmap(byte[] data)
    {
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }
    
    /**
     * 图片转字节
     * 
     * @author 2013-10-12 下午3:57:54
     * @param bitmap
     * @return byte[]
     */
    public static byte[] getBytes(Bitmap bitmap)
    {
        ByteArrayOutputStream baops = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 0, baops);
        return baops.toByteArray();
    }
    
    /**
     * 获取压缩后的bitmap
     * 
     * @param bitmap
     * @param reqSize
     * @return
     */
    public static Bitmap downSizeBitmap(Bitmap bitmap, int reqSize)
    {
        
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        
        float scaleWidth = ((float)reqSize) / width;
        float scaleHeight = ((float)reqSize) / height;
        
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = null;
        try
        {
            resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return resizedBitmap;
    }
    
    /**
     * 获取bitmap，获取相应的长、宽
     * 
     * @param dst
     * @param width
     * @param height
     * @return
     */
    public Bitmap getBitmapFromFile(File dst, int width, int height)
    {
        if (null != dst && dst.exists())
        {
            BitmapFactory.Options opts = null;
            if (width > 0 && height > 0)
            {
                opts = new BitmapFactory.Options();
                opts.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(dst.getPath(), opts);
                // 计算图片缩放比例
                final int minSideLength = Math.min(width, height);
                opts.inSampleSize = computeSampleSize(opts, minSideLength, width * height);
                opts.inJustDecodeBounds = false;
                opts.inInputShareable = true;
                opts.inPurgeable = true;
            }
            try
            {
                return BitmapFactory.decodeFile(dst.getPath(), opts);
            }
            catch (OutOfMemoryError e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels)
    {
        int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);
        
        int roundedSize;
        if (initialSize <= 8)
        {
            roundedSize = 1;
            while (roundedSize < initialSize)
            {
                roundedSize <<= 1;
            }
        }
        else
        {
            roundedSize = (initialSize + 7) / 8 * 8;
        }
        
        return roundedSize;
    }
    
    private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels)
    {
        double w = options.outWidth;
        double h = options.outHeight;
        
        int lowerBound = (maxNumOfPixels == -1) ? 1 : (int)Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound =
            (minSideLength == -1) ? 128 : (int)Math.min(Math.floor(w / minSideLength), Math.floor(h / minSideLength));
        
        if (upperBound < lowerBound)
        {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }
        
        if ((maxNumOfPixels == -1) && (minSideLength == -1))
        {
            return 1;
        }
        else if (minSideLength == -1)
        {
            return lowerBound;
        }
        else
        {
            return upperBound;
        }
    }
    
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static byte[] convertBitmapToBytes(Bitmap bitmap)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        {
            ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(buffer);
            return buffer.array();
        }
        else
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data = baos.toByteArray();
            return data;
        }
    }
    
    // 解码图像用来减少内存消耗
    // width 图片像素宽， height 高
    public static Bitmap decodeFile(File f, int width, int height)
    {
        try
        {
            // 解码图像大小
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            
            final int REQUIRED_SIZE_WIDTH = width * (GlobalState.getInstance().getmDensityDpi() / 160);
            final int REQUIRED_SIZE_HEIGHT = height * (GlobalState.getInstance().getmDensityDpi() / 160);
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true)
            {
                if (width_tmp / 2 < REQUIRED_SIZE_WIDTH && height_tmp / 2 < REQUIRED_SIZE_HEIGHT)
                    break;
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        }
        catch (OutOfMemoryError outE)
        {
            outE.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Bitmap getFileBitMap(String filePath, String key, int w, int h)
    {
        Bitmap bt = getBitmap(key);
        
        if (bt == null)
        {
            if (MIP_FileUtils.isFileExist(filePath))
            {
                Bitmap bitmap = decodeFile(new File(filePath), w, h);
                
                if (bitmap != null)
                {
                    MIP_BitmapUtils.addBitmap(key, bitmap);
                    return bitmap;
                }
            }
        }
        else
        {
            return bt;
        }
        
        return null;
    }
    
    public static Bitmap getRBitmap(Context mContext, int id)
    {
        Bitmap bt = getBitmap("R_" + id);
        if (bt == null)
        {
            try
            {
                new BitmapFactory();
                bt = BitmapFactory.decodeResource(mContext.getResources(), id);
            }
            catch (OutOfMemoryError e)
            {
                // TODO: handle exception
                e.printStackTrace();
            }
            if (bt != null)
            {
                MIP_BitmapUtils.addBitmap("R_" + id, bt);
            }
        }
        return bt;
    }
    
    /**
     * 转换图片成圆形
     * 
     * @param bitmap 传入Bitmap对象
     * @return
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap)
    {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height)
        {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        }
        else
        {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        
        Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int)left, (int)top, (int)right, (int)bottom);
        final Rect dst = new Rect((int)dst_left, (int)dst_top, (int)dst_right, (int)dst_bottom);
        final RectF rectF = new RectF(dst);
        
        paint.setAntiAlias(true);
        
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }
}
