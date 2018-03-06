package com.av.okmenu.callData;


import com.av.okmenu.classes.LoginResponse;
import com.av.okmenu.classes.SyncDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Mina on 1/10/2018.
 */

public interface ApiInterface {
    //@GET("/api/users?")
    @FormUrlEncoded
    @POST("users/login")
    Call<LoginResponse> loginApi(@Field("email")String email, @Field("password")String password, @Field("deviceToken") String deviceToken);

    @FormUrlEncoded
    @POST("users/synchronize")
    Call<SyncDataResponse> syncData(@Field("adminId") int adminId);
}
