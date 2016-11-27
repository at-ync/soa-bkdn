package com.example.asiantech.scanqrcode.network;

import com.example.asiantech.scanqrcode.model.Account;
import com.example.asiantech.scanqrcode.model.ResultPig;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
public interface PigDetailServer {
    @GET("api/pig/view-detail")
    Call<ResultPig> getDetailPig(@Query("id") int id);

    @POST("api/health-journal/update")
    @FormUrlEncoded
    Call<Object> updatePig(@Field("pig_id") int mid, @Field("token") String token, @Field("weight")int weight, @Field("health_id")int id,@Field("note")  String note);
}
