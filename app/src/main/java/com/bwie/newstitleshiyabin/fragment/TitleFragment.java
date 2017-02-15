package com.bwie.newstitleshiyabin.fragment;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.adapter.MyPullAdapter;
import com.bwie.newstitleshiyabin.bean.JavaBean;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/12 16:57
 */


public class TitleFragment extends Fragment implements PullToRefreshExpandableListView.OnRefreshListener2<ListView>{

    private View view;
    private PullToRefreshListView ptrl;
    private MyPullAdapter adapter;
    private  int curPage=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_title, null,false);

        initView();
        initData();
        jiexishuju(false);

        return view;
    }

    private void jiexishuju(final boolean isNeedClear) {
        String url = com.bwie.newstitleshiyabin.Application.Application.getUrl(curPage);
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                JavaBean wen = gson.fromJson(result, JavaBean.class);
                if (wen.getError_code()==0){
                    List<JavaBean.ResultBean.DataBean> data = wen.getResult().getData();
                    adapter.addData(data,isNeedClear);
                    adapter.notifyDataSetChanged();
                    ptrl.onRefreshComplete();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }



    private void initView() {
        ptrl = (PullToRefreshListView) view.findViewById(R.id.ptrl);
        ptrl.setMode(PullToRefreshListView.Mode.BOTH);
        ptrl.setOnRefreshListener(this);
    }
    private void initData() {
        adapter = new MyPullAdapter(getActivity());
        ptrl.setAdapter(adapter);
    }



    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

        curPage=1;
        jiexishuju(true);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

        curPage++;
        jiexishuju(false);
    }
}
