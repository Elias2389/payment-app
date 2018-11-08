package com.arivas.paymentapp.ui.selectbank.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.arivas.paymentapp.R;
import com.dpizarro.uipicker.library.picker.PickerUI;
import com.dpizarro.uipicker.library.picker.PickerUISettings;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBankFragment extends Fragment implements Step{
    private PickerUI pickerUI;
    private View view;
    ImageView iconBank;

    public SelectBankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_select_bank, container, false);
        pickerUI = (PickerUI) view.findViewById(R.id.picker_ui_view);
        iconBank = (ImageView) view.findViewById(R.id.icon_bank);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPicker();
        pickerUI.slide();

        iconBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerUI.slide();
            }
        });

        pickerUI.setOnClickItemPickerUIListener(new PickerUI.PickerUIItemClickListener() {
            @Override
            public void onItemClickPickerUI(int which, int position, String valueResult) {
                Toast.makeText(getContext(), valueResult, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPicker() {
        List<String> banks = new ArrayList<String>();
        banks.add("ICBC");
        banks.add("Santander");
        banks.add("HSBC");
        banks.add("BNA");

        PickerUISettings pickerUISettings = new PickerUISettings.Builder()
                .withItems(banks)
                .withAutoDismiss(true)
                .withItemsClickables(false)
                .withUseBlur(false)
                .build();
        pickerUI.setSettings(pickerUISettings);
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}
