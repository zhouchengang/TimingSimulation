package com.example.timinglay.adapteritem;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.glidetransform.CenterCropWithBlur;
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
public class HomeMixItem2Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemsoup;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {


        baseViewHolder.setText(R.id.homedakaneckname,""+homeMixItem.svlog.author.nickname);
        baseViewHolder.setText(R.id.homesouptextmid,""+homeMixItem.svlog.content);
        ImageView imageView = baseViewHolder.findView(R.id.homedakahead);
        Glide.with(getContext())
                .load(homeMixItem.svlog.author.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(new RequestOptions().transform(new CircleCrop()))
                .into(imageView);


        ImageView imageView1 = baseViewHolder.findView(R.id.homevloggif);
        if(homeMixItem.svlog.video.hasGif){
            Glide.with(getContext())
                    .load(homeMixItem.svlog.video.gifUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(new RequestOptions().transform(new CenterCrop()))
                    .into(imageView1);
        }else{
            Glide.with(getContext())
                    .load(homeMixItem.svlog.video.cover.url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(new RequestOptions().transform(new CenterCrop()))
                    .into(imageView1);
        }





        ImageView imageView2 = baseViewHolder.findView(R.id.homesvlogbkg);
        Glide.with(getContext())
                .load(homeMixItem.svlog.video.cover.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(new RequestOptions().transform(new GlideRoundCornorCenterCrop(20)))
//                .apply(new RequestOptions().transform(new CenterCropWithBlur(getContext(),40)))
                .into(imageView2);
    }
}
