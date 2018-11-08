package com.arivas.paymentapp.ui.selectfee.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.arivas.paymentapp.R;
import com.dpizarro.uipicker.library.picker.PickerUI;
import com.dpizarro.uipicker.library.picker.PickerUISettings;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFeeFragment extends Fragment implements Step {
    private PickerUI pickerUIFee;
    private View view;
    ImageView iconFee;

    public SelectFeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_select_fee, container, false);
        pickerUIFee = (PickerUI) view.findViewById(R.id.picker_ui_view);
        iconFee = (ImageView) view.findViewById(R.id.icon_fee);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPicker();
        pickerUIFee.slide();

        iconFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerUIFee.slide();
            }
        });

        pickerUIFee.setOnClickItemPickerUIListener(new PickerUI.PickerUIItemClickListener() {
            @Override
            public void onItemClickPickerUI(int which, int position, String valueResult) {
                Toast.makeText(getContext(), valueResult, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initPicker() {
        List<String> fee = new ArrayList<String>();
        fee.add("12");
        fee.add("24");
        fee.add("36");

        PickerUISettings pickerUISettings = new PickerUISettings.Builder()
                .withItems(fee)
                .withAutoDismiss(true)
                .withItemsClickables(false)
                .withUseBlur(false)
                .build();
        pickerUIFee.setSettings(pickerUISettings);
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
