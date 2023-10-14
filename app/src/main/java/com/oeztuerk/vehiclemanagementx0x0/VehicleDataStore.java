package com.oeztuerk.vehiclemanagementx0x0;

import java.util.List;

public interface VehicleDataStore {
    List<Vehicle> getAllVehicles();
    void addVehicle(Vehicle vehicle);
}
