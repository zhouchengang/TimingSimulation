package com.example.timinglay.fragment;




import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timinglay.R;
import com.example.timinglay.adapter.FreeRoomPopularAdapter;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class FreeRoomFragment extends Fragment {
    public static FreeRoomFragment newInstance(int index) {
        FreeRoomFragment fragment = new FreeRoomFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_freeroom, container, false);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();


        RecyclerView roomlistrecycler=getView().findViewById(R.id.freeroomlist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        //锁死recycleview中所有item的长宽，统一风格
        roomlistrecycler.setHasFixedSize(true);
        roomlistrecycler.setLayoutManager(manager);
        //roomlistrecycler.setAdapter( new TweetCardAdapter(getContext()));
        ArrayList <String> al =new ArrayList<>();
        al.add("helo");
        al.add("hello1");
        al.add("hell4o2");
        al.add("hello");
        al.add("hello441");
        al.add("hello2");
        al.add("hello");
        al.add("hell4o1");
        al.add("hello2");
        al.add("hello");
        al.add("hel44lo1");
        al.add("hello2");


        //al.clear();

        View v = getActivity().getLayoutInflater().inflate(R.layout.empty, null);
        FreeRoomPopularAdapter rl=new FreeRoomPopularAdapter(al);
        //rl.setNewInstance(null);
        rl.setUseEmpty(true);
        rl.setEmptyView(v);
        roomlistrecycler.setAdapter( rl);
        rl.setRecyclerView(roomlistrecycler);


    }
}