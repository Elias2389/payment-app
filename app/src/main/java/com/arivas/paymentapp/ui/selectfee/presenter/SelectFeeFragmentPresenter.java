package com.arivas.paymentapp.ui.selectfee.presenter;

import com.arivas.paymentapp.model.selectfee.SelectFeeModel;
import com.arivas.paymentapp.ui.selectfee.view.SelectFeeFragment;

import java.util.List;

public interface SelectFeeFragmentPresenter {
    void getFee();
    void getFeeSuccess(List<SelectFeeModel> feeList);
    void failed();
    SelectFeeFragment getContextView();
}
