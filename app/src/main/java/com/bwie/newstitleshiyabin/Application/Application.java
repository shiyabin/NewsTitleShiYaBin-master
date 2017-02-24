package com.bwie.newstitleshiyabin.Application;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatDelegate;

import com.bwie.newstitleshiyabin.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import org.xutils.x;

import java.util.Date;

import static android.R.attr.hardwareAccelerated;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/15 09:26
 */


public class Application extends android.app.Application{

    public static boolean isFlag;

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        isFlag=true;


        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .showImageOnFail(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();


        //这样自定义设置后就可以管理二级缓存和三级缓存了
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(20)//设置占用内存的百分比
                .diskCacheFileCount(100)//设置最大下载图片数
                .diskCacheSize(5 * 1024 * 1024)
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(configuration);//初始化完成


        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }
    }

