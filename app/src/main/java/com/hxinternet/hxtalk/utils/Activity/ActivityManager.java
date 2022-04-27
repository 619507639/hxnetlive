package com.hxinternet.hxtalk.utils.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * create time: 2021/1/23
 * author: wd
 * description:activity处理器，用于处理activity的添加与删除。
 */
public class ActivityManager {

    private static ActivityManager mInstance;

    private List<Activity> mActivity;

    private ActivityManager() {
        mActivity = new ArrayList<>();
    }

    public static ActivityManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    public void addActivity(Activity activity) {
        if (!mActivity.contains(activity)) {
            mActivity.add(activity);
        }
    }

    public void removeActivity(Activity activity) {
        if (mActivity.contains(activity)) {
            mActivity.remove(activity);
        }
    }

    public void clearActivity() {
        for (Activity mactivity : mActivity) {
            mActivity.remove(mactivity);
        }
    }

    public void SerchinActivity() {
        for (Activity mActivity : mActivity) {
            Log.e("当前ACTIVITY栈", mActivity.getClass() + "");
        }
    }

    public void finishOtherActivity(String className) {
        Log.d("bruce", "finishOtherActivity: " + className);
        Iterator<Activity> iterator = mActivity.iterator();
        while (iterator.hasNext()) {
            Activity a = iterator.next();
            if (!a.getClass().getName().equals(className)) {
                a.finish();
                iterator.remove();
            }
        }
    }

    public void finishNowActivity(String className) {
        Log.d("bruce", "finishOtherActivity: " + className);
        Iterator<Activity> iterator = mActivity.iterator();
        while (iterator.hasNext()) {
            Activity a = iterator.next();
            if (a.getClass().getName().equals(className)) {
                a.finish();
                iterator.remove();
            }
        }
    }

    public static String convertIconToString(Bitmap bitmap)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();// outputstream
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] appicon = baos.toByteArray();// 转为byte数组
        return Base64.encodeToString(appicon, Base64.DEFAULT);

    }


    //隐藏虚拟按键
    public static void hideNavKey(Context context) {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = ((Activity) context).getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = ((Activity) context).getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    //设置状态栏透明
    public static void setStatusBarTransparent(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = ((Activity) context).getWindow().getDecorView();
            decorView.setOnApplyWindowInsetsListener((v, insets) -> {
                WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                return defaultInsets.replaceSystemWindowInsets(
                        defaultInsets.getSystemWindowInsetLeft(),
                        0,
                        defaultInsets.getSystemWindowInsetRight(),
                        defaultInsets.getSystemWindowInsetBottom());
            });
            ViewCompat.requestApplyInsets(decorView);
            ((Activity) context).getWindow().setStatusBarColor(ContextCompat.getColor(context, android.R.color.transparent));
        }
    }



}
