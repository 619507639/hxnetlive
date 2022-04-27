package com.hxinternet.hxtalk

import android.app.Application
import com.hxinternet.hxtalk.http.api.utils.NetWorkUtils

class Myapplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        NetWorkUtils().init(this)
        onLanguageChange()
    }
    fun onLanguageChange() {
        //       AppLanguageUtils.changeAppLanguage(this, AppLanguageUtils.getSupportLanguage(getAppLanguage(this)));
    }


}