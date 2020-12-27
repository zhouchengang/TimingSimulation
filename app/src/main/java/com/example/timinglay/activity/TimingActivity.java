package com.example.timinglay.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.timinglay.R;
import com.example.timinglay.eventbus.AnyEventType;
import com.example.timinglay.eventbus.EventType;
import com.example.timinglay.fragment.FollowFragment;
import com.example.timinglay.fragment.HomeFragment;
import com.example.timinglay.fragment.MessageFragment;
import com.example.timinglay.fragment.MineFragment;
import com.example.timinglay.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

public class TimingActivity extends AppCompatActivity {
    static  Fragment timingminefrag;
    static  Fragment timingmessagefrag;
    static  Fragment timingfollowfrag;
    static  Fragment timinghomefrag;

    int nowstate=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_timing);
        Window window = this.getWindow();
        super.onCreate(savedInstanceState);
        Utils.verifyStoragePermissions(this);
        findViewById(R.id.nv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadpage1();
            }
        });

        findViewById(R.id.nv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadpage2();
            }
        });


        findViewById(R.id.nv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadpage3();
            }
        });

        findViewById(R.id.nv4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadpage4();
            }
        });

        findViewById(R.id.nv5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadpage5();
            }
        });


        loadpage1();


        View decor = getWindow().getDecorView();
        int ui = decor.getSystemUiVisibility();
        ui = ui |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        decor.setSystemUiVisibility(ui);
    }

    private int getNavigationBarHeight(Activity mActivity) {
        Resources resources = mActivity.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    void loadpage1(){
        clearpage();
        nowstate=1;
        if(getSupportFragmentManager().getFragments().contains(timinghomefrag)){
            getSupportFragmentManager().beginTransaction().show(timinghomefrag).commit();
        }else{
            timinghomefrag = HomeFragment.newInstance("Scroll");
            getSupportFragmentManager().beginTransaction().add(R.id.constafragmentmid, timinghomefrag).commit();
        }
    }
    void loadpage2(){
        clearpage();
        nowstate=2;
        if(getSupportFragmentManager().getFragments().contains(timingfollowfrag)){
            getSupportFragmentManager().beginTransaction().show(timingfollowfrag).commit();
        }else{
            timingfollowfrag =  FollowFragment.newInstance("Scroll");
            getSupportFragmentManager().beginTransaction().add(R.id.constafragmentmid, timingfollowfrag).commit();
        }
    }

    void loadpage3(){
        if(timingminefrag!=null){
            Log.e("LAZY","timingminefrag"+timingminefrag.getUserVisibleHint());
        }else{
            Log.e("LAZY","timingminefrag is null");
        }
        if(timingmessagefrag!=null){
            Log.e("LAZY","timingmessagefrag"+timingmessagefrag.getUserVisibleHint());
        }else{
            Log.e("LAZY","timingmessagefrag is null");
        }
        if(timingfollowfrag!=null){
            Log.e("LAZY","timingfollowfrag"+timingfollowfrag.getUserVisibleHint());
        }else{
            Log.e("LAZY","timingfollowfrag is null");
        }
        if(timinghomefrag!=null){
            Log.e("LAZY","timinghomefrag"+timinghomefrag.getUserVisibleHint());
        }else{
            Log.e("LAZY","timinghomefrag is null");
        }
        showPopupWindow();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

//        EventBus.getDefault().post(new AnyEventType("msg"));
//        EventBus.getDefault().post(new EventType("msg22"));

        Log.d("TAG", "run : 1");
        EventBus.getDefault().post(new AnyEventType("msg"));//发送一个事件
        Log.d("TAG", "run : 2");
        EventBus.getDefault().post(new EventType("msg22"));//发送一个事件
    }
    void loadpage4(){
        clearpage();
        nowstate=4;
        if(getSupportFragmentManager().getFragments().contains(timingmessagefrag)){
            getSupportFragmentManager().beginTransaction().show(timingmessagefrag).commit();
        }else{
            timingmessagefrag = MessageFragment.newInstance("Scroll");
            getSupportFragmentManager().beginTransaction().add(R.id.constafragmentmid, timingmessagefrag).commit();
        }
    }
    void loadpage5(){
        clearpage();
        nowstate=5;
        if(getSupportFragmentManager().getFragments().contains(timingminefrag)){
            getSupportFragmentManager().beginTransaction().show(timingminefrag).commit();
        }else{
            timingminefrag = MineFragment.newInstance("Scroll");
            getSupportFragmentManager().beginTransaction().add(R.id.constafragmentmid, timingminefrag).commit();
        }
    }

    void clearpage(){
        switch (nowstate){
            case 1:
                getSupportFragmentManager().beginTransaction().hide(timinghomefrag).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().hide(timingfollowfrag).commit();
//                getSupportFragmentManager().beginTransaction().hide(FollowSectionsPagerAdapter.vp0).commit();
//                getSupportFragmentManager().beginTransaction().hide(FollowSectionsPagerAdapter.vp1).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().hide(timingmessagefrag).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().hide(timingminefrag).commit();
                break;
            default:

        }
    }
    void  showPopupWindow(){
        View contentView = LayoutInflater.from(this).inflate(R.layout.activity_publish, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                android.app.ActionBar.LayoutParams.MATCH_PARENT,
                android.app.ActionBar.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.popupAnimation);
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER| Gravity.CENTER, 0, 0);


        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return false;
            }
        });
        LinearLayout first = (LinearLayout) contentView.findViewById(R.id.lineraddgroup);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("FRAG","按钮被点击了");
                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener(){
            @Override
            public void onDismiss() {

            }
        } );
        //android PopupWindow之设置动画无效的问题
        //https://www.pianshen.com/article/85591897242/

    }




    static boolean re = false;
    @Override
    public void onBackPressed() {

        Log.e("TimingActivity", "back");
        if (re) {
            re = false;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.MONKEY");
            startActivity(intent);
        } else {
            new Runnable() {
                @Override
                public void run() {
                    re = true;
                    Toast.makeText(TimingActivity.this, "再次按下退出", Toast.LENGTH_SHORT).show();
                    //Thread.sleep(1000);  阻塞线程
//                        new Handler().postDelayed(new Runnable(){
//                            @Override
//                            public void run(){
//                                re=false;
//                            }
//                        },2000);
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            re = false;
                        }
                    }, 2000);

                }
            }.run();
        }
    }
}
