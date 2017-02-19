package com.bwie.newstitleshiyabin.utils;


import com.bwie.newstitleshiyabin.bean.Imgextra;
import com.bwie.newstitleshiyabin.bean.NewsTop;


import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HttPData {

    public static void getData(String id, int num1, final HttpDataCallBack httpDataCallBack) {
        final String url = UrlPath.getUri(id, num1);
        x.http().get(new RequestParams(url), new Callback.CacheCallback<String>() {

                    private Imgextra imgextra1;

                    @Override
                    public void onSuccess(String result) {


                        List<NewsTop> list = new ArrayList<NewsTop>();


                        try {
                            JSONObject jsject = new JSONObject(result);

                            Iterator<String> keys = jsject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONArray jsonArray = jsject.optJSONArray(next);
                                for (int i = 1; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String imgsrc = jsonObject.optString("imgsrc");
                                    String lmodify = jsonObject.optString("lmodify");
                                    String title = jsonObject.optString("title");
                                    String source = jsonObject.optString("source");
                                    String url_3w = jsonObject.optString("url_3w");
                                    String replyCount = jsonObject.optString("replyCount");
                                    JSONArray imgextra = jsonObject.optJSONArray("imgextra");
                                    if (imgextra != null && imgextra.length() > 0) {
                                        String imageOne = imgextra.optJSONObject(0).optString("imgsrc");
                                        String imageTwo = imgextra.optJSONObject(1).optString("imgsrc");
                                        imgextra1 = new Imgextra(imageOne, imageTwo);

                                    } else {
                                        imgextra1 = null;
                                    }

                                    NewsTop newsTop = new NewsTop(imgsrc, lmodify, title, source, url_3w, replyCount, imgextra1);
                                    list.add(newsTop);
                                    //         Log.e("--------222222------", list.toString());
                                }


                                httpDataCallBack.success(list);
                                //      Log.e("------------------", list.toString());
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
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

                    @Override
                    public boolean onCache(String result) {
                        return false;
                    }
                }

        );

    }

    public interface HttpDataCallBack<T> {
        void success(T t);
    }
}
