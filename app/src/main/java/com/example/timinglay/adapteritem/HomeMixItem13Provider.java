package com.example.timinglay.adapteritem;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.adapter.HomeQuestionPopularAdapter;
import com.example.timinglay.adapter.HomeTopicPopularAdapter;
import com.example.timinglay.glidetransform.CenterCropWithBlur;
import com.example.timinglay.glidetransform.GlideRoundCornorCenterCropWithBlur;
import com.example.timinglay.struct.HomeMixItem;
import com.example.timinglay.struct.QuesInfo;
import com.example.timinglay.struct.TopicPicInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 15:55
 */
public class HomeMixItem13Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP13;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemquestion;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);



        ArrayList<QuesInfo> itlist = new   ArrayList<>();
        for(QuesInfo tp : homeMixItem.qaRoom.qaList){
            itlist.add(tp);
            itlist.add(tp);
            itlist.add(tp);
        }

        RecyclerView topiccycle=baseViewHolder.getView(R.id.homeitemquestioncycle);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        topiccycle.setLayoutManager(manager);
        topiccycle.setAdapter(new HomeQuestionPopularAdapter(itlist));


        baseViewHolder.setText(R.id.homeitemquestiontitle,""+homeMixItem.qaRoom.title);
        baseViewHolder.setText(R.id.homeitemquestionneckname,""+homeMixItem.qaRoom.userInfo.nickname);
        baseViewHolder.setText(R.id.homeitemquestionintroduction,""+homeMixItem.qaRoom.userInfo.department);
        baseViewHolder.setText(R.id.homeitemquestionpaidui,""+homeMixItem.qaRoom.queueCount+"人正在排队");


        Glide.with(getContext())
                .load(""+homeMixItem.qaRoom.userInfo.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into( (ImageView)baseViewHolder.findView(R.id.homeitemquestionuserhead));


        if(homeMixItem.qaRoom.queueCount>=1){
            Glide.with(getContext())
                    .load(""+homeMixItem.qaRoom.queueUserList.get(0).avatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into( (ImageView)baseViewHolder.findView(R.id.icon2));

            if(homeMixItem.qaRoom.queueCount>=1) {
                Glide.with(getContext())
                        .load(""+homeMixItem.qaRoom.queueUserList.get(1).avatar)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                        .into( (ImageView)baseViewHolder.findView(R.id.icon1));
            }
        }


        Glide.with(getContext())
                .load(homeMixItem.qaRoom.coverUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(new RequestOptions().transform(new GlideRoundCornorCenterCropWithBlur(getContext(),20)))
                .into( (ImageView)baseViewHolder.findView(R.id.homeitemquestionbkg));



    }
}
