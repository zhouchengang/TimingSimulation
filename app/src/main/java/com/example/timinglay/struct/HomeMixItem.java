package com.example.timinglay.struct;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.timinglay.struct.DiaryStru;
import com.example.timinglay.struct.StrangeStru;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 14:34
 */
public class HomeMixItem implements MultiItemEntity {
    public static int TYP0 = -1;
    public static int TYP1 = 1;
    public static int TYP2 =2 ;
    public static int TYP3 =3 ;
    public static int TYP4 =4 ;
    public static int TYP5 =5 ;
    public static int TYP6 =6 ;
    public static int TYP7 =7 ;
    public static int TYP8 =8 ;
    public static int TYP9 =9 ;
    public static int TYP10=10 ;
    public static int TYP11=11 ;
    public static int TYP12=12 ;
    public static int TYP13=13 ;

    public   HomeMixItem(){

    }

    @Override
    public int getItemType() {
        return contentType ;
    }
    public int contentType;
    public DiaryStru feed;
    public SvlogStru svlog;
    public StrangeStru group;
    public DakaStru clockApp;
    public QiyueStru contractApp;
    public FreeLiveStru freeLive;
    public StrangeStru personalLive;
    public QueationStru qaRoom;
    public StrangeStru freeLearningRoom;
    public StrangeStru payLearningRoom;
    public TopicStru topic;
    public StrangeStru activity;

}
