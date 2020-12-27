package com.example.timinglay.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-20 16:22
 */
public class QueationStru {
    public int id;
    public int chat_room_id;
    public String title;
    public String coverUrl;
    public  UserInfo userInfo;
    public int queueCount;
    public ArrayList <UserInfo> queueUserList;
    public ArrayList <QuesInfo> qaList;
}