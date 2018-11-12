package com.arivas.paymentapp.ui.paymentmethod.interactor;

import android.content.Context;

import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;

import java.util.List;

public interface PaymentMethodFragmentInteractor {
    void getPaymentMethods();
    void getPaymentMethodsSuccess(List<PaymentMethodModel> paymentMethod);
    void failed();
}
