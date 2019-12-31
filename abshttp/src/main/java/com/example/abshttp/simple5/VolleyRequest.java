package com.example.abshttp.simple5;

import android.text.TextUtils;

import com.example.abshttp.Log;
import com.example.abshttp.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author：created by SugarT
 * Time：2019/11/27 22
 */
public class VolleyRequest implements IHttpRequest {

    private final SPHttpCache spHttpCache;
    private final OkHttpClient mOkHttpClient;

    public VolleyRequest(){
        spHttpCache = new SPHttpCache();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor).build();
    }

    @Override
    public  <T> void get(String url, Map<String, Object> params, final boolean cache, final HttpCallBack<T> callback) {
        Log.e("Gost请求路径：", "开始网络请求");

        Request.Builder requestBuilder = new Request.Builder().url(url);
        //可以省略，默认是GET请求
        Request request = requestBuilder.build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFail(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultJson = response.body().string();
                Log.e("TAG",resultJson);
            }
        });
    }


    @Override
    public  <T> void post(String url, Map<String, Object> params, final boolean cache, final HttpCallBack<T> callback) {
        Log.e("Post请求路径：", "开始网络请求");
    }
}
