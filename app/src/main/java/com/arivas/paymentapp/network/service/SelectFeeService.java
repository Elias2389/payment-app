package com.arivas.paymentapp.network.service;

import com.arivas.paymentapp.BuildConfig;
import com.arivas.paymentapp.model.selectfee.SelectFeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SelectFeeService {
    @GET("payment_methods/installments?public_key="+ BuildConfig.PRIVATE_KEY )
    Call<List<SelectFeeModel>> selectFee(@Query("amount") Double amount,
                                         @Query("payment_method_id") String idMethod,
                                         @Query("issuer.id") int idBank);
}
