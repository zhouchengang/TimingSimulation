package com.example.timinglay.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.timinglay.R;
import com.example.timinglay.struct.HomeMixItem;
import com.example.timinglay.utils.GlideCache;
import com.example.timinglay.utils.Utils;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public static String localcachepath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        localcachepath= Utils.getDiskCachePath(this);
        Window window = this.getWindow();

        super.onCreate(savedInstanceState);
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        runOnUiThread(r);



       // GlideCache.cleanCacheDisk();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Log.e("MainActivity","here");
                startActivity(new Intent(MainActivity.this, TimingActivity.class));
            }
        }, 700);

        View decor = getWindow().getDecorView();
        int ui = decor.getSystemUiVisibility();
        ui = ui |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        //ui = ui|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体颜色为白色
        decor.setSystemUiVisibility(ui);


        //new JsonTest(this);

//        String jsonFile= Utils.getJSONFile(this,"data.json");
//        DataStru foo = new Gson().fromJson(jsonFile, DataStru.class);
//        Log.e("JSON",""+foo.result);
//        for(int i=0;i<foo.list.size();i++){
//            HomeMixItem c = foo.list.get(i);
//            Log.e("JSON","contentType : "+c.contentType);
//            getFromListStru(c);
//        }
    }
    public void getFromListStru(HomeMixItem foo){
        switch(foo.contentType){
            case 1:
                Log.e("JSON ","feed :"+foo.feed.id);
                break;
            case 2:
                Log.e("JSON ","svlog :"+foo.svlog.id);
                break;
            case 3:
                Log.e("JSON ","group :"+foo.group.id);
                break;
            case 4:
                Log.e("JSON ","clockApp :"+foo.clockApp.id);
                break;
            case 5:
                Log.e("JSON ","contractApp :"+foo.contractApp.id);
                break;
            case 6:
                Log.e("JSON ","freeLive :"+foo.freeLive.id);
                break;
            case 7:
                Log.e("JSON ","personalLive :"+foo.personalLive.id);
                break;
            case 8:
                Log.e("JSON ","qaRoom :"+foo.qaRoom.id);
                break;
            case 9:
                Log.e("JSON ","freeLearningRoom :"+foo.freeLearningRoom.id);
                break;
            case 10:
                Log.e("JSON ","payLearningRoom :"+foo.payLearningRoom.id);
                break;
            case 11:
                Log.e("JSON ","topic :"+foo.topic.id);

        }
    }







}