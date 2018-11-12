package com.arivas.paymentapp.ui.selectbank.presenter;

import com.arivas.paymentapp.model.selectbank.SelectBankModel;
import com.arivas.paymentapp.ui.selectbank.view.SelectBankFragment;

import java.util.List;

public interface SelectBankFragmentPresenter {
    void getBanks();
    void getBanksSuccess(List<SelectBankModel> bankModelList);
    void failed();
    SelectBankFragment getContextView();
}
