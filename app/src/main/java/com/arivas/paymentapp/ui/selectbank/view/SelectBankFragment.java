package com.arivas.paymentapp.ui.selectbank.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arivas.paymentapp.R;
import com.arivas.paymentapp.model.paymentmethod.UserPayData;
import com.arivas.paymentapp.model.selectbank.SelectBankModel;
import com.arivas.paymentapp.network.DataProvider;
import com.arivas.paymentapp.ui.selectbank.presenter.SelectBankFragmentPresenter;
import com.arivas.paymentapp.ui.selectbank.presenter.SelectBankFragmentPresenterImpl;
import com.arivas.paymentapp.utils.ErrorHandleMessage;
import com.dpizarro.uipicker.library.picker.PickerUI;
import com.dpizarro.uipicker.library.picker.PickerUISettings;
import com.squareup.picasso.Picasso;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBankFragment extends Fragment implements SelectBankFragmentView, Step, BlockingStep {
    private PickerUI pickerUI;
    private ImageView iconBank;
    private TextView layoutPsd;
    private View view;
    private LoadToast loadToast;
    private SelectBankFragmentPresenter presenter;
    List<SelectBankModel> selectBankList = new ArrayList<SelectBankModel>();
    List<String> banks = new ArrayList<String>();

    public SelectBankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_select_bank, container, false);
        pickerUI = (PickerUI) view.findViewById(R.id.picker_select_bank);
        layoutPsd = (TextView) view.findViewById(R.id.layout_psd);
        iconBank = (ImageView) view.findViewById(R.id.icon_bank);
        presenter = new SelectBankFragmentPresenterImpl(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadToast = new LoadToast(getContext());

        layoutPsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerUI.slide();
            }
        });

        pickerUI.setOnClickItemPickerUIListener(new PickerUI.PickerUIItemClickListener() {
            @Override
            public void onItemClickPickerUI(int which, int position, String valueResult) {
                updateCard(valueResult);
//                Toast.makeText(getContext(), valueResult, Toast.LENGTH_SHORT).show();
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
        getBanks();
    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void getBanks() {
        loadToast.setText(getString(R.string.charge)).show();
        presenter.getBanks();
    }

    @Override
    public void getBanksSuccess(List<SelectBankModel> bankModelList) {
        loadToast.success();
        selectBankList.clear();
        selectBankList = bankModelList;
        for (SelectBankModel item: bankModelList) {
            banks.add(item.getName());
        }

        PickerUISettings pickerUISettings = new PickerUISettings.Builder()
                .withItems(banks)
                .withItemsClickables(false)
                .withUseBlur(false)
                .build();
        pickerUI.setSettings(pickerUISettings);
        pickerUI.slide();
    }

    @Override
    public void failed() {
        loadToast.error();
        ErrorHandleMessage.getInstance().generalError(getContext());
    }

    @Override
    public SelectBankFragment getContextView() {
        return null;
    }

    public void updateCard(String valueSelected) {
        for (SelectBankModel item: selectBankList) {
            if (item.getName().equals(valueSelected)) {
                Picasso.get().load(item.getThumbnail()).into(iconBank);
                layoutPsd.setText(item.getName());
                DataProvider.getInstance().setDataBankSelected(item.getId());
            }
        }
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

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }
}
