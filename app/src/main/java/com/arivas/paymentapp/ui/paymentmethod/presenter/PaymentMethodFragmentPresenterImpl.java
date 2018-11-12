package com.arivas.paymentapp.ui.paymentmethod.presenter;

import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;
import com.arivas.paymentapp.ui.paymentmethod.interactor.PaymentMethodFragmentInteractor;
import com.arivas.paymentapp.ui.paymentmethod.interactor.PaymentMethodFragmentInteractorImpl;
import com.arivas.paymentapp.ui.paymentmethod.view.PaymentMethodFragment;
import com.arivas.paymentapp.ui.paymentmethod.view.PaymentMethodFragmentView;

import java.util.List;

public class PaymentMethodFragmentPresenterImpl  implements PaymentMethodFragmentPresenter {
    private PaymentMethodFragmentInteractor interactor;
    private PaymentMethodFragmentView view;

    public PaymentMethodFragmentPresenterImpl(PaymentMethodFragmentView view) {
        this.interactor = new PaymentMethodFragmentInteractorImpl(this);
        this.view = view;
    }

    @Override
    public void getPaymentMethods() {
        interactor.getPaymentMethods();
    }

    @Override
    public void getPaymentMethodsSuccess(List<PaymentMethodModel> paymentMethod) {
        view.getPaymentMethodsSuccess(paymentMethod);
    }

    @Override
    public void failed() {
        view.failed();
    }

    @Override
    public PaymentMethodFragment getContext() {
        return view.getContextView();
    }
}
