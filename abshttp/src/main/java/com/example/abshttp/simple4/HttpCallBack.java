package com.example.abshttp.simple4;

/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 */
public  abstract class HttpCallBack<T> {

    public abstract void onSuccess(T result);

    public abstract void onFail(Exception e);

}
