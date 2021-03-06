package com.bwie.newstitleshiyabin.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitleshiyabin.Application.Application;
import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.fragment.Fragment_FA;
import com.bwie.newstitleshiyabin.fragment.Fragment_SP;
import com.bwie.newstitleshiyabin.fragment.Fragment_WD;
import com.bwie.newstitleshiyabin.fragment.Fragment_XW;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;


/**
 * 主界面
 */

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {


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
    private long exitTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
            //初始化控件
            initView();
            //侧滑
            //setSlidingmenu();
        FragmentManager manager1 = getSupportFragmentManager();
    }
    //两次退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //初始化控件
    private void initView() {
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
        if(Application.isFlag){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl,fxw).commit();
            tv_xw.setTextColor(Color.RED);

            Application.isFlag=false;
        }
    }
    //fragment切换
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
    //侧滑
    private void setSlidingmenu() {
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
           menu.setMenu(R.layout.main3_cehua);

    }

}
