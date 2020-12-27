package com.example.timinglay.adapteritem;

import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.struct.HomeMixItem;
import com.example.timinglay.utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 15:55
 */
public class HomeMixItem5Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP5;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemqiyue;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);


        baseViewHolder.setText(R.id.homeqiyuecomeon,""+homeMixItem.contractApp.groupInfo.name);
        baseViewHolder.setText(R.id.homeqiyueneckname,""+homeMixItem.contractApp.groupInfo.builderInfo.nickname);


        baseViewHolder.setText(R.id.homeqiyuepublishtime,"群主在"+ Utils.getMonthDay(homeMixItem.contractApp.createTime)+"发布");

        ImageView imageView = baseViewHolder.findView(R.id.homeqiyuehead);
        Glide.with(getContext())
                .load(""+homeMixItem.contractApp.groupInfo.builderInfo.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);


        SpannableString span=new SpannableString("¥"+homeMixItem.contractApp.totalAmount);

        span.setSpan(new AbsoluteSizeSpan(25),0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView)baseViewHolder.getView(R.id.homeqiyuetotal)).setText(span);

        Handler handler = new Handler( );
        handler.postDelayed(new Runnable( ) {
            @Override
            public void run ( ) {
                long timenow=System.currentTimeMillis();
                timenow -=8305457848L;
                long timest=homeMixItem.contractApp.startTime;
                //Log.e("t:",""+(timest-timenow)/3600000%60+":"+(timest-timenow)/60000%60+":"+(timest-timenow)/1000%60);
                baseViewHolder.setText(R.id.vlogdjs2,""+(timest-timenow)/3600000%60);
                baseViewHolder.setText(R.id.vlogdjs4,""+(timest-timenow)/60000%60);
                baseViewHolder.setText(R.id.vlogdjs6,""+(timest-timenow)/1000%60);
                handler.postDelayed(this,1000);
            }
        },0);



    }
}
