package com.hxinternet.hxtalk.ui.Activity.Login

import android.content.Intent
import android.view.View
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Activity.MainActivity
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.loper7.date_time_picker.DateTimeConfig
import kotlinx.android.synthetic.main.activity_register_data.*
import kotlinx.android.synthetic.main.base_title.*

/**
 * 注册信息填写
 */

class RegisterDataActivity : BaseAppCompatActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_register_data
    }

    override fun onCreate() {
        super.onCreate()
        img_title.visibility= View.GONE
        txt_title.text=getString(R.string.sex)
        data_timer.let {
            it.setDisplayType(intArrayOf(
                DateTimeConfig.MONTH,//显示月
                DateTimeConfig.DAY,//显示日
                DateTimeConfig.YEAR,//显示年
            ))
            it.showLabel(false)

            rl_continue.setOnClickListener{
                startActivity(Intent(this@RegisterDataActivity, MainActivity::class.java))
            }
        }
    }
}