package com.por.belajarspringboot.service.vehicle.Implementation;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.entity.Vehicle;
import com.por.belajarspringboot.repository.VehicleRepository;
import com.por.belajarspringboot.request.SaveVehicleRequest;
import com.por.belajarspringboot.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Long personId, SaveVehicleRequest request) {
        Person person = new Person();
        person.setId(personId);

        Vehicle vehicle = new Vehicle(person, request.getVehicle());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicle(Long personId) {
        return vehicleRepository.findAllByPersonId(personId);
    }

    @Override
    public Vehicle getOneVehicleById(Long personId, Long vehicleId) {
        return vehicleRepository.findByPersonIdAndId(personId, vehicleId);
    }

    @Override
    public Vehicle deleteVehicle(Long personId, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findByPersonIdAndId(personId, vehicleId);
        if(vehicle != null) {
            vehicleRepository.deleteByPersonIdAndId(personId, vehicleId);
        }
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(Long personId, Long vehicleId, SaveVehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findByPersonIdAndId(personId, vehicleId);
        vehicle.setVehicle(request.getVehicle());
        return vehicleRepository.save(vehicle);
    }
}
