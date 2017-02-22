package com.bwie.newstitleshiyabin.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.activity.Login_DengLu;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;


/**
 * 1. 类的用途 ： 注册登录页面
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_WD extends Fragment implements  View.OnClickListener {

    private View view;
    private ListView wd_lv;
    private  String[] textLv={"消息通知","头条商城","京东提供","我也爆料","用户反馈","系统设置"};
    private ImageView wd_dx;
    private ImageView wd_wx;
    private ImageView wd_qq;
    private ImageView wd_jt;
    private LinearLayout wd_yj;
    private LinearLayout wd_ls;
    private LinearLayout wd_sc;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_wd,null);
        wd_lv = (ListView) view.findViewById(R.id.wd_lv);
        wd_lv.setAdapter( new Myadapter());
        initView();


        return view;
    }

    private void initView() {
        wd_dx = (ImageView) view.findViewById(R.id.wd_dx);
        wd_wx = (ImageView) view.findViewById(R.id.wd_wx);
        wd_qq = (ImageView) view.findViewById(R.id.wd_qq);
        wd_jt = (ImageView) view.findViewById(R.id.wd_jt);

        wd_yj = (LinearLayout) view.findViewById(R.id.wd_yj);
        wd_ls = (LinearLayout) view.findViewById(R.id.wd_ls);
        wd_sc = (LinearLayout) view.findViewById(R.id.wd_sc);


        wd_dx.setOnClickListener(this);
        wd_wx.setOnClickListener(this);
        wd_qq.setOnClickListener(this);
        wd_jt.setOnClickListener(this);

        wd_yj.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.wd_dx:
                Jump(new Login_DengLu());
                break;
            case R.id.wd_wx:
                break;
            case R.id.wd_qq:

                break;
            case R.id.wd_jt:
                Jump(new Login_DengLu());
                break;
            case R.id.wd_yj:


                break;

        }


    }

    class  Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return textLv.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=LayoutInflater.from(getActivity()).inflate(R.layout.wd_inte,null);
            TextView wd_tv= (TextView) v.findViewById(R.id.wd_tv);
            wd_tv.setText(textLv[position]);


            return v;
        }
    };
    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object o) {
            Log.d("zzz", "onComplete: " + SystemClock.elapsedRealtime());
        }

        @Override
        public void onError(UiError uiError) {
        }

        @Override
        public void onCancel() {

        }

    }


    private void Jump(Activity a) {
        Intent intent = new Intent(getActivity(), a.getClass());
        startActivity(intent);
    }


}
