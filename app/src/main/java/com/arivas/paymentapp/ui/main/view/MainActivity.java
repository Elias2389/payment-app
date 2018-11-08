package com.arivas.paymentapp.ui.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arivas.paymentapp.R;
import com.arivas.paymentapp.adapter.StepAdapter;
import com.stepstone.stepper.StepperLayout;

public class MainActivity extends AppCompatActivity {
    private StepperLayout stepperLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        stepperLayout.setAdapter(new StepAdapter(getSupportFragmentManager(), this));
    }
}
