package com.arivas.paymentapp.ui.selectfee.interactor;

import com.arivas.paymentapp.model.selectfee.SelectFeeModel;
import com.arivas.paymentapp.ui.selectfee.view.SelectFeeFragment;

import java.util.List;

public interface SelectFeeFragmentInteractor {
    void getFee();
    void getFeeSuccess(List<SelectFeeModel> feeList);
    void failed();
}
