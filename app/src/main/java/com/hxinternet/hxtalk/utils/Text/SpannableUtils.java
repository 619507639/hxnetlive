package com.hxinternet.hxtalk.utils.Text;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

public class SpannableUtils {

    private static SpannableUtils mInstance;

    public static SpannableUtils getInstance() {
        if (mInstance == null) {
            synchronized (SpannableUtils.class) {
                if (mInstance == null) {
                    mInstance = new SpannableUtils();
                }
            }
        }
        return mInstance;
    }

    public SpannableStringBuilder setForegroundColorSpan(String text,int color,int start,int end){
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        spannable.setSpan(new ForegroundColorSpan(color),start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    public SpannableStringBuilder setAbsoluteSizeSpan(String text,int size,int start,int end){
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        spannable.setSpan(new AbsoluteSizeSpan(size),start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    public SpannableStringBuilder setTimeBackgroundColorSpan(String text,int color,int start,int end){
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        spannable.setSpan(new BackgroundColorSpan(color),start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}
