package com.bwie.newstitleshiyabin.Application;

import java.util.Date;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/2/15 09:26
 */


public class Application {
    private static int pageSize = 10;
    public static final String APP_KEY = "a0f19c0e92c82045c9cc4f7e716e6c33";
    public static final String URL_PICTURE = "http://japi.juhe.cn/joke/content/list.from?key="+APP_KEY;


    public static String getUrl(int currentPage) {
        String url = URL_PICTURE + "&page="+currentPage+"&pagesize="+pageSize+"&sort=asc&time="+"1418816972";
        return url;
    }

    public static String getTimeStr() {
        return String.valueOf(new Date().getTime()).substring(0,10);
    }
}
