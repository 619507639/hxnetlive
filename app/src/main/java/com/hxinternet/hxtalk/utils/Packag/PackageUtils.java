package com.hxinternet.hxtalk.utils.Packag;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * create time: 2021/2/4
 * author: wd
 * description:
 */
public class PackageUtils {

    private static PackageUtils mInstance;

    private PackageUtils() {
    }

    public static PackageUtils getInstance() {
        if (mInstance == null) {
            synchronized (PackageUtils.class) {
                if (mInstance == null) {
                    mInstance = new PackageUtils();
                }
            }
        }
        return mInstance;
    }

    public int packageCode(Context context) {
        PackageManager manager = context.getPackageManager();
        int code = 0;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            code = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    public String packageName(Context context) {
        PackageManager manager = context.getPackageManager();
        String name = null;
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            name = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return name;
    }
}
