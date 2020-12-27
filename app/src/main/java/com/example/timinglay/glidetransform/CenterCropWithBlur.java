package com.example.timinglay.glidetransform;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

import java.security.MessageDigest;

/**
 * 描述:
 * demoone-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-16 12:21
 */

public class CenterCropWithBlur extends BitmapTransformation {

    public    float radius ;
    private static final String IDD = ".RoundCornorWithBlur";
    Context context;

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof CenterCrop) &&(this.radius ==( radius)) ;
    }

    @Override
    public int hashCode() {
        return IDD.hashCode();
    }



    public CenterCropWithBlur(Context context, float radius) {
        this.context= context;
        this.radius=radius;

    }

    @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        if (toTransform == null) {
            return null;
        }
        //Bitmap result = pool.get(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        //   * <p>If no Bitmap with the requested attributes is present in the pool, a new one will be
        //   * allocated.
        // toTransform.setConfig(new Bitmap.Config());

        Bitmap result = TransformationUtils.centerCrop(pool, toTransform, outWidth, outHeight);
        Log.e("RoundCornorWithBlur",""+result.getHeight());
        return  blurBitmap(context,result,4);
    }


//    @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
//        if (toTransform == null) {
//            return null;
//        }
//        Bitmap result = pool.get(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
//
//        result = TransformationUtils.centerCrop(pool, result, outWidth, outHeight);
//        return  blurBitmap(context,result,10);
//    }

    private static final float BITMAP_SCALE = 0.15f;

    /**
     * @param context 上下文对象
     * @param image   需要模糊的图片
     * @return 模糊处理后的Bitmap
     */
    public static Bitmap blurBitmap(Context context, Bitmap image, float blurRadius) {
        // 计算图片缩小后的长宽
        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);
        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        RenderScript rs = RenderScript.create(context);
        // 创建一个模糊效果的RenderScript的工具对象
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        // 由于RenderScript并没有使用VM来分配内存,所以需要使用Allocation类来创建和分配内存空间
        // 创建Allocation对象的时候其实内存是空的,需要使用copyTo()将数据填充进去
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        // 设置渲染的模糊程度, 25f是最大模糊度
        blurScript.setRadius(blurRadius);
        // 设置blurScript对象的输入内存
        blurScript.setInput(tmpIn);
        // 将输出数据保存到输出内存中
        blurScript.forEach(tmpIn);
        // 将数据填充到Allocation中
        tmpIn.copyTo(inputBitmap);
        return inputBitmap;
    }
}


