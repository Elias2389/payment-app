package com.arivas.paymentapp.network.service;

import com.arivas.paymentapp.BuildConfig;
import com.arivas.paymentapp.model.selectbank.SelectBankModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SelectBankservice {
    @GET("payment_methods/card_issuers?public_key="+ BuildConfig.PRIVATE_KEY )
    Call<List<SelectBankModel>> selectBank( @Query("payment_method_id") String idMethod);
}
