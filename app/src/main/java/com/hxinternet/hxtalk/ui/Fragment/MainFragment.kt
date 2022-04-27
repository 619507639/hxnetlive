package com.hxinternet.hxtalk.ui.Fragment

import androidx.recyclerview.widget.GridLayoutManager
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Adapter.AnchorItemAdapter
import com.hxinternet.hxtalk.ui.Adapter.Recommand_AnchorItemAdapter
import com.hxinternet.hxtalk.ui.Banner.BannerLoad
import com.hxinternet.hxtalk.utils.Activity.ActivityManager
import kotlinx.android.synthetic.main.activity_anchor_detail.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.banner
import java.util.*
import kotlin.concurrent.schedule

/**
 *@ClassName Mainfragment
 *@Author wd
 *@Date 2022/4/22
 *@Description 首页
 */
class MainFragment :BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    lateinit var AnchorAdapter:AnchorItemAdapter
    lateinit var mRecommand_AnchorItemAdapter: Recommand_AnchorItemAdapter
    lateinit var command_gridlayoutmanager:GridLayoutManager
    lateinit var gridlayoutmanager: GridLayoutManager

    //轮播
    var ImageList = arrayListOf<String>("https://img1.baidu.com/it/u=978590908,3139882285&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750",
        "https://img0.baidu.com/it/u=3784738455,2043719400&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500",
        "https://img2.baidu.com/it/u=294067899,3835331763&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750",
        "https://img1.baidu.com/it/u=4231145582,3608685825&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500")

    override fun onCreateView() {
        super.onCreateView()
        mRecommand_AnchorItemAdapter=Recommand_AnchorItemAdapter(context)
        command_gridlayoutmanager= GridLayoutManager(context,2)
        rec_recommand_anchor.layoutManager=command_gridlayoutmanager
        rec_recommand_anchor.adapter=mRecommand_AnchorItemAdapter

        AnchorAdapter=AnchorItemAdapter(context)
        gridlayoutmanager= GridLayoutManager(context,2)
        rec_anchor.layoutManager=gridlayoutmanager
        rec_anchor.adapter=AnchorAdapter


        smart_layout.setOnLoadMoreListener{
            Timer().schedule(2000) {
                smart_layout.finishLoadMore()
            }
        }

        smart_layout.setOnRefreshListener{
            Timer().schedule(2000) {
                smart_layout.finishRefresh()
            }
        }

        banner.setDatas(ImageList!! as List<Nothing>?)
        BannerLoad.load(banner,context,ImageList)

    }
}