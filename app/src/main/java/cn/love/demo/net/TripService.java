package cn.love.demo.net;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author：created by SugarT
 * Time：2019/12/4 10
 */
public interface TripService {

    @FormUrlEncoded
    @POST()
    Flowable<ResponseBody> tripShoot(@Field("groupChannelCode") String groupChannelCode);



    @POST("json/searchTripShootListForHomePageV2")
    Flowable<ResponseBody> tripShoot(@Body RequestBody requestBody);

}
