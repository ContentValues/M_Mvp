package cn.love.model.http;

import android.content.Context;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import cn.love.XDroidConf;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * http helper负责创建ApiService实例
 */
public class HttpHelper {
    private static Context mContext;
    private Retrofit mRetrofitClient;

    /**
     * 作用是缓存Service接口 其实用处也不大
     */
    private HashMap<String, Object> mServiceMap;


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


    /**
     * 自定义用 一般情况下OkHttpClient已经初始化了 不需要传参
     *
     * @param serviceClass
     * @param client
     * @param <S>
     * @return
     */
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
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(XDroidConf.HTTP_READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(XDroidConf.HTTP_CONNECT_TIME_OUT, TimeUnit.SECONDS)

                //todo拦截器添加头部
//                .addInterceptor(new BaseInterceptor<>(null, mContext))
                .addInterceptor(httpLoggingInterceptor)
                .build();
        mRetrofitClient = createRetrofitClient(httpClient);
    }

    private Retrofit createRetrofitClient(OkHttpClient httpClient) {

        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(XDroidConf.BASE_URL)
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
