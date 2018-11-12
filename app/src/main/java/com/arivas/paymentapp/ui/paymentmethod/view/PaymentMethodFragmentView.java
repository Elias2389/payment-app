package com.arivas.paymentapp.ui.paymentmethod.view;

import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;

import java.util.List;

public interface PaymentMethodFragmentView {
    void getPaymentMethods();
    void getPaymentMethodsSuccess(List<PaymentMethodModel> paymentMethod);
    void failed();
    PaymentMethodFragment getContextView();
}
