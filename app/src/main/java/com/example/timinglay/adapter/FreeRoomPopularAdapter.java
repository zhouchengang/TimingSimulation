package com.example.timinglay.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.timinglay.R;
import com.example.timinglay.activity.SeatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;



public class FreeRoomPopularAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public FreeRoomPopularAdapter(List<String> list) {
        super(R.layout.view_tweetcons, list);
    }

    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull String item) {
        //helper.setText(R.id.customText, "This is an Item, pos: " + (helper.getAdapterPosition() - getHeaderLayoutCount()));
        helper.setText(R.id.customText, "剩余座位: " );
        helper.setText(R.id.necknametext, "昵称: " +item);
        helper.setText(R.id.tweettitle, "文章标题: " );
        helper.setText(R.id.tweetinfo, "文章正文wenzhangzhengwen: " );
        helper.setText(R.id.cunstomzanzhu, "赞助: " );
        helper.getView(R.id.enterbutt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("enterbutt","enterbutt");
                Context context =getContext();
                Intent i = new Intent(context, SeatActivity.class);
                i.putExtra("123", item);
                context.startActivity(i);
            }
        });
    }
}
