package com.example.timinglay.adapter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.timinglay.fragment.FollowMidFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class FollowSectionsPagerAdapter extends FragmentPagerAdapter {

    //@StringRes
    //private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};

    String tabname[] = new String[]{"关注", "道友"};
    private final Context mContext;


    static public Fragment vp0;
    static public Fragment vp1;
    static public Fragment vp2;

    public FollowSectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        Log.e("TABADAPTER","TABADAPTER");
//        return PlaceholderFragment.newInstance(position);

        if(position == 0){
            vp0= FollowMidFragment.newInstance(0);
            return vp0;
        }

        if(position == 1){
            vp1= FollowMidFragment.newInstance(1);
            return vp1;
        }


        vp2= FollowMidFragment.newInstance(2);
        return vp2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabname[position];
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return tabname.length;
    }
}