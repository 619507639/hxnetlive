package com.hxinternet.hxtalk.ui.Activity

import android.content.Intent
import android.view.WindowManager
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Activity.Login.LoginActivity
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.hxinternet.hxtalk.utils.Activity.ActivityManager
import com.hxinternet.hxtalk.utils.LanguageUtils.InternationalUtil
import java.util.*
import kotlin.concurrent.schedule

class LaunchActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
        ActivityManager.hideNavKey(this)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return  R.layout.activity_launch
    }

    override fun onCreate() {
        super.onCreate()
        //获取相关国际化信息
        InternationalUtil.changeAppLanguage(this@LaunchActivity, Locale.CHINA)
        //判断用户是否登录
        Timer().schedule(1000){
            finish()
            startActivity(Intent(this@LaunchActivity, LoginActivity::class.java))
        }
//
    }








}