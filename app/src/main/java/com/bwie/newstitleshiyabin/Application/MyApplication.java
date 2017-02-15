package com.bwie.newstitleshiyabin.Application;

import android.app.Application;

import org.xutils.x;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/15 09:28
 */


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
