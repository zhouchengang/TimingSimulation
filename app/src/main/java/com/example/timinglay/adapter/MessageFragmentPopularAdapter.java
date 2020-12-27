package com.example.timinglay.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.adapteritem.MessageFragmentStru;


import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 11:48
 */
public class MessageFragmentPopularAdapter extends BaseQuickAdapter<MessageFragmentStru, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public MessageFragmentPopularAdapter(List<MessageFragmentStru> list) {
        super(R.layout.messitem, list);
    }


    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull MessageFragmentStru item) {

        helper.setText(R.id.mixitemhold, ""+item.messagetitle );
        helper.setText(R.id.messagepreview, ""+item.messagepreview );
        helper.setImageBitmap(R.id.mixitemimg,item.mixitemimg);

    }
}
