package com.arivas.paymentapp.provider;

import android.util.Log;

public class DataProvider {

    private static DataProvider instance = null;
    public float dataAmount;
    public String dataBankSelected, dataPaymentMethodSelected;
    public int datadataFeeSelected;

    private DataProvider(){
    }

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
    }

    public static DataProvider getInstance() {
        if (instance == null) createInstance();
        return instance;
    }

    public float getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(float dataAmount) {
        this.dataAmount = dataAmount;
    }

    public String getDataBankSelected() {
        return dataBankSelected;
    }

    public void setDataBankSelected(String dataBankSelected) {
        this.dataBankSelected = dataBankSelected;
    }

    public String getDataPaymentMethodSelected() {
        return dataPaymentMethodSelected;
    }

    public void setDataPaymentMethodSelected(String dataPaymentMethodSelected) {
        this.dataPaymentMethodSelected = dataPaymentMethodSelected;
    }

    public int getDatadataFeeSelected() {
        return datadataFeeSelected;
    }

    public void setDatadataFeeSelected(int datadataFeeSelected) {
        this.datadataFeeSelected = datadataFeeSelected;
    }
}
