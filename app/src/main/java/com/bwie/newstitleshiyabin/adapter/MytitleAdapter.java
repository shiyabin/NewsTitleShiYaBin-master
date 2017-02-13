package com.bwie.newstitleshiyabin.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/12 16:49
 */

public class MytitleAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private Context context;
    private String[] title;

    public MytitleAdapter(FragmentManager fm, Context context, String[] title) {

        super(fm);
        this.context = context;
        this.title = title;
    }
    public void setList(List<Fragment> list) {
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return  list.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
