package com.hxinternet.hxtalk.utils.Glide;


import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hxinternet.hxtalk.R;

/**
 * Glide 工具类
 */
public class GlideManager  {

    private static GlideManager mInstance;

    private GlideManager() {
    }

    public static GlideManager getInstance() {
        if (mInstance == null) {
            synchronized (GlideManager.class) {
                if (mInstance == null) {
                    mInstance = new GlideManager();
                }
            }
        }
        return mInstance;
    }

    /***
     * 加载图片显示默认动画
     * 淡入淡出
     * @param context
     * @param url
     * @param imageView
     */
    public void loadImgCacheAnim(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .error(R.mipmap.logo)
                .override(250,250)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /***
     * 加载图片显示默认动画
     * 淡入淡出
     * @param context
     * @param url
     * @param imageView
     */
    public void loadImgAnim(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .error(R.mipmap.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /***
     * 缓存加载 圆角图片
     * @param context
     * @param url
     * @param mImageView
     */
    public void loadRoundCacheImg(Context context, String url, ImageView mImageView) {
        Glide.with(context)
                .load(url)
                .error(R.mipmap.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new GlideRoundTransform(context))
                .into(mImageView);
    }

    /***
     * 缓存 加载圆形图片
     * @param activity
     * @param url
     * @param mImageView
     */
    public void loadCircleCache_Img(Activity activity, String url, ImageView mImageView) {
        Glide.with(activity)
                .load(url)
                .placeholder(R.mipmap.logo)
                .error(R.mipmap.logo)
                .override(100,100)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new GlideCircleTransform(activity))
                .into(mImageView);
    }

    /***
     * 缓存 加载圆形图片
     * @param activity
     * @param url
     * @param mImageView
     */
    public void loadCircleCacheImg(Activity activity, String url, ImageView mImageView) {
        Glide.with(activity)
                .load(url)
                .placeholder(R.mipmap.logo)
                .error(R.mipmap.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new GlideCircleTransform(activity))
                .into(mImageView);
    }

    /***
     * 缓存 加载圆形图片
     * @param activity
     * @param url
     * @param mImageView
     */
    public void loadCircleCacheImgAdd(Activity activity, String url, ImageView mImageView) {
        Glide.with(activity)
                .load(url)
                .placeholder(R.mipmap.logo)
                .error(R.mipmap.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new GlideCircleTransform(activity))
                .into(mImageView);
    }

}
