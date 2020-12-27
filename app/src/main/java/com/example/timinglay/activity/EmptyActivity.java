package com.example.timinglay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timinglay.R;

import java.util.Timer;
import java.util.TimerTask;

public class EmptyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String args = intent.getStringExtra("123");
        //Toast.makeText(this,"received: "+args,Toast.LENGTH_SHORT).show();
        ((TextView)findViewById(R.id.info)).setText(args);
        //接收String类型的值
        super.onCreate(savedInstanceState);
    }

//    public static  Intent  createIntent(Context c){
//        return new Intent(c,EmptyActivity.class);
////        EmptyActivity ret = new EmptyActivity();
////        Bundle bundle =new Bundle();
////        bundle.putString("flag",sa);
////        ret.setArguments(bundle);
////        return ret;
//    }

}