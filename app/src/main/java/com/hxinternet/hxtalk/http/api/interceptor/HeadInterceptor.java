package com.hxinternet.hxtalk.http.api.interceptor;

import android.content.Context;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * create time: 2021/1/28
 * author: wd
 * description:
 */
public class HeadInterceptor implements Interceptor {

    public static Context mContext;

    private static String DEVICE = "android";



    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("version", PackageUtils.getInstance().packageName(mContext))
//                        .build();
        return chain.proceed(request);
    }

}
