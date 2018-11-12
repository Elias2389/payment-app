package com.arivas.paymentapp.ui.paymentmethod.presenter;

import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;
import com.arivas.paymentapp.ui.paymentmethod.view.PaymentMethodFragment;

import java.util.List;

public interface PaymentMethodFragmentPresenter {
    void getPaymentMethods();
    void getPaymentMethodsSuccess(List<PaymentMethodModel> paymentMethod);
    void failed();
    PaymentMethodFragment getContext();
}
