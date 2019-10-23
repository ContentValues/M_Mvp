package cn.love.demo;


import cn.love.demo.model.GankResults;
import cn.love.model.http.BaseApiService;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author：LiuXiaoDong on 2018/4/20 18:26.
 */

public interface MainApiService /*extends BaseApiService*/ {

    @FormUrlEncoded
    @POST("userRegister/login")
    Observable<ResponseBody> login(@Field("mobile") String mobile, @Field("code") String code);


//    @GET("data/{type}/{number}/{page}")
//    Flowable<GankResults> getGankData(@Path("type") String type,
//                                      @Path("number") int pageSize,
//                                      @Path("page") int pageNum);


    @GET("data/{type}/{number}/{page}")
    Observable<GankResults> getGankData(@Path("type") String type,
                                        @Path("number") int pageSize,
                                        @Path("page") int pageNum);


}
