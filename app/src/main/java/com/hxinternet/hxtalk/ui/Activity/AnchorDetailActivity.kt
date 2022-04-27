package com.hxinternet.hxtalk.ui.Activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.hxinternet.hxtalk.R
import com.hxinternet.hxtalk.ui.Adapter.AnchorPointAdapter
import com.hxinternet.hxtalk.ui.Base.BaseAppCompatActivity
import com.hxinternet.hxtalk.utils.Activity.ActivityManager
import com.hxinternet.hxtalk.utils.Glide.GlideManager
import kotlinx.android.synthetic.main.activity_anchor_detail.*
import kotlinx.android.synthetic.main.anchor_title.*

/**
 * 主播详情
 */
class AnchorDetailActivity : BaseAppCompatActivity() {

    override fun getLayoutId(): Int {
        ActivityManager.hideNavKey(this)
        return  R.layout.activity_anchor_detail
    }

    var listview = arrayListOf<View>()
    var listImage= arrayListOf<String>()
    lateinit var linelayoutmanage:LinearLayoutManager
    lateinit var pointAdapter :AnchorPointAdapter

    override fun onCreate() {
        super.onCreate()
        listImage.add("https://img1.baidu.com/it/u=978590908,3139882285&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750")
        listImage.add("https://img0.baidu.com/it/u=3784738455,2043719400&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500")
        listImage.add("https://img2.baidu.com/it/u=294067899,3835331763&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=750")
        listImage.add("https://img1.baidu.com/it/u=4231145582,3608685825&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500")
        setImageList(listImage)

        linelayoutmanage= LinearLayoutManager(this).apply {
            orientation=LinearLayoutManager.HORIZONTAL
        }
        pointAdapter= AnchorPointAdapter(this)
        rec_point.layoutManager=linelayoutmanage
        rec_point.adapter=pointAdapter


        img_back.setOnClickListener{
            finish()
        }
    }




    //设置轮播图片
    fun setImageList(imgUrls: List<String?>)
    {

        for (k in listImage.indices) {
            val view: View = LayoutInflater.from(this).inflate(R.layout.item_image, null)
            val img_shoptalk = view.findViewById<ImageView>(R.id.item_anchor)
            GlideManager.getInstance().loadImgAnim(
                this,
                imgUrls.get(k),
                img_shoptalk
            )
            listview.add(view)
        }

        viewpager.adapter = object : PagerAdapter() {
            override fun getCount(): Int {
                return imgUrls.size
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view === `object`
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                container.addView(listview.get(position))
                return listview.get(position)
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(listview.get(position))
            }
        }
    }

}