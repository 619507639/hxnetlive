package com.hxinternet.hxtalk.utils.Log;

import android.text.TextUtils;
import android.util.Log;

/**
 * create time: 2021/1/28
 * author: bruce
 * description:
 */
public class LogUtils {

    public static boolean DEBUG = true;

    private static final int MAX_LENGTH = 3900;

    public static final String TAG = "gtt_tag";

    public static void d(String TAG, String msg) {
        if (!DEBUG) {
            return;
        }
        if (TextUtils.isEmpty(msg)) {
            Log.d(TAG, "log信息为空");
        } else {
            String content = msg;
            if (content.length() > MAX_LENGTH) {
                while (content.length() > MAX_LENGTH ) {
                    String logContent = content.substring(0, MAX_LENGTH);
                    content = content.replace(logContent, "");
                    Log.d(TAG, logContent);
                }
                Log.d(TAG, content);
            } else {
                Log.d(TAG, content);
            }
        }
    }
}
