package com.hxinternet.hxtalk.ui.Activity.Login

import android.content.Intent
import android.view.View
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_set_password.*
import kotlinx.android.synthetic.main.base_title.*

/**
 * 设置登录密码
 */
class SetPasswordActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_set_password
    }

    override fun onCreate() {
        super.onCreate()
        txt_title.text=getString(R.string.set_password_title)
        img_title.visibility= View.GONE
        img_back.setOnClickListener{
            finish()
        }
        rl_agree.setOnClickListener{
            startActivity(Intent(this@SetPasswordActivity, RegisterDataActivity::class.java))
        }
    }

}