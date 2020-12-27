package com.example.timinglay.adapteritem;

import android.graphics.Bitmap;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 11:50
 */
public class MessageFragmentStru {
    public String messagetitle;
    public String messagepreview;
    public Bitmap mixitemimg;
    public MessageFragmentStru(String messagetitle, String messagepreview, Bitmap mixitemimg){
        this.messagetitle=messagetitle;
        this.messagepreview=messagepreview;
        this.mixitemimg=mixitemimg;
    }
}