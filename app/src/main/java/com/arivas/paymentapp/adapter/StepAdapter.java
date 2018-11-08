package com.arivas.paymentapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.arivas.paymentapp.ui.enteramount.view.EnterAmountFragment;
import com.arivas.paymentapp.ui.paymentmethod.view.PaymentMethodFragment;
import com.arivas.paymentapp.ui.selectbank.view.SelectBankFragment;
import com.arivas.paymentapp.ui.selectfee.view.SelectFeeFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

public class StepAdapter extends AbstractFragmentStepAdapter {

    public StepAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return new EnterAmountFragment();
            case 1:
                return new PaymentMethodFragment();
            case 2:
                return new SelectBankFragment();
            case 3:
                return new SelectFeeFragment();
            default:
                return new EnterAmountFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
