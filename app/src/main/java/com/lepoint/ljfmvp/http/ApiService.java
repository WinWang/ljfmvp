package com.lepoint.ljfmvp.http;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 2018/4/11.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("api")
    Observable<ResponseBody> queryHomeData(@Field("accessToken") String token,
                                           @Field("actionName") String actionName,
                                           @Field("payload") String payload,
                                           @Field("timestamp") long timaStamp,
                                           @Field("sign") String sign,
                                           @Field("from") String from);

    @FormUrlEncoded
    @POST("get-access-token")
    Observable<ResponseBody> getToken(@Field("mobileType") String type,
                                      @Field("mobileId") String mobileID);
}
