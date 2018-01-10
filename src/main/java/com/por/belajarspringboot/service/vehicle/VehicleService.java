package com.por.belajarspringboot.service.vehicle;

import com.por.belajarspringboot.entity.Vehicle;
import com.por.belajarspringboot.request.SaveVehicleRequest;

import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Long personId, SaveVehicleRequest request);
    List<Vehicle> getAllVehicle(Long personId);
    Vehicle getOneVehicleById(Long personId, Long vehicleId);
    void deleteVehicle(Long personId, Long vehicleId);
    Vehicle updateVehicle(Long personId, Long vehicleId, SaveVehicleRequest request);

}
