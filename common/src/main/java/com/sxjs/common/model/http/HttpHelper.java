package com.sxjs.common.model.http;

import android.content.Context;

import com.sxjs.common.CommonConfig;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * http helper负责创建ApiService实例
 */
public class HttpHelper {
    private static Context mContext;
    private Retrofit mRetrofitClient;
    private HashMap<String, Object> mServiceMap;

//    static HttpHelper instance = null;
//
//
//    private HttpHelper() {
//        mServiceMap = new HashMap<>();
//        initRetrofitClient();
//    }
//
//    public static synchronized HttpHelper newInstance(Context context) {
//
//        if (instance == null) {
//            instance = new HttpHelper();
//            mContext = context;
//        }
//        return instance;
//    }


//    @Inject
    public HttpHelper(Context context) {
        this.mContext = context;
        mServiceMap = new HashMap<>();
        initRetrofitClient();
    }


    @SuppressWarnings("unchecked")
    public <S> S getService(Class<S> serviceClass) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createService(serviceClass, null);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }


    }

    @SuppressWarnings("unchecked")
    public <S> S getService(Class<S> serviceClass, OkHttpClient client) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createService(serviceClass, client);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }

    private void initRetrofitClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(CommonConfig.HTTP_READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CommonConfig.HTTP_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new BaseInterceptor<>(null, mContext))
                .build();
        mRetrofitClient = createRetrofitClient(httpClient);
    }

    private Retrofit createRetrofitClient(OkHttpClient httpClient) {

        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(CommonConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    private <S> S createService(Class<S> serviceClass, OkHttpClient client) {
        if (client == null) {
            return mRetrofitClient.create(serviceClass);
        } else {
            return createRetrofitClient(client).create(serviceClass);
        }
    }

}
