package com.example.timinglay.adapteritem;

import android.util.Log;
import android.widget.ImageView;

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

import java.util.Date;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 15:55
 */
public class HomeMixItem4Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP4;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemdaka;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);

        baseViewHolder.setText(R.id.homedakacomeon,""+homeMixItem.clockApp.groupInfo.name);
        baseViewHolder.setText(R.id.homedakaneckname,""+homeMixItem.clockApp.groupInfo.builderInfo.nickname);
        baseViewHolder.setText(R.id.homedakamidmid,""+homeMixItem.clockApp.title);

        // 根据long类型的毫秒数生命一个date类型的时

        baseViewHolder.setText(R.id.homedakapublishtime,"群主在"+ Utils.getMonthDay(homeMixItem.clockApp.createTime)+"发布");
        ImageView imageView = baseViewHolder.findView(R.id.homedakahead);
        Glide.with(getContext())
                .load(""+homeMixItem.clockApp.groupInfo.builderInfo.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);

    }
}
