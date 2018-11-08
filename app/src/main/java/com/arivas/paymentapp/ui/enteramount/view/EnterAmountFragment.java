package com.arivas.paymentapp.ui.enteramount.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arivas.paymentapp.R;
import com.arivas.paymentapp.provider.DataProvider;
import com.hanks.passcodeview.CircleView;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterAmountFragment extends Fragment implements Step, View.OnClickListener, BlockingStep {

    private TextView layout_text;
    private TextView tv_input_tip;
    private TextView number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;
    private ImageView numberB, numberOK;
    private ImageView iv_lock, iv_ok;
    private View cursor;
    private View view;
    private String firstInputTip = "Ingrese el monto";
    private int numberTextColor = 0xFF747474;
    private DataProvider dataProvider;


    public EnterAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_enter_amount, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataProvider = DataProvider.getInstance();
        init();
    }



    private void init() {

        layout_text = (TextView) view.findViewById(R.id.layout_psd);
        tv_input_tip = (TextView) view.findViewById(R.id.tv_input_tip);
        cursor = view.findViewById(R.id.cursor);
        iv_lock = (ImageView) view.findViewById(R.id.iv_lock);
        iv_ok = (ImageView) view.findViewById(R.id.iv_ok);

        tv_input_tip.setText(firstInputTip);

        number0 = (TextView) view.findViewById(R.id.number0);
        number1 = (TextView) view.findViewById(R.id.number1);
        number2 = (TextView) view.findViewById(R.id.number2);
        number3 = (TextView) view.findViewById(R.id.number3);
        number4 = (TextView) view.findViewById(R.id.number4);
        number5 = (TextView) view.findViewById(R.id.number5);
        number6 = (TextView) view.findViewById(R.id.number6);
        number7 = (TextView) view.findViewById(R.id.number7);
        number8 = (TextView) view.findViewById(R.id.number8);
        number9 = (TextView) view.findViewById(R.id.number9);
        numberOK = (ImageView) view.findViewById(R.id.numberOK);
        numberB = (ImageView) view.findViewById(R.id.numberB);

        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);

        numberB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeNumber();
            }
        });
        numberOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Listo",Toast.LENGTH_LONG).show();
            }
        });

        number0.setTag(0);
        number1.setTag(1);
        number2.setTag(2);
        number3.setTag(3);
        number4.setTag(4);
        number5.setTag(5);
        number6.setTag(6);
        number7.setTag(7);
        number8.setTag(8);
        number9.setTag(9);
        number0.setTextColor(numberTextColor);
        number1.setTextColor(numberTextColor);
        number2.setTextColor(numberTextColor);
        number3.setTextColor(numberTextColor);
        number4.setTextColor(numberTextColor);
        number5.setTextColor(numberTextColor);
        number6.setTextColor(numberTextColor);
        number7.setTextColor(numberTextColor);
        number8.setTextColor(numberTextColor);
        number9.setTextColor(numberTextColor);

    }

    @Override
    public void onClick(View view) {
        int number = (int) view.getTag();
        addNumber(number);
    }

    private void addNumber(int number) {
        layout_text.append(String.valueOf(number));
    }

    private void removeNumber() {
        String textAmount = layout_text.getText().toString();
        if (textAmount.length() > 0) {
            layout_text.setText(textAmount.substring(0, textAmount.length() -1));
        }

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        dataProvider.setDataAmount(Float.valueOf(layout_text.getText().toString()));
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

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
