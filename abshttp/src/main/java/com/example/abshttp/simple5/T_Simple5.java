package com.example.abshttp.simple5;

import android.support.v7.app.AlertDialog;

import com.example.abshttp.ConstantValue;


/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 */
public class T_Simple5 {


    public static void main(String args[]) {
        getString();
    }

    public static void getString() {

        new HttpUtils.Builder()
                .setUrl(ConstantValue.UrlConstant.XC_URL)
                .create()
                .httpRequest(new VolleyRequest())
                .request(new HttpCallBack<String>() {
                    @Override
                    public void onSuccess(String result) {

                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                });
    }
}
