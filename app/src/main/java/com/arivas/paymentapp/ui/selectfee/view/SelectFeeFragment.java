package com.arivas.paymentapp.ui.selectfee.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arivas.paymentapp.R;
import com.arivas.paymentapp.adapter.StepAdapter;
import com.arivas.paymentapp.model.paymentmethod.UserPayData;
import com.arivas.paymentapp.model.selectfee.PayerCost;
import com.arivas.paymentapp.model.selectfee.SelectFeeModel;
import com.arivas.paymentapp.network.DataProvider;
import com.arivas.paymentapp.ui.enteramount.view.EnterAmountFragment;
import com.arivas.paymentapp.ui.main.view.MainActivity;
import com.arivas.paymentapp.ui.selectfee.presenter.SelectFeeFragmentPresenter;
import com.arivas.paymentapp.ui.selectfee.presenter.SelectFeeFragmentPresenterImpl;
import com.arivas.paymentapp.utils.ErrorHandleMessage;
import com.dpizarro.uipicker.library.picker.PickerUI;
import com.dpizarro.uipicker.library.picker.PickerUISettings;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.tapadoo.alerter.Alerter;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFeeFragment extends Fragment implements SelectFeeFragmentView ,Step, BlockingStep{
    private PickerUI pickerUIFee;
    private TextView layoutPsd;
    private FrameLayout pant;
    private LoadToast loadToast;
    private View view;
    StepperLayout stepperLayout;
    private SelectFeeFragmentPresenter presenter;
    List<SelectFeeModel> selectFeeList = new ArrayList<SelectFeeModel>();
    List<String> fee = new ArrayList<String>();

    public SelectFeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_select_fee, container, false);
        pickerUIFee = (PickerUI) view.findViewById(R.id.picker_ui_view);
        layoutPsd = (TextView) view.findViewById(R.id.layout_psd);
        pant = (FrameLayout) view.findViewById(R.id.pant);
        stepperLayout =(StepperLayout) getActivity().findViewById(R.id.stepperLayout);
        presenter = new SelectFeeFragmentPresenterImpl(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadToast = new LoadToast(getContext());

        layoutPsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerUIFee.slide();
            }
        });

        pant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerUIFee.slide();
            }
        });

        pickerUIFee.setOnClickItemPickerUIListener(new PickerUI.PickerUIItemClickListener() {
            @Override
            public void onItemClickPickerUI(int which, int position, String valueResult) {
            layoutPsd.setText(valueResult);
            DataProvider.getInstance().setDataFeeSelected(valueResult);
            }
        });
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        getFee();
    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void getFee() {
        loadToast.setText(getString(R.string.charge)).show();
        presenter.getFee();
    }

    @Override
    public void getFeeSuccess(List<SelectFeeModel> feeList) {
        loadToast.success();
        selectFeeList.clear();
        selectFeeList = feeList;
        for (SelectFeeModel item: feeList) {
            for (PayerCost payerCost: item.getPayerCosts()) {
                fee.add(payerCost.getRecommendedMessage());
            }
        }

        PickerUISettings pickerUISettings = new PickerUISettings.Builder()
                .withItems(fee)
                .withItemsClickables(false)
                .withUseBlur(false)
                .build();
        pickerUIFee.setSettings(pickerUISettings);
        pickerUIFee.slide();
    }

    @Override
    public void failed() {
        loadToast.error();
        ErrorHandleMessage.getInstance().generalError(getContext());
    }

    @Override
    public SelectFeeFragment getContextView() {
        return null;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        if (layoutPsd.getText().toString().equals("")) {
            failed();
        } else {
            callback.goToNextStep();
         }
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        callback.complete();
        Alerter.create(getActivity())
                .setTitle(getResources().getString(R.string.send_data))
                .setText(getString(R.string.amount) + ": " + DataProvider.getInstance().getDataAmount() + "\n" +
                        getString(R.string.payment_selected) + ": " + DataProvider.getInstance().getDataPaymentMethodSelected() + "\n" +
                        getString(R.string.bank) + ": " + DataProvider.getInstance().getDataBankSelected() + "\n" +
                        getString(R.string.fee_selected) + ": " + DataProvider.getInstance().getDataFeeSelected()
                )
                .enableInfiniteDuration(true)
                .enableVibration(true)
                .setBackgroundColorInt(getResources().getColor(R.color.colorPrimaryDark))
                .show();

        stepperLayout.setCurrentStepPosition(0);
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }
}
