
package com.arivas.paymentapp.model.paymentmethod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecurityCode {

    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("card_location")
    @Expose
    private String cardLocation;
    @SerializedName("mode")
    @Expose
    private String mode;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getCardLocation() {
        return cardLocation;
    }

    public void setCardLocation(String cardLocation) {
        this.cardLocation = cardLocation;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

}
