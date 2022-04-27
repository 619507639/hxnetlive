package com.hxinternet.hxtalk.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.hxinternet.hxtalk.ui.Dialog.CallSettingDialog
import kotlinx.android.synthetic.main.activity_caller.*

/**
 * 呼叫方
 */
class CalledActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return  R.layout.activity_called;
    }

    override fun onCreate() {
        super.onCreate()
        img_setting.setOnClickListener{
            //设置弹框
            CallSettingDialog(this@CalledActivity).show()
        }
    }
}