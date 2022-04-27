package com.hxinternet.hxtalk.http.api.service;


import com.hxinternet.hxtalk.http.api.bean.base.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * create time: 2021/1/30
 * author: wd
 * description: 接口
 */
public interface AllService {


    //首页
    @GET("app/index")
    Observable<BaseBean> appMain();

//    //获取验证码
//    @POST("app/login/code")
//    Observable<Login_AuthCodeBean> getAuthCode(@Body Login_AuthCodeParam authCodeParam);
//
//    //手机验证码登录
//    @POST("app/login")
//    Observable<Login_PhoneBean> loginPhone(@Body Login_PhoneParam phoneParam);
//
//    //微信登录
//    @GET("app/wechat/login")
//    Observable<Login_WxBean> loginWx(@Query("code") String code);

}
