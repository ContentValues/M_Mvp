package cn.love.callback;

/**
 * Created by zhangmin on 2017/2/15.
 */

public abstract class ResultCallback<T> {

    public abstract void onSuccess(T data);

    public void onFailure(int code, String msg) {
    }
}
