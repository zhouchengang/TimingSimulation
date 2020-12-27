package com.example.timinglay.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import com.example.timinglay.R;
import com.example.timinglay.adapter.AdBannerPopularAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends Fragment {
    public static final String ARGS = "args";
    public MineFragment() {
        // Required empty public constructor
    }
    public static MineFragment newInstance(String  sa){
        MineFragment ret = new MineFragment();
        Bundle bundle =new Bundle();
        bundle.putString(ARGS,sa);
        ret.setArguments(bundle);
        return ret;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("1","hererere");
        if(getArguments()==null){

        } else{
            String str = getArguments().getString(ARGS);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ViewPager2 viewPager2 = getView().findViewById(R.id.banner);
       //AdBannerAdapter pager2Adapter = new AdBannerAdapter(getActivity().getSupportFragmentManager());
        ArrayList <String> al=new ArrayList<>();
        al.add("1");al.add("1");al.add("1");al.add("2");al.add("1");
        AdBannerPopularAdapter pager2Adapter = new AdBannerPopularAdapter(al);
        viewPager2.setAdapter(pager2Adapter);


        viewPager2.registerOnPageChangeCallback(new  ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, @Px int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(@ViewPager2.ScrollState int state) {
                //Log.e("viewPager2","viewPager2");
            }
        });
        //viewPager2.setCurrentItem();
        //更多方法 https://www.ctolib.com/wangpeiyuan-CycleViewPager2.html




        getView().findViewById(R.id.minemid).setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(getView().findViewById(R.id.minemid).getScrollY() ==0){
                    ((TextView) (getView().findViewById(R.id.midname))).setText("");
                    Log.e("MineMidFragment","Y == 0 ");
                }else{
                    //((TextView)(topf.getView().findViewById(R.id.midname)) ).setText("Dynamic Name");
                    ((TextView) (getView().findViewById(R.id.midname))).setText("Dynamic Name");
                    Log.e("MineMidFragment","Y != 0 ");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.mine_page_fragment,container,false);
        Log.e("Mine","onCreateView");
        //((TextView)(view.findViewById(R.id.fragtest))).setText(str);
        return view;
    }
}