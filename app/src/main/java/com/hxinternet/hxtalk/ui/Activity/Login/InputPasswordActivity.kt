package com.hxinternet.hxtalk.ui.Activity.Login

import android.content.Intent
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_input_password2.*
import kotlinx.android.synthetic.main.base_title.*

/**
 * 输入密码登录
 */
class InputPasswordActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_input_password2
    }

    override fun onCreate() {
        super.onCreate()
        txt_forget.setOnClickListener{
            startActivity(Intent(this@InputPasswordActivity, BackPasswordActivity::class.java))
        }
        img_back.setOnClickListener{
            finish()
        }
    }
}