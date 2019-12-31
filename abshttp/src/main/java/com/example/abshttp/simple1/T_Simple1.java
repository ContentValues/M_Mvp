package com.example.abshttp.simple1;


import com.example.abshttp.ConstantValue;
import com.example.abshttp.Log;
import com.example.abshttp.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.love.XDroidConf;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author：created by SugarT
 * Time：2019/11/27 10
 */
public class T_Simple1 {

    private final static String TAG = T_Simple1.class.getSimpleName();

    public static void main(String args[])  {

        postString();

    }


    public static void getString(){

        Log.e("Post请求路径：", "开始网络请求");

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor).build();

        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("iid", 6152551759L);
        params.put("aid", 7);
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

        final String jointUrl = Utils.jointParams(ConstantValue.UrlConstant.MW_URL, params);  //打印
        Log.e("Post请求路径：", jointUrl);

        Request.Builder requestBuilder = new Request.Builder().url(jointUrl);
        //可以省略，默认是GET请求
        Request request = requestBuilder.build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 失败
                Log.e("TAG","异常了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultJson = response.body().string();
                Log.e("TAG", resultJson);
                // 1.JSON解析转换
                // 2.显示列表数据
                // 3.缓存数据
            }
        });
    }





    public static void postString(){

        Log.e("Post请求路径：", "开始网络请求");

        /********************访问网络开始*******************/
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor).build();

        /**
         *  1.MediaType对象包含了三种信息：type - 数据基础类型 、subtype - 数据子类型 以及 charset - 字符编码
         *  (1)text，表示是文本这一大类
         *  (2)x-markdown是subtype，表示是文本这一大类下的markdown这一小类
         *  (3)charset=utf-8 则buffer.readString(charset)表示采用UTF-8编码
         */
        MediaType mediaType= MediaType.parse("text/x-markdown;charset=utf-8");
        /**
         * 2.要提提交的数据内容
         */
        String requestContent="美丽可爱的大咪咪";
        /**
         * 3.合成请求体
         */
        RequestBody requestBody=RequestBody.create(mediaType,requestContent);
        //要访问的地址
        String url="https://api.github.com/markdown/raw";
        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call=mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG,"onFailure getMessage"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG," response.body() = "+response.body().string());
                Log.d(TAG," response.code() = "+response.code());
                Log.d(TAG," response.message() = "+response.message());
                Log.d(TAG," response.protocol() = "+response.protocol());
                Headers headers=response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    Log.d(TAG,""+headers.name(i)+":"+headers.value(i));
                }
            }
        });
    }

}
