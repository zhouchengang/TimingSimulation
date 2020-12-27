package com.example.timinglay.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timinglay.adapter.MessageFragmentPopularAdapter;
import com.example.timinglay.R;
import com.example.timinglay.adapteritem.MessageFragmentStru;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment {
    public static final String ARGS = "args";
    public MessageFragment() {
        // Required empty public constructor
    }
    public static MessageFragment newInstance(String  sa){
        MessageFragment ret = new MessageFragment();
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
        RecyclerView messagerecycler=getView().findViewById(R.id.messagerecycle);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        messagerecycler.setLayoutManager(manager);
        ArrayList<MessageFragmentStru> itlist =new ArrayList<MessageFragmentStru>();
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.head)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.head)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.head)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.head)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tool_study_plan)));
        itlist.add(new MessageFragmentStru("1","2",BitmapFactory.decodeResource(getResources(), R.mipmap.head)));

        //itlist.clear();
//        messagerecycler.setAdapter(new MyBaseAdapter<fragmentstru>(R.layout.messitem,
//                R.layout.listhead,
//                R.layout.listtail,
//                R.layout.messageempty,
//                itlist){
//            @Override
//            public void setItem(View v,fragmentstru item ) {
//                ((TextView) v.findViewById(R.id.mixitemhold)).setText(item.messagetitle);
//                ((TextView) v.findViewById(R.id.messagepreview)).setText(item.messagepreview);
//                ((ImageView) v.findViewById(R.id.mixitemimg)).setImageBitmap(item.mixitemimg);
//            }
//            @Override
//            public void setEmpty() {
//                View vvv=getView().findViewById(R.id.messagerecycle);
//                if ( vvv != null ) {
//                    Log.e("asasasas","sss");
//                }
//            }
//        });

        messagerecycler.setAdapter(new MessageFragmentPopularAdapter(itlist));
        //messagerecycler.addItemDecoration(new  MyItemDecoration(getContext(),2,180,0));
        //分割线和间距

        //https://www.liangzl.com/get-article-detail-28923.html

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.message_page_fragment,container,false);
        return view;
    }
}



