package com.example.abshttp.simple5;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 *
 * 面向对象的语言的三大特点是继承、封装、多态，里氏替换原则就是依赖于继承、多态这两大特性
 *
 * 链式写法
 *
 * 1 单一职责原则:就一个类而言，应该仅有一个引起它变化的原因。简单来说，一个类中应该是一组相关性很高的函数、数据的封装
 * 2 开闭原则:软件中的对象（类、模块、函数等）应该对于扩展是开放的，但是，对于修改是封闭的
 *           当软件需要变化时，应该尽量通过扩展的方式来实现变化，而不是通过修改已有的代码来实现
 * 3 里氏替换原则:引用基类的地方必须能透明地使用其子类的对象。通俗点讲，只要父类能出现的地方子类就可以出现
 *            // 1. 今天所写的初始化请求
 *                 HttpUtils.initHttpRequest(new XUtilsRequest());
 *                 HttpUtils.initHttpRequest(new OKHttpRequest());
 *          // 2. RecyclerView 的 LayoutMananger
 *                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
 *                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
 * 4 依赖倒置原则:高层模块不依赖低层次模块的细节
 */
public class HttpUtils {

//    依赖的就已经不在是具体的细节了，而是抽象的 IHttpRequest 这个可以在 application 中去初始化
    private static IHttpRequest mInitHttpRequest;

    // 这个可以在 application 中去初始化  备用替代方案
    private IHttpRequest mHttpRequest;


    private String url;
    private Map<String, Object> params;
    private final int TYPE_POST = 0x0011;
    private final int TYPE_GET  = 0x0022;
    private int mType = TYPE_GET;
    private boolean cache = false;


    public HttpUtils(String url, Map<String, Object> params, int mType, boolean cache) {
        this.url = url;
        this.params = params;
        this.mType = mType;
        this.cache = cache;
    }

    /**
     * 建造者模式 一般都使用链式写法
     */
    public static class Builder{
        private String url;
        private Map<String, Object> params;
        private final int TYPE_POST = 0x0011;
        private final int TYPE_GET  = 0x0022;
        private int mType = TYPE_GET;
        private boolean cache = false;

        public Builder() {
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setParams(Map<String, Object> params) {
            this.params = params;
            return this;
        }

        public Builder setmType(int mType) {
            this.mType = mType;
            return this;
        }

        public Builder setCache(boolean cache) {
            this.cache = cache;
            return this;
        }

        /**
         * AlertDialog中写法
         * @return
         */
        public HttpUtils create(){
            HttpUtils httpUtils = new HttpUtils(url,params,mType,cache);
            return httpUtils;
        }

        /**
         * 这种事OKHttp 中的request写法
         * @return
         */
//        public HttpUtils build(){
//            HttpUtils httpUtils = new HttpUtils(url,params,mType,cache);
//            return httpUtils;
//        }

    }




//    public static HttpUtils with(){
//        return new HttpUtils();
//    }

    //todo 为什么这么传递呢
//    private HttpUtils(){
////        mHttpRequest = new OKhttpRequest();
//        params = new HashMap<>();
//    }

    public static void initHttpRequest(IHttpRequest httpRequest) {
        mInitHttpRequest = httpRequest;
    }

      //    如果有两种的情况下 比如 volley 下载文件并不是很屌 ，那么可以换成 OKHttp
    public HttpUtils httpRequest(IHttpRequest httpRequest){
        mHttpRequest = httpRequest;
        return this;
    }

//
//    public HttpUtils setUrl(String url) {
//        this.url = url;
//        return this;
//    }
//
//
//    public HttpUtils setmType(int mType) {
//        this.mType = mType;
//        return this;
//    }
//
//    public HttpUtils setParams(Map<String, Object> params) {
//        this.params = params;
//        return this;
//    }
//
//    public HttpUtils setParams(String name, Object value){
//        params.put(name,value);
//        return this;
//    }
//
//    public HttpUtils setCache(boolean cache) {
//        this.cache = cache;
//        return this;
//    }

    public <T> void request(HttpCallBack<T> callBack){

        // 如果没有指定，那么就用 application 中初始化的
        if(mHttpRequest == null){
            mHttpRequest = mInitHttpRequest;
        }
        //执行方法
        mHttpRequest.get(url,params,cache,callBack);
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
