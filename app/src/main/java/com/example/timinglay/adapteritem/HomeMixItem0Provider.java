package com.example.timinglay.adapteritem;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.struct.HomeMixItem;

import org.jetbrains.annotations.NotNull;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 15:55
 */
public class HomeMixItem0Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homemixitem0blog;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        //here
    }
}
