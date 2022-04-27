package com.hxinternet.hxtalk.http.api.utils;


import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okio.Buffer;

/**
 * @创建者:李祥
 * @创建日期： 2019/7/23 10:38
 * @类说明：网络请求输入日志
 */
public class LogInterceptor implements Interceptor {

    public static String TAG = "LogInterceptor";


    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        okhttp3.Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Log.e("返回数据", "----------Start----------------");
        Log.e("返回数据", "| " + request.toString());
        String method = request.method();
        if ("POST".equals(method)) {
            Log.e("返回数据", "| RequestBody:" + bodyToString(request));
        }
        Log.e("返回数据", "| Response:" + content);
        Log.e("返回数据", "----------End:" + duration + "毫秒----------");
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }

    private String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (copy.body() == null) {
                return "get------------";
            }
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
