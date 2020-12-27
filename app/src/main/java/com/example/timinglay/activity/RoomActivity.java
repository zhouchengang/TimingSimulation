package com.example.timinglay.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.timinglay.R;
import com.example.timinglay.adapter.RoomSectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_room);
        super.onCreate(savedInstanceState);

//
//        RecyclerView roomlistrecycler=findViewById(R.id.roomlist);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        //锁死recycleview中所有item的长宽，统一风格
//        roomlistrecycler.setHasFixedSize(true);
//        roomlistrecycler.setLayoutManager(manager);
//        roomlistrecycler.setAdapter( new TweetCardAdapter(this));
//
//


        RoomSectionsPagerAdapter roomSectionsPagerAdapter = new RoomSectionsPagerAdapter(this, getSupportFragmentManager());


        ViewPager roomviewPager = findViewById(R.id.roombanner);
        roomviewPager.setAdapter(roomSectionsPagerAdapter);
        TabLayout roomtabs = findViewById(R.id.roomtabs);
        roomtabs.setupWithViewPager(roomviewPager);



    }



}