package com.example.timinglay.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timinglay.R;
import com.example.timinglay.adapter.RoomListPopularAdapter;
import com.example.timinglay.struct.SeatStru;

import java.util.ArrayList;

public class SeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_seat);
        Intent intent = getIntent();
        String args = intent.getStringExtra("123");
        ((TextView)findViewById(R.id.title)).setText(args);
        super.onCreate(savedInstanceState);

        View decor = getWindow().getDecorView();
        int ui = decor.getSystemUiVisibility();
        ui = ui |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        //ui = ui|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体颜色为白色
        decor.setSystemUiVisibility(ui);


        SpannableString span=new SpannableString("自习室开放时间\n12月14日10:00 ~ 12月14日12:00");

        span.setSpan(new AbsoluteSizeSpan(40),0,7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new AbsoluteSizeSpan(55),14,19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new AbsoluteSizeSpan(55),28,33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        span.setSpan(new ForegroundColorSpan(Color.parseColor("#5090F0")),
//                28, 33, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        ((TextView)findViewById(R.id.opentimetext)).setText(span);






        ArrayList<SeatStru> itlist =new ArrayList<>();
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                false,true,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                true,false,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                false,true,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                true,false,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                false,true,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                true,false,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                false,true,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                true,false,true,false
        ));
        itlist.add(new SeatStru(
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.head),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan),
                false,true,true,false
        ));
//        itlist.clear();
        RecyclerView roomlistrecycler=findViewById(R.id.seatrecycle);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        roomlistrecycler.setLayoutManager(manager);
        RoomListPopularAdapter rl = new RoomListPopularAdapter(itlist);

        roomlistrecycler.setAdapter(rl);


    }






}


