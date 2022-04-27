package com.hxinternet.hxtalk.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.hxinternet.hxtalk.ui.Dialog.CallSettingDialog
import com.hxinternet.hxtalk.ui.Dialog.EndTalkDialog
import com.hxinternet.hxtalk.utils.Activity.KeyBoardListenerHelper
import kotlinx.android.synthetic.main.activity_caller.*

/**
 * 呼叫方
 */
class CallerActivity : BaseAppCompatActivity() {
    override fun getLayoutId(): Int {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return  R.layout.activity_caller;
    }
    override fun onCreate() {
        super.onCreate()
        img_setting.setOnClickListener{
            //设置弹框
        }
        KeyBoardListenerHelper(this).setOnKeyBoardChangeListener {
                isShow, keyBoardHeight ->
            //键盘监听
            Log.e("isShow",isShow.toString()+"keyboarheight"+keyBoardHeight)
        }
        img_setting.setOnClickListener{
            EndTalkDialog(this@CallerActivity).show()
        }
    }
}