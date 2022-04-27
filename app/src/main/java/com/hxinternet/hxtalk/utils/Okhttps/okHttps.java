package com.hxinternet.hxtalk.utils.Okhttps;

import android.text.TextUtils;

import com.hxinternet.hxtalk.http.RetrofitWrapper;
import com.hxinternet.hxtalk.http.api.bean.base.BaseBean;
import com.hxinternet.hxtalk.http.api.model.BackBeanBeanP;
import com.hxinternet.hxtalk.http.api.service.AllService;
import com.hxinternet.hxtalk.http.api.utils.HttpStatueUtils;
import com.hxinternet.hxtalk.http.api.utils.NetWorkUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName okHttps
 * @Author wd
 * @Date 2022/4/20
 * @Description
 */
public class okHttps {

    static AllService allService=null;
    public static void BaseHttpUrlConnect(BackBeanBeanP lotteryP) {
        if (!NetWorkUtils.getInstance().checkNetworkConnect()) {
            lotteryP.onNetworkDisable();
            return;
        }
        if(allService==null)
        {
            allService = RetrofitWrapper.getInstance().create(AllService.class);
        }
        lotteryP.onLoading();
        allService.appMain()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(BaseBean lotteryBean) {
                        if (lotteryBean != null) {
                            if (HttpStatueUtils.SUCCESS.equals(lotteryBean.getStatus())) {
                                lotteryP.onSuccess(lotteryBean);
                            } else {
                                lotteryP.onError(lotteryBean.getStatus(), lotteryBean.getMsg());
                            }
                        } else {
                            lotteryP.onError(HttpStatueUtils.NULL, HttpStatueUtils.NULL);
                        }
                        lotteryP.onFinish();
                    }
                    @Override
                    public void onError(Throwable e) {
                        lotteryP.onFailure(TextUtils.isEmpty(e.getMessage()) ? "" : e.getMessage());
                        lotteryP.onFinish();
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
}
