
package com.arivas.paymentapp.model.paymentmethod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Setting {

    @SerializedName("card_number")
    @Expose
    private CardNumber cardNumber;
    @SerializedName("bin")
    @Expose
    private Bin bin;
    @SerializedName("security_code")
    @Expose
    private SecurityCode securityCode;

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public SecurityCode getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(SecurityCode securityCode) {
        this.securityCode = securityCode;
    }

}
