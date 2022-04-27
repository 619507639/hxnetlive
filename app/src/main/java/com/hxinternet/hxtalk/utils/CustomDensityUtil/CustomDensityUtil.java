package com.hxinternet.hxtalk.utils.CustomDensityUtil;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * @ClassName CustomDensityUtil
 * @Author wd
 * @Date 2022/4/23
 * @Description
 */
public class CustomDensityUtil {
    private static float sNoncompatDensity;
    private static float sNoncompatScaledDensity;
    //通过资源文件getResources类获取DisplayMetrics
    public static void setCustomDensity(Activity activity, final Application application) {
        //通过资源文件getResources类获取DisplayMetrics
        DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
        if (sNoncompatDensity == 0) {
            //保存之前density值
            sNoncompatDensity = appDisplayMetrics.density;
            //保存之前scaledDensity值，scaledDensity为字体的缩放因子，正常情况下和density相等，但是调节系统字体大小后会改变这个值
            sNoncompatScaledDensity = appDisplayMetrics.scaledDensity;
            //监听设备系统字体切换
            application.registerComponentCallbacks(new ComponentCallbacks() {

                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        //调节系统字体大小后改变的值
                        sNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                public void onLowMemory() {

                }
            });
        }

        //获取以设计图总宽度360dp下的density值
        float targetDensity = appDisplayMetrics.widthPixels / 360;
        //通过计算之前scaledDensity和density的比获得scaledDensity值
        float targetScaleDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
        //获取以设计图总宽度360dp下的dpi值
        int targetDensityDpi = (int) (160 * targetDensity);
        //设置系统density值
        appDisplayMetrics.density = targetDensity;
        //设置系统scaledDensity值
        appDisplayMetrics.scaledDensity = targetScaleDensity;
        //设置系统densityDpi值
        appDisplayMetrics.densityDpi = targetDensityDpi;

        //获取当前activity的DisplayMetrics
        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        //设置当前activity的density值
        activityDisplayMetrics.density = targetDensity;
        //设置当前activity的scaledDensity值
        activityDisplayMetrics.scaledDensity = targetScaleDensity;
        //设置当前activity的densityDpi值
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }
}
