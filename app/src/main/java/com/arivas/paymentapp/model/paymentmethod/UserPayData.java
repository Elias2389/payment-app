package com.arivas.paymentapp.model.paymentmethod;

public class UserPayData {
    private double dataAmount;
    private String dataPaymentMethodSelected;
    private String dataBankSelected;
    private String dataFeeSelected;


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

    public String getDatadataFeeSelected() {
        return dataFeeSelected;
    }

    public void setDatadataFeeSelected(String datadataFeeSelected) {
        this.dataFeeSelected = datadataFeeSelected;
    }
}
