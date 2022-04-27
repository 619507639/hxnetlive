package com.hxinternet.hxtalk.ui.Activity.Login

import android.content.Intent
import android.os.CountDownTimer
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_code_login.*
import kotlinx.android.synthetic.main.base_title.*

/**
 * 输入验证码登录
 */

class CodeLoginActivity : BaseAppCompatActivity() {

    lateinit var mCountDownTimer : CountDownTimer

    override fun onCreate() {
        super.onCreate()
        rl_next.setOnClickListener{
            startActivity(Intent(this@CodeLoginActivity, SetPasswordActivity::class.java))
        }
        img_back.setOnClickListener{
            finish()
        }
        mCountDownTimer=object : CountDownTimer(60000,1000){
            override fun onTick(p0: Long) {
                recount_code.text=(p0/1000).toString()+"s"
            }
            override fun onFinish() {
            }
        }

        mCountDownTimer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountDownTimer.cancel()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_code_login
    }
}