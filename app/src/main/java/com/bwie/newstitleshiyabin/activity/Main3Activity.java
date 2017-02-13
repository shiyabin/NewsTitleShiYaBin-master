package com.bwie.newstitleshiyabin.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.fragment.Fragment_FA;
import com.bwie.newstitleshiyabin.fragment.Fragment_SP;
import com.bwie.newstitleshiyabin.fragment.Fragment_WD;
import com.bwie.newstitleshiyabin.fragment.Fragment_XW;

public class Main3Activity extends FragmentActivity implements View.OnClickListener {


    private ImageView iv_xw;
    private ImageView iv_sp;
    private ImageView iv_fx;
    private ImageView iv_wd;
    private TextView tv_xw;
    private TextView tv_sp;
    private TextView tv_fx;
    private TextView tv_wd;
    private LinearLayout btn_xw;
    private LinearLayout btn_sp;
    private LinearLayout btn_fx;
    private LinearLayout btn_wd;
    private Fragment_XW fxw;
    private Fragment_SP fsp;
    private Fragment_FA ffx;
    private Fragment_WD fwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //初始化控件
        btn_xw = (LinearLayout) findViewById(R.id.btn_xw);
        btn_sp = (LinearLayout) findViewById(R.id.btn_sp);
        btn_fx = (LinearLayout) findViewById(R.id.btn_fx);
        btn_wd = (LinearLayout) findViewById(R.id.btn_wd);
        iv_xw = (ImageView) findViewById(R.id.iv_xw);
        iv_sp = (ImageView) findViewById(R.id.iv_sp);
        iv_fx = (ImageView) findViewById(R.id.iv_fx);
        iv_wd = (ImageView) findViewById(R.id.iv_wd);
        tv_xw = (TextView) findViewById(R.id.tv_xw);
        tv_sp = (TextView) findViewById(R.id.tv_sp);
        tv_fx = (TextView) findViewById(R.id.tv_fx);
        tv_wd = (TextView) findViewById(R.id.tv_wd);

        //点击监听
        btn_xw.setOnClickListener(this);
        btn_sp.setOnClickListener(this);
        btn_fx.setOnClickListener(this);
        btn_wd.setOnClickListener(this);


        fxw = new Fragment_XW();
        fsp = new Fragment_SP();
        ffx = new Fragment_FA();
        fwd = new Fragment_WD();

        //默认选择Fragment1
        getSupportFragmentManager().beginTransaction().replace(R.id.fl,fxw).commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_xw:

                FragmentManager manager1 = getSupportFragmentManager();

                FragmentTransaction transaction1 = manager1.beginTransaction();

                transaction1.replace(R.id.fl,fxw);

                transaction1.commit();

                iv_xw.setBackgroundResource(R.drawable.xw2);
                tv_xw.setTextColor(Color.RED);

                iv_sp.setBackgroundResource(R.drawable.sp);
                tv_sp.setTextColor(Color.BLACK);

                iv_fx.setBackgroundResource(R.drawable.fx);
                tv_fx.setTextColor(Color.BLACK);

                iv_wd.setBackgroundResource(R.drawable.wd);
                tv_wd.setTextColor(Color.BLACK);




                break;
            case R.id.btn_sp:

                FragmentManager manager2 = getSupportFragmentManager();

                FragmentTransaction transaction2 = manager2.beginTransaction();

                transaction2.replace(R.id.fl,fsp);

                transaction2.commit();

                iv_xw.setBackgroundResource(R.drawable.xw);
                tv_xw.setTextColor(Color.BLACK);

                iv_sp.setBackgroundResource(R.drawable.sp2);
                tv_sp.setTextColor(Color.RED);

                iv_fx.setBackgroundResource(R.drawable.fx);
                tv_fx.setTextColor(Color.BLACK);

                iv_wd.setBackgroundResource(R.drawable.wd);
                tv_wd.setTextColor(Color.BLACK);

                break;
            case R.id.btn_fx:

                FragmentManager manager3 = getSupportFragmentManager();

                FragmentTransaction transaction3 = manager3.beginTransaction();

                transaction3.replace(R.id.fl,ffx);

                transaction3.commit();

                iv_xw.setBackgroundResource(R.drawable.xw);
                tv_xw.setTextColor(Color.BLACK);

                iv_sp.setBackgroundResource(R.drawable.sp);
                tv_sp.setTextColor(Color.BLACK);

                iv_fx.setBackgroundResource(R.drawable.fx2);
                tv_fx.setTextColor(Color.RED);

                iv_wd.setBackgroundResource(R.drawable.wd);
                tv_wd.setTextColor(Color.BLACK);


                break;
            case R.id.btn_wd:

                FragmentManager manager4 = getSupportFragmentManager();

                FragmentTransaction transaction4 = manager4.beginTransaction();

                transaction4.replace(R.id.fl,fwd);

                transaction4.commit();

                iv_xw.setBackgroundResource(R.drawable.xw);
                tv_xw.setTextColor(Color.BLACK);

                iv_sp.setBackgroundResource(R.drawable.sp);
                tv_sp.setTextColor(Color.BLACK);

                iv_fx.setBackgroundResource(R.drawable.fx);
                tv_fx.setTextColor(Color.BLACK);

                iv_wd.setBackgroundResource(R.drawable.wd2);
                tv_wd.setTextColor(Color.RED);


                break;
        }
    }
}
