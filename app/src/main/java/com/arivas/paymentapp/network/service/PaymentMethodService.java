package com.arivas.paymentapp.network.service;

import com.arivas.paymentapp.BuildConfig;
import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;


public interface PaymentMethodService {
    @GET("payment_methods?public_key=" + BuildConfig.PRIVATE_KEY)
    Call<List<PaymentMethodModel>> paymentMethod();
}
