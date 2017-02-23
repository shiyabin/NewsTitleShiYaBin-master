package com.bwie.newstitleshiyabin.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitleshiyabin.R;
import com.bwie.newstitleshiyabin.activity.Account_Password_DengLu;
import com.bwie.newstitleshiyabin.activity.Login_DengLu;
import com.bwie.newstitleshiyabin.activity.Main3Activity;
import com.bwie.newstitleshiyabin.bean.Night;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.greenrobot.eventbus.EventBus;


/**
 * 1. 类的用途 ： 注册登录页面
 * 2. @author Administrator
 * 3. @date 2017/2/10 12:15
 */


public class Fragment_WD extends Fragment implements  View.OnClickListener {

    private View view;
    private ListView wd_lv;
    private  String[] textLv={"消息通知","头条商城","京东提供","我也爆料","用户反馈","系统设置"};
    private ImageView wd_dx;
    private ImageView wd_wx;
    private ImageView wd_qq;
    private ImageView wd_jt;
    private LinearLayout wd_ls;
    private LinearLayout wd_sc;
    private LinearLayout wd_yj;
    private Main3Activity activity;
    private static String gAppid = "1105924500";
    private Tencent tencent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        activity = (Main3Activity) getActivity();

        view = inflater.inflate(R.layout.fragment_wd,null);
        wd_lv = (ListView) view.findViewById(R.id.wd_lv);
        wd_lv.setAdapter( new Myadapter());

        wd_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (isNetworkAvailable(getActivity())) {
                    Intent intent = new Intent(getActivity(), Account_Password_DengLu.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(), "没有可用的网络，请先连接网络",Toast.LENGTH_SHORT).show();

                }
            }
        });

        initView();


        return view;
    }

    private void initView() {
        wd_dx = (ImageView) view.findViewById(R.id.wd_dx);
        wd_wx = (ImageView) view.findViewById(R.id.wd_wx);
        wd_qq = (ImageView) view.findViewById(R.id.wd_qq);
        wd_jt = (ImageView) view.findViewById(R.id.wd_jt);


        wd_ls = (LinearLayout) view.findViewById(R.id.wd_ls);
        wd_sc = (LinearLayout) view.findViewById(R.id.wd_sc);
        wd_yj = (LinearLayout) view.findViewById(R.id.wd_yj);
        wd_yj = (LinearLayout) view.findViewById(R.id.wd_yj);


        wd_dx.setOnClickListener(this);
        wd_wx.setOnClickListener(this);
        wd_qq.setOnClickListener(this);
        wd_jt.setOnClickListener(this);
        wd_yj.setOnClickListener(this);

        tencent = Tencent.createInstance(gAppid,getActivity());


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.wd_dx:
                if (isNetworkAvailable(getActivity())) {
                    Jump(new Login_DengLu());
                }else {
                    Toast.makeText(getActivity(), "没有可用的网络，不能注册",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.wd_wx:
                break;
            case R.id.wd_qq:
                if(isNetworkAvailable(getActivity())) {
                    tencent.login(getActivity(), "all", new BaseUiListener());
                }else {
                    Toast.makeText(getActivity(), "没有可用的网络，不能登录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.wd_jt:
                Jump(new Login_DengLu());
                break;
            case R.id.wd_yj:
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                activity.getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO
                        ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                // 同样需要调用recreate方法使之生效
                recreate();
                break;


        }


    }
    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object o) {
            Log.d("zzz", "onComplete: " + SystemClock.elapsedRealtime());
        }

        @Override
        public void onError(UiError uiError) {
        }

        @Override
        public void onCancel() {

        }

    }

    private void recreate() {
    }

    class  Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return textLv.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=LayoutInflater.from(getActivity()).inflate(R.layout.wd_inte,null);
            TextView wd_tv= (TextView) v.findViewById(R.id.wd_tv);
            wd_tv.setText(textLv[position]);
            return v;
        }
    };



    private void Jump(Activity a) {
        Intent intent = new Intent(getActivity(), a.getClass());
        startActivity(intent);
    }


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
