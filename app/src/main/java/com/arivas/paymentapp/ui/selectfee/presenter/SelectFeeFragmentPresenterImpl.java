package com.arivas.paymentapp.ui.selectfee.presenter;

import com.arivas.paymentapp.model.selectfee.SelectFeeModel;
import com.arivas.paymentapp.ui.selectfee.interactor.SelectFeeFragmentInteractor;
import com.arivas.paymentapp.ui.selectfee.interactor.SelectFeeFragmentInteractorImpl;
import com.arivas.paymentapp.ui.selectfee.view.SelectFeeFragment;
import com.arivas.paymentapp.ui.selectfee.view.SelectFeeFragmentView;

import java.util.List;

public class SelectFeeFragmentPresenterImpl implements SelectFeeFragmentPresenter {
    private SelectFeeFragmentInteractor interactor;
    private SelectFeeFragmentView view;

    public SelectFeeFragmentPresenterImpl(SelectFeeFragmentView view) {
        this.interactor = new SelectFeeFragmentInteractorImpl(this);
        this.view = view;
    }

    @Override
    public void getFee() {
        interactor.getFee();
    }

    @Override
    public void getFeeSuccess(List<SelectFeeModel> feeList) {
        view.getFeeSuccess(feeList);
    }

    @Override
    public void failed() {
        view.failed();
    }

    @Override
    public SelectFeeFragment getContextView() {
        return null;
    }
}
