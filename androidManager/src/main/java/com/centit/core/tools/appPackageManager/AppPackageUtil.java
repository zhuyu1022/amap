package com.centit.core.tools.appPackageManager;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

@SuppressLint("NewApi")
public class AppPackageUtil {
	// 获取所有已安装应用
	// type = 0 ; 所有应用， type =1 系统应用； type =2 非系统应用
	public static List<AppInfo> getAllInstallApps(Context mContext, int type) {

		ArrayList<AppInfo> appList = new ArrayList<AppInfo>(); // 用来存储获取的应用信息数据

		List<PackageInfo> packages = mContext.getPackageManager()
				.getInstalledPackages(0);

		for (int i = 0; i < packages.size(); i++) {
			PackageInfo packageInfo = packages.get(i);
			AppInfo tmpInfo = new AppInfo();
			tmpInfo.setAppName(packageInfo.applicationInfo.loadLabel(
					mContext.getPackageManager()).toString());
			tmpInfo.setPackageName(packageInfo.packageName);
			tmpInfo.setVersionName(packageInfo.versionName);
			tmpInfo.setVersionCode(packageInfo.versionCode);
			tmpInfo.setIsShortCut(false);

			// 非系统应用
			switch (type) {
			case 0:
				appList.add(tmpInfo);
				break;
			case 1:
				if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
					appList.add(tmpInfo);
				}
				break;
			case 2:
				if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
					appList.add(tmpInfo);
				}
				break;

			default:
				break;
			}
			if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
				appList.add(tmpInfo);
			}
		}
		return appList;
	}

	// 获取该应用安装包的Intent，用于启动该应用
	public static Intent getLaucherIntent(Context mContext, String packageName) {
		return mContext.getPackageManager().getLaunchIntentForPackage(
				packageName);
	}

	/**
	 * 根据报名获取app信息
	 * 
	 * @param mContext
	 * @param packageName
	 * @return
	 */
	public static AppInfo getAppInfo(Context mContext, String packageName) {
		AppInfo tmpInfo = null;
		PackageInfo packageInfo = AppPackageUtil.getPackageInfo(mContext,
				packageName);

		if (packageInfo != null) {
			tmpInfo = new AppInfo();
			tmpInfo.setAppName(packageInfo.applicationInfo.loadLabel(
					mContext.getPackageManager()).toString());
			tmpInfo.setPackageName(packageInfo.packageName);
			tmpInfo.setVersionName(packageInfo.versionName);
			tmpInfo.setVersionCode(packageInfo.versionCode);
			// tmpInfo.setAppIcon(packageInfo.applicationInfo.loadIcon(mContext
			// .getPackageManager()));
			tmpInfo.setIsShortCut(false);

		}
		return tmpInfo;
	}

	/**
	 * 获取应用图标
	 * 
	 * @param mContext
	 * @param packageName
	 * @return
	 */
	public static Drawable getAppIcon(Context mContext, String packageName) {
		Drawable icon = null;

		PackageInfo pInfo = getPackageInfo(mContext, packageName);
		if (pInfo != null) {
			icon = pInfo.applicationInfo.loadIcon(mContext.getPackageManager());
		}
		return icon;
	}

	/**
	 * 获取包的信息
	 * 
	 * @param mContext
	 * @param packageName
	 * @return
	 */
	public static PackageInfo getPackageInfo(Context mContext,
			String packageName) {
		PackageInfo pi = null;
		try {
			pi = mContext.getPackageManager().getPackageInfo(packageName, 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pi;
	}

	/**
	 * 根据apk包路径，获取该包的信息
	 * 
	 * @param mContext
	 * @param mAPKPath
	 * @return
	 */
	public static PackageInfo getAPKFilePackageInfo(Context mContext,
			String mAPKPath) {
		PackageInfo pi = null;
		pi = mContext.getPackageManager().getPackageArchiveInfo(mAPKPath, 0);

		return pi;

	}

	/**
	 * <一句话功能简述> 根据报名获取应用的启动 intent
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param context
	 * @param packageName
	 * @return
	 * @LastModifiedDate：2015-9-6
	 * @author rqj
	 * @EditHistory：<修改内容><修改人>
	 */
	public static Intent getIntentAPPWithPackageName(Context context,
			String packageName) {
		Intent intent = null;
		PackageInfo pi = null;
		try {
			pi = context.getPackageManager().getPackageInfo(packageName, 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pi != null) {
			Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
			resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			resolveIntent.setPackage(pi.packageName);

			PackageManager pm = context.getPackageManager();
			List<ResolveInfo> apps = pm.queryIntentActivities(resolveIntent, 0);

			if (apps != null && apps.size() > 0 && apps.iterator() != null) {
				ResolveInfo ri = apps.iterator().next();

				if (ri != null) {
					String className = ri.activityInfo.name;

					intent = new Intent(Intent.ACTION_MAIN);

					intent.addCategory(Intent.CATEGORY_LAUNCHER);

					ComponentName cn = new ComponentName(packageName, className);

					intent.setComponent(cn);
				}
			}
		}
		return intent;
	}

	/**
	 * <一句话功能简述> 获取最上面活跃的Activity
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param context
	 * @return
	 * @LastModifiedDate：2015-9-6
	 * @author rqj
	 * @EditHistory：<修改内容><修改人>
	 */
	public static String getAppTopActivityName(Context context) {
		String packageName = context.getPackageName();
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> runningTaskInfos = activityManager
				.getRunningTasks(256);
		for (RunningTaskInfo info : runningTaskInfos) {
			System.out.println(info.topActivity.getPackageName() + "   "
					+ info.topActivity.getClassName());
			if (packageName != null
					&& info.topActivity.getPackageName() != null
					&& packageName.equals(info.topActivity.getPackageName())) {
				return info.topActivity.getClassName();
			}
		}
		return null;
	}

	/**
	 * <一句话功能简述> 判断Activity是否已经退到后台
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param context
	 * @return
	 * @LastModifiedDate：2015-9-6
	 * @author rqj
	 * @EditHistory：<修改内容><修改人>
	 */
	public static boolean isBackground(Context context) {
		// 判断前提，已经不在前台
		String packageName = context.getPackageName();
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> runningTaskInfos = activityManager
				.getRunningTasks(100);
		for (RunningTaskInfo info : runningTaskInfos) {
			if (packageName != null
					&& info.topActivity.getPackageName() != null
					&& packageName.equals(info.topActivity.getPackageName())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isRunningForeground(Context context) {
		String packageName = context.getPackageName();
		String topActivityClassName = getTopActivityName(context);
		if (packageName != null && topActivityClassName != null
				&& topActivityClassName.startsWith(packageName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <一句话功能简述> 获取最上层的Activity包名
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param context
	 * @return
	 * @LastModifiedDate：2015-9-6
	 * @author rqj
	 * @EditHistory：<修改内容><修改人>
	 */
	public static String getTopActivityName(Context context) {
		String topActivityClassName = null;
		ActivityManager activityManager = (ActivityManager) (context
				.getSystemService(android.content.Context.ACTIVITY_SERVICE));
		List<RunningTaskInfo> runningTaskInfos = activityManager
				.getRunningTasks(1);
		if (runningTaskInfos != null) {
			ComponentName f = runningTaskInfos.get(0).topActivity;
			topActivityClassName = f.getClassName();
		}
		return topActivityClassName;
	}

}
