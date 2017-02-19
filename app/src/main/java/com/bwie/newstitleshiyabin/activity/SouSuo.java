package com.bwie.newstitleshiyabin.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.bwie.newstitleshiyabin.R;

/**
 * 搜索页面
 */

public class SouSuo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sou_suo);
    }
}
