package com.example.asiantech.scanqrcode.network;

import android.content.Context;

import com.example.asiantech.scanqrcode.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asiantech on 22/11/2016.
 */

public class ApiClient {
    private Context mContext;

    public ApiClient(Context context){
        this.mContext = context;
    }
    private Retrofit retrofit = null;
    private Gson gson = new GsonBuilder().setLenient().create();
    public  Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(mContext.getString(R.string.url))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
