package com.oeztuerk.vehiclemanagementx0x0;

public class Car extends Vehicle{
    private int numberOfSeats;

    public Car(String manufacturer, String modelName, String securityCertificateExpirationDate, int numberOfSeats) {
        super(manufacturer, modelName, securityCertificateExpirationDate);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String getAdditionalInfo() {
        return "Number of seats: " + numberOfSeats;
    }
}
