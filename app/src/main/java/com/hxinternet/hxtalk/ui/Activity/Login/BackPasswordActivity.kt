package com.hxinternet.hxtalk.ui.Activity.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.base_title.*

/**
 * 密码找回
 */

class BackPasswordActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_back_password
    }

    override fun onCreate() {
        super.onCreate()
        txt_title.text=getString(R.string.back_password_title)
        img_title.visibility= View.GONE
        img_back.setOnClickListener{
            finish()
        }
    }

}