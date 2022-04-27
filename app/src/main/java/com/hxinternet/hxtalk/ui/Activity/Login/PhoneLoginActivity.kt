package com.hxinternet.hxtalk.ui.Activity.Login

import android.content.Intent
import androidx.core.widget.addTextChangedListener
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.http.RetrofitWrapper
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_phone_login.*
import kotlinx.android.synthetic.main.base_title.*

/**
 * 手机号登录
 */
class PhoneLoginActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
       return R.layout.activity_phone_login
    }

    override fun onCreate() {
        super.onCreate()


        rl_next.setOnClickListener{
            when(intent.getStringExtra("logintype"))
            {
                RetrofitWrapper.Constant.FACEBOOK->{
                    startActivity(Intent(this@PhoneLoginActivity, CodeLoginActivity::class.java))
                }
                RetrofitWrapper.Constant.GOOGLE->{
                    startActivity(Intent(this@PhoneLoginActivity, InputPasswordActivity::class.java))
                }
            }
        }

        etxt_phone.addTextChangedListener {
            if(it?.length==6)
            {
                rl_next?.background=resources.getDrawable(R.drawable.agreement_agree)
            }else{
                rl_next?.background=resources.getDrawable(R.drawable.agreement_unagree)
            }
        }

        img_back.setOnClickListener{
            finish()
        }
    }

}