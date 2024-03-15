package com.example.productlocationfinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("Data")
    @Expose
    private RegistrationResult registrationResult;

    public DataModel(RegistrationResult registrationResult) {
        this.registrationResult = registrationResult;
    }

    public RegistrationResult getRegistrationResult() {
        return registrationResult;
    }

    public void setRegistrationResult(RegistrationResult registrationResult) {
        this.registrationResult = registrationResult;
    }
}
