package com.example.abshttp.simeple2;

import com.example.abshttp.ConstantValue;
import com.example.abshttp.Log;
import com.example.abshttp.Utils;
import com.example.abshttp.simple1.T_Simple1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 */
public class T_Simple2 {

    private final static String TAG = T_Simple1.class.getSimpleName();

    public static void main(String args[])  {
          getString();
    }

    public static void getString(){
        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("iid", 6152551759L);
        params.put("aid", 7);

        HttpUtils.get(ConstantValue.UrlConstant.HOME_DISCOVERY_URL,params,new Callback() {
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

}
