package com.por.belajarspringboot.request;

public class SaveVehicleRequest {

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
