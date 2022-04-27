package com.hxinternet.hxtalk.ui.Activity

import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.hxinternet.hxtalk.ui.Fragment.MainFragment
import com.hxinternet.hxtalk.ui.Fragment.MeFragment
import com.hxinternet.hxtalk.ui.Fragment.TalkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseAppCompatActivity() {


    var mMainFragment:MainFragment?=null
    var mTalkFragment:TalkFragment?=null
    var mMeFragment:MeFragment?=null
    lateinit var fragmentTransaction :FragmentTransaction

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }
    override fun onCreate() {

        initCenterView()
//        nav_view?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun initCenterView() {
        mMainFragment = MainFragment()
        mTalkFragment= TalkFragment()
        mMeFragment= MeFragment()
        fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.center_view, mMainFragment!!)
        fragmentTransaction.add(R.id.center_view, mTalkFragment!!)
        fragmentTransaction.add(R.id.center_view, mMeFragment!!)
        fragmentTransaction.commit()
        showCenterView(mMainFragment!!);
    }

    private fun showCenterView(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.show(fragment)
        if (fragment is MainFragment) {
            fragmentTransaction.hide(mTalkFragment!!)
            fragmentTransaction.hide(mMeFragment!!)
        } else if (fragment is TalkFragment) {
            fragmentTransaction.hide(mMainFragment!!)
            fragmentTransaction.hide(mMeFragment!!)
        } else if (fragment is MeFragment) {
            fragmentTransaction.hide(mMainFragment!!)
            fragmentTransaction.hide(mTalkFragment!!)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            Log.e("当前选中", item.itemId.toString() + "")
            Log.e("主id",  mMainFragment?.id.toString())
            Log.e("talkid",  mTalkFragment?.id.toString())
            Log.e("meid",  mMeFragment?.id.toString())
            when (item.itemId) {
                R.id.navigation_home ->{
                    showCenterView(mMainFragment!!)
                }
                R.id.navigation_talk ->{
                    showCenterView(mTalkFragment!!)
                }
                R.id.navigation_myself ->{
                    showCenterView(mMeFragment!!)
                }
            }
            true
        }


    var firstTime:Long=0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val secondTime = System.currentTimeMillis()
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                finish()
            } else {
                Toast.makeText(this,getString(R.string.main_back),Toast.LENGTH_SHORT)
                firstTime = System.currentTimeMillis()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}