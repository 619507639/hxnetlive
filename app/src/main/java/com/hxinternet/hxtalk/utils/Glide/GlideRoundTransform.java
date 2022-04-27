package com.hxinternet.hxtalk.utils.Glide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by AED on 2017/9/13.
 */

public class GlideRoundTransform extends BitmapTransformation {

    private static float radius = 0f;

    public static int ROUND_POSITION = 0;

    public static final int TOP_ROUND = 1;

    public GlideRoundTransform(Context context) {
        this(context, 6);
    }

    public GlideRoundTransform(Context context, int dp) {
        super(context);
        this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }

    public GlideRoundTransform(Context context, int dp, int roundPosition) {
        super(context);
        this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
        this.ROUND_POSITION = TOP_ROUND;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool, toTransform);
    }

    private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        if (ROUND_POSITION == TOP_ROUND) {
           /* RectF rectF = new RectF(0, source.getHeight() - 2 * radius, source.getWidth(), source.getWidth());
            canvas.drawRoundRect(rectF, radius, radius, paint);*/

            canvas.drawRoundRect(new RectF(0, 0, source.getWidth(), 2 * radius), radius, radius, paint);
            canvas.drawRect(new RectF(0, radius, source.getWidth(), source.getWidth()), paint);

            /*canvas.drawRoundRect(new RectF(0, 0, source.getWidth(), radius * 2), source.getWidth(), radius, paint);

            canvas.drawRect(new RectF(0, radius, source.getWidth(), source.getHeight()), paint);*/
        } else {
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
        }
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }

}
