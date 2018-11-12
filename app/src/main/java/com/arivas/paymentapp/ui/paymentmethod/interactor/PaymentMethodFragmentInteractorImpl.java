package com.arivas.paymentapp.ui.paymentmethod.interactor;

import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;
import com.arivas.paymentapp.network.RetrofitClient;
import com.arivas.paymentapp.network.service.PaymentMethodService;
import com.arivas.paymentapp.ui.paymentmethod.presenter.PaymentMethodFragmentPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentMethodFragmentInteractorImpl implements PaymentMethodFragmentInteractor {
    private PaymentMethodFragmentPresenter presenter;

    public PaymentMethodFragmentInteractorImpl(PaymentMethodFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getPaymentMethods() {
        PaymentMethodService retrofit =  RetrofitClient.getInstance().retrofitCliente().create(PaymentMethodService.class);
        Call<List<PaymentMethodModel>> call = retrofit.paymentMethod();
        call.enqueue(new Callback<List<PaymentMethodModel>>() {
            @Override
            public void onResponse(Call<List<PaymentMethodModel>> call, Response<List<PaymentMethodModel>> response) {
                if (response.isSuccessful() && !response.body().isEmpty() && response.body() != null) {
                    getPaymentMethodsSuccess(response.body());
                } else {
                    failed();
                }
            }

            @Override
            public void onFailure(Call<List<PaymentMethodModel>> call, Throwable t) {
                failed();
            }
        });

    }

    @Override
    public void getPaymentMethodsSuccess(List<PaymentMethodModel> paymentMethod) {
        presenter.getPaymentMethodsSuccess(paymentMethod);
    }

    @Override
    public void failed() {
        presenter.failed();
    }

}
