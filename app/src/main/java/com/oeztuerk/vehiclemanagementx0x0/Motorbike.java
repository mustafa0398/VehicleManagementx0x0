package com.oeztuerk.vehiclemanagementx0x0;

public class Motorbike extends Vehicle {

    private boolean isElectric;

    public Motorbike(String manufacturer, String modelName, String securityCertificateExpirationDate, boolean isElectric) {
        super(manufacturer, modelName, securityCertificateExpirationDate);
        this.isElectric = isElectric;
    }

    @Override
    public String getAdditionalInfo() {
        return isElectric ? "Electric Vehicle" : "Not electric";
    }

}
