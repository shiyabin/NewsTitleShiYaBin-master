package com.bwie.newstitleshiyabin.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bwie.newstitleshiyabin.R;


/**
 * 1. 类的用途 ： 视频页面
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_SP extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sp,null);
        initData();

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initData() {

        WebView web= (WebView) view.findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setPluginState(WebSettings.PluginState.ON);
       //可以使用插件
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        web.getSettings().setAllowFileAccess(true);
        web.getSettings().setDefaultTextEncodingName("UTF-8");
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
        web.setVisibility(View.VISIBLE);
        web.loadUrl("http://player.youku.com/embed/XNTM5MTUwNDA0");
    }
}
