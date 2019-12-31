package com.example.abshttp.simple3;

import com.example.abshttp.ConstantValue;
import java.util.HashMap;
import java.util.Map;


/**
 * Author：created by SugarT
 * Time：2019/11/27 17
 */
public class T_Simple3 {


    public static void main(String args[])  {
        getString();
    }

    public static void getString(){
        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("iid", 6152551759L);
        params.put("aid", 7);

        HttpUtils.get(ConstantValue.UrlConstant.HOME_DISCOVERY_URL,params, new HttpCallBack<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
