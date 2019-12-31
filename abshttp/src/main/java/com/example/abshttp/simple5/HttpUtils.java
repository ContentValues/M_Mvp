package com.example.abshttp.simple5;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 *
 * 链式写法
 *
 * 单一职责原则:就一个类而言，应该仅有一个引起它变化的原因。简单来说，一个类中应该是一组相关性很高的函数、数据的封装
 *
 *
 */
public class HttpUtils {

   private OKhttpRequest oKhttpRequest;
    private String url;
    private Map<String, Object> params;
    private final int TYPE_POST = 0x0011;
    private final int TYPE_GET  = 0x0022;
    private int mType = TYPE_GET;
    private boolean cache = false;



    public static HttpUtils with(){
        return new HttpUtils();
    }

    //todo 为什么这么传递呢
    private HttpUtils(){
        oKhttpRequest = new OKhttpRequest();
        params = new HashMap<>();
    }

    public HttpUtils setUrl(String url) {
        this.url = url;
        return this;
    }


    public HttpUtils setmType(int mType) {
        this.mType = mType;
        return this;
    }

    public HttpUtils setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public HttpUtils setParams(String name, Object value){
        params.put(name,value);
        return this;
    }

    public HttpUtils setCache(boolean cache) {
        this.cache = cache;
        return this;
    }

    public <T> void request(HttpCallBack<T> callBack){
        //执行方法
         oKhttpRequest.get(url,params,cache,callBack);
    }


     /*public  <T> void get(Context context, String url, Map<String, Object> params, final HttpCallBack<T> callback, final boolean cache) {
        mHttpRequest.get(context,url,params,callback,cache);
    }
    // 10几个参数以上
    public  <T> void get(Context context, String url, Map<String, Object> params,
                         final HttpCallBack<T> callback, final boolean cache,final boolean cookie,int recount) {
        mHttpRequest.get(context,url,params,callback,cache);
    }*/
}
