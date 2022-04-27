package com.hxinternet.hxtalk.ui.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hxinternet.hxtalk.utils.Activity.ActivityManager;
import com.hxinternet.hxtalk.utils.Eventbus.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import me.jessyan.autosize.internal.CustomAdapt;

public abstract class BaseAppCompatActivity extends AppCompatActivity implements CustomAdapt {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.setStatusBarTransparent(this);
        setContentView(getLayoutId());
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
        ActivityManager.getInstance().addActivity(this);
        onCreate();
        initView();
        initNetData();
    }

    protected abstract int getLayoutId();

    protected void onCreate(){}

    protected void initView(){}

    protected void initNetData(){}

    @Override
    protected void onDestroy() {
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
        ActivityManager.getInstance().removeActivity(this);
        super.onDestroy();
    }


    @Override
    public boolean isBaseOnWidth() {
        return true;
    }

    //设置宽高转化比
    @Override
    public float getSizeInDp() {
        return 376;
    }

}
