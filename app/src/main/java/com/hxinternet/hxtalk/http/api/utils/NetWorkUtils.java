package com.hxinternet.hxtalk.http.api.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetWorkUtils {

    private static Context mContext;

    private static NetWorkUtils mInstance;

    public NetWorkUtils() {
    }

    public static NetWorkUtils getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkUtils.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkUtils();
                }
            }
        }
        return mInstance;
    }

    public void init(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 检查网络是否连接
     * context 全局context
     *
     * @return true 已连接 false 未连接
     */
    public static Boolean checkNetworkConnect() {
        if (mContext != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) mContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }

        return false;
    }
}
