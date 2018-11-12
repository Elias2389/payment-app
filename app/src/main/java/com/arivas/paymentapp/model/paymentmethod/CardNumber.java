
package com.arivas.paymentapp.model.paymentmethod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardNumber {

    @SerializedName("validation")
    @Expose
    private String validation;
    @SerializedName("length")
    @Expose
    private Integer length;

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}
