
package com.arivas.paymentapp.model.paymentmethod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bin {

    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("installments_pattern")
    @Expose
    private String installmentsPattern;
    @SerializedName("exclusion_pattern")
    @Expose
    private Object exclusionPattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getInstallmentsPattern() {
        return installmentsPattern;
    }

    public void setInstallmentsPattern(String installmentsPattern) {
        this.installmentsPattern = installmentsPattern;
    }

    public Object getExclusionPattern() {
        return exclusionPattern;
    }

    public void setExclusionPattern(Object exclusionPattern) {
        this.exclusionPattern = exclusionPattern;
    }

}
