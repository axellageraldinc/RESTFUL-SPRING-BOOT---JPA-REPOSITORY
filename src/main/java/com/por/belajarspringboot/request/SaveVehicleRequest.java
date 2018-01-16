package com.por.belajarspringboot.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class SaveVehicleRequest {

    @NotBlank(message = "Vehicle name cannot be empty!")
    @Length(max = 30, message = "Vehicle's name too long!")
    private String vehicle;

    public SaveVehicleRequest() {
    }

    public SaveVehicleRequest(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
