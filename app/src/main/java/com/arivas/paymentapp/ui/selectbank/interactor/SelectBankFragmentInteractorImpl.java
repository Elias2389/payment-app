package com.arivas.paymentapp.ui.selectbank.interactor;

import android.util.Log;

import com.arivas.paymentapp.model.selectbank.SelectBankModel;
import com.arivas.paymentapp.network.DataProvider;
import com.arivas.paymentapp.network.RetrofitClient;
import com.arivas.paymentapp.network.service.SelectBankservice;
import com.arivas.paymentapp.ui.selectbank.presenter.SelectBankFragmentPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectBankFragmentInteractorImpl implements SelectBankFragmentInteractor {
    private SelectBankFragmentPresenter presenter;

    public SelectBankFragmentInteractorImpl(SelectBankFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getBanks() {
        DataProvider data = DataProvider.getInstance();

        SelectBankservice retrofit =  RetrofitClient.getInstance().retrofitCliente().create(SelectBankservice.class);
        Call<List<SelectBankModel>> call =
                retrofit.selectBank(
                        data.getDataPaymentMethodSelected()
                );

        call.enqueue(new Callback<List<SelectBankModel>>() {
            @Override
            public void onResponse(Call<List<SelectBankModel>> call, Response<List<SelectBankModel>> response) {
                Log.e("call=", call.request().toString());
                if (response.isSuccessful() && !response.body().isEmpty() && response.body() != null) {
                    getBanksSuccess(response.body());
                } else {
                    failed();
                }
            }

            @Override
            public void onFailure(Call<List<SelectBankModel>> call, Throwable t) {
                Log.e("ErrorRetro=", t.getMessage());
                failed();
            }
        });
    }

    @Override
    public void getBanksSuccess(List<SelectBankModel> bankModelList) {
        presenter.getBanksSuccess(bankModelList);
    }

    @Override
    public void failed() {
        presenter.failed();
    }
}
