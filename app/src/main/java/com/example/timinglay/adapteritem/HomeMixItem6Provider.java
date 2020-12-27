package com.example.timinglay.adapteritem;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.glidetransform.GlideRoundCornorCenterCrop;
import com.example.timinglay.struct.HomeMixItem;

import org.jetbrains.annotations.NotNull;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 15:55
 */
public class HomeMixItem6Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP6;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemlive;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);


        ImageView imageView = baseViewHolder.findView(R.id.homelivebkg);
        RequestOptions r =new RequestOptions().transform(new GlideRoundCornorCenterCrop(22));
        Glide.with(getContext())
                .load(homeMixItem.freeLive.cover.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(r)
                .into(imageView);



        ImageView imageView1 = baseViewHolder.findView(R.id.homedakahead);
        Glide.with(getContext())
                .load(homeMixItem.freeLive.spUserInfo.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(new RequestOptions().transform(new CircleCrop()))
                .into(imageView1);


        ImageView imageView2 = baseViewHolder.findView(R.id.homedakaxxq);
        int resourceId = R.mipmap.main_item_live;
        Glide.with(getContext())
                .asGif()
                .load(resourceId)
                .into(imageView2);


        baseViewHolder.setText(R.id.homedakamidbutt,""+homeMixItem.freeLive.title);
        baseViewHolder.setText(R.id.homedakaneckname,""+homeMixItem.freeLive.spUserInfo.nickname);


    }
}
