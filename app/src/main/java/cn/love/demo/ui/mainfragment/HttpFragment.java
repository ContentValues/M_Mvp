package cn.love.demo.ui.mainfragment;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.abshttp.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import cn.love.base.BaseFragment;
import cn.love.demo.R;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author：created by SugarT
 * Time：2019/12/4 10
 */
public class HttpFragment extends BaseFragment {

    private TextView mTvContent;

    public static HttpFragment newInstance() {
        return new HttpFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_http;
    }

    @Override
    public void initView(View v) {

        v.findViewById(R.id.tvGet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGet();
            }
        });
        v.findViewById(R.id.tvPost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doPost();
            }
        });
        mTvContent = v.findViewById(R.id.mTvContent);
    }


    private void doGet() {


        Cache cache = new Cache(new File(getContext().getCacheDir() + "/okhttpCache.txt"),1024*1024*10);

        HttpLoggingInterceptor httpLoggingInterceptor =  new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
//                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(new HttpCacheInterceptor())
                .build();

        Request request = new Request.Builder()
                .get()
                .cacheControl(new CacheControl.Builder()
                        .maxStale(8, TimeUnit.SECONDS)
                        .build())
//                .url("http://gank.io/api/data/福利/10/1")
                .url("http://www.devio.org/io/flutter_app/json/travel_page.json")
                .build();
        Call call = client.newCall(request);



        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println("onResponse" + response.body().string());
            }
        });

    }

    private void doPost() {


        Log.d(TAG, "doPost()");

        HashMap<String, String> params = new HashMap();
        params.put("groupChannelCode", "tourphoto_global1");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(params));


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://m.ctrip.com/restapi/soa2/16189/json/searchTripShootListForHomePageV2")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse" + response.body().string());
            }
        });


//        Api.getTripService().tripShoot(requestBody)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ResponseBody>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//
//                        String str = responseBody.toString();
//
//                        System.out.println("得到的数据" + str);
//
//                        Log.d(TAG, "onNext  -->" + str);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                        Log.d(TAG, "onError");
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                        Log.d(TAG, "onComplete");
//
//                    }
//                });

    }


}
