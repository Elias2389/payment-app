package com.arivas.paymentapp.ui.selectbank.presenter;

import com.arivas.paymentapp.model.selectbank.SelectBankModel;
import com.arivas.paymentapp.ui.selectbank.interactor.SelectBankFragmentInteractor;
import com.arivas.paymentapp.ui.selectbank.interactor.SelectBankFragmentInteractorImpl;
import com.arivas.paymentapp.ui.selectbank.view.SelectBankFragment;
import com.arivas.paymentapp.ui.selectbank.view.SelectBankFragmentView;

import java.util.List;

public class SelectBankFragmentPresenterImpl implements SelectBankFragmentPresenter {
    private SelectBankFragmentInteractor interactor;
    private SelectBankFragmentView view;

    public SelectBankFragmentPresenterImpl(SelectBankFragmentView view) {
        this.interactor = new SelectBankFragmentInteractorImpl(this);
        this.view = view;
    }

    @Override
    public void getBanks() {
        interactor.getBanks();
    }

    @Override
    public void getBanksSuccess(List<SelectBankModel> bankModelList) {
        view.getBanksSuccess(bankModelList);
    }

    @Override
    public void failed() {
        view.failed();
    }

    @Override
    public SelectBankFragment getContextView() {
        return null;
    }
}
