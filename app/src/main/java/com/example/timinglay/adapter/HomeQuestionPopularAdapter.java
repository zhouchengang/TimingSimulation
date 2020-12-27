package com.example.timinglay.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.glidetransform.GlideRoundCornorCenterCrop;
import com.example.timinglay.struct.QuesInfo;
import com.example.timinglay.struct.TopicPicInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class HomeQuestionPopularAdapter extends BaseQuickAdapter<QuesInfo, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public HomeQuestionPopularAdapter(List<QuesInfo> list) {
        super(R.layout.homeitemquestionitem, list);
    }

    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull QuesInfo item) {

        helper.setText(R.id.homeitemquestionitemtext,item.text);

      ImageView imageView = helper.findView(R.id.homeitemquestionitemimg);
        RequestOptions r =new RequestOptions().transform(new CircleCrop());

        Glide.with(getContext())
                .load(item.userInfo.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(r)
                .into(imageView);

    }
}
