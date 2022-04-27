package com.hxinternet.hxtalk.http.api.persenter;


import com.hxinternet.hxtalk.http.api.persenter.base.BaseP;

/**
 * create time: 2021/2/24
 * author: wd
 * description:
 */
public interface WxLoginP extends BaseP {

    void onWxLogin(String code);
}
