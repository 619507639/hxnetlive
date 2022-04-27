package com.hxinternet.hxtalk.http.api.bean.base;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * create time: 2021/1/28
 * author: wd
 * description:
 */
public class BaseNoEmptyBean implements Serializable {

    public String retString(String key) {
        return !TextUtils.isEmpty(key) ? key : "";
    }
}
