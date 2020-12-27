package com.example.timinglay.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.activity.SeatActivity;
import com.example.timinglay.glidetransform.GlideRoundCornorCenterCrop;
import com.example.timinglay.struct.ImageInfo;
import com.example.timinglay.struct.TopicPicInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class HomeTopicPopularAdapter extends BaseQuickAdapter<TopicPicInfo, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public HomeTopicPopularAdapter(List<TopicPicInfo> list) {
        super(R.layout.homeitemtopicitem, list);
    }

    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull TopicPicInfo item) {
        helper.setText(R.id.homeitemtopicitemtext,item.content);


        ImageView imageView = helper.findView(R.id.homeitemtopicitemimg);
        RequestOptions r =new RequestOptions().transform(new GlideRoundCornorCenterCrop(15));

        Glide.with(getContext())
                .load(item.imageList.get(0).url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(r)
                .into(imageView);

    }
}
