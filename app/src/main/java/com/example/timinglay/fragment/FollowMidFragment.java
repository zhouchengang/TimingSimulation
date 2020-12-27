package com.example.timinglay.fragment;




import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.timinglay.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FollowMidFragment extends Fragment {
    public static FollowMidFragment newInstance(int index) {
        FollowMidFragment fragment = new FollowMidFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("ZCG","onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("ZCG","onCreateView");
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        textView.setText("scroll vertical or horizontal");
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        Log.e("ZCG","onDestroyView");
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        Log.e("ZCG","onDestroy");
        super.onDestroy();
    }
}