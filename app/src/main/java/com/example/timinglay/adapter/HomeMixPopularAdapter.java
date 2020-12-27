package com.example.timinglay.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.timinglay.adapteritem.HomeMixItem11Provider;
import com.example.timinglay.adapteritem.HomeMixItem13Provider;
import com.example.timinglay.adapteritem.HomeMixItem3Provider;
import com.example.timinglay.adapteritem.HomeMixItem4Provider;
import com.example.timinglay.adapteritem.HomeMixItem5Provider;
import com.example.timinglay.adapteritem.HomeMixItem6Provider;
import com.example.timinglay.struct.HomeMixItem;
import com.example.timinglay.adapteritem.HomeMixItem0Provider;
import com.example.timinglay.adapteritem.HomeMixItem1Provider;
import com.example.timinglay.adapteritem.HomeMixItem2Provider;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * TimingLay-
 *
 * @Author J_jiasheng@qq.com
 * @create 2020-12-17 11:48
 */
public class HomeMixPopularAdapter extends BaseProviderMultiAdapter<HomeMixItem> {

    public HomeMixPopularAdapter( ArrayList<HomeMixItem> itlist ) {
        super(itlist);
        // 注册 Provider
        addItemProvider(new HomeMixItem0Provider());
        addItemProvider(new HomeMixItem1Provider());
        addItemProvider(new HomeMixItem2Provider());
        addItemProvider(new HomeMixItem3Provider());
        addItemProvider(new HomeMixItem4Provider());
        addItemProvider(new HomeMixItem5Provider());
        addItemProvider(new HomeMixItem6Provider());
        //addItemProvider(new HomeMixItem7Provider());
        //addItemProvider(new HomeMixItem8Provider());
        //addItemProvider(new HomeMixItem9Provider());
        //addItemProvider(new HomeMixItem10Provider());
        addItemProvider(new HomeMixItem11Provider());
        //addItemProvider(new HomeMixItem12Provider());
        addItemProvider(new HomeMixItem13Provider());

    }

    @Override
    protected int getItemType(@NotNull List<? extends HomeMixItem> list, int position) {
        switch (list.get(position).getItemType()) {
            case 0:
                return HomeMixItem.TYP0;
            case 1:
                return HomeMixItem.TYP1;
            case 2:
                return HomeMixItem.TYP2;
            case 3:
                return HomeMixItem.TYP3;
            case 4:
                return HomeMixItem.TYP4;
            case 5:
                return HomeMixItem.TYP5;
            case 6:
                return HomeMixItem.TYP6;
            case 7:
                return HomeMixItem.TYP7;
            case 8:
                return HomeMixItem.TYP8;
            case 9:
                return HomeMixItem.TYP9;
            case 10:
                return HomeMixItem.TYP10;
            case 11:
                return HomeMixItem.TYP11;
            case 12:
                return HomeMixItem.TYP12;
            case 13:
                return HomeMixItem.TYP13;
            default:
                return HomeMixItem.TYP0;
        }
    }
}
