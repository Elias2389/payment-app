package com.arivas.paymentapp.network;


import com.arivas.paymentapp.model.paymentmethod.UserPayData;

public class DataProvider {
    private UserPayData userPayData;
    private static DataProvider instance = null;
    private double dataAmount;
    private String dataPaymentMethodSelected;
    private String dataBankSelected;
    private String dataFeeSelected;

    private DataProvider(){
    }

    public double getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(double dataAmount) {
        this.dataAmount = dataAmount;
    }

    public String getDataPaymentMethodSelected() {
        return dataPaymentMethodSelected;
    }

    public void setDataPaymentMethodSelected(String dataPaymentMethodSelected) {
        this.dataPaymentMethodSelected = dataPaymentMethodSelected;
    }

    public String getDataBankSelected() {
        return dataBankSelected;
    }

    public void setDataBankSelected(String dataBankSelected) {
        this.dataBankSelected = dataBankSelected;
    }

    public String getDataFeeSelected() {
        return dataFeeSelected;
    }

    public void setDataFeeSelected(String dataFeeSelected) {
        this.dataFeeSelected = dataFeeSelected;
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


    public static void setInstance(DataProvider instance) {
        DataProvider.instance = instance;
    }

    public UserPayData getUserPayData() {
        return userPayData;
    }

    public void setUserPayData(UserPayData userPayData) {
        this.userPayData = userPayData;
    }
}
