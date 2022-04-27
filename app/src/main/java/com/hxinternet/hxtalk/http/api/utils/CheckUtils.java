package com.hxinternet.hxtalk.http.api.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create time: 2021/1/28
 * author: wd
 * description:
 */
public class CheckUtils {

    private static CheckUtils mInstance;

    private CheckUtils() {
    }

    public static CheckUtils getInstance() {
        if (mInstance == null) {
            synchronized (CheckUtils.class) {
                if (mInstance == null) {
                    mInstance = new CheckUtils();
                }
            }
        }
        return mInstance;
    }

    /***
     * 手机号正则
     */
    public boolean authPhone(String phone) {
        String str = "^1[0-9]{10}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
