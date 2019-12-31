package com.example.abshttp.simple5;

import com.example.abshttp.ConstantValue;


/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 */
public class T_Simple4 {


    public static void main(String args[]) {
        getString();
    }

    public static void getString() {
//        Map<String, Object> params = new HashMap<>();
//        // 特定参数
//        params.put("iid", 6152551759L);
//        params.put("aid", 7);

        HttpUtils.with()
                .setUrl(ConstantValue.UrlConstant.HOME_DISCOVERY_URL)
//                .setParams(params)
                .setParams("iid", 6152551759L)
                .setParams("aid", 7)
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
