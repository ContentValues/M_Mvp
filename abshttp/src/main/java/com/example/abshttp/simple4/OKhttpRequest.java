package com.example.abshttp.simple4;

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
 * Time：2019/11/27 17
 */
public class OKhttpRequest {


    private final SPHttpCache spHttpCache;

    public OKhttpRequest(){
        spHttpCache = new SPHttpCache();
    }


    public  <T> void get(String url, Map<String, Object> params, final boolean cache, final HttpCallBack<T> callback) {
        Log.e("Gost请求路径：", "开始网络请求");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor).build();

        // 公共参数
        params.put("app_name", "joke_essay");
        params.put("version_name", "5.7.0");
        params.put("ac", "wifi");
        params.put("device_id", "30036118478");
        params.put("device_brand", "Xiaomi");
        params.put("update_version_code", "5701");
        params.put("manifest_version_code", "570");
        params.put("longitude", "113.000366");
        params.put("latitude", "28.171377");
        params.put("device_platform", "android");

        final String jointUrl = Utils.jointParams(url, params);  //打印
        // 缓存问题
        Log.e("Post请求路径：", jointUrl);  // 缓存写到  SP 里面，多级缓存（内存中 30条,数据库 ，文件中 ）
        final String cacheJson = spHttpCache.getCache(jointUrl);
        // 写一大堆处理逻辑 ，内存怎么扩展等等
        if (cache && !TextUtils.isEmpty(cacheJson)) {
            Gson gson = new Gson();
            // data:{"name","darren"}   data:"请求失败"
            T objResult = (T) gson.fromJson(cacheJson,
                    Utils.analysisClazzInfo(callback));
            callback.onSuccess(objResult);
            return;
        }



        Request.Builder requestBuilder = new Request.Builder().url(jointUrl);
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

                Log.e("TAG",resultJson.equals(cacheJson)+"");

                Gson gson = new Gson();
                T objResult = (T) gson.fromJson(resultJson,Utils.analysisClazzInfo(callback));
                callback.onSuccess(objResult);
                if(cache){
                    spHttpCache.saveCache(jointUrl,resultJson);
                }
            }
        });
    }


    public  <T> void post(String url, Map<String, Object> params, final boolean cache, final HttpCallBack<T> callback) {
        Log.e("Post请求路径：", "开始网络请求");
    }

}
