package com.arivas.paymentapp.ui.selectfee.interactor;

import android.util.Log;

import com.arivas.paymentapp.model.selectfee.SelectFeeModel;
import com.arivas.paymentapp.network.DataProvider;
import com.arivas.paymentapp.network.RetrofitClient;
import com.arivas.paymentapp.network.service.SelectFeeService;
import com.arivas.paymentapp.ui.selectfee.presenter.SelectFeeFragmentPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectFeeFragmentInteractorImpl implements SelectFeeFragmentInteractor {
    private SelectFeeFragmentPresenter presenter;

    public SelectFeeFragmentInteractorImpl(SelectFeeFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getFee() {
        DataProvider dataProvider = DataProvider.getInstance();
        SelectFeeService retrofit =  RetrofitClient.getInstance().retrofitCliente().create(SelectFeeService.class);
        Call<List<SelectFeeModel>> call =
                retrofit.selectFee(
                        dataProvider.getDataAmount(),
                        String.valueOf(dataProvider.getDataPaymentMethodSelected()),
                        Integer.valueOf(dataProvider.getDataBankSelected())
                );

        call.enqueue(new Callback<List<SelectFeeModel>>() {
            @Override
            public void onResponse(Call<List<SelectFeeModel>> call, Response<List<SelectFeeModel>> response) {
                Log.i("call===", call.request().toString());
                if (response.isSuccessful()) {
                   getFeeSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SelectFeeModel>> call, Throwable t) {
                presenter.failed();
            }
        });
    }

    @Override
    public void getFeeSuccess(List<SelectFeeModel> feeList) {
        presenter.getFeeSuccess(feeList);
    }

    @Override
    public void failed() {
        presenter.failed();
    }
}
