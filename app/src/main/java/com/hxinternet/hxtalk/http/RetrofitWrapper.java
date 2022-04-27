package com.hxinternet.hxtalk.http;



import com.hxinternet.hxtalk.http.api.interceptor.HeadInterceptor;
import com.hxinternet.hxtalk.http.api.utils.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitWrapper {
    private static RetrofitWrapper instance;
    private OkHttpClient okHttpClient;
    private Retrofit mRetrofit;
    public RetrofitWrapper() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new LogInterceptor())
                .followRedirects(true)
                .addInterceptor(new HeadInterceptor())
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetrofitWrapper getInstance() {
        if (instance == null) {
            synchronized (RetrofitWrapper.class) {
                if (instance == null) {
                    instance = new RetrofitWrapper();
                }
            }
        }
        return instance;
    }
    /**
     * 转换为对象的Service
     *
     * @param service
     * @param <T>
     * @return
     */

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }


    public class Constant {

//        public static final String BASE_URL = "http://10.10.16.148:8088";

        public static final String BASE_URL = "https://dev-api.hzglmf.cn/";

//        public static final String BASE_URL = "https://api.hzgoujingxi.com/";

        public static final String BASE_IMG_URL = "https://image.hzglmf.cn/";

        //隐私协议
        public static final String PRIVACY_POLICY = "https://h5.hzglmf.cn/#/agreementV2";
        //用户协议
        public static final String USER_AGREEMENT = "https://h5.hzglmf.cn/#/privacyV2";


        public static final String FACEBOOK="FACEBOOK";
        public static final String GOOGLE="GOOGLE";

    }
}
