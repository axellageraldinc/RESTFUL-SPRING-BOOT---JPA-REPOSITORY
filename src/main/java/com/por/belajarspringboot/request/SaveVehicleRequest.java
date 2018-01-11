package com.por.belajarspringboot.request;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.type.VehicleType;
import org.hibernate.validator.constraints.NotBlank;

public class SaveVehicleRequest {

    private VehicleType vehicleType;

    public SaveVehicleRequest() {
    }

    public SaveVehicleRequest(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
