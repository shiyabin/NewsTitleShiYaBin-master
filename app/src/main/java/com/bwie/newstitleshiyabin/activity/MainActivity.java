package com.bwie.newstitleshiyabin.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.adapter.Myadapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private SharedPreferences sha;
    private TextView p3_tv;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);

        sha = getSharedPreferences("user", MODE_PRIVATE);

        boolean f = sha.getBoolean("flag", false);
        if (f) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }

        View p1 = View.inflate(this, R.layout.p1, null);
        View p2 = View.inflate(this, R.layout.p2, null);
        View p3 = View.inflate(this, R.layout.p3, null);

        p3_tv = (TextView) p3.findViewById(R.id.p3_tv);

        list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        vp.setAdapter(new Myadapter(this,list));

        p3_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sha=getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor ed=sha.edit();
                ed.putBoolean("flag", true);
                ed.commit();

                Intent it=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(it);
            }
        });

    }
}
