package com.arivas.paymentapp.ui.selectbank.interactor;

import com.arivas.paymentapp.model.selectbank.SelectBankModel;

import java.util.List;

public interface SelectBankFragmentInteractor {
    void getBanks();
    void getBanksSuccess(List<SelectBankModel> bankModelList);
    void failed();
}
