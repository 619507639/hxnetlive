package com.hxinternet.hxtalk.ui.Fragment

import com.hxinternet.hxtalk.R
import kotlinx.android.synthetic.main.fragment_talk.*

/**
 *@ClassName TalkFragment
 *@Author wd
 *@Date 2022/4/22
 *@Description
 */
class TalkFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_talk
    }

    override fun onCreateView() {
        super.onCreateView()
        txt_hx.text="IM界面"
    }
}