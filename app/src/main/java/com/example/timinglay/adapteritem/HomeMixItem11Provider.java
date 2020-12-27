package com.example.timinglay.adapteritem;

import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.adapter.HomeTopicPopularAdapter;
import com.example.timinglay.adapter.RoomListPopularAdapter;
import com.example.timinglay.struct.HomeMixItem;
import com.example.timinglay.struct.ImageInfo;
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
public class HomeMixItem11Provider extends BaseItemProvider<HomeMixItem> {
    @Override
    public int getItemViewType() {
        return HomeMixItem.TYP11;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homeitemtopic;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, HomeMixItem homeMixItem) {
        Log.e("convert",""+homeMixItem.contentType);

        baseViewHolder.setText(R.id.hometopiccomeon,homeMixItem.topic.name);


        ArrayList<TopicPicInfo> itlist = new   ArrayList<>();
        for(TopicPicInfo tp : homeMixItem.topic.feedList){
            itlist.add(tp);
        }

        RecyclerView topiccycle=baseViewHolder.getView(R.id.homeitemtopiccycle);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        topiccycle.setLayoutManager(manager);
        topiccycle.setAdapter(new HomeTopicPopularAdapter(itlist));
    }
}
