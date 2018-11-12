package com.arivas.paymentapp.ui.selectbank.view;

import com.arivas.paymentapp.model.selectbank.SelectBankModel;

import java.util.List;

public interface SelectBankFragmentView {
    void getBanks();
    void getBanksSuccess(List<SelectBankModel> bankModelList);
    void failed();
    SelectBankFragment getContextView();
}
