package com.arivas.paymentapp.ui.paymentmethod.view;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.arivas.paymentapp.R;
import com.arivas.paymentapp.model.paymentmethod.PaymentMethodModel;
import com.arivas.paymentapp.model.paymentmethod.UserPayData;
import com.arivas.paymentapp.network.DataProvider;
import com.arivas.paymentapp.ui.paymentmethod.presenter.PaymentMethodFragmentPresenter;
import com.arivas.paymentapp.ui.paymentmethod.presenter.PaymentMethodFragmentPresenterImpl;
import com.arivas.paymentapp.utils.ErrorHandleMessage;
import com.dpizarro.uipicker.library.picker.PickerUI;
import com.dpizarro.uipicker.library.picker.PickerUISettings;

import com.squareup.picasso.Picasso;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.vinaygaba.creditcardview.CreditCardView;


import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentMethodFragment extends Fragment implements Step, PaymentMethodFragmentView, BlockingStep {
    List<PaymentMethodModel> paymentMethodList = new ArrayList<PaymentMethodModel>();
    List<String> banks = new ArrayList<String>();
    private PaymentMethodFragmentPresenter presenter;
    private ImageView mBrandLogoView;
    private ImageView mCardTypeView;
    private CreditCardView cardView;
    private PickerUI pickerUI;
    private View view;
    private LoadToast loadToast;

    public PaymentMethodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_payment_method, container, false);
        pickerUI = (PickerUI) view.findViewById(R.id.picker_ui_view);
        cardView = (CreditCardView) view.findViewById(R.id.card1);
        mCardTypeView = (ImageView) view.findViewById(R.id.card_logo);
        mBrandLogoView = (ImageView) view.findViewById(R.id.brand_logo);
        presenter = new PaymentMethodFragmentPresenterImpl(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadToast = new LoadToast(getContext());

        cardView.setOnClickListener(new View.OnClickListener() {
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

    @SuppressLint("CheckResult")
    @Override
    public void onSelected() {
        getPaymentMethods();
    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void getPaymentMethods() {
        loadToast.setText(getString(R.string.charge)).show();
        presenter.getPaymentMethods();
    }

    @Override
    public void getPaymentMethodsSuccess(List<PaymentMethodModel> paymentMethod) {
        loadToast.success();
        paymentMethodList = paymentMethod;
        for (PaymentMethodModel item: paymentMethodList) {
            banks.add(item.getName());
        }

        PickerUISettings pickerUISettings = new PickerUISettings.Builder()
                .withItems(banks)
                .withAutoDismiss(true)
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
    public PaymentMethodFragment getContextView() {
        return this;
    }

    public void updateCard(String valueSelected) {
        for (PaymentMethodModel item: paymentMethodList) {
            if (item.getName().equals(valueSelected)) {
                Picasso.get().load(item.getThumbnail()).into(mBrandLogoView);
                cardView.setCardName(item.getName());
                DataProvider.getInstance().setDataPaymentMethodSelected(item.getId());
            }
        }
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        if (cardView.getCardName().toString().equals("")) {
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
