package com.centit.core.tools.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;

import com.centit.GlobalState;

/**
 * 
 * 文件处理工具类
 * 
 * @Description 对文件进行保存、更新等操作的工具类
 * 
 * @author du_tuo
 * @Version [版本号, 2013-3-13]
 */
@SuppressLint("NewApi")
public class MIP_FileUtils
{
    
    public final static String FILE_EXTENSION_SEPARATOR = ".";
    
    /**
     * read file
     * 
     * @param filePath
     * @return if file not exist, return null, else return content of file
     * @throws IOException if an error occurs while operator BufferedReader
     */
    public static StringBuilder readFile(String filePath)
    {
        File file = new File(filePath);
        StringBuilder fileContent = new StringBuilder("");
        if (file == null || !file.isFile())
        {
            return null;
        }
        
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                if (!fileContent.toString().equals(""))
                {
                    fileContent.append("\r\n");
                }
                fileContent.append(line);
            }
            reader.close();
            return fileContent;
        }
        catch (IOException e)
        {
            throw new RuntimeException("IOException occurred. ", e);
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }
    
    /**
     * write file
     * 
     * @param filePath
     * @param content
     * @param append is append, if true, write to the end of file, else clear content of file and write into it
     * @return return true
     * @throws IOException if an error occurs while operator FileWriter
     */
    public static boolean writeFile(String filePath, String content, boolean append)
    {
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(filePath, append);
            fileWriter.write(content);
            fileWriter.close();
            return true;
        }
        catch (IOException e)
        {
            throw new RuntimeException("IOException occurred. ", e);
        }
        finally
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }
    
    /**
     * write file
     * 
     * @param filePath
     * @param stream
     * @return return true
     * @throws IOException if an error occurs while operator FileWriter
     */
    public static boolean writeFile(String filePath, InputStream stream)
    {
        OutputStream o = null;
        try
        {
            o = new FileOutputStream(filePath);
            byte data[] = new byte[1024];
            int length = -1;
            while ((length = stream.read(data)) != -1)
            {
                o.write(data, 0, length);
            }
            o.flush();
            return true;
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        }
        catch (IOException e)
        {
            throw new RuntimeException("IOException occurred. ", e);
        }
        finally
        {
            if (o != null)
            {
                try
                {
                    o.close();
                    stream.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }
    
    /**
     * read file to string list, a element of list is a line
     * 
     * @param filePath
     * @return if file not exist, return null, else return content of file
     * @throws IOException if an error occurs while operator BufferedReader
     */
    public static List<String> readFileToList(String filePath)
    {
        File file = new File(filePath);
        List<String> fileContent = new ArrayList<String>();
        if (file == null || !file.isFile())
        {
            return null;
        }
        
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                fileContent.add(line);
            }
            reader.close();
            return fileContent;
        }
        catch (IOException e)
        {
            throw new RuntimeException("IOException occurred. ", e);
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }
    
    /**
     * get file name from path, not include suffix
     * 
     * <pre>
     *      getFileNameWithoutExtension(null)               =   null
     *      getFileNameWithoutExtension("")                 =   ""
     *      getFileNameWithoutExtension("   ")              =   "   "
     *      getFileNameWithoutExtension("abc")              =   "abc"
     *      getFileNameWithoutExtension("a.mp3")            =   "a"
     *      getFileNameWithoutExtension("a.b.rmvb")         =   "a.b"
     *      getFileNameWithoutExtension("c:\\")              =   ""
     *      getFileNameWithoutExtension("c:\\a")             =   "a"
     *      getFileNameWithoutExtension("c:\\a.b")           =   "a"
     *      getFileNameWithoutExtension("c:a.txt\\a")        =   "a"
     *      getFileNameWithoutExtension("/home/admin")      =   "admin"
     *      getFileNameWithoutExtension("/home/admin/a.txt/b.mp3")  =   "b"
     * </pre>
     * 
     * @param filePath
     * @return file name from path, not include suffix
     * @see
     */
    public static String getFileNameWithoutExtension(String filePath)
    {
        if (MIP_StringUtils.isEmpty(filePath))
        {
            return filePath;
        }
        
        int extenPosi = filePath.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        int filePosi = filePath.lastIndexOf(File.separator);
        if (filePosi == -1)
        {
            return (extenPosi == -1 ? filePath : filePath.substring(0, extenPosi));
        }
        if (extenPosi == -1)
        {
            return filePath.substring(filePosi + 1);
        }
        return (filePosi < extenPosi ? filePath.substring(filePosi + 1, extenPosi) : filePath.substring(filePosi + 1));
    }
    
    /**
     * get file name from path, include suffix
     * 
     * <pre>
     *      getFileName(null)               =   null
     *      getFileName("")                 =   ""
     *      getFileName("   ")              =   "   "
     *      getFileName("a.mp3")            =   "a.mp3"
     *      getFileName("a.b.rmvb")         =   "a.b.rmvb"
     *      getFileName("abc")              =   "abc"
     *      getFileName("c:\\")              =   ""
     *      getFileName("c:\\a")             =   "a"
     *      getFileName("c:\\a.b")           =   "a.b"
     *      getFileName("c:a.txt\\a")        =   "a"
     *      getFileName("/home/admin")      =   "admin"
     *      getFileName("/home/admin/a.txt/b.mp3")  =   "b.mp3"
     * </pre>
     * 
     * @param filePath
     * @return file name from path, include suffix
     */
    public static String getFileName(String filePath)
    {
        if (MIP_StringUtils.isEmpty(filePath))
        {
            return filePath;
        }
        
        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? filePath : filePath.substring(filePosi + 1);
    }
    
    /**
     * get folder name from path
     * 
     * <pre>
     *      getFolderName(null)               =   null
     *      getFolderName("")                 =   ""
     *      getFolderName("   ")              =   ""
     *      getFolderName("a.mp3")            =   ""
     *      getFolderName("a.b.rmvb")         =   ""
     *      getFolderName("abc")              =   ""
     *      getFolderName("c:\\")              =   "c:"
     *      getFolderName("c:\\a")             =   "c:"
     *      getFolderName("c:\\a.b")           =   "c:"
     *      getFolderName("c:a.txt\\a")        =   "c:a.txt"
     *      getFolderName("c:a\\b\\c\\d.txt")    =   "c:a\\b\\c"
     *      getFolderName("/home/admin")      =   "/home"
     *      getFolderName("/home/admin/a.txt/b.mp3")  =   "/home/admin/a.txt"
     * </pre>
     * 
     * @param filePath
     * @return
     */
    public static String getFolderName(String filePath)
    {
        
        if (MIP_StringUtils.isEmpty(filePath))
        {
            return filePath;
        }
        
        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? "" : filePath.substring(0, filePosi);
    }
    
    /**
     * get suffix of file from path
     * 
     * <pre>
     *      getFileExtension(null)               =   ""
     *      getFileExtension("")                 =   ""
     *      getFileExtension("   ")              =   "   "
     *      getFileExtension("a.mp3")            =   "mp3"
     *      getFileExtension("a.b.rmvb")         =   "rmvb"
     *      getFileExtension("abc")              =   ""
     *      getFileExtension("c:\\")              =   ""
     *      getFileExtension("c:\\a")             =   ""
     *      getFileExtension("c:\\a.b")           =   "b"
     *      getFileExtension("c:a.txt\\a")        =   ""
     *      getFileExtension("/home/admin")      =   ""
     *      getFileExtension("/home/admin/a.txt/b")  =   ""
     *      getFileExtension("/home/admin/a.txt/b.mp3")  =   "mp3"
     * </pre>
     * 
     * @param filePath
     * @return
     */
    public static String getFileExtension(String filePath)
    {
        if (MIP_StringUtils.isBlank(filePath))
        {
            return filePath;
        }
        
        int extenPosi = filePath.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        int filePosi = filePath.lastIndexOf(File.separator);
        if (extenPosi == -1)
        {
            return "";
        }
        return (filePosi >= extenPosi) ? "" : filePath.substring(extenPosi + 1);
    }
    
    /**
     * Creates the directory named by the trailing filename of this file, including the complete directory path required
     * to create this directory. <br/>
     * <br/>
     * <ul>
     * <strong>Attentions:</strong>
     * <li>makeDirs("C:\\Users\\Trinea") can only create users folder</li>
     * <li>makeFolder("C:\\Users\\Trinea\\") can create Trinea folder</li>
     * </ul>
     * 
     * @param filePath
     * @return true if the necessary directories have been created or the target directory already exists, false one of
     *         the directories can not be created.
     *         <ul>
     *         <li>if {@link Handler_File#getFolderName(String)} return null, return false</li>
     *         <li>if target directory already exists, return true</li>
     *         <li>return {@link java.io.File#makeFolder}</li>
     *         </ul>
     */
    public static boolean makeDirs(String filePath)
    {
        String folderName = getFolderName(filePath);
        if (MIP_StringUtils.isEmpty(folderName))
        {
            return false;
        }
        
        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }
    
    /**
     * @param filePath
     * @return
     * @see #makeDirs(String)
     */
    public static boolean makeFolders(String filePath)
    {
        return makeDirs(filePath);
    }
    
    /**
     * Indicates if this file represents a file on the underlying file system.
     * 
     * @param filePath
     * @return
     */
    public static boolean isFileExist(String filePath)
    {
        if (MIP_StringUtils.isBlank(filePath))
        {
            return false;
        }
        
        File file = new File(filePath);
        return (file.exists() && file.isFile());
    }
    
    /**
     * Indicates if this file represents a directory on the underlying file system.
     * 
     * @param directoryPath
     * @return
     */
    public static boolean isFolderExist(String directoryPath)
    {
        if (MIP_StringUtils.isBlank(directoryPath))
        {
            return false;
        }
        
        File dire = new File(directoryPath);
        return (dire.exists() && dire.isDirectory());
    }
    
    /**
     * delete file or directory
     * <ul>
     * <li>if path is null or empty, return true</li>
     * <li>if path not exist, return true</li>
     * <li>if path exist, delete recursion. return true</li>
     * <ul>
     * 
     * @param path
     * @return
     */
    public static boolean deleteFile(String path)
    {
        if (MIP_StringUtils.isBlank(path))
        {
            return true;
        }
        
        File file = new File(path);
        if (!file.exists())
        {
            return true;
        }
        if (file.isFile())
        {
            return file.delete();
        }
        if (!file.isDirectory())
        {
            return false;
        }
        for (File f : file.listFiles())
        {
            if (f.isFile())
            {
                f.delete();
            }
            else if (f.isDirectory())
            {
                deleteFile(f.getAbsolutePath());
            }
        }
        return file.delete();
    }
    
    /**
     * 获取文件大小
     * <ul>
     * <li>if path is null or empty, return -1</li>
     * <li>if path exist and it is a file, return file size, else return -1</li>
     * <ul>
     * 
     * @param path
     * @return
     */
    public static long getFileSize(String path)
    {
        if (MIP_StringUtils.isBlank(path))
        {
            return -1;
        }
        
        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }
    
    public static long getDirSize(String dir)
    {
        long size = 0;
        File dirFile = new File(dir);
        
        if (dirFile != null && dirFile.isDirectory())
        {
            File files[] = dirFile.listFiles();
            if (files != null)
            {
                for (File file : files)
                {
                    if (file.isFile())
                    {
                        size += file.length();
                    }
                    else if (file.isDirectory())
                    {
                        size += getDirSize(file.getAbsolutePath());
                    }
                }
            }
        }
        return size;
    }
    
    /**
     * 文件拷贝
     * 
     * @author gdpancheng@gmail.com 2014-2-15 下午7:15:51
     * @param sourceFile
     * @param targetFile
     * @throws IOException
     * @return void
     */
    public static void copyFile(File sourceFile, File targetFile)
    {
        if (sourceFile == null || targetFile == null)
        {
            return;
        }
        if (targetFile.exists())
        {
            targetFile.delete();
        }
        
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try
        {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1)
            {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
            // sourceFile.delete();
            // sourceFile.deleteOnExit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭流
            try
            {
                if (inBuff != null)
                    inBuff.close();
                if (outBuff != null)
                    outBuff.close();
            }
            catch (IOException e)
            {
            }
        }
    }
    
    public static File getExternalCacheDir(Context context, String dirs_name)
    {
        File dataDir = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File appCacheDir = new File(new File(new File(dataDir, context.getPackageName()), "cache"), dirs_name);
        if (!appCacheDir.exists())
        {
            try
            {
                new File(dataDir, ".nomedia").createNewFile();
            }
            catch (IOException e)
            {
                Log.w("创建目录", "Can't create \".nomedia\" file in application external cache directory", e);
            }
            if (!appCacheDir.mkdirs())
            {
                Log.w("创建目录", "Unable to create external cache directory");
                return null;
            }
        }
        return appCacheDir;
    }
    
    public static void write(File file, String data)
    {
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter(new FileWriter(file), 1024);
            out.write(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                try
                {
                    out.flush();
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static String getAsString(File file)
    {
        if (!file.exists())
            return null;
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new FileReader(file));
            String readString = "";
            String currentLine;
            while ((currentLine = in.readLine()) != null)
            {
                readString += currentLine;
            }
            return readString;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 删除目录
     * 
     * @Description<功能详细描述>
     * 
     * @param file
     * @LastModifiedDate：2013-11-27
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static void deleteDir(File file)
    {
        if (file != null && file.isFile())
        {
            file.delete();
            return;
        }
        if (file != null && file.isDirectory())
        {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0)
            {
                file.delete();
                return;
            }
            for (File f : childFile)
            {
                deleteDir(f);
            }
            file.delete();
        }
        
    }
    
    /**
     * 
     * 创建文件目录
     * 
     * @param destDirName
     * @return
     * @LastModifiedDate：2013-9-27
     * @author shen_feng
     * @EditHistory：<修改内容><修改人>
     */
    public static boolean createSubDir(String destDirName)
    {
        if (!destDirName.endsWith("/"))
        {
            int index = destDirName.lastIndexOf("/");
            if (index != -1 && index != 0)
            {
                destDirName = destDirName.substring(0, index);
            }
        }
        File fileDir = new File(destDirName);
        if (!fileDir.exists())
        {
            fileDir.mkdirs();
            return true;
        }
        return false;
        
    }
    
    /**
     * 拷贝文件从 asset到sd卡上
     * 
     * @Description<功能详细描述>
     * 
     * @param assetName
     * @param dir
     * @LastModifiedDate：2013-12-24
     * @author ren_qiujing
     * @EditHistory：<修改内容><修改人>
     */
    public static void CopyAssets(String assetName, String dir)
    {
        AssetManager am = null;
        am = GlobalState.getInstance().getAssets();
        try
        {
            InputStream is = am.open(assetName);
            File fileDir = new File(dir);
            if (!fileDir.exists())
            {
                fileDir.mkdirs();
            }
            
            File file = new File(dir + "/" + assetName);
            FileOutputStream fileOutputStream = null;
            if (is != null)
            {
                fileOutputStream = new FileOutputStream(file);
                byte[] buf = new byte[2048];
                int ch = -1;
                while ((ch = is.read(buf)) != -1)
                {
                    fileOutputStream.write(buf, 0, ch);
                }
            }
            fileOutputStream.flush();
            if (fileOutputStream != null)
            {
                fileOutputStream.close();
            }
            
        }
        catch (IOException e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
        }
        
    }
    
    /**
     * 保存文件流
     * 
     * @param is
     * @param os
     */
    public static void CopyStream(InputStream is, OutputStream os)
    {
        
        final int buffer_size = 1024;
        try
        {
            byte[] bytes = new byte[buffer_size];
            for (;;)
            {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
            is.close();
            os.close();
        }
        catch (Exception ex)
        {
        }
    }
    
    /**
     * 文件copy，
     * 
     * @param oldPath 需要复制的文件路径
     * @param newPath 复制后的文件路径
     */
    public static void renameFile(String oldPath, String newPath)
    {
        File oldFile = new File(oldPath);
        if (oldFile.exists())
        {
            try
            {
                InputStream is = new FileInputStream(oldFile);
                File newFile = new File(newPath);
                
                if (newFile != null)
                {
                    mkPdir(newPath);
                    if (newFile.exists())
                    {
                        newFile.delete();
                    }
                }
                
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                byte[] buf = new byte[2048];
                int ch = -1;
                try
                {
                    while ((ch = is.read(buf)) != -1)
                    {
                        fileOutputStream.write(buf, 0, ch);
                    }
                    fileOutputStream.flush();
                    if (fileOutputStream != null)
                    {
                        fileOutputStream.close();
                    }
                    
                    if (is != null)
                    {
                        is.close();
                    }
                    
                    oldFile.delete();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
    
    /**
     * 保存文件
     * 
     * @param bm
     * @param fileName
     * @throws IOException
     */
    public static void saveFile(Bitmap bm, String fileParentPath, String fileName)
        throws IOException
    {
        File dirFile = new File(fileParentPath);
        if (!dirFile.exists())
        {
            dirFile.mkdir();
        }
        File myCaptureFile = new File(fileParentPath + fileName);
        if (myCaptureFile != null && myCaptureFile.exists())
        {
            myCaptureFile.delete();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
        bos.flush();
        bos.close();
        
        bm.recycle();
        bm = null;
    }
    
    public static Bitmap convertToBitmap(String path, int w, int h)
    {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        // 设置为ture只获取图片大小
        opts.inJustDecodeBounds = true;
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        // 返回为空
        BitmapFactory.decodeFile(path, opts);
        int width = opts.outWidth;
        int height = opts.outHeight;
        float scaleWidth = 0.f, scaleHeight = 0.f;
        if (width > w || height > h)
        {
            // 缩放
            scaleWidth = ((float)width) / w;
            scaleHeight = ((float)height) / h;
        }
        opts.inJustDecodeBounds = false;
        float scale = Math.max(scaleWidth, scaleHeight);
        opts.inSampleSize = (int)scale;
        WeakReference<Bitmap> weak = new WeakReference<Bitmap>(BitmapFactory.decodeFile(path, opts));
        return Bitmap.createScaledBitmap(weak.get(), w, h, true);
    }
    
    // 使用Bitmap加Matrix来缩放
    public static Bitmap resizeImage(Bitmap bitmap, int w, int h)
    {
        Bitmap BitmapOrg = bitmap;
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = w;
        int newHeight = h;
        float scaleWidth = ((float)newWidth) / width;
        float scaleHeight = ((float)newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight); // if you want to rotate the
                                                   // Bitmap
        // matrix.postRotate(45);
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width, height, matrix, true);
        return resizedBitmap;
    }
    
    // 创建父目录
    public static void mkPdir(String filepath)
    {
        if (filepath != null)
        {
            File file = new File(filepath);
            if (file != null)
            {
                File pFile = file.getParentFile();
                if (pFile != null && !pFile.exists())
                {
                    pFile.mkdirs();
                }
            }
        }
    }
    
    public static Bitmap getBitMapFile(String filePath)
    {
        Bitmap bm = null;
        File file = new File(filePath);
        if (file != null && file.exists())
        {
            BufferedInputStream in = null;
            try
            {
                in = new BufferedInputStream(new FileInputStream(file));
                new BitmapFactory();
                bm = BitmapFactory.decodeStream(in);
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally
            {
                if (in != null)
                {
                    try
                    {
                        in.close();
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    in = null;
                }
            }
        }
        return bm;
    }
    
    /**
     * Compress file and folder
     * 
     * @param srcFileString file or folder to be Compress
     * @param zipFileString the path name of result ZIP
     * @throws Exception
     */
    public static void ZipFolder(String srcFileString, String zipFileString)
        throws Exception
    {
        File zipFile = new File(zipFileString);
        if (zipFile != null && zipFile.exists())
        {
            zipFile.delete();
        }
        // create ZIP
        
        // create the file
        File file = new File(srcFileString);
        
        if (file != null && file.exists() && file.isDirectory())
        {
            File[] files = file.listFiles();
            if (files != null && files.length > 0)
            {
                ZipOutputStream outZip = new ZipOutputStream(new FileOutputStream(zipFileString));
                for (int i = 0; i < files.length; i++)
                {
                    File fileItem = files[i];
                    if (fileItem != null && fileItem.exists() && fileItem.isFile())
                    {
                        ZipEntry zipEntry = new ZipEntry(fileItem.getName());
                        FileInputStream inputStream = new FileInputStream(fileItem);
                        outZip.putNextEntry(zipEntry);
                        int len;
                        byte[] buffer = new byte[4096];
                        while ((len = inputStream.read(buffer)) != -1)
                        {
                            outZip.write(buffer, 0, len);
                        }
                        outZip.closeEntry();
                    }
                }
                outZip.finish();
                outZip.close();
            }
        }
    }
    
    public static void ZipFiles(List<String> filepaths, String zipFileString)
        throws Exception
    {
        File zipFile = new File(zipFileString);
        if (zipFile != null && zipFile.exists())
        {
            zipFile.delete();
        }
        if (filepaths != null)
        {
            ZipOutputStream outZip = new ZipOutputStream(new FileOutputStream(zipFileString));
            for (String filepath : filepaths)
            {
                File file = new File(filepath);
                if (file != null && file.exists())
                {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    FileInputStream inputStream = new FileInputStream(file);
                    outZip.putNextEntry(zipEntry);
                    int len;
                    byte[] buffer = new byte[4096];
                    while ((len = inputStream.read(buffer)) != -1)
                    {
                        outZip.write(buffer, 0, len);
                    }
                    outZip.closeEntry();
                }
            }
            outZip.finish();
            outZip.close();
        }
    }
    
    public static void unzip(String zipFileName, String outputDirectory)
        throws IOException
    {
        ZipFile zipFile = null;
        try
        {
            zipFile = new ZipFile(zipFileName);
            Enumeration e = zipFile.entries();
            ZipEntry zipEntry = null;
            File dest = new File(outputDirectory);
            dest.mkdirs();
            while (e.hasMoreElements())
            {
                zipEntry = (ZipEntry)e.nextElement();
                String entryName = zipEntry.getName();
                InputStream in = null;
                FileOutputStream out = null;
                try
                {
                    if (zipEntry.isDirectory())
                    {
                        String name = zipEntry.getName();
                        name = name.substring(0, name.length() - 1);
                        File f = new File(outputDirectory + File.separator + name);
                        f.mkdirs();
                    }
                    else
                    {
                        int index = entryName.lastIndexOf("\\");
                        if (index != -1)
                        {
                            File df = new File(outputDirectory + File.separator + entryName.substring(0, index));
                            df.mkdirs();
                        }
                        index = entryName.lastIndexOf("/");
                        if (index != -1)
                        {
                            File df = new File(outputDirectory + File.separator + entryName.substring(0, index));
                            df.mkdirs();
                        }
                        File f = new File(outputDirectory + File.separator + zipEntry.getName());
                        // f.createNewFile();
                        in = zipFile.getInputStream(zipEntry);
                        out = new FileOutputStream(f);
                        int c;
                        byte[] by = new byte[1024];
                        while ((c = in.read(by)) != -1)
                        {
                            out.write(by, 0, c);
                        }
                        out.flush();
                    }
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    throw new IOException("解压失败：" + ex.toString());
                }
                finally
                {
                    if (in != null)
                    {
                        try
                        {
                            in.close();
                        }
                        catch (IOException ex)
                        {
                        }
                    }
                    if (out != null)
                    {
                        try
                        {
                            out.close();
                        }
                        catch (IOException ex)
                        {
                        }
                    }
                }
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            throw new IOException("解压失败：" + ex.toString());
        }
        finally
        {
            if (zipFile != null)
            {
                try
                {
                    zipFile.close();
                }
                catch (IOException ex)
                {
                }
            }
        }
    }
}
