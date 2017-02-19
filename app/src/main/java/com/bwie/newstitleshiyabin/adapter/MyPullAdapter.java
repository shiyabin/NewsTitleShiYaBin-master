package com.bwie.newstitleshiyabin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.bean.Imgextra;
import com.bwie.newstitleshiyabin.bean.NewsTop;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/15 09:37
 */


public class MyPullAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NewsTop> dataBeen = new ArrayList<>();
    private int TYPE_1 = 0;
    private int TYPE_2 = 1;
    public MyPullAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return dataBeen.size();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public int getItemViewType(int position) {
        Imgextra imgextra = dataBeen.get(position).getImgextra();
        if (imgextra != null) {
            return TYPE_1;
        }
        return TYPE_2;

    }


    @Override
    public Object getItem(int position) {
        return dataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoider holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            holder = new ViewHoider();
            if (type == TYPE_1) {
                convertView = View.inflate(context, R.layout.xw_inte, null);
                holder.inte1_tv= (TextView) convertView.findViewById(R.id.inte1_tv);
                holder.inte2_time=(TextView) convertView.findViewById(R.id.inte2_time);
                holder.inte2Bt_tv=(TextView) convertView.findViewById(R.id.inte2Bt_tv);

                holder.inte1_iv1= (ImageView) convertView.findViewById(R.id.inte1_iv1);
                holder.inte1_iv2= (ImageView) convertView.findViewById(R.id.inte1_iv2);
                holder.inte1_iv3= (ImageView) convertView.findViewById(R.id.inte1_iv3);
                convertView.setTag(holder);
            } else {
                convertView = View.inflate(context, R.layout.item_title, null);
                holder.tv= (TextView) convertView.findViewById(R.id.tv);
                holder.inte1_time=(TextView) convertView.findViewById(R.id.inte1_time);
                holder.inte1Bt_tv=(TextView) convertView.findViewById(R.id.inte1Bt_tv);
                holder.inte2_iv= (ImageView) convertView.findViewById(R.id.inte2_iv);
                convertView.setTag(holder);
            }

        }else{

            holder= (ViewHoider) convertView.getTag();

        }
        if(type==TYPE_1){
            holder.inte1_tv.setText(dataBeen.get(position).getTitle());
            holder.inte2_time.setText(dataBeen.get(position).getLmodify());
            holder.inte2Bt_tv.setText(dataBeen.get(position).getSource());

            ImageLoader.getInstance().displayImage(dataBeen.get(position).getImgsrc(),holder.inte1_iv1);
            ImageLoader.getInstance().displayImage(dataBeen.get(position).getImgextra().getImageOne(),holder.inte1_iv2);
            ImageLoader.getInstance().displayImage(dataBeen.get(position).getImgextra().getImageOne(),holder.inte1_iv3);

        }else{
            holder.tv.setText(dataBeen.get(position).getTitle());
            holder.inte1_time.setText(dataBeen.get(position).getLmodify());
            holder.inte1Bt_tv.setText(dataBeen.get(position).getSource());
            ImageLoader.getInstance().displayImage(dataBeen.get(position).getImgsrc(),holder.inte2_iv);
        }


        return convertView;
    }
    public  void  addData(List<NewsTop> datas, boolean isNeedClear){
        if (datas!=null){
            if (isNeedClear){
                dataBeen.clear();
            }
            dataBeen.addAll(datas);
        }

    }

    class ViewHoider {

        private  ImageView inte1_iv1,inte1_iv2,inte1_iv3,inte2_iv;
        private  TextView inte1_tv,tv,inte1Bt_tv,inte1_time,inte2Bt_tv,inte2_time;

    }


}
