package com.example.asiantech.scanqrcode.network;

import com.example.asiantech.scanqrcode.model.Account;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asiantech on 22/11/2016.
 */

public interface LoginService {
    @POST("api/account/login")
    @FormUrlEncoded
    Call<Account> login(@Field("username")String username,@Field("password")String password);
}
