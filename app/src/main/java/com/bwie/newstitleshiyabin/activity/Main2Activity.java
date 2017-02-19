package com.bwie.newstitleshiyabin.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.bwie.newstitleshiyabin.R;

/**
 * 欢迎页面
 */
public class Main2Activity extends AppCompatActivity {

    private Handler han =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Intent i = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(i);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        han.sendEmptyMessageDelayed(0,2000);



    }
}
