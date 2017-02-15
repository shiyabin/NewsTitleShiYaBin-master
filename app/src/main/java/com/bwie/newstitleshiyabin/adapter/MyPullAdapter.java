package com.bwie.newstitleshiyabin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.bean.JavaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/15 09:37
 */


public class MyPullAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<JavaBean.ResultBean.DataBean> dataBeen = new ArrayList<>();

    public MyPullAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return dataBeen.size();
    }

    @Override
    public JavaBean.ResultBean.DataBean getItem(int position) {
        return dataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoider v = null;
        if (convertView == null) {
            v = new ViewHoider();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_title, null);

            v.tv = (TextView) convertView.findViewById(R.id.tv);

            convertView.setTag(v);
        }else {
            v = (ViewHoider) convertView.getTag();
        }
        v.tv.setText(getItem(position).getContent());


        return convertView;
    }
    public  void  addData(List<JavaBean.ResultBean.DataBean> datas, boolean isNeedClear){
        if (datas!=null){
            if (isNeedClear){
                dataBeen.clear();
            }
            dataBeen.addAll(datas);
        }

    }

    static class ViewHoider {
        private TextView tv;

    }
}
