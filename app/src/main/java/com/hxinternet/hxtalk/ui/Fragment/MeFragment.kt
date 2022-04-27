package com.hxinternet.hxtalk.ui.Fragment

import com.hxinternet.hxtalk.R
import kotlinx.android.synthetic.main.fragment_me.*

/**
 *@ClassName MeFragment
 *@Author wd
 *@Date 2022/4/22
 *@Description
 */
class MeFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }

    override fun onCreateView() {
        super.onCreateView()
        txt_hx.text="个人中心"
    }
}