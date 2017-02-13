package com.bwie.newstitleshiyabin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newstitleshiyabin.R;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_WD extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_wd,null);

        return view;
    }
}
