package com.example.abshttp.simple5;

/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 */
public class SPHttpCache {

    public  void saveCache(String url, String resultJson) {
        PreferencesUtil.getInstance().saveParam(url, resultJson);
    }

    public  String getCache(String url) {
        return (String) PreferencesUtil.getInstance().getObject(url);
    }

}
