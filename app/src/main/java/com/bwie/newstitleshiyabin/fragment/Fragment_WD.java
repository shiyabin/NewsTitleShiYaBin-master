package com.bwie.newstitleshiyabin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.newstitleshiyabin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_WD extends Fragment {

    private View view;
    private ListView wd_lv;
    private  String[] textLv={"消息通知","头条商城","京东提供","我也爆料","用户反馈","系统设置"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wd,null);

        wd_lv = (ListView) view.findViewById(R.id.wd_lv);
        wd_lv.setAdapter( new Myadapter());

        return view;
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
}
