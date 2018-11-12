package com.arivas.paymentapp.ui.selectfee.view;

import com.arivas.paymentapp.model.selectfee.SelectFeeModel;

import java.util.List;

public interface SelectFeeFragmentView {
    void getFee();
    void getFeeSuccess(List<SelectFeeModel> feeList);
    void failed();
    SelectFeeFragment getContextView();
}
