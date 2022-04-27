package com.hxinternet.hxtalk.ui.Banner;

import android.content.Context;

import com.hxinternet.hxtalk.utils.Glide.GlideManager;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

/**
 * @ClassName BannerLoad
 * @Author wd
 * @Date 2022/4/25
 * @Description
 */
public class BannerLoad {


    public static void load(Banner banner, Context mcontext, List<String> list)
    {
        banner.setAdapter(new BannerImageAdapter<String>(list) {

            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                System.out.println("hello TEST");
                GlideManager.getInstance().loadImgAnim(mcontext,list.get(position), holder.imageView);
            }

        }).setIndicator(new CircleIndicator(mcontext)).stop();
    }
}
