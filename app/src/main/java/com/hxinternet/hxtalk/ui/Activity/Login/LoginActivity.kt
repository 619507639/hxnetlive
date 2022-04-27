package com.hxinternet.hxtalk.ui.Activity.Login

import android.content.Intent
import android.graphics.Paint
import android.telecom.Call
import android.view.View
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.http.RetrofitWrapper
import com.hxinternet.hxtalk.ui.Activity.AnchorDetailActivity
import com.hxinternet.hxtalk.ui.Activity.CalledActivity
import com.hxinternet.hxtalk.ui.Activity.CallerActivity
import com.hxinternet.hxtalk.ui.Activity.MainActivity
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.hxinternet.hxtalk.ui.Dialog.UserAgreementDialog
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 登录首页
 */
class LoginActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {

        return R.layout.activity_login
    }

    override fun onCreate() {
        super.onCreate()

        line_priuser.setOnClickListener {
            UserAgreementDialog(this).show()
        }

        txt_more.setOnClickListener {
            rl_phone.visibility= View.VISIBLE
            it.visibility=View.GONE
        }

        rl_facebook.setOnClickListener {
            startActivity(Intent(this@LoginActivity, NationActivity::class.java).let {
                it.putExtra("logintype", RetrofitWrapper.Constant.FACEBOOK)
            })
        }

        rl_google.setOnClickListener {
            startActivity(Intent(this@LoginActivity, PhoneLoginActivity::class.java).let {
                it.putExtra("logintype", RetrofitWrapper.Constant.GOOGLE)
            })
        }

        txt_pripolicy.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        txt_useragreement.paintFlags = Paint.UNDERLINE_TEXT_FLAG

    }
    override fun onDestroy() {
        super.onDestroy()
    }
}