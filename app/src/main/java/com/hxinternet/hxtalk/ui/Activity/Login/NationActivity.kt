package com.hxinternet.hxtalk.ui.Activity.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Adapter.ChoseContainAdapter
import com.hxinternet.hxtalk.ui.Adapter.RankAdapter
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_nation.*

class NationActivity : BaseAppCompatActivity() {



    override fun getLayoutId(): Int {
        return R.layout.activity_nation
    }

    lateinit var choseContain: ChoseContainAdapter
    lateinit var linelayout:LinearLayoutManager

    lateinit var rankAdapter: RankAdapter
    lateinit var rank_linelayout:LinearLayoutManager


    override fun onCreate() {
        super.onCreate()
        choseContain=ChoseContainAdapter(this)
        linelayout=LinearLayoutManager(this)
        linelayout.orientation=LinearLayoutManager.VERTICAL

        rec_contain.layoutManager=linelayout
        rec_contain.adapter=choseContain

        rankAdapter= RankAdapter(this)
        rank_linelayout=LinearLayoutManager(this)
        linelayout.orientation=LinearLayoutManager.VERTICAL

        rec_rank.layoutManager=rank_linelayout
        rec_rank.adapter=rankAdapter

        img_back.setOnClickListener{
            finish()
        }

    }

}