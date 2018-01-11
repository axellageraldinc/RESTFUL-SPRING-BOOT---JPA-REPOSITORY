package com.por.belajarspringboot.controller;

import com.por.belajarspringboot.entity.Vehicle;
import com.por.belajarspringboot.request.SaveVehicleRequest;
import com.por.belajarspringboot.service.person.PersonService;
import com.por.belajarspringboot.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/person/{personId}/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Vehicle saveVehicle(@PathVariable("personId") Long personId,
                               @Valid @RequestBody SaveVehicleRequest request){
        return vehicleService.saveVehicle(personId, request);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Vehicle> getAllVehicle(@PathVariable("personId") Long personId){
        return vehicleService.getAllVehicle(personId);
    }

    @RequestMapping(
            value = "/{vehicleId)",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Vehicle getOneVehicle(@PathVariable("personId") Long personId,
                                 @PathVariable("vehicleId") Long vehicleId){
        return vehicleService.getOneVehicleById(personId, vehicleId);
    }

    @RequestMapping(
            value = "/{vehicleId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteVehicle(@PathVariable("personId") Long personId,
                              @PathVariable("vehicleId") Long vehicleId){
        vehicleService.deleteVehicle(personId, vehicleId);
    }

    @RequestMapping(
            value = "/{vehicleId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Vehicle updateVehicle(@PathVariable("personId") Long personId,
                                 @PathVariable("vehicleId") Long vehicleId,
                                 @Valid @RequestBody SaveVehicleRequest request){
        return vehicleService.updateVehicle(personId, vehicleId, request);
    }

}
