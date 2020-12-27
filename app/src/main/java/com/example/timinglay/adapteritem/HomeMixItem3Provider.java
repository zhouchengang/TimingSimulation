package com.example.timinglay.adapteritem;

import android.util.Log;

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
public class HomeMixItem3Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP3;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homemixitem2blog;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);
    }
}
