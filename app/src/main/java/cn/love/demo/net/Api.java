package cn.love.demo.net;

import cn.love.net.XApi;

/**
 * Created by wanglei on 2016/12/31.
 */

public class Api {
    public static final String API_BASE_URL = "http://gank.io/api/";

    private static GankService gankService;
    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (Api.class) {
                if (gankService == null) {
                    gankService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(GankService.class);
                }
            }
        }
        return gankService;
    }


    private static TripService tripService;
    public static final String API_BASE_URL_TRIP = "https://m.ctrip.com/restapi/soa2/16189/";
    public static TripService getTripService() {
        if (tripService == null) {
            synchronized (Api.class) {
                if (tripService == null) {
                    tripService = XApi.getInstance().getRetrofit(API_BASE_URL_TRIP, true).create(TripService.class);
                }
            }
        }
        return tripService;
    }

}
