package com.example.timinglay.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.timinglay.adapter.FollowSectionsPagerAdapter;
import com.example.timinglay.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FollowFragment extends Fragment {
    public static final String ARGS = "args";
    public FollowFragment() {
        // Required empty public constructor
    }
    public static FollowFragment newInstance(String  sa){
        FollowFragment ret = new FollowFragment();
        Bundle bundle =new Bundle();
        bundle.putString(ARGS,sa);
        ret.setArguments(bundle);
        return ret;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()==null){

        } else{
            String str = getArguments().getString(ARGS);
        }
    }

    @Override
    public void onResume() {
        super.onResume();


        Log.e("ZCG","FollowFragment onResume");


        FollowSectionsPagerAdapter followSectionsPagerAdapter = new FollowSectionsPagerAdapter(getContext(), getActivity().getSupportFragmentManager());
        ViewPager viewPager = getView().findViewById(R.id.banner);
        viewPager.setAdapter(followSectionsPagerAdapter);
        TabLayout tabs = getView().findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.e("onScrollChange","onScrollChange");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.e("ZCG","FollowFragment onCreateView");

        View view= inflater.inflate(R.layout.follow_page_fragment,container,false);

        return view;
    }
}