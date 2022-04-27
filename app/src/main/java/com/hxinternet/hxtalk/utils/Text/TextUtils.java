package com.hxinternet.hxtalk.utils.Text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create time: 2021/3/8
 * author: wd
 * description:
 */
public class TextUtils {

    private static TextUtils instance;

    private ClipboardManager clipboardManager;

    private ClipData clipData;

    public static TextUtils getInstance() {
        if (instance == null) {
            synchronized (TextUtils.class) {
                if (instance == null) {
                    instance = new TextUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 复制到剪贴板
     * @param context
     * @param str
     */
    public void putTextIntoClip(Context context, String str) {
        if (clipboardManager == null) {
            clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        }
        clipData = ClipData.newPlainText("copy Params", str);
        clipboardManager.setPrimaryClip(clipData);
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
