package com.arivas.paymentapp.network;

import com.arivas.paymentapp.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;

    private RetrofitClient(){
    }

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
    }

    public static RetrofitClient getInstance() {
        if (instance == null) createInstance();
        return instance;
    }

    public Retrofit retrofitCliente() {
        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;
    }

}
