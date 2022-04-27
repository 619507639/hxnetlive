package com.hxinternet.hxtalk.utils.View;

import android.view.View;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.hxinternet.hxtalk.R;


//防抖动
public class AntiShakeUtils {

    private final static long INTERNAL_TIME = 1000;

    public static boolean isInvalidClick(@NonNull View target) {
        return isInvalidClick(target, INTERNAL_TIME);
    }


    public static boolean isInvalidClick(@NonNull View target, @IntRange(from = 0) long internalTime) {
        long curTimeStamp = System.currentTimeMillis();
        long lastClickTimeStamp = 0;
        Object time = target.getTag(R.id.last_click_time);
        if (time == null){
            target.setTag(R.id.last_click_time, curTimeStamp);
            return false;
        }
        lastClickTimeStamp = (Long) time;
        boolean isInvalid = curTimeStamp - lastClickTimeStamp < internalTime;
        if (!isInvalid)
            target.setTag(R.id.last_click_time, curTimeStamp);
        return isInvalid;
    }

}
