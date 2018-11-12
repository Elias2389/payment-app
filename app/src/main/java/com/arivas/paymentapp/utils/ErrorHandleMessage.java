package com.arivas.paymentapp.utils;

import android.content.Context;
import android.widget.Toast;

import com.arivas.paymentapp.R;

public class ErrorHandleMessage {
    private static ErrorHandleMessage instance = null;


    private ErrorHandleMessage(){
    }


    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ErrorHandleMessage();
        }
    }

    public static ErrorHandleMessage getInstance() {
        if (instance == null) createInstance();
        return instance;
    }

    public void generalError(Context context) {
        Toast.makeText(context, context.getResources().getText(R.string.general_error), Toast.LENGTH_LONG).show();
    }
}
