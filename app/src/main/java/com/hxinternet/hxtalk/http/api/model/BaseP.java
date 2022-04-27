package com.hxinternet.hxtalk.http.api.model;

/**
 * create time: 2021/1/28
 * author: bruce
 * description:
 */
public interface BaseP {

    void onNetworkDisable();

    void onVerification(String msg);

    void onLoading();

    void onReLogin();

    void onError(String code, String msg);

    void onFailure(String msg);

    void onFinish();

}
