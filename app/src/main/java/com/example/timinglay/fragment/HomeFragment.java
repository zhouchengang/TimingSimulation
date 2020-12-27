package com.example.timinglay.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.timinglay.R;
import com.example.timinglay.activity.RoomActivity;
import com.example.timinglay.adapter.FreeRoomPopularAdapter;
import com.example.timinglay.adapter.HomeMixPopularAdapter;
import com.example.timinglay.eventbus.AnyEventType;
import com.example.timinglay.eventbus.EventType;
import com.example.timinglay.struct.HomeMixItem;
import com.example.timinglay.struct.DataStru;
import com.example.timinglay.utils.Utils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    public static final String ARGS = "args";

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String sa) {
        HomeFragment ret = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS, sa);
        ret.setArguments(bundle);
        return ret;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {

        } else {
            String str = getArguments().getString(ARGS);
        }

        EventBus.getDefault().register(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.toppic2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RoomActivity.class));
            }
        });
        renew();
    }
    //(1)  onViewCreated在onCreateView执行完后立即执行。
    //(2)  onCreateView返回的就是fragment要显示的view。

    void renew(){
        RecyclerView mixitemrecycler = getView().findViewById(R.id.homemixrecycle);
        mixitemrecycler.setNestedScrollingEnabled(false);
        mixitemrecycler.setHasFixedSize(true);
        int spanCount = 2;
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        mixitemrecycler.setLayoutManager(manager);
        ArrayList<HomeMixItem> itlist = new ArrayList<>();


        String jsonFile = Utils.getJSONFile(getContext(), "data.json");
//        String jsonFile = Utils.getJSONFile(getContext(), "data.json");
//        String jsonFile= Utils.getJSONFile(getContext(),"datasingle.json");
        DataStru foo = new Gson().fromJson(jsonFile, DataStru.class);
        Log.e("JSON foo.result:", "" + foo.result);


        HomeMixPopularAdapter mQuickAdapter = new HomeMixPopularAdapter(itlist);

        if(foo.result){
            for (int i = 0; i < foo.list.size(); i++) {
                HomeMixItem c = foo.list.get(i);
                Log.e("JSON  add", "contentType : " + c.contentType);
                itlist.add(c);
            }
        }
        View v = getActivity().getLayoutInflater().inflate(R.layout.empty,null);
        mQuickAdapter.setEmptyView(v);
        mQuickAdapter.setUseEmpty(true);
        mixitemrecycler.setAdapter(mQuickAdapter);



        mixitemrecycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);

                StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
                if (lp.getSpanIndex() == 0) {
                    outRect.top = 10;//item上边的间距
                    outRect.left = 10;//左边间距
                    outRect.right = 10;//右边间距
                    outRect.bottom = 10;//设置bottom padding
                } else if (lp.getSpanIndex() + 1 == spanCount) {
                    outRect.top = 10;//item上边的间距
                    outRect.left = 10;//左边间距
                    outRect.right = 10;//右边间距
                    outRect.bottom = 10;//设置bottom padding
                } else {
                    outRect.top = 10;//item上边的间距
                    outRect.left = 10;//左边间距
                    outRect.right = 10;//右边间距
                    outRect.bottom = 10;//设置bottom padding
                }
            }
        });
        //分割线和间距
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AnyEventType event) {
        //((NestedScrollView) getView().findViewById(R.id.homefragmentscrollview)).scrollTo(0,0);
        //EventBus.getDefault().unregister(this);
        Log.e("hhh", ""+ event.getMsg());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventAnother(EventType event) {
        //SystemClock.sleep(5000);
        //((NestedScrollView) getView().findViewById(R.id.homefragmentscrollview)).scrollTo(0,0);
        Log.e("hhh2", ""+ event.getMsg());
    }

}