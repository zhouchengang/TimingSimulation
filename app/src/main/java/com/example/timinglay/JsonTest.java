package com.example.timinglay;

import android.content.Context;
import android.util.Log;

import com.example.timinglay.struct.HomeMixItem;

import com.example.timinglay.utils.Utils;
import com.google.gson.Gson;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-20 12:05
 */



public class JsonTest {
    public JsonTest(Context context){
        String jsonFile= Utils.getJSONFile(context,"datatest.json");
        HomeMixItem foo = new Gson().fromJson(jsonFile, HomeMixItem.class);
        Log.e("JSON ","contentType :"+foo.contentType);
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
