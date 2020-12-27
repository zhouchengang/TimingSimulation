package com.example.timinglay.adapteritem;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
public class HomeMixItem1Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemdiary;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);
        Log.e("convert",""+homeMixItem.feed.imageList.get(0).shareImgUrl);


        View cy=  baseViewHolder.findView(R.id.headback1);
        ObjectAnimator alphaanicy=ObjectAnimator.ofFloat(cy,"alpha",0.5f,0).setDuration(500);
        ObjectAnimator alphaanicy2=ObjectAnimator.ofFloat(cy,"alpha",0,0.5f).setDuration(400);
        AnimatorSet ascy=new AnimatorSet();
        ascy.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                    ascy.start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        ascy.play(alphaanicy);
        ascy.play(alphaanicy2).after(alphaanicy);
        ascy.start();



        View bp=  baseViewHolder.findView(R.id.headd);
        ObjectAnimator a1=ObjectAnimator.ofFloat(bp,"scaleX",1,0.85f).setDuration(400);
        ObjectAnimator a2=ObjectAnimator.ofFloat(bp,"scaleY",1,0.85f).setDuration(400);
        ObjectAnimator a3=ObjectAnimator.ofFloat(bp,"scaleX",0.85f,1).setDuration(400);
        ObjectAnimator a4=ObjectAnimator.ofFloat(bp,"scaleY",0.85f,1).setDuration(400);
        AnimatorSet as=new AnimatorSet();
        as.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                as.start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        as.play(a1);
        as.play(a2).with(a1);
        as.play(a3).after(a1).after(a2);
        as.play(a4).with(a3);
        as.setStartDelay(400);
        as.start();



        if(homeMixItem.feed.imageList.size()>=1){
            ImageView imageView = baseViewHolder.findView(R.id.cover);
            RequestOptions  r =new RequestOptions().transform(new GlideRoundCornorCenterCrop(20));

            Glide.with(getContext())
                    .load(homeMixItem.feed.imageList.get(0).url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(r)
                    .into(imageView);
        }

        baseViewHolder.setText(R.id.diaryneckname,""+homeMixItem.feed.author.nickname);

        ImageView imageView2 = baseViewHolder.findView(R.id.headd);
        Glide.with(getContext())
                .load(homeMixItem.feed.author.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView2);



        if(homeMixItem.feed.topic!=null){
            baseViewHolder.setText(R.id.topic,homeMixItem.feed.topic.name);
        } else{
            baseViewHolder.setVisible(R.id.topic,false);
        }

        if(homeMixItem.feed.content!=null){
            baseViewHolder.setText(R.id.homediaryinfo,homeMixItem.feed.content);
        }else{
            baseViewHolder.setVisible(R.id.homediaryinfo,false);
        }




    }
}
