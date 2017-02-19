package com.bwie.newstitleshiyabin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.activity.SouSuo;

/**
 * 1. 类的用途 ： 关注页面，页面
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_FA extends Fragment {

    private ImageView fxJia;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fx, null);
        fxJia = (ImageView) view.findViewById(R.id.fx_jia);

        fxJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(), SouSuo.class);
                startActivity(i);
            }
        });

        return view;
    }
}
