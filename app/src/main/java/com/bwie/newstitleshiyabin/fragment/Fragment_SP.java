package com.bwie.newstitleshiyabin.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import  com.bwie.newstitleshiyabin.R;


/**
 * 1. 类的用途 ： 视频页面
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_SP extends Fragment {

    private View view;
    private String[] title = {"热点视频", "娱乐视频", "搞笑视频", "精品视频"};
    private String[] mId = {"V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB"};
    List<Fragment> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sp,null);
        initView();

        return view;
    }

    private void initView() {
        TabLayout tab = (TabLayout) view.findViewById(R.id.video_tablayout);
        ViewPager vp = (ViewPager) view.findViewById(R.id.video_viewpager);
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            VideoTitleFragment titleFragment = new VideoTitleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("mId",mId[i]);
            titleFragment.setArguments(bundle);
            list.add(titleFragment);
        }
        //适配器
        vp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        //第一个参数是未选中颜色，第二参数为选中颜色
        tab.setTabTextColors(Color.BLACK, Color.RED);
        //设置下划线颜色：
        tab.setSelectedTabIndicatorColor(Color.GRAY);
        //设置下划线高度，宽度跟随tab的宽度:
        tab.setSelectedTabIndicatorHeight(5);
        //设置横向模式，默认是纵向
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setupWithViewPager(vp);
    }

    }



