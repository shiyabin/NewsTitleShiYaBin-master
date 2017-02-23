package com.bwie.newstitleshiyabin.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.activity.SouSuo;
import com.bwie.newstitleshiyabin.adapter.MyPullAdapter;
import com.bwie.newstitleshiyabin.adapter.MytitleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途 ： 首页
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_XW extends Fragment {


    private String[] title = {"推荐", "足球", "娱乐", "体育", "财经", "科技", "电影", "汽车"};
    private String[] str = {"T1348647909107", "T1399700447917", "T1348648517839", "T1348649079062", "T1348648756099", "T1348649580692", "T1348648650048", "T1348654060988"};
    private View view;
    private EditText fragXwEt;
    private ViewPager frag_xw_vp;

    private List<Fragment> list;
    private TabLayout frag_xw_tl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xw, null);
        //网络判断
        if(isNetworkAvailable(getActivity())) {
            initView();
            buju();
        } else {
            Toast.makeText(getActivity(), "没有可用的网络",Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void buju() {
        frag_xw_vp = (ViewPager) view.findViewById(R.id.frag_xw_vp);
        frag_xw_tl = (TabLayout) view.findViewById(R.id.frag_xw_tl);
        list = new ArrayList<Fragment>();
        for (int i = 0; i < title.length; i++) {
            com.bwie.newstitleshiyabin.fragment.TitleFragment fragment = new com.bwie.newstitleshiyabin.fragment.TitleFragment();
            Bundle bun = new Bundle();
            bun.putString("id",str[i]);
            fragment.setArguments(bun);


            list.add(fragment);
        }
        MytitleAdapter adapter = new MytitleAdapter(getActivity().getSupportFragmentManager(), getActivity(), title);
        adapter.setList(list);
        frag_xw_vp.setAdapter(adapter);
        frag_xw_tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        frag_xw_tl.setupWithViewPager(frag_xw_vp);
    }

    private void initView() {
        fragXwEt = (EditText) view.findViewById(R.id.frag_xw_et);
        fragXwEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), SouSuo.class);
                startActivity(it);
            }
        });

    }

    // 判断当前是否有可用的网络
    public boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    System.out.println(i + "===状态==="
                            + networkInfo[i].getState());
                    System.out.println(i + "===类型==="
                            + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
