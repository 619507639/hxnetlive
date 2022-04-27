package com.hxinternet.hxtalk.utils.LanguageUtils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * @ClassName InternationalUtil
 * @Author wd
 * @Date 2022/4/21
 * @Description  国际化语音切换
 */
public class InternationalUtil {
    /**
     * 更改应用语言
     *
     * @param locale
     */
    public static void changeAppLanguage(Context context,Locale locale) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        context.getResources().updateConfiguration(configuration, metrics);
        //重新启动Activity
    }

    //切换语言
    public static void switchLanguage(Context context, Locale locale)
    {
        Resources res=context.getApplicationContext().getResources();
        DisplayMetrics dm=res.getDisplayMetrics();
        Configuration conf=res.getConfiguration();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            conf.setLocale(locale);
            LocaleList localeList=new LocaleList(locale);
            localeList.setDefault(localeList);
            conf.setLocale(locale);
        }else
        {
            conf.setLocale(locale);
        }

        res.updateConfiguration(conf,dm);
    }


    //获取当前屏幕语言
    public static String getDefaultLanguage(Context context)
    {
        Resources resources=context.getResources();
        Configuration configuration=resources.getConfiguration();
        Locale contextlocal =configuration.locale;
        return contextlocal.toString();
    }

}
