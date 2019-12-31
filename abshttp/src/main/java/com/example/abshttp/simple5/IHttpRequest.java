package com.example.abshttp.simple5;

import java.util.Map;

/**
 * Author：created by SugarT
 * Time：2019/11/27 22
 */
public interface IHttpRequest {

    <T> void get(String url, Map<String, Object> params, final boolean cache, final HttpCallBack<T> callback);

    <T> void post(String url, Map<String, Object> params, final boolean cache, final HttpCallBack<T> callback);


}
