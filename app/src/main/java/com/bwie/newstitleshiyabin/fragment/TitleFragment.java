package com.bwie.newstitleshiyabin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.activity.WebViewActivity;
import com.bwie.newstitleshiyabin.adapter.MyPullAdapter;
import com.bwie.newstitleshiyabin.bean.NewsTop;
import com.bwie.newstitleshiyabin.utils.HttPData;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 类的用途 ： 首页数据
 * 2. @author Administrator
 * 3. @date 2017/2/12 16:57
 */


public class TitleFragment extends Fragment implements PullToRefreshExpandableListView.OnRefreshListener2<ListView>,HttPData.HttpDataCallBack<List<NewsTop>> {

    private View view;
    private  boolean isNeedClear;
    private PullToRefreshListView ptrl;
    private MyPullAdapter adapter;
    private int num = 0;
//    private String id;

    //传值
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle = getArguments();
//        id = bundle.getString("id");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_title, null, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ptrl.setMode(PullToRefreshBase.Mode.BOTH);
        ptrl.setOnRefreshListener(this);

        adapter = new MyPullAdapter(getActivity());
        ptrl.setAdapter(adapter);

        HttPData.getData(getArguments().getString("id"),num,this);
        ptrl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsTop newstop = (NewsTop) adapter.getItem(position-1);
                String url = newstop.getUrl_3w();
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url",url);
                Log.i("url","----------->"+url.toString());

                startActivity(intent);
            }
        });
    }

    private void initView() {

        ptrl = (PullToRefreshListView) view.findViewById(R.id.ptrl);

    }


    @Override
    public void success(List<NewsTop> newsTops) {


        adapter.addData(newsTops, isNeedClear);
        adapter.notifyDataSetChanged();
        ptrl.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        num = 0;
        isNeedClear = true;
        HttPData.getData(getArguments().getString("id"), num, this);

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

        num = num + 10;
        isNeedClear = false;
        HttPData.getData(getArguments().getString("id"), num, this);
    }



}
